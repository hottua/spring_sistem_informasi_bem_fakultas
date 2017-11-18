package com.sibftie.service;

import com.sibftie.model.KategoriPengumuman;

import java.util.List;

public interface KategoriPengumumanService
{
    public KategoriPengumuman getKategoriById(long id);
    public List<KategoriPengumuman> getAllKategoriPengumuman();

}
