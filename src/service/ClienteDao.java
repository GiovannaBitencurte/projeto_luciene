package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class ClienteDao {
    private final static String url = "jdbc:mysql://localhost:3306/estacionamento?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
        private final static String usuario = "root";
                private final static String senha = "345678";
                            
                                public void inserir(Cliente cliente) {
                                    String sql = "INSERT INTO cliente (nome, cpf, telefone, email, endereco, data_nascimento, genero) " +
                                                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
                            
                                    try (Connection conn = DriverManager.getConnection(url, usuario, senha);
                                         PreparedStatement stmt = conn.prepareStatement(sql)) {
                            
                                        stmt.setString(1, cliente.getNome());
                                        stmt.setString(2, cliente.getCpf());
                                        stmt.setString(3, cliente.getTelefone());
                                        stmt.setString(4, cliente.getEmail());
                                        stmt.setString(5, cliente.getEndereço());
                                        stmt.setString(6, cliente.getDataNascimento()); // Supondo formato YYYY-MM-DD
                                        stmt.setString(7, cliente.getGenero());
                            
                                        stmt.executeUpdate();
                                        System.out.println("Cliente inserido com sucesso!");
                                    } catch (SQLException e) {
                                        System.err.println("Erro ao inserir cliente: " + e.getMessage());
                                        e.printStackTrace();
                                    }
                                }
                            
                                public static Cliente buscarPorCpf(String cpf) {
                                    String sql = "SELECT * FROM cliente WHERE cpf = ?";
                                    try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            stmt.setString(1, cpf);

            if (rs.next()) {
                return new Cliente(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("endereco"),
                    rs.getString("data_nascimento"),
                    rs.getString("genero")
                );
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void removerPorCpf(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Cliente removido com sucesso.");
            } else {
                System.out.println("Nenhum cliente encontrado com esse CPF.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
