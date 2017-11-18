package com.sibftie.repository;


import com.sibftie.model.Diskusi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiskusiRepository extends JpaRepository<Diskusi, Long>
{
    Diskusi findDiskusiById(long id);

}
