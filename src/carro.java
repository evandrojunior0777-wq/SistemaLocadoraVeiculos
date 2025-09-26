/**
 * Classe carro: representa um veículo da locadora.
 */
public class carro {
    private String modelo;
    private int ano;
    private String cor;
    private boolean disponivel = true; // por padrão, carro cadastrado como disponível


    public carro(String modelo, int ano, String cor) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }


    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }


    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }


    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }


    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }


    @Override
    public String toString() {
        return modelo + " | " + ano + " | " + cor + " | " + (disponivel ? "Disponível" : "Alugado");
    }
}
