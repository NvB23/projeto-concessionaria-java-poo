public class Main {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria("MeuCar");
        Veiculo veiculoToro = new Veiculo("Fiat", "Touro", "TOW6I62", 2022, 208.000);
        Veiculo veiculoCorolla = new Veiculo("Toyota", "Corolla", "TOX90O56", 2024, 235.000);
        Veiculo veiculoEclipse = new Veiculo("Mitsubishi", "Eclipse", "XAA2O53", 2018, 350.000);
        Veiculo veiculoFusca = new Veiculo("Volkswagen", "Fusca", "GTR2K65", 1995, 15.000);

        boolean statusInsersaoVeiculoToro = concessionaria.adicionarVeiculo(veiculoToro);
        boolean statusInsersaoVeiculoCorolla = concessionaria.adicionarVeiculo(veiculoCorolla);
        boolean statusInsersaoVeiculoEclipse = concessionaria.adicionarVeiculo(veiculoEclipse);
        boolean statusInsersaoVeiculoFusca = concessionaria.adicionarVeiculo(veiculoFusca);

        if (statusInsersaoVeiculoToro) {
            System.out.printf("Veículo %s adicionado na concessionária %s com sucesso!\n", veiculoToro.marca, concessionaria.nome);
        }

        if (statusInsersaoVeiculoCorolla) {
            System.out.printf("Veículo %s adicionado na concessionária %s com sucesso!\n", veiculoCorolla.marca, concessionaria.nome);
        }

        if (statusInsersaoVeiculoEclipse) {
            System.out.printf("Veículo %s adicionado na concessionária %s com sucesso!\n", veiculoEclipse.marca, concessionaria.nome);
        }

        if (statusInsersaoVeiculoFusca) {
            System.out.printf("Veículo %s adicionado na concessionária %s com sucesso!\n", veiculoFusca.marca, concessionaria.nome);
        }

        System.out.printf("Todos os veículos cadastrados: %s\n", concessionaria.veiculos);

        boolean statusRemocaoVeiculo = concessionaria.removerVeiculo("GTR2K65");

        if (statusRemocaoVeiculo) {
            System.out.printf("Veículo removido da concessionária %s com sucesso!\n", concessionaria.nome);
        }

        System.out.printf("Todos os veículos cadastrados: %s\n", concessionaria.veiculos);

        System.out.printf("Resultado busca por marca Fiat: %s\n", concessionaria.buscarVeiculoPorMarca("fiat"));

        System.out.printf("Resultado busca por modelo Corolla %s\n", concessionaria.buscarVeiculoPorModelo("corolla"));

        Cliente clienteJoao = new Cliente("João", 1, "83993216543", "joao@email.com");
        Cliente clienteMaria = new Cliente("Maria", 2, "83993547865", "maria@email.com");
        Cliente clientePedro = new Cliente("Pedro", 3, "83993764509", "pedro@email.com");
        Cliente clienteFrederico = new Cliente("Frederico", 4, "83993674796", "frederico@email.com");

        boolean statusInsercaoClienteJoao = concessionaria.cadastrarCliente(clienteJoao);
        boolean statusInsercaoClienteMaria = concessionaria.cadastrarCliente(clienteMaria);
        boolean statusInsercaoClientePedro = concessionaria.cadastrarCliente(clientePedro);
        boolean statusInsercaoClienteFrederico = concessionaria.cadastrarCliente(clienteFrederico);

        if (statusInsercaoClienteJoao) {
            System.out.printf("Cliente %s adicionado na concessionária %s com sucesso!\n", clienteJoao.nome, concessionaria.nome);
        }

        if (statusInsercaoClienteMaria) {
            System.out.printf("Cliente %s adicionado na concessionária %s com sucesso!\n", clienteMaria.nome, concessionaria.nome);
        }

        if (statusInsercaoClientePedro) {
            System.out.printf("Cliente %s adicionado na concessionária %s com sucesso!\n", clientePedro.nome, concessionaria.nome);
        }

        if (statusInsercaoClienteFrederico) {
            System.out.printf("Cliente %s adicionado na concessionária %s com sucesso!\n", clienteFrederico.nome, concessionaria.nome);
        }

        System.out.printf("Todos os clientes cadastrados: %s\n", concessionaria.clientes);

        boolean statusRemocaoCliete = concessionaria.removerCliente(clienteFrederico.id);
        if (statusRemocaoCliete) {
            System.out.printf("Cliente %s removido da concessionária %s com sucesso!\n", clienteFrederico.nome, concessionaria.nome);
        }

        System.out.printf("Todos os clientes cadastrados: %s\n", concessionaria.clientes);

        boolean statusRealizarVenda1 = concessionaria.realizarVenda("TOW6I62", 1, "19/09/2025", "Á VISTA", (veiculoToro.preco - (veiculoToro.preco * 0.1)));
        boolean statusRealizarVenda2 = concessionaria.realizarVenda("TOX90O56", 2, "20/09/2025", "FINANCIAMENTO", veiculoToro.preco);

        if (statusRealizarVenda1) {
            System.out.printf("Venda de veículo realizada na %s!\n", concessionaria.nome);
        }

        if (statusRealizarVenda2) {
            System.out.printf("Venda de veículo realizada na %s!\n", concessionaria.nome);
        }

        System.out.printf("Todos as vendas cadastradas: %s\n", concessionaria.vendas);

        System.out.printf("Veículos disponíveis: %s\n", concessionaria.listarVeiculosDisponiveis());

        System.out.printf("Vendas realizadas: %s\n", concessionaria.listarVendasRealizadas());


    }
}