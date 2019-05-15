package designpatterns.metier.builder;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Kamgo
 */
public class Client_taxi{

    private int idclient;

    private String nom;

    private String prenom;

    private String tel;

    private Adressetaxi adresse;
    
    private Set<Location_taxi> location=new HashSet<>();

    public Client_taxi() {
    }

    public Client_taxi(int idclient, String nom, String prenom, String tel, Adressetaxi adresse) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
    }
    
    

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Adressetaxi getAdresse() {
        return adresse;
    }

    public void setAdresse(Adressetaxi adresse) {
        this.adresse = adresse;
    }

    public Set<Location_taxi> getLocation() {
        return location;
    }

    public void setLocation(Set<Location_taxi> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Client_taxi{" + "idclient=" + idclient + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse + ", location=" + location + '}';
    }


   

}
