import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RegistroParticipantes {
    public static void main(String[] args) {
        Set<String> estudiantes = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- Registro de Participantes ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Mostrar estudiantes");
            System.out.println("5. Mostrar numero de estudiantes");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el enter

            switch (opcion) {
                case 1:
                    System.out.print("ID del estudiante: ");
                    String nuevo = sc.nextLine();
                    boolean agregado = estudiantes.add(nuevo);
                    if (agregado) {
                        System.out.println("Estudiante registrado.");
                    } else {
                        System.out.println("El estudiante ya existia.");
                    }
                    break;

                case 2:
                    System.out.print("ID a buscar: ");
                    String buscar = sc.nextLine();
                    if (estudiantes.contains(buscar)) {
                        System.out.println("El estudiante " + buscar + " esta registrado.");
                    } else {
                        System.out.println("El estudiante no esta registrado.");
                    }
                    break;

                case 3:
                    System.out.print("ID a eliminar: ");
                    String eliminar = sc.nextLine();
                    if (estudiantes.remove(eliminar)) {
                        System.out.println("Estudiante eliminado.");
                    } else {
                        System.out.println("El estudiante no existe.");
                    }
                    break;

                case 4:
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        System.out.println("Estudiantes:");
                        for (String e : estudiantes) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Total de estudiantes: " + estudiantes.size());
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}