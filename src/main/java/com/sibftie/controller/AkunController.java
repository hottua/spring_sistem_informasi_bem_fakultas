package com.sibftie.controller;

import com.sibftie.model.Akun;
import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;
import com.sibftie.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class AkunController extends WebMvcConfigurerAdapter
{
    private final String POTO = "user.png";
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

    @Autowired
    private AkunService akunService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("pages/dashboard");
    }

    @RequestMapping(value="/admin/mengelola_akun", method = RequestMethod.GET)
    public ModelAndView mengelolaAkun(Mahasiswa mahasiswa, MahasiswaJabatan mahasiswaJabatan, Model model, Akun akun)
    {
        ModelAndView m = new ModelAndView();
        m.addObject("daftarKelas", kelasService.getAllKelas());
        m.addObject("daftarJabatan", jabatanService.getAllJabatan());
        m.addObject("daftarMahasiswa", mahasiswaService.getAllMahasiswa());
        m.setViewName("pages/admin/mengelola-akun");
        return m;
    }

    @PostMapping(value = "/admin/mengelola_akun")
    public ModelAndView registerMahasiswa(@Valid @ModelAttribute(value = "mahasiswa") Mahasiswa mahasiswa, BindingResult bindingResultMahasiswa,
                                          @Valid @ModelAttribute(value = "mahasiswaJabatan") MahasiswaJabatan mahasiswaJabatan, BindingResult bindingResultMahasiswaJabatan,
                                          @Valid @ModelAttribute(value = "akun") Akun akun, BindingResult bindingResultAkun

                                    ) throws ConversionFailedException
    {
        ModelAndView modelAndView = new ModelAndView();
        Mahasiswa mhsExist = mahasiswaService.getMahasiswaByNim(mahasiswa.getNim());
        if(mhsExist != null)
            bindingResultMahasiswa.rejectValue("nim", "NimExist", "Nim telah terdaftar");

        if(bindingResultMahasiswa.hasErrors() || bindingResultMahasiswa.hasErrors() || bindingResultAkun.hasErrors())
        {
            modelAndView.addObject("daftarKelas", kelasService.getAllKelas());
            modelAndView.addObject("daftarJabatan", jabatanService.getAllJabatan());
            modelAndView.addObject("daftarMahasiswa", mahasiswaService.getAllMahasiswa());
            modelAndView.setViewName("pages/admin/mengelola-akun");
        }else
        {
            mahasiswa.setPath(POTO);
            mahasiswa.setAkun(akun);
            akun.setMahasiswa(mahasiswa);
            mahasiswaService.addMahasiswa(mahasiswa);
            jabatanService.addJabatan(mahasiswaJabatan.getJabatan());
            mahasiswaJabatan.setMahasiswa(mahasiswa);
            mahasiswaJabatanService.addMahasiswaJabatan(mahasiswaJabatan);
            modelAndView.setViewName("redirect:/admin/mengelola_akun");
        }
        return modelAndView;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/**");
    }



}
