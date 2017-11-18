package com.sibftie.dao;


import com.sibftie.model.Privasi;
import com.sibftie.repository.PrivasiRepository;
import com.sibftie.service.PrivasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivasiServiceImpl implements PrivasiService
{
    @Autowired
    private PrivasiRepository privasiRepository;

    @Override
    public Privasi getPrivasiById(long id) {
        return privasiRepository.findPrivasiById(id);
    }

    @Override
    public List<Privasi> getAllPrivasi() {
        return privasiRepository.findAll();
    }
}
