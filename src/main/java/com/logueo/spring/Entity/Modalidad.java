package com.logueo.spring.Entity;

public enum Modalidad{
    modadlidadh(TIPOModalidad.HIBRIDA),
    modalidadp(TIPOModalidad.PRESENCIAL),
    modalidadv(TIPOModalidad.VIRTUAL);
    private final TIPOModalidad tipo;
    Modalidad(TIPOModalidad tipo){
        this.tipo=tipo;
    }
    public TIPOModalidad getTipo(){
        return tipo;
    }
}
