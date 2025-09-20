public class Veiculo {
    public String marca;
    public String modelo;
    public String placa;
    public int ano;
    public boolean disponivel;
    public double preco;

    public Veiculo(String marca, String modelo, String placa, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.disponivel = true;
        this.preco = preco;
    }

    public void mudarDisponibilidade(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return String.format("<Veiculo: marca= %s, modelo=%s, " +
                        "placa=%s, ano=%d, disponivel=%s, preco=%.2f>",
                this.marca,
                this.modelo,
                this.placa,
                this.ano,
                this.disponivel,
                this.preco);
    }
}
