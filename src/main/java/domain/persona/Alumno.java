package domain.persona;

import domain.academico.Materia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String legajo;
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre, Materia ... materias) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
        this.agregarMaterias(materias);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public Boolean cumpleConCorrelativas(Materia materia){
        return this.getMateriasAprobadas()
            .containsAll(materia.getCorrelativas());
    }

    public void agregarMaterias(Materia ... materias){
        Collections.addAll(this.materiasAprobadas, materias);
    }
}