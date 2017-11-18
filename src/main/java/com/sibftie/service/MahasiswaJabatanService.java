package com.sibftie.service;

import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;

import java.util.List;

public interface MahasiswaJabatanService
{
    public void addMahasiswaJabatan(MahasiswaJabatan mj);
    public List<MahasiswaJabatan> getAllMahasiswaJabatan();
    public MahasiswaJabatan getMahasiswaJabatanByMahasiswa(Mahasiswa m);

}
