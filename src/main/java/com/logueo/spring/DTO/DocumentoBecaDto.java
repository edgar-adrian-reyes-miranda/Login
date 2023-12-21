package com.logueo.spring.DTO;

import java.io.Serializable;

import lombok.*;
@Data
public class DocumentoBecaDto implements Serializable {
    private static final long SerialVersionUID=1L;
    private byte[] pago;
    private  byte[] cuenta;
    private Beca beca;

}
