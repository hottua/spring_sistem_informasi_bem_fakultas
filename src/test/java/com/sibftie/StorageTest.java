package com.sibftie;

import com.sibftie.configuration.FileStorageProperties;
import com.sibftie.service.FileStorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by solo on 03/06/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageTest
{

    @Autowired
    FileStorageService fileStorageService;

    @Test
    public void testStorage()
    {
        FileStorageProperties fileStorageProperties = new FileStorageProperties();
        System.out.println(fileStorageProperties.getLocation());
        fileStorageProperties.setLocation(fileStorageProperties.getLocation()+"\\dokument");
        System.out.println(fileStorageProperties.getLocation());
    }


    @Test
    public void testCreateDirectory()
    {
        MultipartFile m = new MultipartFile() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getOriginalFilename() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {

            }
        };
        fileStorageService.store(m, "\\iss14008\\images");
    }

}
