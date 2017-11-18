package com.sibftie.service;


import com.sibftie.model.Privasi;

import java.util.List;

public interface PrivasiService
{
    public Privasi getPrivasiById(long id);
    public List<Privasi> getAllPrivasi();

}
