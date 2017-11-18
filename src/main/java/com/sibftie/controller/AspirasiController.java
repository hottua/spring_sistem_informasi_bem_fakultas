package com.sibftie.controller;
import com.sibftie.model.Akun;
import com.sibftie.model.Aspirasi;
import com.sibftie.model.Dokumen;
import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;
import com.sibftie.model.Pengumuman;
import com.sibftie.model.Proposal;
import com.sibftie.service.AkunService;
import com.sibftie.service.AspirasiService;
import com.sibftie.service.FileStorageService;

import com.sibftie.service.MahasiswaJabatanService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class AspirasiController {
	
	@Autowired
    private AspirasiService aspirasiService;
	
	@Autowired
    private AkunService akunService;

	@Autowired
    private MahasiswaJabatanService mahasiswaJabatanService;
	
	@RequestMapping(value="/user/aspirasi/tambah-aspirasi", method = RequestMethod.GET)
    public ModelAndView tambahAspirasi(Mahasiswa mahasiswa, MahasiswaJabatan mahasiswaJabatan, Model model, Akun akun)
    {
        ModelAndView m = new ModelAndView();
        m.addObject("aspirasi", new Aspirasi());
        m.setViewName("/pages/user/tambah-aspirasi");
        return m;
    }


    @RequestMapping(value = "/user/aspirasi/tambah-aspirasi", method = RequestMethod.POST)
    public  ModelAndView saveAspirasi(@Valid @ModelAttribute("aspirasi") Aspirasi aspirasi, BindingResult bindingResultDokument,
                                      RedirectAttributes redirectAttributes)
    {

    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Akun a = akunService.getAkunByEmail(authentication.getName());
        ModelAndView m = new ModelAndView();
        String error;
        error = cekAspirasiError(aspirasi.getIsiAspirasi());
        if(!error.isEmpty())
        {
            redirectAttributes.addFlashAttribute("aspirasiError", error);
            m.setViewName("redirect:/user/aspirasi/tambah-aspirasi");
        }
        else
        {
	        aspirasi.setTgl_dibuat(new Date());
	        aspirasi.setMahasiswa(a.getMahasiswa());
	        aspirasi.setStatus("Pending");
	        aspirasiService.addAspirasi(aspirasi);
	        m.setViewName("redirect:/user/aspirasi/daftar-aspirasi");
	    }

        return m;
    }
    
    private String cekAspirasiError(String aspirasi)
    {
        String error = "";
        if(aspirasi.equalsIgnoreCase(""))
        {
           error += "Aspirasi harus diisi";
        }
        return error;
    }


    @GetMapping("/user/aspirasi/daftar-aspirasi")
    public ModelAndView daftarAspirasi()
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/user/daftar-aspirasi");
        return m;
    }

    @GetMapping("/user/getAllAspirasi")
    public String getDaftarAspirasi(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Akun a = akunService.getAkunByEmail(authentication.getName());
        MahasiswaJabatan m = mahasiswaJabatanService.getMahasiswaJabatanByMahasiswa(a.getMahasiswa());
        if(m.getJabatan().getNamaJabatan().equalsIgnoreCase("KETUABEM"))
        {
            model.addAttribute("aspirasis", aspirasiService.getAllAspirasi());
        }else
        {
            model.addAttribute("aspirasis", aspirasiService.getAspirasiByMahasiswa(a.getMahasiswa()));
        }
        return "/pages/user/aspirasi :: resultAspirasiList";
    }
    
    @RequestMapping(value="/aspirasi/hapus/{id}")
    public String hapus(@PathVariable long id){
	    aspirasiService.hapus(id);
	    return "redirect:/user/aspirasi/daftar-aspirasi";
    
    }
    
    @GetMapping("/aspirasi/daftar-aspirasi/detail/{id}")
    public ModelAndView deteailPengumuman(@PathVariable("id") long id)
    {
        ModelAndView m = new ModelAndView();
        m.addObject("aspirasi", aspirasiService.getAspirasiById(id));
        m.addObject("daftarAspirasi", aspirasiService.getAllAspirasi());
        m.setViewName("pages/user/detail-aspirasi");
        return m;
    }

    @GetMapping("user/aspirasi/update/{id}")
    public ModelAndView updateAspirasi(@PathVariable("id") long id)
    {
        ModelAndView m = new ModelAndView();
        Aspirasi a = aspirasiService.getAspirasiById(id);
        a.setStatus("Sudah dirapatkan");
        aspirasiService.updateAspirasi(a);
        m.setViewName("redirect:/user/aspirasi/daftar-aspirasi");
        return  m;
    }

}


