package com.comanda.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosExtrasPayer {
	  public String first_name;
	  public String last_name;
	  public Address address;
	  public Date registration_date;
	  public Phone phone;
}
