package com.example.spring_initializr.Övningsuppgift2;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    /*
    // Gör ingen skillnad när vi bara jobbar med JSON, men när vi också har
    metoder som returnerar XML kan det vara bra att lägga till för att
    säkerställa att vi får tillbaka JSON
    @RequestMapping(value= "/kompis", produces = "application/JSON")
    public Kompis oneKompisJSON() {

        Kompis k1 = new Kompis();
        k1.setId(1);
        k1.setAdress("Stockholm");
        k1.setNamn("Roberto Méndez");
        k1.setTelefonnummer("7634234356");
        return k1;
    }
     */

    KompisDAO kompisDao = new KompisDAO();
    List<Kompis> kompisList = kompisDao.getAllKompis();


    @RequestMapping("/kompis")
    public List<Kompis> index() {
        return kompisList;
    }

    @RequestMapping("/kompis/{id}")
    public Kompis getKompisById(@PathVariable int id) {
        Kompis result = new Kompis();
        for (Kompis kompis : kompisList) {
            if(kompis.getId() == id) {
                result = kompis;
            }
        }
        return result;
    }

    @RequestMapping("/kompisMellan/{idFrom}/{idTo}")
    public List<Kompis> getKompisMellan(@PathVariable int idFrom, @PathVariable int idTo) {
        List<Kompis> result = new ArrayList();
        for (Kompis kompis : kompisList) {
            int id = kompis.getId();
            if (id >= idFrom && id <= idTo) {
                result.add(kompis);
            }
        }
        return result;
    }

    @RequestMapping("/kompisHTML")
    public String getKompisHTML() {
        String result = "<HTML><HEAD><TITLE>Kompis</TITLE></HEAD><BODY><TABLE>";
        for (Kompis kompis : kompisList) {
            result += "<TR><TD>"+kompis.getId()+
                    "</TD><TD>"+kompis.getNamn()+
                    "</TD><TD>"+kompis.getAdress()+
                    "</TD></TR>";
        }
        result += "</TABLE></HTML>";
        return result;
    }

    // POST
//    @PostMapping("/kompis/add")
//    public Response add(@RequestBody Kompis k) {
//        System.out.println(k.getId() + " " + k.getAdress() + " " + k.getNamn() + " " + k.getTelefonnummer());
//        Response res = new Response ("Kompis added", Boolean.FALSE);
//        kompisList.add(k);
//        res.setStatus(Boolean.TRUE);
//        return res;
//    }

    // Samma grej
    @PostMapping("/kompis/add")
    public Response add(@RequestBody Kompis k) {
        kompisList.add(k);
        return new Response("Kompis added", Boolean.TRUE);
    }

    @PostMapping("/kompis/update")
    public Response upsertBook(@RequestBody Kompis k){
        Response res = new Response("Kompis updated", Boolean.FALSE);

        int indexToUpdate = -1;
        for (int i = 0; i < kompisList.size(); i++){
            if (kompisList.get(i).getId() == k.getId()){
                indexToUpdate = i;
            }
        }

        if (indexToUpdate == -1){
            kompisList.add(k);
            res.setMessage("Kompis inserted");
            res.setStatus(Boolean.TRUE);
        }
        else{
            kompisList.set(indexToUpdate, k);
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }

}
