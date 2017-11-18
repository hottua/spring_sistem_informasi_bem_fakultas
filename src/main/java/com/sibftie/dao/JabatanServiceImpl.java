package com.sibftie.dao;


import com.sibftie.model.Jabatan;
import com.sibftie.repository.JabatanRepository;
import com.sibftie.service.JabatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JabatanServiceImpl implements JabatanService
{
    @Autowired
    private JabatanRepository jabatanRepository;

    @Override
    public List<Jabatan> getAllJabatan() {
        return jabatanRepository.findAll();
    }

    @Override
    public void addJabatan(Jabatan jabatan) {
        jabatanRepository.save(jabatan);
    }
}
