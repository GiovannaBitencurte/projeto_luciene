package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Vaga;

public class VagaDao {
    private final String url = "jdbc:mysql://localhost:3306/estacionamento?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private final String usuario = "root";
    private final String senha = "345678";

    public void registrarEntrada(Vaga vaga) {
        String sql = "INSERT INTO vaga (numero, disponivel, placa_veiculo, data_entrada, hora_entrada, id_cliente) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vaga.getNumero());
            stmt.setBoolean(2, vaga.isDisponivel());
            stmt.setString(3, vaga.getPlacaVeiculo()); // corrigido
            stmt.setString(4, vaga.getDataEntrada());
            stmt.setString(5, vaga.getHoraEntrada());
            stmt.setInt(6, vaga.getIdCliente()); // corrigido

            stmt.executeUpdate();
            System.out.println("Entrada registrada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao registrar entrada: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void registrarSaida(int idVaga, String dataSaida, String horaSaida) {
        String sql = "UPDATE vaga SET data_saida = ?, hora_saida = ?, disponivel = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dataSaida);
            stmt.setString(2, horaSaida);
            stmt.setBoolean(3, true); // A vaga agora está disponível
            stmt.setInt(4, idVaga);

            stmt.executeUpdate();
            System.out.println("Saída registrada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao registrar saída: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
