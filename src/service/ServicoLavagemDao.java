package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ServicoLavagem;

public class ServicoLavagemDao {
    private final String url = "jdbc:mysql://localhost:3306/estacionamento?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private final String usuario = "root";
    private final String senha = "345678";

    public void solicitarLavagem(ServicoLavagem lavagem) {
        String sql = "INSERT INTO servico_lavagem (placa_veiculo, id_cliente, tipo_lavagem, status, preco) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lavagem.getVeiculo().getPlaca());
            stmt.setString(2, lavagem.getCliente().getCpf()); // ou ID se estiver usando inteiro
            stmt.setString(3, lavagem.getTipoLavagem());
            stmt.setString(4, lavagem.getStatus());
            stmt.setDouble(5, lavagem.getPreco());

            stmt.executeUpdate();
            System.out.println("Serviço de lavagem registrado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao solicitar lavagem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

