package com.sibftie.service;


import com.sibftie.model.Kelas;

import java.util.List;

public interface KelasService
{
    public Kelas getKelasById(long id);
    public Kelas getKelasByKodeKelas(String kodeKelas);
    public List<Kelas> getAllKelas();
    public void addKelas(Kelas kelas);
    public void updateKelas(Kelas kelas);

    public void deleteKelasById(long id);

}
