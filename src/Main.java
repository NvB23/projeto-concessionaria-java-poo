import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String opcao = "";
        String opcoesDisponiveis = "0123456789";
        Scanner leitor = new Scanner(System.in);
        int idCliente = 1;

        System.out.print("Primeiro digite o nome de sua Concessionária: ");
        String nomeConcessionaria = leitor.nextLine();

        Concessionaria concessionaria = new Concessionaria(nomeConcessionaria);

        while (!Objects.equals(opcao, "0")) {
            System.out.printf("\n=========== BEM VINDO À %s CONCESSIONÁRIA ===========\n", concessionaria.nome.toUpperCase());
            System.out.println("""
                    Opções:
                    
                    1) Adicionar Veículo;
                    2) Remover Veículo;
                    3) Cadastrar Cliente;
                    4) Remover Cliente;
                    5) Realizar Venda;
                    6) Buscar Veículo Por Marca;
                    7) Buscar Veículo Por Modelo;
                    8) Listar Veículos Disponíveis;
                    9) Listar Vendas Realizadas;
                    0) Fechar Programa;
                    """);
            System.out.print(">>> ");
            opcao = leitor.nextLine();

            if (!opcoesDisponiveis.contains(opcao)) {
                System.out.println("Opção Inválida! Tente Novamente...");
                continue;
            }

            switch (opcao.trim()) {
                case "1" -> {
                    System.out.println("------------- ADICIONAR VEÍCULO -------------");
                    System.out.print("Qual a marca do veículo: ");
                    String marca = leitor.nextLine();

                    System.out.print("\nQual o modelo do veículo: ");
                    String modelo = leitor.nextLine();

                    System.out.print("\nQual a placa do veículo: ");
                    String placa = leitor.nextLine();

                    System.out.print("\nQual o ano do veículo: ");
                    int ano = leitor.nextInt();

                    System.out.print("\nQual o preço do veículo: R$");
                    double preco = leitor.nextDouble();
                    leitor.nextLine();

                    Veiculo veiculo = new Veiculo(marca, modelo, placa, ano, preco);
                    boolean statusInsersao = concessionaria.adicionarVeiculo(veiculo);

                    if (statusInsersao) {
                        System.out.printf("Veículo %s adicionado na concessionária %s com sucesso!\n", veiculo.marca, concessionaria.nome);
                    } else {
                        System.out.println("Não foi possível adicionar o veículo! Já existe um veículo com essa placa.");
                    }
                }
                case "2" -> {
                    System.out.println("------------- REMOVER VEÍCULO -------------");
                    System.out.print("Qual a placa do veículo: ");
                    String placa = leitor.nextLine();

                    boolean statusRemocao = concessionaria.removerVeiculo(placa);
                    if (statusRemocao) {
                        System.out.printf("Veículo removido da concessionária %s com sucesso!\n", concessionaria.nome);
                    } else {
                        System.out.println("Não foi possível deletar o veículo! Ainda não existe um veículo com essa placa no nosso sistema.");
                    }
                }
                case "3" -> {
                    System.out.println("------------- CADASTRAR CLIENTE -------------");
                    System.out.print("Digite o nome do cliente: ");
                    String nome = leitor.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = leitor.nextLine();
                    System.out.print("Digite o email do cliente: ");
                    String email = leitor.nextLine();
                    Cliente cliente = new Cliente(nome, idCliente, telefone, email);
                    boolean statusInsersao = concessionaria.cadastrarCliente(cliente);
                    if (statusInsersao) {
                        System.out.printf("Cliente %s adicionado na concessionária %s com sucesso!\n", cliente.nome, concessionaria.nome);
                        idCliente++;
                    } else {
                        System.out.println("Não foi possível adicionar o cliente! Já existe um cliente com esse id.");
                    }
                }

                case "4" -> {
                    System.out.println("------------- REMOVER CLIENTE -------------");
                    System.out.print("Qual o ID do cliente: ");
                    int id = leitor.nextInt();
                    leitor.nextLine();

                    boolean statusRemocao = concessionaria.removerCliente(id);
                    if (statusRemocao) {
                        System.out.printf("Cliente removido da concessionária %s com sucesso!\n", concessionaria.nome);
                    } else {
                        System.out.println("Não foi possível deletar o cliente! Ainda não existe um cliente com esse id no nosso sistema.");
                    }
                }

                case "5" -> {
                    System.out.println("------------- REALIZAR UMA VENDA -------------");
                    System.out.println("Qual veículo para venda? ");
                    ArrayList<Veiculo> veiculosDisponivelParaVenda = concessionaria.listarVeiculosDisponiveis();
                    for (int i = 0; i < veiculosDisponivelParaVenda.size(); i++) {
                        Veiculo veiculo = veiculosDisponivelParaVenda.get(i);
                        System.out.printf("%s - %s;\n", veiculo.placa, veiculo.modelo);
                    }
                    System.out.print("---> ");
                    String placa = leitor.nextLine();

                    System.out.println("Qual cliente irá comprar? ");
                    ArrayList<Cliente> idClientesCadastrados = concessionaria.clientes;
                    for (int i = 0; i < idClientesCadastrados.size(); i++) {
                        Cliente cliente = idClientesCadastrados.get(i);
                        System.out.printf("%d - %s;\n", cliente.id, cliente.nome);
                    }
                    System.out.print("---> ");
                    int idVenda = leitor.nextInt();
                    leitor.nextLine();

                    System.out.print("Digite a data da venda: ");
                    String dataVenda = leitor.nextLine();

                    System.out.println("Qual a forma de pagamento: ");
                    System.out.println("""
                            \t1) À VISTA;
                            \t2) FINANCIADO;
                            \t3) CARTÃO DE CRÉDITO;
                            """);
                    String formaPagamento = leitor.nextLine();
                    switch (formaPagamento) {
                        case "1" -> formaPagamento = "À VISTA";
                        case "2" -> formaPagamento = "FINANCIADO";
                        case "3" -> formaPagamento = "CARTÃO DE CRÉDITO";
                        default -> formaPagamento = "INVALIDA";
                    }
                    if (!formaPagamento.equals("INVALIDA")) {
                        double preco = 0;
                        for (int i = 0; i < concessionaria.totalVeiculos; i++) {
                            if (concessionaria.veiculos.get(i).placa.equalsIgnoreCase(placa)) {
                                preco = concessionaria.veiculos.get(i).preco;
                            }
                        }
                        if (!formaPagamento.equals("À VISTA")) {
                            preco += preco * 0.05;
                        }
                        boolean statusVenda = concessionaria.realizarVenda(placa, idVenda, dataVenda, formaPagamento, preco);
                        if (statusVenda) {
                            System.out.printf("Venda realizada na concessionária %s com sucesso!\n", concessionaria.nome);
                        } else {
                            System.out.println("Não foi possível realizar a venda! Confira as informações passadas.");
                        }
                    }
                }
                case "6" -> {
                    System.out.println("------------- BUSCAR VEÍCULO POR MARCA -------------");
                    System.out.print("Qual a marca do veículo: ");
                    String marca = leitor.nextLine();

                    ArrayList<Veiculo> veiculosBuscadorPorMarca = concessionaria.buscarVeiculoPorMarca(marca);
                    System.out.println("RESULTADO DA BUSCA:");
                    for (int i = 0; i < veiculosBuscadorPorMarca.size(); i++) {
                        Veiculo veiculo = veiculosBuscadorPorMarca.get(i);
                        System.out.printf("""
                                Marca: %s,
                                Modelo: %s,
                                Placa: %s,
                                Ano: %d,
                                Preço: R$ %.2f,
                                """, veiculo.marca, veiculo.modelo, veiculo.placa, veiculo.ano, veiculo.preco);
                        System.out.println("Disponível: " + (veiculo.disponivel ? "Sim" : "Não"));
                        System.out.println("_________________________________________________");
                    }
                }
                case "7" -> {
                    System.out.println("------------- BUSCAR VEÍCULO POR MODELO -------------");
                    System.out.print("Qual o modelo do veículo: ");
                    String modelo = leitor.nextLine();

                    ArrayList<Veiculo> veiculosBuscadorPorModelo = concessionaria.buscarVeiculoPorModelo(modelo);
                    System.out.println("RESULTADO DA BUSCA:");
                    for (int i = 0; i < veiculosBuscadorPorModelo.size(); i++) {
                        Veiculo veiculo = veiculosBuscadorPorModelo.get(i);
                        System.out.printf("""
                                Marca: %s,
                                Modelo: %s,
                                Placa: %s,
                                Ano: %d,
                                Preço: R$ %.2f,
                                """, veiculo.marca, veiculo.modelo, veiculo.placa, veiculo.ano, veiculo.preco);
                        System.out.println("Disponível: " + (veiculo.disponivel ? "Sim" : "Não"));
                        System.out.println("_________________________________________________");
                    }
                }
                case "8" -> {
                    System.out.println("------------- LISTAR VEÍCULOS DISPONÍVEIS -------------");
                    ArrayList<Veiculo> veiculosDisponiveis = concessionaria.listarVeiculosDisponiveis();
                    System.out.println("RESULTADO DA BUSCA:");
                    for (int i = 0; i < veiculosDisponiveis.size(); i++) {
                        Veiculo veiculo = veiculosDisponiveis.get(i);
                        System.out.printf("""
                                Marca: %s,
                                Modelo: %s,
                                Placa: %s,
                                Ano: %d,
                                Preço: R$ %.2f
                                \n""", veiculo.marca, veiculo.modelo, veiculo.placa, veiculo.ano, veiculo.preco);
                        System.out.println("_________________________________________________");
                    }
                }
                case "9" -> {
                    System.out.println("------------- LISTAR VENDAS REALIZADAS -------------");
                    ArrayList<Venda> vendasRealizadas = concessionaria.listarVendasRealizadas();
                    System.out.println("RESULTADO DA BUSCA:");
                    for (int i = 0; i < vendasRealizadas.size(); i++) {
                        Venda venda = vendasRealizadas.get(i);
                        System.out.printf("""
                                Veículo Vendido -> Marca: %s, Modelo: %s, Placa: %s, Ano: %d, Preço: R$ %.2f;
                                Cliente Comprador -> Nome: %s, Id: %d, Telefone: %s, Email: %s;
                                Data Da Venda: %s;
                                Forma de Pagamento: %s;
                                Valor Da Venda: R$ %.2f;
                                \n""",
                                venda.veiculo.marca, venda.veiculo.modelo, venda.veiculo.placa, venda.veiculo.ano, venda.veiculo.preco,
                                venda.cliente.nome, venda.cliente.id, venda.cliente.telefone, venda.cliente.email,
                                venda.dataVenda,
                                venda.formaPagamento,
                                venda.valorVenda
                                );
                        System.out.println("_________________________________________________");
                    }
                }
            }
        }

        System.out.println("PROGRAMA FECHADO!");
        leitor.close();
    }
}