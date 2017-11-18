package com.sibftie.dao;

import com.sibftie.model.Prodi;
import com.sibftie.repository.ProdiRepository;
import com.sibftie.service.ProdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdiServiceImpl implements ProdiService
{

    @Autowired
    ProdiRepository prodiRepository;

    @Override
    public Prodi getProdiById(long id) {
        return prodiRepository.findById(id);
    }

    @Override
    public Prodi getProdiByKodeProdi(String kodeProdi) {
        return prodiRepository.findByKodeProdi(kodeProdi);
    }

    @Override
    public List<Prodi> getAllProdi() {
        return prodiRepository.findAll();
    }


    @Override
    public void addProdi(Prodi prodi)
    {
        prodi.setKodeProdi(prodi.getKodeProdi().toUpperCase());
        prodiRepository.save(prodi);
    }

    @Override
    public void updateProdi(Prodi prodi)
    {
        Prodi prodiUpdate = prodiRepository.findByKodeProdi(prodi.getKodeProdi());
        prodiUpdate.setKodeProdi(prodi.getKodeProdi().toUpperCase());
        prodiUpdate.setNamaProdi(prodi.getNamaProdi());
        prodiRepository.save(prodiUpdate);
    }

    @Override
    public void deleteProdi(String kodeProdi)
    {
        Prodi prodiDelete = prodiRepository.findByKodeProdi(kodeProdi);
        prodiRepository.delete(prodiDelete);
    }
}
