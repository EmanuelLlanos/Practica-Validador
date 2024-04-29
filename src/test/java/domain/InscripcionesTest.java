package domain;

import domain.academico.Inscripcion;
import domain.academico.Materia;
import domain.persona.Alumno;
import org.junit.Assert;
import org.junit.Test;

public class InscripcionesTest {
  Materia ingles1 = new Materia("ingles1");
  Materia ingles2 = new Materia("ingles2");
  Materia ingles3 = new Materia("ingles3");
  Materia matematica = new Materia("Matematica");
  Materia matematica2 = new Materia("Matematica2");


  @Test
  public void faltanCorrelativas(){
    Alumno boris = new Alumno("Boris", ingles1, matematica);
    ingles3.agregarCorrelativas(ingles1, ingles2);
    Inscripcion inscripcion = new Inscripcion(boris, ingles3);

    Assert.assertFalse(inscripcion.aprobada());
  }

  @Test
  public void notieneMateriasAprobadas(){
    Alumno camilo = new Alumno("Camilo");
    matematica2.agregarCorrelativas(matematica);
    Inscripcion inscripcion = new Inscripcion(camilo, matematica2);

    Assert.assertFalse(inscripcion.aprobada());
  }

  @Test
  public void tieneLasCorrelativas(){
    Alumno jorge = new Alumno("Jorge", ingles1, ingles2, matematica);
    ingles3.agregarCorrelativas(ingles1, ingles2);
    matematica2.agregarCorrelativas(matematica);
    Inscripcion inscripcion = new Inscripcion(jorge, ingles3, matematica2);

    Assert.assertTrue(inscripcion.aprobada());
  }
}
