/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir datos del estudiante
        System.out.println("Ingrese el nombre del estudiante:");
        String nombreEstudiante = scanner.nextLine();

        System.out.println("Ingrese la edad del estudiante:");
        int edadEstudiante = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el sexo del estudiante (M o F):");
        char sexoEstudiante = scanner.nextLine().charAt(0);

        int calificacionEstudiante = generarCalificacion();

        Estudiante estudiante = new Estudiante(nombreEstudiante, edadEstudiante, sexoEstudiante, calificacionEstudiante);

        // Pedir datos del profesor
        System.out.println("Ingrese el nombre del profesor:");
        String nombreProfesor = scanner.nextLine();

        System.out.println("Ingrese la edad del profesor:");
        int edadProfesor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el sexo del profesor (M o F):");
        char sexoProfesor = scanner.nextLine().charAt(0);

        System.out.println("Ingrese la materia que da el profesor (matemáticas, filosofía o física):");
        String materiaProfesor = scanner.nextLine();

        Profesor profesor = new Profesor(nombreProfesor, edadProfesor, sexoProfesor, materiaProfesor);

        // Pedir datos del aula
        System.out.println("Ingrese el identificador numérico del aula:");
        int idAula = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el número máximo de estudiantes del aula:");
        int maxEstudiantesAula = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la materia para la que está destinada el aula (matemáticas, filosofía o física):");
        String materiaAula = scanner.nextLine();

        Aula aula = new Aula(idAula, maxEstudiantesAula, materiaAula);
        aula.setProfesor(profesor);
        aula.agregarEstudiante(estudiante);

        // Determinar si se puede dar clase
        if (aula.sePuedeDarClase()) {
            System.out.println("Se puede dar clase en el aula " + aula.getId() + ".");

            int aprobadosMujeres = aula.cantidadAprobados('F');
            int aprobadosHombres = aula.cantidadAprobados('M');

            System.out.println("Cantidad de mujeres aprobadas: " + aprobadosMujeres);
            System.out.println("Cantidad de hombres aprobados: " + aprobadosHombres);
        } else {
            System.out.println("No se puede dar clase en el aula " + aula.getId() + ".");
        }
    }

    private static int generarCalificacion() {
        Random random = new Random();
        return random.nextInt(11);
    }
}