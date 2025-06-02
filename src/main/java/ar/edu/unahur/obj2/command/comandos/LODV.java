package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV implements Operable{

    private Integer valor;

    public LODV(Integer valor) {
        this.valor = valor;
    }

    @Override
    public void execute(Programable micro) {
        micro.setAcumuladorA(valor);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undo'");
    }
    
}
