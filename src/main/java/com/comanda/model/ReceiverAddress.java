package com.comanda.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiverAddress {
    public String street_name;
    public int street_number;
    public String zip_code;
    public String city_name;
    public String state_name;
}
