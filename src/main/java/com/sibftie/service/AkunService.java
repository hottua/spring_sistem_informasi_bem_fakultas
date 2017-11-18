package com.sibftie.service;

import com.sibftie.model.Akun;
import com.sibftie.model.Mahasiswa;

/**
 * Created by solo on 15/05/2017.
 */
public interface AkunService
{
    public void addAkun(Akun akun);
    public Akun getAkunById(long id);
    public Akun getAkunByEmail(String email);
    public Akun getAkunByMahasiswa(Mahasiswa m);
}
