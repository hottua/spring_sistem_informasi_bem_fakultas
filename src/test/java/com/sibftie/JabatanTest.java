package com.sibftie;

import com.sibftie.model.Jabatan;
import com.sibftie.model.Mahasiswa;
import com.sibftie.model.MahasiswaJabatan;
import com.sibftie.service.JabatanService;
import com.sibftie.service.MahasiswaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JabatanTest
{
    @Autowired
    JabatanService jabatanService;
    @Test
    public void getAllJabatanTest()
    {
        List<Jabatan> jabatans = jabatanService.getAllJabatan();
        for (Jabatan j: jabatans)
        {
            System.out.println("==========================");
            System.out.println("Nama Jabatan\t:"+j.getNamaJabatan());
            System.out.println("Deskripsi Jabatan\t:"+j.getDeskripsi());
            System.out.println("==========================");
        }
    }

    @Autowired
    MahasiswaService mahasiswaService;
    @Test
    public void getMahasiswa()
    {
        Mahasiswa m = mahasiswaService.getMahasiswaByNim("12s14008");
        System.out.println("===================================");
        System.out.println("Nama\t:"+m.getNamaLengkap());
        System.out.println("Jabatan\t:"+m.getKelas().toString());
//        for(MahasiswaJabatan mj : m.getMahasiswaJabatans())
//        {
//            System.out.println("\t:"+mj.getJabatan().getNamaJabatan());
//        }
        System.out.println("===================================");
    }

}
