package com.comanda.utils;

import java.util.HashMap;
import java.util.Map;

public class CodePagamentoUtil {
	
	public Map<String,String> codigos = new HashMap<String,String>();	

	public CodePagamentoUtil() {
		codigos.put("approved", "Pagamento aprovado com sucesso");
		codigos.put("pending", "Pagamento pendente");
		codigos.put("authorized", "Pagamento autorizado mas ainda não finalizado");
		codigos.put("in_process", "Pagamento está sendo analizado");
		codigos.put("in_mediation", "Os usuários iniciaram uma disputa com o pagamento");
		codigos.put("rejected", "O pagamento foi rejeitado. O usuário pode tentar o pagamento novamente");
		codigos.put("cancelled", "O pagamento foi cancelado por uma das partes ou porque o prazo para pagamento expirou");
		codigos.put("refunded", "O pagamento foi devolvido ao usuário");
		codigos.put("charged_back", "Foi feito um estorno no cartão de crédito do comprador");
	}
	
	public String getVal(String val){
		return this.codigos.get(val);
	}
}
