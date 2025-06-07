package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV extends Command{

    private Integer valor;

    public LODV(Integer valor) {
        this.valor = valor;
    }

    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(valor);
    }
    
}
