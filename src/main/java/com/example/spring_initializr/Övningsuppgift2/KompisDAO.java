package com.example.spring_initializr.Övningsuppgift2;

import java.util.ArrayList;
import java.util.List;

public class KompisDAO {

    public List<Kompis> getAllKompis() {

        List<Kompis> kompisList = new ArrayList<>();
        Kompis k1 = new Kompis(1, "Roberto Méndez", "Stockholm", "7634234356");
        Kompis k2 = new Kompis(2, "Emil Eyre", "New York", "723435796");
        Kompis k3 = new Kompis(3, "Jason Da", "Jönköping", "7634739284");
        Kompis k4 = new Kompis(4, "Erik Bovary", "Nyköping", "7612332145");
        Kompis k5 = new Kompis(5, "Madison Parker", "Linköping", "7098778934");
        Kompis k6 = new Kompis(6, "Pale Henderson", "Stockholm", "7154545454");

        kompisList.add(k1);
        kompisList.add(k2);
        kompisList.add(k3);
        kompisList.add(k4);
        kompisList.add(k5);
        kompisList.add(k6);

        return kompisList;
    }
}
