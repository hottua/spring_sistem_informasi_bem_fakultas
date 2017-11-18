package com.sibftie.service;

import com.sibftie.model.Dokumen;

import java.util.List;

public interface DokumenService
{
    public void addDokumen(Dokumen d);
    public void updateDokumen(Dokumen d);
    public List<Dokumen> getAllDokumen();
    public List<Dokumen> getAllDokumen(String searchText);
    public Dokumen getDokumenById(long id);

    public void deleteDokumen(long id);



}
