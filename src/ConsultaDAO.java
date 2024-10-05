import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO {
    public void registrarConsulta(int pacienteId, int medicoId, String sintomas, double peso, double estatura) {
        String sql = "INSERT INTO consultas(paciente_id, medico_id, sintomas, peso, estatura) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pacienteId);
            pstmt.setInt(2, medicoId);
            pstmt.setString(3, sintomas);
            pstmt.setDouble(4, peso);
            pstmt.setDouble(5, estatura);
            pstmt.executeUpdate();
            System.out.println("Consulta registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar consulta: " + e.getMessage());
        }
    }
}
