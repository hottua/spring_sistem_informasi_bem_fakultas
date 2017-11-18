package com.sibftie.repository;

import com.sibftie.model.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Long>
{
    public Kelas findById(long id);
    public Kelas findByKodeKelas(String kodeKelas);

}
