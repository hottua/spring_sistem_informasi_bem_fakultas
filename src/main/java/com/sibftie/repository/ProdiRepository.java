package com.sibftie.repository;


import com.sibftie.model.Prodi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdiRepository extends JpaRepository<Prodi, Long>
{
    public Prodi findById(long id);
    public Prodi findByKodeProdi(String kodeProdi);
}
