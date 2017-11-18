package com.sibftie.service;


import com.sibftie.model.Diskusi;

import java.util.List;

public interface DiskusiService
{
    public void addDiskusi(Diskusi d);
    public List<Diskusi> getAllDiskusi();
    public Diskusi getDiskusiById(long id);
    public void updateDiskusi(Diskusi d);
    void hapusDiskusi(long id);
}
