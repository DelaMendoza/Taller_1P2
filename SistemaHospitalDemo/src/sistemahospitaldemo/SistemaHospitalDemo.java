package sistemahospitaldemo;
import Servicios.Servicios;
import java.util.Scanner;

public class SistemaHospitalDemo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=====Sistema de gestion hospitalaria=====");
            System.out.println("=====Menu principal=====");
            System.out.println("1. Gestion de pacientes");
            System.out.println("2. Gestion de empleados");
            System.out.println("3. Gestion de citas");
            System.out.println("4. Calculo de nomina total");
            System.out.println("5. Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    Servicios.MenuPacientes();
                    break;
                case 2:
                    Servicios.MenuEmpleados();
                    break;
                case 3:
                    Servicios.MenuCitas();
                    break;
                case 4:
                    System.out.println("La nomina total es:" );
                    break;
            }
        } while (opcion != 5);
        System.out.println("Saliendo del sistema...");

    }

}
