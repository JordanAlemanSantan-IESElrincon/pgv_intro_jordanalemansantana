package Tema1Procesos;

import java.io.IOException;
import java.util.Arrays;

public class LanzaProceso {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Debe indicarse comando a ejecutar: ");
            System.exit(1);
        }

        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();

        try {
            Process p = pb.start();
            int codRet = p.waitFor();
            System.out.println("Hola, Mundo!");
            System.out.println("La ejecución de " + Arrays.toString(args)
                    + " devuelve " + codRet
                    + " " + (codRet == 0 ? "(ejecución correcta)" : "(ERROR)"));
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("----------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }
    }
    // public static void main(String[] args) {
    // System.out.println("Hola");
    // ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\System32\\cmd.exe",
    // "/c", "dir", "src\\Tema1Procesos"); // Ejemplo: listar archivos en un
    // directorio
    // pb.inheritIO(); // Redirigir los flujos de entrada y salida

    // try {
    // Process process = pb.start(); // Iniciar el proceso
    // int exitCode = process.waitFor(); // Esperar a que el proceso termine
    // System.out.println("El proceso ha terminado con código de salida: " +
    // exitCode);
    // } catch (IOException | InterruptedException e) {
    // System.out.println("No funciono");
    // e.printStackTrace();
    // }
    // }
}
