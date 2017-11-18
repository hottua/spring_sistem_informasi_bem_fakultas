package com.sibftie.dao.storage;

import com.sibftie.exception.StorageException;
import com.sibftie.exception.StorageFileNotFoundException;
import com.sibftie.configuration.FileStorageProperties;
import com.sibftie.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private Path rootLocation;

    @Autowired
    public FileStorageServiceImpl(FileStorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    public void setRootLocation(String location) {
        if(location.isEmpty() || location.contains(" ") || location.contains("."))
            throw  new StorageException("Nama folder idak boleh berisi `~!@#$%^&*(),");
        FileStorageProperties properties = new FileStorageProperties();
        properties.setLocation(properties.getLocation()+location);
        this.rootLocation = Paths.get(properties.getLocation());
        if(!Files.exists(rootLocation))
        {
            System.out.println("Folder : "+location+" belum ada. Mencoba untuk membuat direktori");
            init();
        }

    }

    @Override
    public String store(MultipartFile file, String location) {
        String pathFile="";
        setRootLocation(location);
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
//            java.util.UUID.randomUUID().toString().replace("-", "")
            String newFileName = file.getOriginalFilename();
            Files.copy(file.getInputStream(), this.rootLocation.resolve(newFileName), StandardCopyOption.REPLACE_EXISTING);
            pathFile = newFileName;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
        return pathFile;
    }

    @Override
    public Stream<Path> loadAll(String location) {
        setRootLocation(location);
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename, String location) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename, String location) {
        setRootLocation(location);
        try {
            Path file = load(filename, location);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll(String location) {
        setRootLocation(location);
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
            System.out.println("Berhasil membuat direktori : "+rootLocation.getFileName());
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
