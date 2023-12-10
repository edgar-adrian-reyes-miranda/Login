package com.logueo.spring.Entity;

public enum Unidades {
    CURSO1(Unidad.PRIMERA),
    CURSO2(Unidad.SEGUNDA),
    CURSO3(Unidad.TERCERA),
    CURSO4(Unidad.CUARTA),
    CUROSF(Unidad.FINALIZADO);

    private final Unidad tipo;
    Unidades(Unidad tipo){
        this.tipo=tipo;
    }
    public Unidad getTipo(){
        return tipo;
    }

}
