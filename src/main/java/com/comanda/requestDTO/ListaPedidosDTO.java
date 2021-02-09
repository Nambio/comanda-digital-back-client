package com.comanda.requestDTO;

import java.util.List;

import com.comanda.model.Bebida;
import com.comanda.model.ItensAdicionais;
import com.comanda.model.Pedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaPedidosDTO {
	public List<PedidoDTO> pedidosDTO;
    private Integer idItem;
    private String titulo;
    private Integer valorPrato;
    private List<ItensAdicionais> itensAdicionais;
    private List<Bebida> bebidas ;
    private Integer valores;
    private Integer quantidade;
	
	public List<Pedido> pedidoDTOParaPedidos(List<PedidoDTO> pedidosDTO){
		Pedido pedido;
		List<Pedido> pedidos;
		
		pedidosDTO.forEach(p->{
				
		});
		return null;
	}
}
