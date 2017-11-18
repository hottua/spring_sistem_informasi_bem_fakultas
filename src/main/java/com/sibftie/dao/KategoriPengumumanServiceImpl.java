package com.sibftie.dao;

import com.sibftie.model.KategoriPengumuman;
import com.sibftie.repository.KategoriPengumumanRepository;
import com.sibftie.service.KategoriPengumumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriPengumumanServiceImpl implements KategoriPengumumanService
{
    @Autowired
    private KategoriPengumumanRepository kategoriPengumumanRepository;

    @Override
    public KategoriPengumuman getKategoriById(long id)
    {
        return kategoriPengumumanRepository.findById(id);
    }

    @Override
    public List<KategoriPengumuman> getAllKategoriPengumuman() {
        return kategoriPengumumanRepository.findAll();
    }
}
