package com.comanda.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pedido {
    private Integer idItem;
    private String titulo;
    private Integer valorPrato;
    private List<ItensAdicionais> itensAdicionais;
    private List<Bebida> bebidas ;
    private Integer valores;
    private Integer quantidade;
}
