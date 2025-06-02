package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class NOP implements Operable{

    @Override
    public void execute(Programable micro) {
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undo'");
    }
    
}
