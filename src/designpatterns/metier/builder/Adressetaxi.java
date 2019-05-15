
package designpatterns.metier.builder;


import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author Kamgo
 */
public class Adressetaxi {
    
    private int idadr;
    
    private int cp;
    
    private String localite;
    
    private String rue;
   
    private String num;
    
    private Set<Location_taxi>locdeb=new HashSet<>();
    
    private Set<Location_taxi>locfin=new HashSet<>();
    
    private Set<Client_taxi>client=new HashSet<>();

    public Adressetaxi() {
    }

    public Adressetaxi(int idadr, int cp, String localite, String rue, String num) {
        this.idadr = idadr;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
    }

    
    public int getIdadr() {
        return idadr;
    }

    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Set<Location_taxi> getLocdeb() {
        return locdeb;
    }

    public void setLocdeb(Set<Location_taxi> locdeb) {
        this.locdeb = locdeb;
    }

    public Set<Location_taxi> getLocfin() {
        return locfin;
    }

    public void setLocfin(Set<Location_taxi> locfin) {
        this.locfin = locfin;
    }

    public Set<Client_taxi> getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Adressetaxi{" + "idadr=" + idadr + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + ", locdeb=" + locdeb + ", locfin=" + locfin + ", client=" + client + '}';
    }

    
   @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idadr;
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
        final Adressetaxi other = (Adressetaxi) obj;
        if (this.idadr != other.idadr) {
            return false;
        }
        return true;
   
    }   
}
