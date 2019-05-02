
package proj_taxi;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import taxi_DAO.Vehicule_taxi_DAO;
import taxi_DAO.DAO;
import taxi.metier.Vehicule_taxi;
import dbconnect.dbconnexion;
import taxi.metier.Client_taxi;
import taxi_DAO.Client_taxi_DAO;
/**
 *
 * @Frank Kamgo Tchoula
 */
public class Gestion_vehicule_taxi {
     Scanner sc = new Scanner(System.in);
    Vehicule_taxi vtActuel = null;
    private Vehicule_taxi_DAO vtDAO;
    //DAO<Vehicule_taxi> Vehicule_taxi_DAO = null;

    public Gestion_vehicule_taxi() {
    }
    
     public void gesvehitaxi() {
        Connection dbConnect = dbconnexion.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }
  System.out.println("connexion établie");

        vtDAO = new Vehicule_taxi_DAO();
         vtDAO.setConnection(dbConnect);
        
         int ch = 0;
        do {
            System.out.println("1.nouveau_taxi \n2.recherche\n3.modification\n4.recherche_description\n5.fin de programme");
            System.out.print("choix :");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    nouveau_taxi();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modif();
                    break;
                
                case 4:
                   rechdescription();
                    break;
                case 5:
                    System.out.println("FIN DE PROGRAMME");
                    break;
                default:
                    System.out.println("choix incorrect");
                    break;
            }

        } while (ch != 5);
        dbconnexion.closeConnection();
    }
     
      public void nouveau_taxi() {

        System.out.print("immatriculation :");
        String immatriculation = sc.nextLine();
        System.out.print("carburant :");
        String carburant = sc.nextLine();
        System.out.print("prixkm :");
        int prixkm = sc.nextInt();
        sc.skip("\n");
           System.out.println("description");
        String description=sc.nextLine();
        vtActuel = new Vehicule_taxi(0, immatriculation, carburant,prixkm,description);
        try {
            vtActuel = vtDAO.create(vtActuel);
            System.out.println("taxi actuel : " + vtActuel);
        } catch (SQLException e) {
            System.out.println("erreur creation véhicule :" + e);
        }

    }
      
       public void recherche() {
        try {
            System.out.println("immatriculation recherché :");
            String nc = sc.nextLine();
            vtActuel = vtDAO.readImmatriculation(nc);
            System.out.println("immatriculation recherché : " + vtActuel);
            
            int choix = 0;
            String option = "";
            do {
                do {
                    System.out.println("Menu secondaire :");
                    System.out.println("\t1.Modifier");
                    System.out.println("\t2.Supprimer");
                    System.out.println("\t3.Revenir au menu cours");
                    option = sc.nextLine();
                } while (verifier_chaine(option, "[1-3]") == false);
                choix = Integer.parseInt(option);
                switch (choix) {
                    case 1:
                        modif();
                        break;
                    case 2:
                        sup();
                        break;
                    case 3:
                       gesvehitaxi();
                        break;
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
       
        public void modif() {
        try {
            System.out.println("modification de l'immatriculation");
            System.out.println("entre immatricule :");
            String immatriculation = sc.next();
            vtActuel.setImmatriculation(immatriculation);
            vtDAO.update(vtActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
        
         public void sup() {
        try {
            vtDAO.delete(vtActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
         
       public void rechdescription() {
        System.out.println("entre description : ");
        String description = sc.nextLine();
        
        try {
            List<Vehicule_taxi> vta = vtDAO.rechdescption(description);
            for (Vehicule_taxi vt : vta) {
                System.out.println(vt);//affiche de tout ce que j''ai trouvé
            }
            //System.out.println(vta.indexOf(vta.get(0)));
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
      public boolean verifier_chaine(String ch, String regex) {
        return ch.matches(regex);
    } 
     
}

