package com.sibftie.repository;
import com.sibftie.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sibftie.model.Aspirasi;
import com.sibftie.model.Dokumen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AspirasiRepository extends JpaRepository<Aspirasi, Long>
{
	Aspirasi findAspirasiById(long id);
	List<Aspirasi> findAspirasiByMahasiswa(Mahasiswa m);
}
