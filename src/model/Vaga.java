package model;

public class Vaga {

    
    private String numero;
    private boolean disponivel;
    private String placaVeiculo; // Não está mais usando a classe Veiculo
    private String dataEntrada;
    private String dataSaida;
    private int idCliente; // Agora é apenas o ID, não mais o objeto Cliente
    private String horaEntrada;
    private String horaSaida;

   
   

    // Construtor sem ID (para inserções, onde o ID é gerado automaticamente)
    public Vaga(String numero, boolean disponivel, String placaVeiculo, String dataEntrada,
                String dataSaida, int idCliente, String horaEntrada, String horaSaida) {
        this.numero = numero;
        this.disponivel = disponivel;
        this.placaVeiculo = placaVeiculo;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.idCliente = idCliente;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    // Getters e Setters
    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }
}
