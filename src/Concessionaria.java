import java.util.ArrayList;

public class Concessionaria {
    public String nome;
    public ArrayList<Veiculo> veiculos;
    public ArrayList<Cliente> clientes;
    public ArrayList<Venda> vendas;
    public int totalVeiculos;
    public int totalClientes;
    public int totalVendas;

    public Concessionaria(String nome) {
        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public boolean adicionarVeiculo(Veiculo veiculo) {
        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).placa.equalsIgnoreCase(veiculo.placa)) {
                return false;
            }
        }

        boolean statusInsersao = this.veiculos.add(veiculo);
        if (statusInsersao) {
            this.totalVeiculos++;
        }
        return statusInsersao;
    }

    public boolean removerVeiculo(String placa) {
        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).disponivel && this.veiculos.get(i).placa.equalsIgnoreCase(placa)) {
                Veiculo veiculo = this.veiculos.get(i);
                this.veiculos.remove(veiculo);
                this.totalVeiculos--;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Veiculo> buscarVeiculoPorMarca(String marca) {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).marca.equalsIgnoreCase(marca)) {
                Veiculo veiculo = this.veiculos.get(i);
                veiculosEncontrados.add(veiculo);
            }
        }
        return veiculosEncontrados;
    }
    public ArrayList<Veiculo> buscarVeiculoPorModelo(String modelo) {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).modelo.equalsIgnoreCase(modelo)) {
                Veiculo veiculo = this.veiculos.get(i);
                veiculosEncontrados.add(veiculo);
            }
        }
        return veiculosEncontrados;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        for (int i = 0; i < this.totalClientes; i++) {
            if (this.clientes.get(i).id == cliente.id) {
                return false;
            }
        }

        boolean statusInsercao = this.clientes.add(cliente);
        if (statusInsercao) {
            this.totalClientes++;
        }
        return statusInsercao;
    }


    public boolean removerCliente(int id){
        for (int i = 0; i < this.totalClientes; i++) {
            if (this.clientes.get(i).id == (id)){
                Cliente clientes = this.clientes.get(i);
                this.clientes.remove(clientes);
                this.totalClientes--;
                return true;
            }
        }
        return false;
    }

    public boolean realizarVenda(String placa, int idCliente, String dataVenda, String formaPagamento, double valor) {
        for (int i = 0; i < this.totalVendas; i++) {
            if (this.vendas.get(i).cliente.id == idCliente
                    && this.vendas.get(i).veiculo.placa.equalsIgnoreCase(placa)) {
                return false;
            }
        }

        Veiculo veiculo = null;
        Cliente cliente = null;

        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).placa.equalsIgnoreCase(placa)) {
                veiculo = this.veiculos.get(i);
            }
        }

        for (int i = 0; i < this.totalClientes; i++) {
            if (this.clientes.get(i).id == idCliente) {
                cliente = this.clientes.get(i);
            }
        }

        boolean statusInsercao = false;

        if (veiculo != null && cliente != null) {
            Venda venda = new Venda(veiculo, cliente, dataVenda, valor, formaPagamento);
            statusInsercao = this.vendas.add(venda);
            this.totalVendas++;
        }
        return statusInsercao;
    }

    public ArrayList<Veiculo> listarVeiculosDisponiveis() {
        ArrayList<Veiculo> veiculosEncontrados = new ArrayList<>();

        for (int i = 0; i < this.totalVeiculos; i++) {
            if (this.veiculos.get(i).disponivel) {
                Veiculo veiculo = this.veiculos.get(i);
                veiculosEncontrados.add(veiculo);
            }
        }

        return veiculosEncontrados;
    }

    public ArrayList<Venda> listarVendasRealizadas(){
        ArrayList<Venda> veiculoVendidos = new ArrayList<>();
        for (int i = 0; i < this.totalVendas; i++) {
            Venda venda = this.vendas.get(i);
            veiculoVendidos.add(venda);
        }
        return veiculoVendidos;
    }


    @Override
    public String toString() {
        return String.format("<Concessionaria nome=%s, veiculos=%s, clientes=%s, " +
                "vendas=%s, totalVeiculos=%d, totalClientes=%s, totalVendas=%s>", this.nome, this.veiculos, this.clientes,
                this.vendas, this.totalVeiculos, this.totalClientes, this.totalVendas
        );

    }
}
