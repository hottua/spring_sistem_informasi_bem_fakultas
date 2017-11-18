package com.sibftie.controller;

import com.sibftie.model.*;
import com.sibftie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by solo on 29/04/2017.
 */
@Controller
public class KelasController extends WebMvcConfigurerAdapter
{
    @Autowired
    private ProdiService prodiService;

    @Autowired
    private KelasService kelasService;

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private JabatanService jabatanService;

    @Autowired
    private MahasiswaJabatanService mahasiswaJabatanService;




    @RequestMapping(value="/admin/mengelola_kelas", method = RequestMethod.GET)
    public ModelAndView mengelolaKelas(Model model)
    {
        ModelAndView m = new ModelAndView();
        m.addObject("prodi", new Prodi());
        m.addObject("kelas", new Kelas());
        m.addObject("daftarKelas", kelasService.getAllKelas());
        m.addObject("daftarProdi", prodiService.getAllProdi());
        m.setViewName("pages/admin/mengelola-kelas");
        return m;
    }

    @PostMapping(value="/admin/add-prodi")
    public String addProdi(@ModelAttribute Prodi prodi)
    {
        prodiService.addProdi(prodi);
        return "redirect:/admin/mengelola_kelas";
    }

    @PostMapping(value = "/admin/add-kelas")
    public String addKelas(@ModelAttribute Kelas kelas)
    {
        kelasService.addKelas(kelas);
        System.out.println("Success");
        return "redirect:/admin/mengelola_kelas";
    }

    @GetMapping("/admin")
    public String getAdmin()
    {
        return "pages/dashboard";
    }


    @GetMapping("/admin/delete/{id}")
    public String deleteKelas(@PathVariable("id") long id, Model m)
    {
        System.out.println("Kelas berhasil dihapus");
        kelasService.deleteKelasById(id);
        m.addAttribute("daftarKelas", kelasService.getAllKelas());
        m.addAttribute("daftarProdi", prodiService.getAllProdi());
        return "pages/admin/daftar-kelas :: resultKelasList";
    }

    @GetMapping("/admin/daftarKelas")
    public String daftarKelas(Model m)
    {
       m.addAttribute("daftarKelas", kelasService.getAllKelas());
        m.addAttribute("daftarProdi", prodiService.getAllProdi());
        return "pages/admin/daftar-kelas :: resultKelasList";
    }

    @PostMapping(value = "/admin/update-kelas")
    public String updateKelas(@ModelAttribute("kelasEdit") Kelas kelasEdit)
    {
        kelasService.updateKelas(kelasEdit);
        return "redirect:/admin/mengelola_kelas";
    }

    @RequestMapping("/admin/mengelola_kelas/{id}")
    public String updateKelas(@PathVariable("id") long id, Model model)
    {
        Kelas kelas = kelasService.getKelasById(id);
        System.out.println("=====================================");
        System.out.println("Kelas\t:"+ kelas.getKodeKelas());
        System.out.println("=====================================");
        model.addAttribute("kelasEdit", kelas);
        model.addAttribute("daftarProdiEdit", prodiService.getAllProdi());
        return "pages/admin/update-kelas";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handler(Exception e)
    {
        return "pages/404";
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/**");
    }

}
