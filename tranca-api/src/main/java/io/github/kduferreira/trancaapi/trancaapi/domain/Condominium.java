package io.github.kduferreira.trancaapi.trancaapi.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Condominium {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cnpj;


    private String descripition;

    private String address;

    private String phone;

    private String numberAddress;

    private String addressOther;

    private String latitude;

    private String longetude;


}
