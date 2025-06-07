package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class Command implements Operable{

    Programable programableUndo;

    @Override
    public void execute(Programable micro) {
        programableUndo = micro.copy();
        doExecute(micro);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        micro.copyFrom(programableUndo);;
    }

    public abstract void doExecute(Programable micro);
    
}
