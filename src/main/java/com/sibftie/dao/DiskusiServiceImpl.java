package com.sibftie.dao;

import com.sibftie.model.Diskusi;
import com.sibftie.repository.DiskusiRepository;
import com.sibftie.service.DiskusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiskusiServiceImpl implements DiskusiService
{
    @Autowired
    private DiskusiRepository diskusiRepository;

    @Override
    public void addDiskusi(Diskusi d)
    {
        diskusiRepository.save(d);

    }

    @Override
    public List<Diskusi> getAllDiskusi() {
        return diskusiRepository.findAll();
    }

    @Override
    public Diskusi getDiskusiById(long id) {
        return diskusiRepository.findDiskusiById(id);
    }

    @Override
    public void updateDiskusi(Diskusi d)
    {

    }

    @Override
    public void hapusDiskusi(long id)
    {
        diskusiRepository.delete(id);
    }
}
