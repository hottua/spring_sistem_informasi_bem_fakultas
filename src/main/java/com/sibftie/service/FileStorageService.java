package com.sibftie.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService
{
    public void init();

    public String store (MultipartFile file, String location);

    public Stream<Path> loadAll(String location);

    public Path load(String filename, String location);

    public Resource loadAsResource(String filename, String location);

    public void deleteAll(String location);
}
