package com.sibftie.dao;


import com.sibftie.model.KategoriPengumuman;
import com.sibftie.model.Pengumuman;
import com.sibftie.repository.PengumumanRepository;
import com.sibftie.service.PengumumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengumumanServiceImpl implements PengumumanService
{
    @Autowired
    PengumumanRepository pengumumanRepository;

    @Override
    public void addPengumuman(Pengumuman p)
    {
        pengumumanRepository.save(p);
    }

    @Override
    public void updatePengumuman(Pengumuman p)
    {

    }

    @Override
    public List<Pengumuman> getAllPengumuman()
    {
        return pengumumanRepository.findAll();
    }

    @Override
    public List<Pengumuman> getPengumumanTerbaru() {
        return pengumumanRepository.findPengumumanTerbaru();
    }

    @Override
    public List<Pengumuman> getPengumumanByKategory(KategoriPengumuman k) {
        return pengumumanRepository.findPengumumanByKategoriPengumuman(k);
    }

    @Override
    public Pengumuman getPengumumanById(long id) {
        return pengumumanRepository.findPengumumanById(id);
    }

    @Override
    public void deletePengumuman(long id) {
        pengumumanRepository.delete(id);
    }
}
