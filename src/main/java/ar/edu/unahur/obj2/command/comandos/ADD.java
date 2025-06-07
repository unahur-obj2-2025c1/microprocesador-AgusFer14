package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class ADD extends Command{

    @Override
    public void doExecute(Programable micro) {
        Integer resultado = micro.getAcumuladorA() + micro.getAcumuladorB();
        micro.setAcumuladorA(resultado);
        micro.setAcumuladorB(0);
    }
    
}
