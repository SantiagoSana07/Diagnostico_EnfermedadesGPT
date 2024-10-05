import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicamentoDAO {

    public void autorizarMedicamentos(int consultaId, String medicamentos) {
        String sql = "INSERT INTO medicamentos(consulta_id, medicamentos) VALUES (?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1, consultaId);
            pstmt.setString(2, medicamentos);


            pstmt.executeUpdate();

            System.out.println("Medicamentos autorizados exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al autorizar medicamentos: " + e.getMessage());
        }
    }
}

