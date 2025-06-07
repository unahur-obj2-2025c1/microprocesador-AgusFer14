package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.IFNZ;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;
import ar.edu.unahur.obj2.command.comandos.WHNZ;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class ProgramBuilder {

    List<Operable> operaciones = new ArrayList<>();

    public ProgramBuilder nop() {
        operaciones.add(new NOP());
        return this;
    }

    public ProgramBuilder add() {
        operaciones.add(new ADD());
        return this;
    }

    public ProgramBuilder swap() {
        operaciones.add(new SWAP());
        return this;
    }

    public ProgramBuilder lod(Integer add) {
        operaciones.add(new LOD(add));
        return this;
    }

    public ProgramBuilder str(Integer add) {
        operaciones.add(new STR(add));
        return this;
    }

    public ProgramBuilder lodv(Integer add) {
        operaciones.add(new LODV(add));
        return this;
    }

    public ProgramBuilder ifnz(List<Operable> operacionesList) {
        operaciones.add(new IFNZ(operacionesList));
        return this;
    }

    public ProgramBuilder whno(List<Operable> operacionesList) {
        operaciones.add(new WHNZ(operacionesList));
        return this;
    }

    public List<Operable> build() {
        if(operaciones.isEmpty())
            throw new MicroException("No se puede builder un programa sin operaciones");
        return operaciones;
    }
}
