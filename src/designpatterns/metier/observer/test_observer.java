/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.metier.observer;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author KAMGO
 */
public class test_observer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
         Vehicule_taxi taxi=new   Vehicule_taxi(1,"kamgo","eau",3,"Test taxi");
        Adressetaxi adresseDepart = new Adressetaxi(1,7000,"Mons","rue des Batars","11");
        Adressetaxi adresseFin= new Adressetaxi(2,7000,"Mons","rue des chaseur","3");
        Client_taxi client= new Client_taxi(1,"Doso","Dosado","0411/11264",adresseDepart);
        adresseDepart.getClient().add(client);
        Location_taxi location=new Location_taxi(1,19,44,40,taxi,adresseDepart,adresseFin,client);
        taxi.getLocation().add(location);
        adresseDepart.getLocdeb().add(location);
        adresseFin.getLocfin().add(location);
       

      Vehicule_taxi taxi2=new Vehicule_taxi(2,"Tchoula","huil",4,"Test2 taxi");
       location.setVehicule(taxi2);
       
        
    }
}
