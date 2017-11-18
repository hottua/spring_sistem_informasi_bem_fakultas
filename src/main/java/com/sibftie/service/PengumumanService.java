package com.sibftie.service;

import com.sibftie.model.KategoriPengumuman;
import com.sibftie.model.Pengumuman;

import java.util.List;

public interface PengumumanService
{
    public void addPengumuman(Pengumuman p);
    public void updatePengumuman(Pengumuman p);
    public List<Pengumuman> getAllPengumuman();
    public List<Pengumuman> getPengumumanTerbaru();
    public List<Pengumuman> getPengumumanByKategory(KategoriPengumuman k);
    public Pengumuman getPengumumanById(long id);


    public void deletePengumuman(long id);

}
