import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {
    public void registrarMedico(String nombre, String especialidad, String usuario, String contraseña) {
        String sql = "INSERT INTO medicos(nombre, especialidad, usuario, contraseña) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, especialidad);
            pstmt.setString(3, usuario);
            pstmt.setString(4, contraseña);
            pstmt.executeUpdate();
            System.out.println("Médico registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar médico: " + e.getMessage());
        }
    }
}
