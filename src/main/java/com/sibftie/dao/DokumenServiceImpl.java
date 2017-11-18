package com.sibftie.dao;


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.sibftie.model.Dokumen;
import com.sibftie.repository.DokumenRepository;
import com.sibftie.service.DokumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DokumenServiceImpl implements DokumenService
{

    @Autowired
    private DokumenRepository dokumenRepository;
    @Override
    public void addDokumen(Dokumen d)
    {
        dokumenRepository.save(d);
    }

    @Override
    public void updateDokumen(Dokumen d)
    {
        Dokumen updateDokumen = dokumenRepository.findDokumenById(d.getId());
        updateDokumen.setJdlDokumen(d.getJdlDokumen());
        updateDokumen.setDeskripsi(d.getDeskripsi());
        updateDokumen.setPath(d.getPath());
        dokumenRepository.save(updateDokumen);
    }

    @Override
    public List<Dokumen> getAllDokumen() {
        return dokumenRepository.findAll();
    }

    @Override
    public List<Dokumen> getAllDokumen(String searchText)
    {
        List<Dokumen> dokumens = dokumenRepository.findCustomDokumen(searchText);
        if(dokumens == null)
            return null;

        return dokumens;
    }




    @Override
    public Dokumen getDokumenById(long id) {
        return dokumenRepository.findDokumenById(id);
    }

    @Override
    public void deleteDokumen(long id) {
        dokumenRepository.delete(id);
    }
}
