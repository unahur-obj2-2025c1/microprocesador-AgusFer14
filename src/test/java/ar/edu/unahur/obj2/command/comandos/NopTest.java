package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

class NopTest {
    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void alEjecutarLaInstrucionNop_avanzaElProgramCounter() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new NOP());
        operaciones.add(new NOP());
        programable.run(operaciones);
        assertEquals(2, programable.getProgramCounter());
    }
}
