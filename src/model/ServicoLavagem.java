package model;

public class ServicoLavagem {
    private static long nextId = 1; // Contador para gerar IDs de serviço
    private long id;
    private Veiculo veiculo;
    private Cliente cliente;
    private String tipoLavagem; // Ex: "Simples", "Completa"
    private String status;      // Ex: "Pendente", "Em Andamento", "Concluído"
    private double preco;

    public ServicoLavagem(Veiculo veiculo, Cliente cliente, String tipoLavagem, double preco) {
        this.id = nextId++;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.tipoLavagem = tipoLavagem;
        this.status = "Pendente"; // Status inicial
        this.preco = preco;
    }
    // Getters
    public long getId() {
        return id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoLavagem() {
        return tipoLavagem;
    }

    public String getStatus() {
        return status;
    }

    public double getPreco() {
        return preco;
    }

    // Setters (para campos que podem ser alterados, como status)
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Serviço de Lavagem #" + id + " - Veículo: " + veiculo.getPlaca() +
               ", Cliente: " + cliente.getNome() + ", Tipo: " + tipoLavagem +
               ", Status: " + status + ", Preço: R$" + String.format("%.2f", preco);
    }
}