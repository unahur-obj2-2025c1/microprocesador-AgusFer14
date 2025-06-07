package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class CompositeCommand extends Command{

    protected List<Operable> operaciones;

    protected CompositeCommand(List<Operable> operaciones) {
        this.operaciones = new ArrayList<>(operaciones);
    }

    protected Boolean notZero(Programable micro) {
        return !micro.getAcumuladorA().equals(0);
    }

    @Override
    public void doExecute(Programable micro) {
        if(Boolean.TRUE.equals(this.notZero(micro))) {
            micro.run(operaciones);
        }
    }
    
}
