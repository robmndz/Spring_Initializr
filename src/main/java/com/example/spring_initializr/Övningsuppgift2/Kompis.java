package com.example.spring_initializr.Övningsuppgift2;

import lombok.Data;

@Data
public class Kompis {

    private int Id;
    private String Namn;
    private String Adress;
    private String Telefonnummer;

    public Kompis() {
    }

    public Kompis(int id, String namn, String adress, String telefonnummer) {
        Id = id;
        Namn = namn;
        Adress = adress;
        Telefonnummer = telefonnummer;
    }


}


