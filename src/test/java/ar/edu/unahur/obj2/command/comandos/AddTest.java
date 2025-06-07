package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class AddTest {

    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void alSumarAcumuladorAMasAcumuladorB_elResultadoQuedaEnElAcumuladorA() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(20));
        operaciones.add(new SWAP());
        operaciones.add(new LODV(17));
        operaciones.add(new ADD());

        programable.run(operaciones);

        assertEquals(37, programable.getAcumuladorA());
        assertEquals(0, programable.getAcumuladorB());
        assertEquals(4, programable.getProgramCounter());
    }

    @Test
    void alSumar3ValoresPasandoPorElAreaDeDatos_elResultadoQuedaEnElAcumuladorA() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(2));
        operaciones.add(new STR(0));
        operaciones.add(new LODV(8));
        operaciones.add(new SWAP());
        operaciones.add(new LODV(5));
        operaciones.add(new ADD());
        operaciones.add(new SWAP());
        operaciones.add(new LOD(0));
        operaciones.add(new ADD());
        programable.run(operaciones);

        assertEquals(15, programable.getAcumuladorA());
        assertEquals(0, programable.getAcumuladorB());
        assertEquals(9, programable.getProgramCounter());
    }

}
