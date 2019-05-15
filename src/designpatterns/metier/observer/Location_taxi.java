
package designpatterns.metier.observer;


import java.time.LocalDate;

/**
 *
 * @author Kamgo
 */
public class Location_taxi extends Subject{
 
  private int idloc;
 
  private int kmtotal;
 
  private float acompte;
 
  private float total;
  
  private Vehicule_taxi vehicule;
  
  private Adressetaxi idadrdebuit;
  
  private Adressetaxi idadrfin;
  
  private Client_taxi client;

    public Location_taxi() {
    }

    public Location_taxi(int idloc, int kmtotal, float acompte, float total, Vehicule_taxi vehicule, Adressetaxi idadrdebuit, Adressetaxi idadrfin, Client_taxi client) {
        this.idloc = idloc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.vehicule = vehicule;
        this.idadrdebuit = idadrdebuit;
        this.idadrfin = idadrfin;
        this.client = client;
    }

    public int getIdloc() {
        return idloc;
    }

    public void setIdloc(int idloc) {
        this.idloc = idloc;
    }

    public int getKmtotal() {
        return kmtotal;
    }

    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    public float getAcompte() {
        return acompte;
    }

    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Vehicule_taxi getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule_taxi vehicule) {
        this.vehicule = vehicule;
    }

    public Adressetaxi getIdadrdebuit() {
        return idadrdebuit;
    }

    public void setIdadrdebuit(Adressetaxi idadrdebuit) {
        this.idadrdebuit = idadrdebuit;
    }

    public Adressetaxi getIdadrfin() {
        return idadrfin;
    }

    public void setIdadrfin(Adressetaxi idadrfin) {
        this.idadrfin = idadrfin;
    }

    public Client_taxi getClient() {
        return client;
    }

    public void setClient(Client_taxi client) {
        this.client = client;
    }
  


    @Override
    public String getNotification() {
        return "le nouvel idtaxi de la location numéro "+idloc+" est "+vehicule.getIdtaxi();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idloc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location_taxi other = (Location_taxi) obj;
        if (this.idloc != other.idloc) {
            return false;
        }
        return true;
    }

  
}
