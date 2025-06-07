package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

class IfnzTest {
    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void alEjecutarLaInstucionIfnz_siendoElAcumuladorANo0_seEjecutanLasInstrucciones() {

        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new SWAP());

        Operable lodv20 = new LODV(20);
        lodv20.execute(programable);

        Operable ifnz = new IFNZ(operaciones);

        ifnz.execute(programable);

        assertEquals(0, programable.getAcumuladorA());
        assertEquals(20, programable.getAcumuladorB());
        assertEquals(3, programable.getProgramCounter());

    }

    @Test
    void alEjecutarLaInstucionIfnz_siendoElAcumuladorA0_NoseEjecutanLasInstrucciones() {

        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new SWAP());
        operaciones.add(new LODV(17));
        operaciones.add(new ADD());

        Operable lodv20 = new LODV(20);
        Operable swap = new SWAP();
        lodv20.execute(programable);
        swap.execute(programable);

        Operable ifnz = new IFNZ(operaciones);

        ifnz.execute(programable);

        assertEquals(0, programable.getAcumuladorA());
        assertEquals(20, programable.getAcumuladorB());
        assertEquals(3, programable.getProgramCounter());

    }

}
