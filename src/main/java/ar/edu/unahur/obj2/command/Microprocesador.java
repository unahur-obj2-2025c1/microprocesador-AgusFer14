package ar.edu.unahur.obj2.command;

import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable{

    private Integer AcumuladorA = 0;
    private Integer AcumuladorB = 0;
    private Integer PC = 0;
    private static final Integer MIN_ADDR_VALUE = 0;
    private static final Integer MAX_ADDR_VALUE = 1023;
    List<Integer> addrs = Arrays.asList(new Integer[1024]);


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
        PC = programable.getProgramCounter();
        AcumuladorA = programable.getAcumuladorA();
        AcumuladorB = programable.getAcumuladorB();
    }

    @Override
    public Programable copy() {
        Microprocesador copia = new Microprocesador();
        copia.PC = this.PC;
        copia.AcumuladorA = this.AcumuladorA;
        copia.AcumuladorB = this.AcumuladorB;
        return copia;
    }

    @Override
    public void reset() {
        AcumuladorA = 0;
        AcumuladorB = 0;
        PC = 0;
        addrs = Arrays.asList(new Integer [1024]);
    }

    private Boolean estaEnRango(Integer addr) {
        return addr >= MIN_ADDR_VALUE && addr <= MAX_ADDR_VALUE;
    }

    @Override
    public void setAddr(Integer addr) {
        if(!estaEnRango(addr))
            throw new IllegalArgumentException("La dirección de memoria no es válida");
        addrs.set(addr, AcumuladorA);    
    }

    @Override
    public Integer getAddr(Integer addr) {
        if(!estaEnRango(addr))
            throw new MicroException("La dirección de memoria no es válida");
        return addrs.get(addr);
    }

}