package com.sibftie;

import com.sibftie.model.*;
import com.sibftie.service.AkunService;
import com.sibftie.service.MahasiswaJabatanService;
import com.sibftie.service.MahasiswaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by solo on 26/05/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MahasiswaJabatanTest
{
    @Autowired
    AkunService akunService;

    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    MahasiswaJabatanService mahasiswaJabatanService;

    @Test
    public void testGetMahasiswaJabatan()
    {
        String email = "iss14023@students.del.ac.id";
        Akun a = null;
        a = akunService.getAkunByEmail(email);
        MahasiswaJabatan mj = mahasiswaJabatanService.getMahasiswaJabatanByMahasiswa(a.getMahasiswa());
        System.out.println("================================");
        System.out.println("Nama\t:"+mj.getMahasiswa().getNamaLengkap());
        System.out.println("Jabatan\t:"+mj.getJabatan().getNamaJabatan());
        System.out.println("================================");

    }
}
