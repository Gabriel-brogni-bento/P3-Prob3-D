package problema3;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    private ArrayList<ItemPedido> itens;
    private TipoEntrega tipoEntrega;

    public Pedido() {
    	itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void incluirItem(Produto p, int qtd) {
        this.itens.add(new ItemPedido(p, qtd));
    }

    public double getValorPedido() {
        double valorTotal = 0;
        for (ItemPedido ip : this.itens) {
            valorTotal += (ip.getValorItem());
        }
        return valorTotal;
    }
    
    public void setTipoEntrega(TipoEntrega entrega) {
    	tipoEntrega = entrega;
    }
    
    public double getValorEntrega() throws TipoEntregaInvalido  {
    	return tipoEntrega.getValorEntrega(itens);
    }
    
    public double getValorTotal() throws TipoEntregaInvalido {
    	return getValorPedido() + getValorEntrega();
    }
}
