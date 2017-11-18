package com.sibftie.repository;


import com.sibftie.model.Dokumen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DokumenRepository extends JpaRepository<Dokumen, Long>
{
    Dokumen findDokumenById(long id);

    @Query("select d from Dokumen d where d.jdlDokumen like :textSearch or d.deskripsi like :textSearch")
    List<Dokumen> findCustomDokumen(@Param("textSearch") String textSearch);
}
