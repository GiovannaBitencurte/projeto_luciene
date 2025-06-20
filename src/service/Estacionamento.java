package service;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Vaga;
import model.Veiculo;

public class Estacionamento {

    private String nome;
    private String endereco;
    private String telefone;
    private String horarioFuncionamento;
    private List<Vaga> vagas;

    public Estacionamento(String nome, String endereco, String telefone, String horarioFuncionamento, int totalVagas) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.horarioFuncionamento = horarioFuncionamento;
        this.vagas = new ArrayList<>();

        for (int i = 1; i <= totalVagas; i++) {
            Vaga vaga = new Vaga("V" + i, true, null, null, null, 0, null, null);
            this.vagas.add(vaga);
        }
    }

    public void exibirStatusVagas() {
        System.out.println("Status das vagas:");
        for (Vaga vaga : vagas) {
            System.out.println("Vaga " + vaga.getNumero() + " - Disponível: " + vaga.isDisponivel());
        }
    }

    public void estacionar(Cliente cliente, Veiculo veiculo, String dataEntrada, String horaEntrada) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel()) {
                vaga.setDisponivel(false);
                vaga.setPlacaVeiculo(veiculo.getPlaca());
                
                vaga.setDataEntrada(dataEntrada);
                vaga.setHoraEntrada(horaEntrada);
                System.out.println("Veículo " + veiculo.getPlaca() + " estacionado na vaga " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Nenhuma vaga disponível.");
    }

    public void liberarVeiculo(String placaSaida, String dataSaida, String horaSaida) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getPlacaVeiculo() != null &&
                vaga.getPlacaVeiculo().equalsIgnoreCase(placaSaida)) {

                vaga.setDisponivel(true);
                vaga.setDataSaida(dataSaida);
                vaga.setHoraSaida(horaSaida);
                vaga.setPlacaVeiculo(null);
                vaga.setIdCliente(0);
                System.out.println("Veículo com placa " + placaSaida + " foi liberado da vaga " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Veículo com placa " + placaSaida + " não encontrado.");
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
}
