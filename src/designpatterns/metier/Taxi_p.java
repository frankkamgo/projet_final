
package designpatterns.metier;
import java.util.HashSet; 
import java.util.Objects; 
import java.util.Set; 
 
/**
 *
 * @author Kamgo
 */
public class Taxi_p {
        /**
   * identifiant unique du taxi
   */
    private int idtaxi;
       /**
   * immatriculation du taxi
   */
    private String immatriculation;
       /**
   * quantité du carburant
   */
    private int carburant;
       /**
   * prix du kilometre parcouru
   */
    private int prixkm;
       /**
   * description du taxi
   */
    private String description;
/**
 * appel de location
 */
     private Set<Location_p> location=new HashSet<>(); 

    public Taxi_p() {
    }
    /**
 * constructeur paramétré
 * @param idtaxi identifiant unique de l'adresse, affecté par la base de données
 * @param immatriculation du ntaxi
 * @param carburant consommé
 * @param prix du kilometre parcouru
 * @param  description du taxi
 */

    public Taxi_p(int idtaxi, String immatriculation, int carburant, int prixkm, String description) {
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

    public int getCarburant() {
        return carburant;
    }

    public void setCarburant(int carburant) {
        this.carburant = carburant;
    }

    public int getPrixkm() {
        return prixkm;
    }

    public void setPrixkm(int prixkm) {
        this.prixkm = prixkm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Location_p> getLocation() {
        return location;
    }

    public void setLocation(Set<Location_p> location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
         int hash = 3; 
        hash = 29 * hash + Objects.hashCode(this.idtaxi); 
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
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
        final Taxi_p other = (Taxi_p) obj; 
        if (!Objects.equals(this.idtaxi, other.idtaxi)) { 
            return false; 
        } 
        return true; 
    } 
     
}
