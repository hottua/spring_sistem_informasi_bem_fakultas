package com.sibftie.controller;
import com.sibftie.model.Akun;
import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;
import com.sibftie.model.Pengumuman;
import com.sibftie.model.Proposal;
import com.sibftie.service.AkunService;
import com.sibftie.service.FileStorageService;
import com.sibftie.service.ProposalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class ProposalController {

    private final String DOKUMEN ="\\proposal\\";
    private String FOLDERDOKUMEN = "\\publik\\";

	@Autowired
    private FileStorageService fileStorageService;

	@Autowired
    private ProposalService proposalService;
	
	@Autowired
    private AkunService akunService;

    @RequestMapping(value="/user/proposal/unggah-proposal", method = RequestMethod.GET)
    public ModelAndView unggahProposal(Mahasiswa mahasiswa, MahasiswaJabatan mahasiswaJabatan, Model model, Akun akun)
    {
        ModelAndView m = new ModelAndView();
        m.addObject("proposal", new Proposal());
        m.setViewName("/pages/user/unggah-proposal");
        return m;
    }


    @RequestMapping(value = "/user/proposal/unggah-proposal", method = RequestMethod.POST)
    public  ModelAndView saveProposal(@Valid @ModelAttribute("proposal") Proposal proposal, BindingResult bindingResultDokument)
    {

    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Akun a = akunService.getAkunByEmail(authentication.getName());
        ModelAndView m = new ModelAndView();
        String error;
        error = cekDokumenError(proposal.getFileProposal());
        if(!error.equals(""))
        {
            m.addObject("proposal", new Proposal());
            m.addObject("proposalError", error);
            m.setViewName("/pages/user/unggah-proposal");
        }else
        {
            String location =FOLDERDOKUMEN+a.getMahasiswa().getNim()+DOKUMEN;
            String path = fileStorageService.store(proposal.getFileProposal(),location);
            proposal.setFileName(path);
            proposal.setPathDokument(location+path);
            proposal.setStatus("Baru");
            proposal.setTglDibuat(new Date());
            proposal.setTimeStamp(new Date());
            proposal.setMahasiswa(a.getMahasiswa());
            proposalService.addProposal(proposal);
            m.setViewName("redirect:/user/proposal/daftar-proposal");
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


    @GetMapping("/user/proposal/daftar-proposal")
    public ModelAndView daftarProposal()
    {
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/user/daftar-proposal");
        return m;
    }

    @GetMapping("/user/getAllProposal")
    public String getDaftarProposal(Model model)
    {
        model.addAttribute("proposals", proposalService.getAllProposal());
        return "/pages/user/proposal :: resultProposalList";
    }
    
    @GetMapping(value="/proposal/delete/{id}")
    public String deleteProposal(@PathVariable long id){
    proposalService.hapus(id);
    return "redirect:/user/proposal/daftar-proposal";
    
    }

    @GetMapping("/user/proposal/detail/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("filename") long id) {
        Proposal p = proposalService.getProposalById(id);
        String location = FOLDERDOKUMEN+p.getMahasiswa().getNim()+DOKUMEN;
        Resource file = fileStorageService.loadAsResource(p.getFileName(), location);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
    @GetMapping("/user/proposal/{id}")
    public String readDokumen(@PathVariable("id") long id, Model model)
    {
        Proposal p = proposalService.getProposalById(id);
        model.addAttribute("proposal", p);
        return "/pages/user/proposal-reader";
    }

    
}
