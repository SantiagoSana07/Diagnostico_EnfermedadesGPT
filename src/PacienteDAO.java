import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {
    public void registrarPaciente(String usuario, String contraseña, String nombre, String cedula) {
        String sql = "INSERT INTO pacientes(usuario, contraseña, nombre, cedula) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            pstmt.setString(3, nombre);
            pstmt.setString(4, cedula);
            pstmt.executeUpdate();
            System.out.println("Paciente registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar paciente: " + e.getMessage());
        }
    }

    public boolean validarLogin(String usuario, String contraseña) {
        String sql = "SELECT * FROM pacientes WHERE usuario = ? AND contraseña = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            return pstmt.executeQuery().next();
        } catch (SQLException e) {
            System.out.println("Error al validar login: " + e.getMessage());
            return false;
        }
    }
}
