package com.sibftie.controller;
import com.sibftie.service.KategoriPengumumanService;
import com.sibftie.model.Akun;
import com.sibftie.model.MahasiswaJabatan;
import com.sibftie.service.AkunService;
import com.sibftie.service.MahasiswaJabatanService;
import com.sibftie.service.PengumumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
public class AutentikasiController
{
    @Autowired
    AkunService akunService;

    @Autowired
    MahasiswaJabatanService mahasiswaJabatanService;

    @Autowired
    PengumumanService pengumumanService;

    @Autowired
    KategoriPengumumanService kategoriPengumumanService;


    @RequestMapping({"/", "/home", "/dashboard"})
    public String index(Model model)
    {
        model.addAttribute("daftarPengumuman", pengumumanService.getPengumumanByKategory(kategoriPengumumanService.getKategoriById(2)));
        model.addAttribute("beritas", pengumumanService.getPengumumanByKategory(kategoriPengumumanService.getKategoriById(1)));

        return "pages/dashboard";
    }

    @RequestMapping("/user/login")
    public ModelAndView loginUser()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages/login");
        return modelAndView;
    }

    // for 403 access denied page
    @GetMapping("/403")
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        model.setViewName("pages/403");
        return model;

    }

    @ModelAttribute
    public void getCurrentUser(Model model)
    {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Akun a = akunService.getAkunByEmail(auth.getName());
            if(a != null) {
                MahasiswaJabatan mj = mahasiswaJabatanService.getMahasiswaJabatanByMahasiswa(a.getMahasiswa());
                model.addAttribute("mahasiswaJabatanLogged", mj);
            }
        }catch (Exception e)
        {
            e.toString();
        }

    }
}
