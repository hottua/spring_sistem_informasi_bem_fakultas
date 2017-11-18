package com.sibftie.repository;

import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MahasiswaJabatanRepository extends JpaRepository<MahasiswaJabatan, Long>
{
    MahasiswaJabatan findById(long id);
    MahasiswaJabatan findByMahasiswa(Mahasiswa m);
}
