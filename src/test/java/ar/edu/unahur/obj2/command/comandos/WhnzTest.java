package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

class WhnzTest {

    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void testDoExecute() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new SWAP());
        operaciones.add(new LODV(17));
        operaciones.add(new ADD());
        operaciones.add(new SWAP());
        Operable load20 = new LODV(20);
        load20.execute(programable);
        Operable whnz = new WHNZ(operaciones);

        whnz.execute(programable);

        assertEquals(0, programable.getAcumuladorA());
        assertEquals(37, programable.getAcumuladorB());
        assertEquals(6, programable.getProgramCounter());
    }
}
