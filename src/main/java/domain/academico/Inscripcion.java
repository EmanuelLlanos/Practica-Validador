package domain.academico;

import domain.persona.Alumno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, Materia ... materias) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
        this.agregarMateriasInscripcion(materias);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public Boolean aprobada(){
        //recorro la lista de materias en las que se quiere inscibir, y me fijo si se puede
      boolean respuesta = true;

      respuesta = this.materias
          .stream()
          .allMatch(m -> this.alumno.cumpleConCorrelativas(m));

      if(respuesta){
        System.out.println("Inscripcion aceptada " + alumno.getNombre() + " puede cursar: ");
        this.materias.stream().map(Materia :: getNombre).forEach(System.out::println);
      }else {System.out.println("Inscripcion rechazada, a " + alumno.getNombre() + " le faltan correlativas");}

      return respuesta;
    }

    public void agregarMateriasInscripcion(Materia ... materias){
        Collections.addAll(this.materias, materias);
    }
}


