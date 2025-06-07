package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

class CommandTest {
    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void testUndo() {

        Operable lodv20 = new LODV(20);
        Operable swap = new SWAP();
        Operable lodv17 = new LODV(17);
        Operable suma = new ADD();

        lodv20.execute(programable);
        swap.execute(programable);
        lodv17.execute(programable);
        suma.execute(programable);
        suma.undo(programable);

        assertEquals(17, programable.getAcumuladorA());
        assertEquals(20, programable.getAcumuladorB());
        assertEquals(3, programable.getProgramCounter());
    }
}
