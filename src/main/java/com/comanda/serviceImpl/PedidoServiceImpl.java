package com.comanda.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.comanda.model.Pagamento;
import com.comanda.service.PedidoService;
import com.comanda.utils.CodePagamentoUtil;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Identification;
import com.mercadopago.resources.datastructures.payment.Payer;

@Service
public class PedidoServiceImpl implements PedidoService {
	private static final Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);
	private static String ACESSTOKEN = "TEST-2279734683163672-090222-997af3170deec852c23835c46c199530-636762063";
	
	@Override
	public String pagamento(Pagamento request) {
		log.debug("Criado pagamento");
		try {
			MercadoPago.SDK.setAccessToken(ACESSTOKEN);
		} catch (MPConfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Payment payment = new Payment();
//		payment.setTransactionAmount(Float.valueOf(request.getParameter("transactionAmount")))
//		       .setToken(request.getParameter("token"))
//		       .setDescription(request.getParameter("description"))
//		       .setInstallments(Integer.valueOf(request.getParameter("installments")))
//		       .setPaymentMethodId(request.getParameter("paymentMethodId"));
//
//		Identification identification = new Identification();
//		identification.setType(request.getParameter("docType"))
//		              .setNumber(request.getParameter("docNumber"));
//
//		Payer payer = new Payer();
//		payer.setEmail(request.getParameter("email"))
		payment.setTransactionAmount(Float.valueOf(request.getTransactionAmount()))
	       .setToken(request.getToken())
	       .setDescription(request.getDescription())
	       .setInstallments(Integer.valueOf(request.getInstallments()))
	       .setPaymentMethodId(request.getPaymentMethodId());

		Identification identification = new Identification();
		identification.setType(request.getDocType())
		              .setNumber(request.getDocNumber());
	
		Payer payer = new Payer();
		payer.setEmail(request.getEmail())
		     .setIdentification(identification);

		payment.setPayer(payer);

		try {
			log.debug("Salvando pagamento");
			payment.save();

		} catch (MPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("Pagamento Salvo");
		System.out.println(payment.getStatus());
		CodePagamentoUtil codePagamentoUtil = new CodePagamentoUtil();
		return codePagamentoUtil.getVal(payment.getStatus().toString());
	}

}
