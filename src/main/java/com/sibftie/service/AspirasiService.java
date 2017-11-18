package com.sibftie.service;

import java.util.List;

import com.sibftie.model.Aspirasi;
import com.sibftie.model.Mahasiswa;

public interface AspirasiService {

	public void addAspirasi(Aspirasi a);
    public List<Aspirasi> getAllAspirasi();
    public Aspirasi getAspirasiById(long id);
    public void updateAspirasi(Aspirasi a);
    public List<Aspirasi> getAspirasiByMahasiswa(Mahasiswa m);
    void hapus(long id);
}
