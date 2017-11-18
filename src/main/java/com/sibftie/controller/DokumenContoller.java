package com.sibftie.controller;


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.sibftie.model.Akun;
import com.sibftie.model.Dokumen;
import com.sibftie.service.AkunService;
import com.sibftie.service.DokumenService;
import com.sibftie.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@Controller
public class DokumenContoller
{
    private final String path= "static\\file\\";
    private final String DOKUMEN ="\\dokumen\\";
    private String FOLDERDOKUMEN = "\\user\\";

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private DokumenService dokumenService;

    @Autowired
    private AkunService akunService;

    @GetMapping("/user/dokumen/ungah-dokumen")
    public ModelAndView unggahDokumen()
    {
        ModelAndView m = new ModelAndView();
        m.addObject("dokumen", new Dokumen());
        m.setViewName("/pages/user/unggah-dokumen");
        return m;
    }


    @RequestMapping(value = "/user/dokumen/ungah-dokumen", method = RequestMethod.POST)
    public  ModelAndView saveDokumen(@Valid @ModelAttribute("dokumen") Dokumen dokumen, BindingResult bindingResultDokument,
                                     RedirectAttributes redirectAttributes
    )
    {
        ModelAndView m = new ModelAndView();
        String request = "";
        String error;
        System.out.println("======================================");
        System.out.println("Ukuran "+ dokumen.getFileDokumen().getSize());
        System.out.println("======================================");
        error = cekDokumenError(dokumen.getFileDokumen());
        if(!error.equals(""))
        {
            redirectAttributes.addFlashAttribute("dokumenError", error);
            m.setViewName("redirect:/user/dokumen/ungah-dokumen");
        }else
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Akun a = akunService.getAkunByEmail(auth.getName());
            String location =FOLDERDOKUMEN+a.getMahasiswa().getNim()+DOKUMEN;
            String fileName = fileStorageService.store(dokumen.getFileDokumen(),location);
            dokumen.setFileName(fileName);
            dokumen.setPath(location+fileName);
            dokumen.setJmlSpam(0);
            dokumen.setTglDibuat(new Date());
            dokumen.setMahasiswa(a.getMahasiswa());
            dokumenService.addDokumen(dokumen);
            m.setViewName("redirect:/user/dokumen/daftar-dokumen");
        }

        return m;
    }

    private String cekDokumenError(MultipartFile file)
    {
        String error = "";
        if(!file.getContentType().toLowerCase().equals("application/pdf"))
        {
           error += "Format file "+file.getOriginalFilename()+" tidak didukung";
        }
        if(file.getSize() >= 31457280)
        {
            error+="\nUkuran file terlalu besar : "+file.getSize();
        }
        return error;
    }


    @GetMapping("/user/dokumen/daftar-dokumen")
    public ModelAndView daftarDokumen()
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/user/daftar-dokumen");
        return m;
    }

    @GetMapping("/user/getAllDokumen")
    public String getDaftarDokumen(Model model)
    {
        model.addAttribute("dokumens", dokumenService.getAllDokumen());
        return "/pages/user/dokumen :: resultDokumenList";
    }

    @GetMapping("/user/dokumen/{id}")
    public String readDokumen(@PathVariable("id") long id, Model model)
    {
        Dokumen d = dokumenService.getDokumenById(id);
        model.addAttribute("dokumen", d);
        return "/pages/user/dokumen-reader";
    }

    @GetMapping("/user/dokumen/detail/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("filename") long id) {
        Dokumen d = dokumenService.getDokumenById(id);
        String location = FOLDERDOKUMEN+d.getMahasiswa().getNim()+DOKUMEN;
        Resource file = fileStorageService.loadAsResource(d.getFileName(), location);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @GetMapping("/user/dokumen/search/{textSearch}")
    public String searchDokumen(@PathVariable("textSearch") String textSearch, Model model)
    {
        textSearch = "%"+textSearch+"%";
        List<Dokumen> dokumens = dokumenService.getAllDokumen(textSearch);
//        Map<Dokumen, Integer> baru = resultSearch(dokumens, textSearch);
        model.addAttribute("dokumens", dokumens);

        return "/pages/user/dokumen :: resultDokumenList";
    }


    private Map resultSearch(List<Dokumen> ds, String textSearch)
    {
        Map<Dokumen, Integer> result = new HashMap<Dokumen, Integer>();
        PdfReader reader;
        try {
            for (Dokumen d : ds)
            {
                Integer count = 0;
                reader = new PdfReader(path+d.getPath());

                for(int i = 1; i<= reader.getNumberOfPages(); i++)
                {
                    String textFromPage = PdfTextExtractor.getTextFromPage(reader, i);
                    count +=Collections.frequency(Arrays.asList(textFromPage.split(" ")), textSearch);;

                }
                result.put(d,count);
                reader.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }


    @GetMapping("/user/dokumen/delete/{id}")
    public String deleteDokumen(@PathVariable("id") long id, Model model)
    {
        dokumenService.deleteDokumen(id);
        model.addAttribute("dokumens", dokumenService.getAllDokumen());
        return "/pages/user/dokumen :: resultDokumenList";
    }


}
