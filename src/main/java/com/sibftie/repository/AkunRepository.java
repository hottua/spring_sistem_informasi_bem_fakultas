package com.sibftie.repository;

import com.sibftie.model.Akun;
import com.sibftie.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AkunRepository extends JpaRepository<Akun, Long>
{
    Akun findById(long id);
    Akun findByEmail(String email);
    Akun findByMahasiswa(Mahasiswa m);
}
