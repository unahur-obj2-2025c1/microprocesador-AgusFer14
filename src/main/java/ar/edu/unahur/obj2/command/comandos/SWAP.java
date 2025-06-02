package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP implements Operable{

    @Override
    public void execute(Programable micro) {
        Integer a = micro.getAcumuladorA();
        Integer b = micro.getAcumuladorB();
        micro.setAcumuladorA(b);
        micro.setAcumuladorB(a);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undo'");
    }
    
}
