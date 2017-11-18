package com.sibftie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.sibftie.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sibftie.model.Aspirasi;
import com.sibftie.model.Proposal;
import com.sibftie.repository.AspirasiRepository;
import com.sibftie.service.AspirasiService;


@Service
public class AspirasiServiceImpl implements AspirasiService
{

	@Autowired
    private AspirasiRepository aspirasiRepository;
	
	@Override
	public void addAspirasi(Aspirasi a) {
		aspirasiRepository.save(a);
		
	}

	@Override
	public List<Aspirasi> getAllAspirasi() {
		return aspirasiRepository.findAll();
	}

	@Override
	public Aspirasi getAspirasiById(long id) {
		return aspirasiRepository.findAspirasiById(id);
	}

	@Override
	public void updateAspirasi(Aspirasi a)
	{
		aspirasiRepository.save(a);
	}

	@Override
	public List<Aspirasi> getAspirasiByMahasiswa(Mahasiswa m)
	{
		return aspirasiRepository.findAspirasiByMahasiswa(m);
	}

	@Override
	public void hapus(long id) {
		aspirasiRepository.delete(id);
	}

}
