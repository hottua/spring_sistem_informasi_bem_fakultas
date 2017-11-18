package com.sibftie.dao;

import com.sibftie.model.Kelas;
import com.sibftie.repository.KelasRepository;
import com.sibftie.repository.ProdiRepository;
import com.sibftie.service.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by solo on 10/05/2017.
 */
@Service
public class KelasServiceImpl implements KelasService
{
    @Autowired
    KelasRepository kelasRepository;

    @Override
    public Kelas getKelasById(long id) {
        return kelasRepository.findById(id);
    }

    @Override
    public Kelas getKelasByKodeKelas(String kodeKelas) {
        return kelasRepository.findByKodeKelas(kodeKelas);
    }

    @Override
    public List<Kelas> getAllKelas()
    {
        return kelasRepository.findAll();
    }

    @Override
    public void addKelas(Kelas kelas)
    {
        kelas.setKodeKelas(kelas.getKodeKelas().toUpperCase());
        kelasRepository.save(kelas);
    }

    @Override
    public void updateKelas(Kelas kelas)
    {
        Kelas kelasUpdate = kelasRepository.findByKodeKelas(kelas.getKodeKelas());
        if(kelasUpdate != null) {
            kelasUpdate.setKodeKelas(kelas.getKodeKelas().toUpperCase());
            kelasUpdate.setDeskripsi(kelas.getDeskripsi());
            kelasUpdate.setProdi(kelas.getProdi());
            kelasRepository.saveAndFlush(kelasUpdate);
        }
        else
            System.out.println("Kelas tidak ada");
    }

    @Override
    public void deleteKelasById(long id)
    {
        Kelas k = getKelasById(id);
        kelasRepository.delete(k);
    }
}
