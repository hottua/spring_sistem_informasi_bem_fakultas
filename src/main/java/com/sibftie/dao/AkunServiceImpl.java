package com.sibftie.dao;

import com.sibftie.model.Akun;
import com.sibftie.model.Mahasiswa;
import com.sibftie.repository.AkunRepository;
import com.sibftie.service.AkunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by solo on 15/05/2017.
 */
@Service
public class AkunServiceImpl implements AkunService
{
    @Autowired
    AkunRepository akunRepository;

    @Override
    public void addAkun(Akun akun)
    {
        akunRepository.save(akun);
    }

    @Override
    public Akun getAkunById(long id)
    {
        return akunRepository.findById(id);
    }

    @Override
    public Akun getAkunByEmail(String email)
    {
        return akunRepository.findByEmail(email);
    }

    @Override
    public Akun getAkunByMahasiswa(Mahasiswa m)
    {
        return  akunRepository.findByMahasiswa(m);
    }
}
