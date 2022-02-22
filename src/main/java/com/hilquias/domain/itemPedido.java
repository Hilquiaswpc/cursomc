package com.hilquias.domain;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class itemPedido  implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private itemPedidoPK id = new itemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public itemPedido() {
    }

    public itemPedido(Pedido pedido,Produtos produtos,  Double desconto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProdutos(produtos);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public Pedido getPedido(){
        return id.getPedido();
    }
    public  Produtos getProdutos(){
        return id.getProdutos();
    }

    public itemPedidoPK getId() {
        return id;
    }

    public void setId(itemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        itemPedido that = (itemPedido) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
