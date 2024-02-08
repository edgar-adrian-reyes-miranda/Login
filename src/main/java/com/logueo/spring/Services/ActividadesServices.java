package com.logueo.spring.Services;


import com.logueo.spring.Repository.ActividadesRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class ActividadesServices implements ActividadesRepository {
    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede iniciar el almacenamiento", e);
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException("No se puede guardar el archivo", e);
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("No se puede leer el archivo " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error al cargar el archivo " + filename, e);
        }
    }

    @Override
    public void deleteall() {
        try {
            FileSystemUtils.deleteRecursively(root);
        } catch (IOException e) {
            throw new RuntimeException("No se puede eliminar todos los archivos", e);
        }
    }

    @Override
    public String deleteFile(String filename) {
        try {
            boolean delete = Files.deleteIfExists(this.root.resolve(filename));
            return delete ? "Borrado" : "El archivo no existe";
        } catch (IOException e) {
            throw new RuntimeException("Error al borrar el archivo " + filename, e);
        }
    }

    @Override
    public Stream<Path> loadall() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root))
                    .map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("No se puede cargar los archivos", e);
        }
    }
}
