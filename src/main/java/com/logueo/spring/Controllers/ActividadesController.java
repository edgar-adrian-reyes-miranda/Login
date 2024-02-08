package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.MesajesActividades;
import com.logueo.spring.Entity.Actividades;
import com.logueo.spring.Repository.ActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ActividadesController {

    @Autowired
    ActividadesRepository actividadesRepository;
    @PostMapping("/upload")
    public ResponseEntity<MesajesActividades> uploadfile(@RequestParam ("files")MultipartFile[] files){
        String menssages="";
        try {

            List<String> filename = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file -> {
                actividadesRepository.save(file);
                filename.add(file.getOriginalFilename());
            });
            menssages ="Se subieron correctamente los archivos"+ filename;
            return  ResponseEntity.status(HttpStatus.OK).body(new MesajesActividades(menssages));
        }catch (Exception e){
            menssages= "Fallo al subir los archivos";
            return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MesajesActividades(menssages));
        }
    }

    @GetMapping("/file")
    public ResponseEntity<List<Actividades>> getFiles(){
            List<Actividades> fileinfo= actividadesRepository.loadall().map(path ->{
                String filename = path.getFileName().toString();
                String url = MvcUriComponentsBuilder.fromMethodName(ActividadesController.class, "getFIle",
                        path.getFileName().toString()).build().toString();
                return new Actividades(url, filename);
                    }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(fileinfo);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<Resource> getfile(@PathVariable String filename){
        Resource file = actividadesRepository.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+ file.getFilename()+ "\"").body(file);
    }

    @DeleteMapping("/filename/{filename}")
    public ResponseEntity<MesajesActividades> deltefile(@PathVariable String filename){
        String meessage="";
        try {
            meessage
                    = actividadesRepository.deleteFile(filename);
            return  ResponseEntity.status(HttpStatus.OK).body(new MesajesActividades(meessage));
        }catch (Exception e){
        return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MesajesActividades(meessage));
        }
    }
}
