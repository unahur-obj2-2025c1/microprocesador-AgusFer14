package ar.edu.unahur.obj2.command.comandos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

class SwapTest {
    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    void alEjecutarLaInstruccionSwap_seIntercambiaLosValoresEnLosAcumuladoresYSeIncrementaElProgamaCounter() {
        List<Operable> operaciones = new ArrayList<>();
        operaciones.add(new LODV(20));
        operaciones.add(new SWAP());

        programable.run(operaciones);

        assertEquals(0, programable.getAcumuladorA());
        assertEquals(20, programable.getAcumuladorB());
        assertEquals(2, programable.getProgramCounter());
    }
}

