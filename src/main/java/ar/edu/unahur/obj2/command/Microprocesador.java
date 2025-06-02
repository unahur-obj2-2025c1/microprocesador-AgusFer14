package ar.edu.unahur.obj2.command;

import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class Microprocesador implements Programable{

    private Integer AcumuladorA = 0;
    private Integer AcumuladorB = 0;
    private Integer PC = 0;
    private Integer Datos = 0;

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.stream().forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        PC ++;
    }

    @Override
    public Integer getProgramCounter() {
        return PC;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        AcumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return AcumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        AcumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return AcumuladorB;
    }

    @Override
    public void copyFrom(Programable programable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copyFrom'");
    }

    @Override
    public Programable copy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copy'");
    }

    @Override
    public void reset() {
        AcumuladorA = 0;
        AcumuladorB = 0;
        PC = 0;
        Datos = 0;
    }

    private void validarDireccion(Integer addr) {
        if(addr < 0 || addr >= 1023) {
            throw new RuntimeException("Dirección fuera de rango: " + addr);
        }
    }

    @Override
    public void setAddr(Integer addr) {
        this.validarDireccion(addr);
        Datos = AcumuladorA;
    }

    @Override
    public Integer getAddr(Integer addr) {
        this.validarDireccion(addr);
        return Datos;
    }

}