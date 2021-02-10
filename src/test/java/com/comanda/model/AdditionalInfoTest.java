package com.comanda.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdditionalInfoTest {
	ListaPedidos l = new ListaPedidos();
	
	@Test
	void test() {
		l.getPedidos();
		
		assertEquals(l.getPedidos(), "a");
		
	}

}
