package com.sibftie.controller;



import com.sibftie.model.Akun;
import com.sibftie.model.Pengumuman;
import com.sibftie.service.*;
import org.apache.log4j.Logger;
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
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.Date;


@Controller
public class PengumumanController
{
    private static String pathImage = "";
    private static String folderPengumuman = "\\publik";
    private Logger logger = org.apache.log4j.Logger.getLogger(PengumumanController.class);

    @Autowired
    private PrivasiService privasiService;

    @Autowired
    private KategoriPengumumanService kategoriPengumumanService;

    @Autowired
    private FileStorageService storageService;

    @Autowired
    private PengumumanService pengumumanService;

    @Autowired
    private AkunService akunService;

    @RequestMapping("/admin/pengumuman/create")
    public ModelAndView createPengumuman(Pengumuman pengumuman)
    {
        ModelAndView m = new ModelAndView();
        m.addObject("privasis", privasiService.getAllPrivasi());
        m.addObject("kategoriPengumumans", kategoriPengumumanService.getAllKategoriPengumuman());
        m.setViewName("pages/admin/create-pengumuman");
        return m;
    }

    @PostMapping("/admin/pengumuman/create")
    public ModelAndView uploadPengumuman(@Valid @ModelAttribute("pengumuman") Pengumuman pengumuman, BindingResult bindingResult)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Akun a = akunService.getAkunByEmail(authentication.getName());
        System.out.println("====================================");
        System.out.println(authentication.getName());
        System.out.println("====================================");
        ModelAndView m = new ModelAndView();
        if(bindingResult.hasErrors())
        {
            m.addObject("privasis", privasiService.getAllPrivasi());
            m.addObject("kategoriPengumumans", kategoriPengumumanService.getAllKategoriPengumuman());
            m.setViewName("pages/admin/create-pengumuman");
        }
        pengumuman.setPathFile(pathImage);
        pengumuman.setTglDibuat(new Date());
        pengumuman.setTimeStamp(new Date());
        pengumuman.setMahasiswa(a.getMahasiswa());
        pengumumanService.addPengumuman(pengumuman);
        m.setViewName("redirect:/pengumuman/daftar-pengumuman");
        return m;
    }

    @GetMapping("/pengumuman/daftar-pengumuman")
    public ModelAndView daftarPengumuman()
    {

        ModelAndView m = new ModelAndView();
        m.addObject("daftarPengumuman", pengumumanService.getPengumumanTerbaru());
        m.setViewName("pages/user/daftar-pengumuman");
        return m;
    }

    @GetMapping("/pengumuman/daftar-pengumuman/detail/{id}")
    public ModelAndView deteailPengumuman(@PathVariable("id") long id)
    {
        ModelAndView m = new ModelAndView();
        m.addObject("pengumuman", pengumumanService.getPengumumanById(id));
        m.addObject("daftarPengumuman", pengumumanService.getPengumumanTerbaru());
        m.setViewName("pages/user/detail-pengumuman");
        return m;
    }

    @RequestMapping(value = "/admin/pengumuman/delete/{id}", method = RequestMethod.DELETE)
    public String deletePengumuman(@PathVariable("id") long id)
    {
        pengumumanService.deletePengumuman(id);
        return "/pengumuman/daftar-pengumuman";
    }



    @PostMapping("/admin/pengumuman/upload/img")
    public void handleFileUpload(@RequestParam("upload") MultipartFile file,
                                   HttpServletRequest request, HttpServletResponse response) {
        if(!file.isEmpty())
        {
            try {
                response.setContentType("text/html; charset=UTF-8");
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("X-Frame-Options", "SAMEORIGIN");
                PrintWriter out = response.getWriter();
                String imageName = storageService.store(file, folderPengumuman);
                String fileUrl = "https://localhost:8443/pengumuman/publik/"+imageName;
                pathImage = fileUrl;
                String callback = request.getParameter("CKEditorFuncNum");
                String script = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + callback + ", '" + fileUrl + "');</script>";
                out.println(script);
                out.flush();
                out.close();

            }catch (Exception e)
            {
                logger.info("You failed to upload  => " + e.getMessage());

            }
        }

    }
    @GetMapping("/pengumuman/public/image")
    public String serveFiles(Model model) {
        model.addAttribute("files", storageService
                .loadAll(folderPengumuman)
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(PengumumanController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));
        return "pages/admin/daftar-gambar";
    }


    @GetMapping("/pengumuman/publik/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("filename") String namaFile) {
        System.out.println("location\t:"+folderPengumuman);
        System.out.println("FileName\t:"+namaFile);
        Resource file = storageService.loadAsResource(namaFile, folderPengumuman);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }



}
