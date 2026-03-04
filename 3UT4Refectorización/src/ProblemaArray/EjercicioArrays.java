package ProblemaArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EjercicioArrays {

    public static void main(String[] args) {
        int numAlumnos = 40;
        Integer[] control = new Integer[numAlumnos];
        int[] practicas = new int[numAlumnos];
        float[] calificaciones = new float[numAlumnos];

        // REFACTORIZACIÓN 2: Unificación de la generación de datos en un solo bucle
        for (int i = 0; i < numAlumnos; i++) {
            control[i] = (int) (Math.random() * 11);
            practicas[i] = (int) (Math.random() * 11);
            calificaciones[i] = (control[i] + (float) practicas[i]) / 2;
        }

        // Búsqueda de extremos
        int minNota = Collections.min(Arrays.asList(control));
        int maxNota = Collections.max(Arrays.asList(control));

        List<Integer> notasList = Arrays.asList(control);
        
        System.out.println("Mínimo: " + minNota + " | Máximo: " + maxNota);
        System.out.println("Índice Mín: " + (notasList.indexOf(minNota) + 1) + " | Máx: " + (notasList.indexOf(maxNota) + 1));
        System.out.println("Array de Notas: " + notasList);
        System.out.println("Prácticas      : " + Arrays.toString(practicas));
        System.out.println("Calificaciones : " + Arrays.toString(calificaciones));

        // Lógica de aprobados y suspensos
        int[] aprobados = new int[numAlumnos];
        int[] suspensos = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++) {
            if (calificaciones[i] < 5) {
                aprobados[i] = i + 1;
            } else {
                suspensos[i] = i + 1;
            }
        }

        System.out.println("Relación aprobados: " + Arrays.toString(aprobados));
        System.out.println("Relación suspensos: " + Arrays.toString(suspensos));

        // Inserción de nota final simplificada
        double[] calif = new double[40];
        for (int j = 0; j < 31; j++) {
            calif[j] = (int) (Math.random() * 11);
        }
        calif[3] = 6;
        System.out.println("Nota nueva alumno nº4: " + calif[3]);
    }
}