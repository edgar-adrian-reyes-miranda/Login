package com.logueo.spring.Repository;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public interface ActividadesRepository {

    public void init();
    public void save(MultipartFile file);
    public Resource load(String filename);

    public void deleteall();
    public Stream<Path> loadall();

    public String deleteFile(String filename);

}
