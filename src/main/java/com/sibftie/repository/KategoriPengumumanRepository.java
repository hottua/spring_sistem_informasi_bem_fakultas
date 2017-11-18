package com.sibftie.repository;

import com.sibftie.model.KategoriPengumuman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriPengumumanRepository extends JpaRepository<KategoriPengumuman, Long>
{
    public KategoriPengumuman findById(long id);
}
