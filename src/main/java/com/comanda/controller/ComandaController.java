package com.comanda.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comanda.model.Pagamento;
import com.comanda.model.Pedido;
import com.comanda.responseDTO.PagamentoResponseDTO;
import com.comanda.serviceImpl.PedidoServiceImpl;
import com.mercadopago.exceptions.MPException;

@RestController
@RequestMapping("api/v1")
public class ComandaController {
	private static final Logger log = LoggerFactory.getLogger(Pedido.class);
	
	@Autowired
	private PedidoServiceImpl pedidoServiceImpl;
	
	
//	@RequestMapping(value = "/pagamento", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	public ResponseEntity<String> SavedRequest(HttpServletRequest request) throws IOException {
//		log.debug("Acessando o pagamento");
//		try {
//			String retorno = pedidoServiceImpl.pagamento(request);
//			return ResponseEntity.ok(retorno);
//			
//		} catch (Exception e) {
//			log.error("Erro no pagamento: "+ e.getMessage());
//			return (ResponseEntity<String>) ResponseEntity.badRequest();
//		}
//		
//	}
	
	@RequestMapping(value = "/pagamento", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PagamentoResponseDTO> SavedRequest(@RequestBody Pagamento request) throws IOException, MPException {
		log.debug("Acessando o pagamento");
		
		
		
		try {
			String retorno = pedidoServiceImpl.pagamento(request);
			System.out.println(ResponseEntity.ok(retorno));
			PagamentoResponseDTO pagamentoResponseDTO = new PagamentoResponseDTO();
			pagamentoResponseDTO.setStatus(200);
			pagamentoResponseDTO.setMessage(retorno);
			return ResponseEntity.ok(pagamentoResponseDTO) ;
			
		} catch (Exception e) {
			log.error("Erro no pagamento: "+ e);
			PagamentoResponseDTO pagamentoResponseDTO = new PagamentoResponseDTO();
			pagamentoResponseDTO.setStatus(400);
			pagamentoResponseDTO.setMessage(e.getMessage());
			return ResponseEntity.status(400).body(pagamentoResponseDTO);
		}
		
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<String> SavedRequest() throws IOException {
		return ResponseEntity.ok("Valor de retorno");
		
	}
	
}
