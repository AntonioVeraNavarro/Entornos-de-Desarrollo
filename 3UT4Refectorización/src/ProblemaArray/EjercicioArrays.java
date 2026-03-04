package ProblemaArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class EjercicioArrays {

    public static void main(String[] args) {
        int numAlumnos = 40;
        Integer[] control = new Integer[numAlumnos];
        int[] practicas = new int[numAlumnos];
        float[] calificaciones = new float[numAlumnos];

        // Rellenado de datos iniciales
        for (int i = 0; i < numAlumnos; i++) {
            control[i] = (int) (Math.random() * 11);
            practicas[i] = (int) (Math.random() * 11);
            calificaciones[i] = (control[i] + (float) practicas[i]) / 2;
        }

        List<Integer> notasList = Arrays.asList(control);
        int min = Collections.min(notasList), max = Collections.max(notasList);

        System.out.println("Mínimo: " + min + " | Máximo: " + max);
        System.out.println("Índice Mín: " + (notasList.indexOf(min) + 1) + " | Máx: " + (notasList.indexOf(max) + 1));
        System.out.println("Notas: " + notasList + "\nPrácticas: " + Arrays.toString(practicas) + "\nCalificaciones: " + Arrays.toString(calificaciones));

        // REFACTORIZACIÓN FINAL: Estadísticas en una sola línea usando Streams
        IntStream.range(0, 10).forEach(i -> {
            long count = IntStream.range(0, numAlumnos).filter(j -> calificaciones[j] > i && calificaciones[j] <= i + 1).count();
            System.out.printf("Estadística tramo <= %d = %.2f%%\n", (i + 1), (count * 100.0 / numAlumnos));
        });

        // Mantenemos el bucle de aprobados/suspensos para conservar los "huecos" de ceros originales
        int[] aprobados = new int[numAlumnos], suspensos = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++) {
            if (calificaciones[i] < 5) aprobados[i] = i + 1;
            else suspensos[i] = i + 1;
        }

        System.out.println("Relación aprobados: " + Arrays.toString(aprobados));
        System.out.println("Relación suspensos: " + Arrays.toString(suspensos));

        // Refactorización de inserción final usando Arrays.setAll e IntStream
        double[] calif = new double[40];
        Arrays.setAll(calif, i -> i < 31 ? (int)(Math.random() * 11) : 0);
        calif[3] = 6;
        System.out.println("Nota nueva alumno nº4: " + calif[3]);
    }
}