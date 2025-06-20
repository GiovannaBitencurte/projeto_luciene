import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/estacionamento?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        String usuario = "root";
        String senha = "345678";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conexão com MySQL bem-sucedida!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao MySQL: " + e.getMessage());
        }
    }
}
