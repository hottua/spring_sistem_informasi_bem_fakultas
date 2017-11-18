package com.sibftie.dao;


import com.sibftie.model.Akun;
import com.sibftie.model.Kelas;
import com.sibftie.model.Mahasiswa;
import com.sibftie.repository.MahasiswaRepository;
import com.sibftie.service.AkunService;
import com.sibftie.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MahasiswaServiceImpl implements MahasiswaService
{
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Autowired
    private AkunService akunService;


    @Override
    public void addMahasiswa(Mahasiswa m)
    {
        String rawPassword = m.getAkun().getPassword();
        m.getAkun().setPassword((bCryptPasswordEncoder().encode(rawPassword)));
        Akun a = m.getAkun();
        a.setMahasiswa(m);
        mahasiswaRepository.save(m);
    }

    @Override
    public void updateMahasiswa(Mahasiswa m)
    {

        if(mahasiswaRepository.findMahasiswaById(m.getId()).equals(m))
        {
            Mahasiswa mUpdate = mahasiswaRepository.findMahasiswaById(m.getId());
            mUpdate.setAlamat(m.getAlamat());
            mUpdate.setJnsKelamin(m.getJnsKelamin());
            mahasiswaRepository.save(mUpdate);
        }
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    @Override
    public Mahasiswa getMahasiswaById(long id) {
        return mahasiswaRepository.findMahasiswaById(id);
    }

    @Override
    public Mahasiswa getMahasiswaByNim(String nim) {
        return mahasiswaRepository.findMahasiswaByNim(nim);
    }
}
