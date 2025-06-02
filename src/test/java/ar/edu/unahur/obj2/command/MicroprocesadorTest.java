package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;

public class MicroprocesadorTest {

    @Test
    public void avanzaTresNOP() {
        Microprocesador micro = new Microprocesador();
        List<Operable> programa = new ArrayList<>();
        programa.add(new NOP());
        programa.add(new NOP());
        programa.add(new NOP());

        micro.run(programa);

        assertEquals(3, micro.getProgramCounter());
    }

    @Test
    public void suma20y17() {
        Microprocesador micro = new Microprocesador();
        List<Operable> programa = new ArrayList<>();
        programa.add(new LODV(20));
        programa.add(new SWAP());
        programa.add(new LODV(17));
        programa.add(new ADD());

        micro.run(programa);

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());
    }

    @Test
    public void suma2_8_5() {
        Microprocesador micro = new Microprocesador();
        List<Operable> programa = new ArrayList<>();
        programa.add(new LODV(2));
        programa.add(new STR(0));
        programa.add(new LODV(8));
        programa.add(new SWAP());
        programa.add(new LODV(5));
        programa.add(new ADD());
        programa.add(new SWAP());
        programa.add(new LOD(0));
        programa.add(new ADD());

        micro.run(programa);

        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }
}
