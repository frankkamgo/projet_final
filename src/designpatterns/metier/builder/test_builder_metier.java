
package designpatterns.metier.builder;

/**
 *
 * @author Kamgo
 */
public class test_builder_metier {
    public static void main(String[] args) {
        System.out.println("full Test taxi : ");
        try{
           Vehicule_taxi tax1 = new Vehicule_taxi.TaxiBuilder().setIdtaxi(1).setImmatriculation("imm").setCarburant("carbu").setPrixkm(12).setDescription("desti").
                   build();
           
            System.out.println(tax1);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
        System.out.println(" full Test taxi: (immatriculation)");
        try{
            Vehicule_taxi tax2 = new Vehicule_taxi.TaxiBuilder().setIdtaxi(1).setCarburant("carbu").setPrixkm(12).setDescription("desti").
            
                    build();
            System.out.println(tax2);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
        System.out.println("full Test taxi: (prixkm)");
        try{
            Vehicule_taxi tax3 = new Vehicule_taxi.TaxiBuilder().setIdtaxi(1).setImmatriculation("imm").setCarburant("carbu").setDescription("desti").
                   
                    build();
            System.out.println(tax3);
        }
        catch(Exception e){
            System.out.println("Erreur: "+e);
        }
        
    }
}
