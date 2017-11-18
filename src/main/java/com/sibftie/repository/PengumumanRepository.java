package com.sibftie.repository;


import com.sibftie.model.KategoriPengumuman;
import com.sibftie.model.Pengumuman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PengumumanRepository extends JpaRepository<Pengumuman, Long>
{
    public Pengumuman findPengumumanById(long id);
    @Query("select p from Pengumuman p order by p.tglDibuat desc ")
    List<Pengumuman> findPengumumanTerbaru();

    List<Pengumuman> findPengumumanByKategoriPengumuman(KategoriPengumuman k);




}
