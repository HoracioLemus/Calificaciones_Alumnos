/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Aula {
    private final int id;
    private final int maxEstudiantes;
    private final String materia;
    private Profesor profesor;
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public Aula(int id, int maxEstudiantes, String materia) {
        this.id = id;
        this.maxEstudiantes = maxEstudiantes;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public int getMaxEstudiantes() {
        return maxEstudiantes;
    }

    public String getMateria() {
        return materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public boolean sePuedeDarClase() {
        if (profesor == null) {
            return false;
        }

        if (!profesor.getMateria().equals(materia)) {
            return false;
        }

        int totalEstudiantes = estudiantes.size();

        if (totalEstudiantes == 0) {
            return false;
        }

        int aprobados = cantidadAprobados();

        if (aprobados < (totalEstudiantes / 2)) {
            return false;
        }

        return true;
    }

    public int cantidadAprobados() {
        int aprobados = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCalificacion() >= 6) {
                aprobados++;
            }
        }

        return aprobados;
    }

    public int cantidadAprobados(char sexo) {
        int aprobados = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getSexo() == sexo && estudiante.getCalificacion() >= 6) {
                aprobados++;
            }
        }

        return aprobados;
    }
}