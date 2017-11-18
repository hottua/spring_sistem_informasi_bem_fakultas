package com.sibftie;

import com.sibftie.model.*;
import com.sibftie.repository.KelasRepository;
import com.sibftie.service.DokumenService;
import com.sibftie.service.MahasiswaJabatanService;
import com.sibftie.service.MahasiswaService;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by solo on 16/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MahasiswaTest
{
    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    KelasRepository kelasRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    MahasiswaJabatanService mahasiswaJabatanService;

    @Autowired
    DokumenService dokumenService;

    @Test
    public void MenyimpanDataMahasiswa()
    {

        Mahasiswa m = new Mahasiswa();
        Kelas k = kelasRepository.findById(1);
        m.setNim("12s14009");
        m.setNamaLengkap("Surya Dharma Simorangkir");
        m.setAkun(new Akun("12s14009", bCryptPasswordEncoder.encode("123456")));
        m.setKelas(k);
        mahasiswaService.addMahasiswa(m);
    }

    @Test
    public void menampilkanDataMahasiswa()
    {
        MahasiswaJabatan m = mahasiswaJabatanService.getMahasiswaJabatanByMahasiswa(mahasiswaService.getMahasiswaByNim("12s14008"));
        System.out.println("======================================");
        System.out.println("Nama\t:"+m.getMahasiswa().getNamaLengkap());
        System.out.println("Jabatan\t:"+m.getJabatan().getNamaJabatan());
        System.out.println("======================================");

    }

    @Test
    public void menamilkanDokumen()
    {
        List<Dokumen> dokumens = dokumenService.getAllDokumen("%Boot%");
        for(Dokumen d : dokumens)
        {
            System.out.println("=================================");
            System.out.println("Nama Dokumen\t"+d.getFileName());
            System.out.println("=================================");
        }
    }
}
