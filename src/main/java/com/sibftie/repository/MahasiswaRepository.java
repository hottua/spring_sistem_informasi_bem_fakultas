package com.sibftie.repository;

import com.sibftie.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long>
{
    Mahasiswa findMahasiswaById(long id);
    Mahasiswa findMahasiswaByNim(String nim);
}
