package com.sibftie.repository;


import com.sibftie.model.Jabatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JabatanRepository extends JpaRepository<Jabatan, Long>
{
}
