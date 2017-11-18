package com.sibftie.repository;

import com.sibftie.model.Privasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivasiRepository extends JpaRepository<Privasi, Long>
{
    public Privasi findPrivasiById(long id);
}
