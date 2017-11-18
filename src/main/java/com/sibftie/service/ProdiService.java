package com.sibftie.service;


import com.sibftie.model.Prodi;

import java.util.List;
public interface ProdiService
{
    public Prodi getProdiById(long id);
    public Prodi getProdiByKodeProdi(String kodeProdi);
    public List<Prodi> getAllProdi();
    public void addProdi(Prodi prodi);
    public void updateProdi(Prodi prodi);
    public void deleteProdi(String kodeProdi);
}
