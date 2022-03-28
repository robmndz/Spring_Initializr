package com.example.spring_initializr;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class Övningsuppgift1_LuckyYou {

    private int random() {
        return (int) (Math.random() * 10) + 1;
    }

    private String randomAnimal() {
        switch ((int) (Math.random() * 4)) {
            case 0:
                return "skata";
            case 1:
                return "hund";
            case 2:
                return "spindel";
            default:
                return "katt";
        }
    }

    //Query parametrar --- @RequestParam
    //http://localhost:8080/hello?firstName=Abraham&lastName=Lincoln
    //http://localhost:8080/hello?firstName=Abraham     // fel
    //http://localhost:8080/hello?someOtherName=Abraham&lastName=Lincoln     // fel
    @RequestMapping("/hello")
    public String hello(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hej " + firstName + " " + lastName + " !";
    }

    // Uppgift 1b
    // Övningsuppgift 1b, Lucky you
    //http://localhost:8080/luckyYouB?type=animal
    //http://localhost:8080/luckyYouB?type=number
    //http://localhost:8080/luckyYouB?type=sdf8752s2df      // fel

    @RequestMapping("/luckyYouB")
    public String lyb(@RequestParam String type) {
        if (type.equalsIgnoreCase("animal")) {
            return randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return String.valueOf(random());
        } else return "I don't understand";
    }


    // Uppgift 1c
    // Övningsuppgift 1c, lucky you with optionals
    // http://localhost:8080/luckyYouC?type=animal&firstname=Roberto&lastname=M%C3%A9ndez
    // http://localhost:8080/luckyYouC?type=number&firstname=Roberto
    // http://localhost:8080/luckyYouC?type=animal
    // ...
    @RequestMapping("/luckyYouC")
    public String lyc(@RequestParam String type,
                      @RequestParam(required = false) String firstname,
                      @RequestParam(required = false) String lastname) {

        String f = "";
        String l = "";

        if (firstname != null) {
            f = firstname;
        }
        if (lastname != null) {
            l = lastname;
        }
        if (type.equalsIgnoreCase("animal")) {
            return f + " " + l + " ditt lyckodjur är " + randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return f + " " + l + " ditt lyckonummer är " + String.valueOf(random());
        } else return "I don't understand";
    }


    // Uppgift 1d
    // Övningsuppgift 1d, lucky you with defaults
    // http://localhost:8080/luckyYouD?type=number
    // http://localhost:8080/luckyYouD?type=number&firstname=Pedro
    // http://localhost:8080/luckyYouD?type=animal&lastname=Turula
    @RequestMapping("/luckyYouD")
    public String lyd(@RequestParam String type,
                      @RequestParam(required = false, defaultValue = "Roberto") String firstname,
                      @RequestParam(required = false, defaultValue = "Méndez") String lastname) {

        String f = "";
        String l = "";
        if (firstname != null) {
            f = firstname;
        }
        if (lastname != null) {
            l = lastname + ", ";
        }

        if (type.equalsIgnoreCase("animal")) {
            return f + " " + l + " ditt lyckodjur är " + randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return f + " " + l + " ditt lyckonummer är " + String.valueOf(random());
        } else return "I don't understand";
    }


    // Uppgift 1e
    // Övningsuppgift 1e, inparameter-listor
    // http://localhost:8080/luckyYouE?type=number&unlucky=1,2,3,4,5,6,7,8,10
    // http://localhost:8080/luckyYouE?type=animal&unlucky=1,4,5,8

    @RequestMapping("/luckyYouE")
    public String lye(@RequestParam String type,
                      @RequestParam List<Integer> unlucky) {

        if (type.equalsIgnoreCase("animal")) {
            return randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            boolean b = true;
            int nr = 0;
            while (b) {
                nr = random();
                if (!unlucky.contains(nr)) {
                    b = false;
                }
            }
            return String.valueOf(nr);
        } else return "I don't understand";
    }

    // Uppgift 1f
    // Övningsuppgift 1f, utparameter-listor
    // http://localhost:8080/luckyYouE?type=animal&unlucky=1,3,8
    // http://localhost:8080/luckyYouE?type=number&unlucky=1,3,8

    @RequestMapping("/luckyYouF")
    public List<String> lyf(@RequestParam String type,
                            @RequestParam List<Integer> unlucky) {
        List<String> res = new LinkedList<>();
        if (type.equalsIgnoreCase("animal")) {
            res.add(randomAnimal());
        } else if (type.equalsIgnoreCase("number")) {
            for (int i = 1; i < 11; i++) {
                if (!unlucky.contains(i)) {
                    res.add(String.valueOf(i));
                }
            }
        }
        return res;
    }

    // Uppgift 1g
    // Övningsuppgift 1g, path-parametrar
    // http://localhost:8080/luckyYouG/animal
    // http://localhost:8080/luckyYouG/number
    @RequestMapping("/luckyYouG/{type}")
    public String lyg(@PathVariable String type) {
        if (type.equalsIgnoreCase("animal")) {
            return randomAnimal();
        } else if (type.equalsIgnoreCase("number")) {
            return String.valueOf(random());
        } else return "I don't understand";
    }

    // Uppgift 1h
    // Övningsuppgift 1h
    // http://localhost:8080/helloHTML?firstname=Roberto&lastname=M%C3%A9ndez
    @RequestMapping("/helloHTML")
    public String hejsan(@RequestParam String firstname,
                         @RequestParam String lastname) {
        return "<h1>Hejsan " + firstname + " " + lastname + "</h1>";
    }

    // Uppgift 1h
    // http://localhost:8080/luckyYouHTML
    @RequestMapping(value = "/luckyYouHTML")     // value är en gammal notation. Det behövs inte att skriva value =
    public String hejhtml() {
        return "<html><head></head><body><h1>hej</h1>på er</body></html>";
    }

}



