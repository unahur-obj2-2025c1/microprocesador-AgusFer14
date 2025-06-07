package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP extends Command{

    @Override
    public void doExecute(Programable micro) {
        Integer buffer = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(buffer);
    }
    
}
