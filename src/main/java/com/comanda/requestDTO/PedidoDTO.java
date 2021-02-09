package com.comanda.requestDTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class PedidoDTO {
    private Integer idItem;
    private String titulo;
    private Integer valorPrato;
    private List<ItensAdicionaisDTO> itensAdicionais;
    private List<BebidaDTO> bebidas ;
    private Integer valores;
    private Integer quantidade;
}
