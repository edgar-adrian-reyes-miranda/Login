package com.logueo.spring.Exption;

import com.logueo.spring.DTO.MesajesActividades;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

public class Exception {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<MesajesActividades>macSizeException(MaxUploadSizeExceededException exc){
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new MesajesActividades("Uno o mas archivos exceden el tamaño"));
    }
}
