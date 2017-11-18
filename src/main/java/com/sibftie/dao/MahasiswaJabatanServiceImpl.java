package com.sibftie.dao;

import com.sibftie.model.Jabatan;
import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;
import com.sibftie.repository.MahasiswaJabatanRepository;
import com.sibftie.repository.MahasiswaRepository;
import com.sibftie.service.MahasiswaJabatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaJabatanServiceImpl implements MahasiswaJabatanService
{
    @Autowired
    MahasiswaJabatanRepository mahasiswaJabatanRepository;

    @Override
    public void addMahasiswaJabatan(MahasiswaJabatan mj)
    {
        mahasiswaJabatanRepository.save(mj);
    }

    @Override
    public List<MahasiswaJabatan> getAllMahasiswaJabatan() {
        return mahasiswaJabatanRepository.findAll();
    }

    @Override
    public MahasiswaJabatan getMahasiswaJabatanByMahasiswa(Mahasiswa m) {
        return mahasiswaJabatanRepository.findByMahasiswa(m);
    }
}
