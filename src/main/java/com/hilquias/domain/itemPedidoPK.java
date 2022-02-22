package com.hilquias.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class itemPedidoPK implements Serializable {

    private static final long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;


    @ManyToOne
    @JoinColumn(name = "produtos_id")
    private Produtos produtos;


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        itemPedidoPK that = (itemPedidoPK) o;
        return pedido.equals(that.pedido) && produtos.equals(that.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produtos);
    }
}
