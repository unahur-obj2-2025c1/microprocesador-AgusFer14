package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LOD implements Operable{

    private Integer direccion;

    public LOD(Integer direccion) {
        this.direccion = direccion;
    }

    @Override
    public void execute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(direccion));
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undo'");
    }
    
}
