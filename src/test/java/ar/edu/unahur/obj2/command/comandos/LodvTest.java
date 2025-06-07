package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

class LodvTest {

    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void alEjecutarLaInstucionLodv_seCargaElAcumuladorAYSeIncrementaElProgramaCounter() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(20));

        programable.run(operaciones);

        assertEquals(20, programable.getAcumuladorA());
        assertEquals(1, programable.getProgramCounter());
    }
}
