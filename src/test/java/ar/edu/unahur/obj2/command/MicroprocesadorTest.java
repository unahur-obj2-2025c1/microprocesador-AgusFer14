package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class MicroprocesadorTest {

    Programable programable = new Microprocesador();

    @BeforeEach
    void setUp() {
        programable.reset();
    }

    @Test
    public void avanzaTresNOP() {
        ProgramBuilder programBuilder = new ProgramBuilder();

        programable.run(programBuilder
                        .nop()
                        .nop()
                        .nop().build());

        assertEquals(3, programable.getProgramCounter());
    }

    @Test
    public void suma20y17() {
        ProgramBuilder programBuilder = new ProgramBuilder();

        programable.run(programBuilder
                        .lodv(20)
                        .swap()
                        .lodv(17)
                        .add().build());

        assertEquals(37, programable.getAcumuladorA());
        assertEquals(0, programable.getAcumuladorB());
        assertEquals(4, programable.getProgramCounter());
    }

    @Test
    public void suma2_8_5() {
        ProgramBuilder programBuilder = new ProgramBuilder();

        programable.run(programBuilder
                        .lodv(2)
                        .str(0)
                        .lodv(8)
                        .swap()
                        .lodv(5)
                        .add()
                        .swap()
                        .lod(0)
                        .add().build());

        assertEquals(15, programable.getAcumuladorA());
        assertEquals(0, programable.getAcumuladorB());
        assertEquals(9, programable.getProgramCounter());
    }

    @Test
    void alBuildearUnProgramaConInstrucciones_CuandoSeLoPasamosAUnMicrocontrolador_FuncionaCorrectamente() {
        ProgramBuilder rutina = new ProgramBuilder();
        ProgramBuilder programBuilderPpal = new ProgramBuilder();

        programable.run(
                programBuilderPpal
                        .lodv(5)
                        .ifnz(rutina
                                .nop()
                                .nop()
                                .swap()
                                .build())
                        .build());

        assertEquals(0, programable.getAcumuladorA());
        assertEquals(5, programable.getAcumuladorB());
        assertEquals(5, programable.getProgramCounter());
    }

    @Test
    void alBuildearUnProgramaSinInstrucciones_SeLanzaUnError() {
        ProgramBuilder programBuilder = new ProgramBuilder();
        assertThrows(MicroException.class, programBuilder::build);

    }
    
}
