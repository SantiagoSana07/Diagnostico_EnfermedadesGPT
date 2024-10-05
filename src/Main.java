import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PacienteDAO pacienteDAO = new PacienteDAO();
        MedicoDAO medicoDAO = new MedicoDAO();
        ConsultaDAO consultaDAO = new ConsultaDAO();
        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

        System.out.println("Bienvenido al Sistema de Diagnóstico de Enfermedades");
        boolean continuar = true;

        while (continuar) {
            System.out.println("Elija una opción:");
            System.out.println("1. Registro de paciente");
            System.out.println("2. Login de paciente");
            System.out.println("3. Registro de médico");
            System.out.println("4. Login de médico");
            System.out.println("5. Registrar consulta (solo médicos)");
            System.out.println("6. Autorizar medicamentos (solo médicos)");
            System.out.println("0. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del paciente:");
                    String nombrePaciente = scanner.nextLine();
                    System.out.println("Ingrese la cédula:");
                    String cedulaPaciente = scanner.nextLine();
                    System.out.println("Ingrese el usuario:");
                    String usuarioPaciente = scanner.nextLine();
                    System.out.println("Ingrese la contraseña:");
                    String contraseñaPaciente = scanner.nextLine();
                    pacienteDAO.registrarPaciente(usuarioPaciente, contraseñaPaciente, nombrePaciente, cedulaPaciente);
                    break;

                case 2:
                    System.out.println("Ingrese el usuario del paciente:");
                    String usuarioLoginPaciente = scanner.nextLine();
                    System.out.println("Ingrese la contraseña:");
                    String contraseñaLoginPaciente = scanner.nextLine();
                    if (pacienteDAO.validarLogin(usuarioLoginPaciente, contraseñaLoginPaciente)) {
                        System.out.println("¡Login exitoso!");
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el nombre del médico:");
                    String nombreMedico = scanner.nextLine();
                    System.out.println("Ingrese la especialidad:");
                    String especialidad = scanner.nextLine();
                    System.out.println("Ingrese el usuario:");
                    String usuarioMedico = scanner.nextLine();
                    System.out.println("Ingrese la contraseña:");
                    String contraseñaMedico = scanner.nextLine();
                    medicoDAO.registrarMedico(nombreMedico, especialidad, usuarioMedico, contraseñaMedico);
                    break;

                case 4:
                    System.out.println("Ingrese el usuario del médico:");
                    String usuarioLoginMedico = scanner.nextLine();
                    System.out.println("Ingrese la contraseña:");
                    String contraseñaLoginMedico = scanner.nextLine();
                    // Aquí vamos a implementar la validacion de medicos

                    break;

                case 5:
                    System.out.println("Ingrese la cédula del paciente:");
                    int pacienteId = scanner.nextInt();
                    System.out.println("Ingrese su ID de médico:");
                    int medicoId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese los síntomas del paciente:");
                    String sintomas = scanner.nextLine();
                    System.out.println("Ingrese el peso del paciente:");
                    double peso = scanner.nextDouble();
                    System.out.println("Ingrese la estatura del paciente:");
                    double estatura = scanner.nextDouble();
                    consultaDAO.registrarConsulta(pacienteId, medicoId, sintomas, peso, estatura);
                    break;

                case 6:
                    System.out.println("Ingrese el ID de la consulta:");
                    int consultaId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese los medicamentos autorizados:");
                    String medicamentos = scanner.nextLine();
                    medicamentoDAO.autorizarMedicamentos(consultaId, medicamentos);
                    break;

                case 0:
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, inténtelo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
