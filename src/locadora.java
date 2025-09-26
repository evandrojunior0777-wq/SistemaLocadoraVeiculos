import java.util.ArrayList;
import java.util.List;


/**
 * Classe locadora: gerencia carros e clientes.
 */
public class locadora {
    private List<carro> carros;
    private List<cliente> clientes;


    public locadora() {
        carros = new ArrayList<>();
        clientes = new ArrayList<>();
    }


    public void cadastrarCarro(carro c) { carros.add(c); }
    public void cadastrarCliente(cliente c) { clientes.add(c); }


    public boolean alugarCarro(String modelo) {
        for (carro c : carros) {
            if (c.getModelo().equalsIgnoreCase(modelo) && c.isDisponivel()) {
                c.setDisponivel(false);
                return true;
            }
        }
        return false;
    }


    public boolean devolverCarro(String modelo) {
        for (carro c : carros) {
            if (c.getModelo().equalsIgnoreCase(modelo) && !c.isDisponivel()) {
                c.setDisponivel(true);
                return true;
            }
        }
        return false;
    }


    public List<carro> listarCarrosDisponiveis() {
        List<carro> disponiveis = new ArrayList<>();
        for (carro c : carros) {
            if (c.isDisponivel()) disponiveis.add(c);
        }
        return disponiveis;
    }
}
