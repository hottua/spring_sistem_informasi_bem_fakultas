package com.sibftie.service;

import com.sibftie.model.Mahasiswa;

import java.util.List;

/**
 * Created by solo on 15/05/2017.
 */
public interface MahasiswaService
{
    public void addMahasiswa(Mahasiswa m);
    public void updateMahasiswa(Mahasiswa m);
    public List<Mahasiswa> getAllMahasiswa();
    public Mahasiswa getMahasiswaById(long id);
    public Mahasiswa getMahasiswaByNim(String nim);

}
