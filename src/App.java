import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Vaga;
import model.Veiculo;
import service.ClienteDao;
import service.Estacionamento;
import service.VagaDao;

// Classe principal para executar a aplicação
public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Inicializa o estacionamento com um nome, endereço, número de vagas de carro e moto
        Estacionamento estacionamento = new Estacionamento(
            "Central Park",
            "Rua das Flores, 123",
            "11987654321",
            "08:00 - 22:00",
            8 // total de vagas (5 carros + 3 motos)
        );
        
        System.out.println("Bem-vindo à Plataforma de Estacionamento " + estacionamento.getNome() + "!");

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Registrar Entrada de Veículo");
            System.out.println("2. Registrar Saída de Veículo");
            System.out.println("3. ver status das vagas");
            System.out.println("4. Cadastrar Novo Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.");
                continue;
            }

            switch (choice) {
                case 1: // Registrar Entrada de Veículo
                        System.out.print("ID do Cliente: ");
                        int idCliente = Integer.parseInt(scanner.nextLine());

                        System.out.print("Número da vaga: ");
                        String numeroVaga = scanner.nextLine();

                        System.out.print("A vaga está disponível? (true/false): ");
                        boolean disponivel = Boolean.parseBoolean(scanner.nextLine());

                        System.out.print("Placa do Veículo: ");
                        String placaVeiculo = scanner.nextLine();

                        System.out.print("Modelo do Veículo: ");
                        String modeloVeiculo = scanner.nextLine();

                        System.out.print("Cor do Veículo: ");
                        String corVeiculo = scanner.nextLine();

                        System.out.print("Tipo do Veículo (Carro/Moto/Caminhonete): ");
                        String tipoVeiculo = scanner.nextLine();

                        System.out.print("Data de entrada (formato: ano-mes-dia): ");
                        String dataEntrada = scanner.nextLine();

                        System.out.print("Hora de entrada (formato: HH:mm:ss): ");
                        String horaEntrada = scanner.nextLine();

                        // Cria o veículo (opcional, caso use em outro local)
                        Veiculo veiculo = new Veiculo(placaVeiculo, modeloVeiculo, corVeiculo, tipoVeiculo);

                        // Cria a vaga com os dados compatíveis com a classe Vaga
                        Vaga vaga = new Vaga(numeroVaga, disponivel, placaVeiculo, dataEntrada, null, idCliente, horaEntrada, null);

                        // Registra no banco
                        VagaDao vagaDao = new VagaDao();
                        vagaDao.registrarEntrada(vaga);



    break;
                                     
                case 2: // Registrar Saída de Veículo
                        System.out.print("Digite o id da vaga: ");
                        int idvaga = scanner.nextInt();
                        scanner.nextLine();  // <--- consome o ENTER pendente
              
                        System.out.print("Data de saída (formato: ano-mes-dia): ");
                        String dataSaida = scanner.nextLine();
                        
                        System.out.print("Hora de saída (formato: HH:mm:ss): ");
                        String horaSaida = scanner.nextLine();
                        
                            VagaDao vagaDaao = new VagaDao();
                            vagaDaao.registrarSaida(idvaga, dataSaida, horaSaida);


                        break;

                
                    
                    

                case 3: // Ver Status do Estacionamento
                    estacionamento.exibirStatusVagas();
                    break;

                case 4: // Cadastrar Novo Cliente
                    
                    System.out.println("\n--- Cadastro de Novo Cliente ---");
                    System.out.print("Nome: ");
                    String nomeCli = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfCli = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telCli = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailCli = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endCli = scanner.nextLine();
                    System.out.print("Data de Nascimento (ano-mes-dia): ");
                    String dataNascCli = scanner.nextLine();
                    System.out.print("Gênero: ");
                    String generoCli = scanner.nextLine();

                    Cliente novoCliente = new Cliente(nomeCli, cpfCli, telCli, emailCli, endCli, dataNascCli, generoCli);
                    ClienteDao clientes = new ClienteDao();
                    clientes.inserir(novoCliente);

                    System.out.println("Cliente " + novoCliente.getNome() + " cadastrado com sucesso!");
                    // Em uma aplicação real, você adicionaria este cliente a uma lista ou banco de dados.
                    break;

                case 5: // Sair
                    System.out.println("Saindo da aplicação. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}


