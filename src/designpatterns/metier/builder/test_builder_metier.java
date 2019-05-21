
package designpatterns.metier.builder;

/**
 *
 * @author Kamgo
 */
public class test_builder_metier {
    public static void main(String[] args) {
        System.out.println("full Test taxi : ");
       try{
            Vehicule_taxi ta1 = new Vehicule_taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setImmatriculation("abc").
                    setCarburant("essence").
                    setPrixkm(2).
                    setDescription("test taxi").
                    build();
            System.out.println(ta1);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
        System.out.println("full Test taxi: (prixkm)");
        try{
            Vehicule_taxi ta2 = new Vehicule_taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setImmatriculation("abc").
                    setCarburant("essence").
                    setDescription("test taxi").
                    build();
            System.out.println(ta2);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
        System.out.println("full Test taxi: (immatriculation)");
        try{
           Vehicule_taxi ta3 = new Vehicule_taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setCarburant("essence").
                    setPrixkm(2).
                    setDescription("test taxi").
                    build();
            System.out.println(ta3);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
    }
}
