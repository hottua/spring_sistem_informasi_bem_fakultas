package com.sibftie;

import com.sibftie.controller.MembacaPDF;
import com.sibftie.model.Dokumen;
import com.sibftie.service.DokumenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by solo on 04/06/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PDFReaderTest
{

    @Autowired
    DokumenService dokumenService;
    @Test
    public void testPdfReader()
    {
        MembacaPDF m = new MembacaPDF();
        m.readPdf();
    }

    @Test
    public void testDokumen()
    {
        Dokumen d = dokumenService.getDokumenById(2);
        System.out.println("==============================");
        System.out.println("Dokumen\t"+d.getJdlDokumen());
        System.out.println("Di unggah\t"+d.getMahasiswa().getNim());
        System.out.println("==============================");
    }

    @Test
    public void countString()
    {
        MembacaPDF m = new MembacaPDF();
        m.countString();
    }
}
