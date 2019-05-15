
package designpatterns.metier.observer;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Kamgo
 */
public class Vehicule_taxi {
 
   private int idtaxi;
 
   private String immatriculation;
  
   private String carburant;
 
   private float prixkm;
  
   private String description;

   private Set<Location_taxi> location=new HashSet<>();

   
    public Vehicule_taxi() {
    }

    public Vehicule_taxi(int idtaxi, String immatriculation, String carburant, float prixkm, String description) {
        this.idtaxi = idtaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixkm = prixkm;
        this.description = description;
    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public float getPrixkm() {
        return prixkm;
    }

    public void setPrixkm(float prixkm) {
        this.prixkm = prixkm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Location_taxi> getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Vehicule_taxi{" + "idtaxi=" + idtaxi + ", immatriculation=" + immatriculation + ", carburant=" + carburant + ", prixkm=" + prixkm + ", description=" + description + ", location=" + location + '}';
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.immatriculation);
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
        final Vehicule_taxi other = (Vehicule_taxi) obj;
        if (!Objects.equals(this.immatriculation, other.immatriculation)) {
            return false;
        }
        return true;
    }
   
    
   
}
