package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class ADD implements Operable{

    @Override
    public void execute(Programable micro) {
        Integer resultado = micro.getAcumuladorA() + micro.getAcumuladorB();
        micro.setAcumuladorA(resultado);
        micro.setAcumuladorB(0);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undo'");
    }
    
}
