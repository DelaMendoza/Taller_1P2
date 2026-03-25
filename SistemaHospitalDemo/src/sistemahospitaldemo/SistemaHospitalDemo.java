package sistemahospitaldemo;

import java.util.Scanner;
import modelo.hospital.Hospital;
import servicios.Servicios;

public class SistemaHospitalDemo {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Hospital hospital = new Hospital("Mi hospital", "Mi direccion");
        int opcion;

        do {
            System.out.println("=====Sistema de gestion hospitalaria=====");
            System.out.println("=====Menu principal=====");
            System.out.println("1. Gestion de pacientes");
            System.out.println("2. Gestion de empleados");
            System.out.println("3. Calculo de nomina total");
            System.out.println("4. Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    Servicios.menuPacientes();
                    break;
                case 2:
                    Servicios.menuEmpleados();
                    break;
                case 3:
                    System.out.println("La nomina total es:" + hospital.calcularNominaTotal());
                    break;
                case 4:
                    break;
            }
        } while (opcion != 4);
        System.out.println("Saliendo del sistema...");

    }

}
