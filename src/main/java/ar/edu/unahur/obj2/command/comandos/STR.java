package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR extends Command{

    private Integer add;

    public STR(Integer add) {
        this.add = add;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAddr(add);
    }
    
}
