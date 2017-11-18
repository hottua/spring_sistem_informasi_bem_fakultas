package com.sibftie.service;

import com.sibftie.model.Jabatan;

import java.util.List;

/**
 * Created by solo on 15/05/2017.
 */
public interface JabatanService
{
    public List<Jabatan> getAllJabatan();
    public void addJabatan(Jabatan jabatan);
}
