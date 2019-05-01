package taxi_DAO;

import dbconnect.dbconnexion;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taxi.metier.Adressetaxi;
import taxi.metier.Client_taxi;
import taxi.metier.Location_taxi;
import taxi.metier.Vehicule_taxi;

/**
 *
 * @author kamgo frank
 */
public class Vehicule_taxi_DAOTest {

    static Connection dbConnect;//declaration de la connection

    public Vehicule_taxi_DAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        dbConnect = dbconnexion.getConnection();//recuperation de notre connection
        if (dbConnect == null) {
            System.out.println("connection invalide");// si null connection invalide 
            System.exit(1);
        }
        System.out.println("connection établi");//si non affiche connection etablie 
    }

    @AfterClass
    public static void tearDownClass() {
        dbconnexion.closeConnection();//femeture de la connection
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class Vehicule_taxi_DAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Vehicule_taxi obj = new Vehicule_taxi(0, "TesImmatriculation", 50, 100, "TesDescription");//creation d'un taxi
        Vehicule_taxi_DAO instance = new Vehicule_taxi_DAO();//objet DAO
        instance.setConnection(dbConnect);//J'établis la connexion avec la BD
        Vehicule_taxi expResult = new Vehicule_taxi(0, "TesImmatriculation", 50, 100, "TesDescription");
        Vehicule_taxi result = instance.create(obj);//
        assertEquals("différents immatriculation", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("litre de carburant pas identique", expResult.getCarburant(), result.getCarburant());
        assertEquals("différents prix", expResult.getPrixkm(), result.getPrixkm());
        assertEquals("Description différentes", expResult.getDescription(), result.getDescription());
        assertNotEquals("id non généré", expResult.getIdtaxi(), result.getIdtaxi());
        int idtaxi = result.getIdtaxi();
        obj = new Vehicule_taxi(0, "TesImmatriculation", 22, 90, "TesDescription");
        try {
            Vehicule_taxi result2 = instance.create(obj);
            fail("exception de doublon non déclenchée");
            instance.delete(result2);
        } catch (SQLException e) {
        }
        instance.delete(result);

    }

    /**
     * Test of read method, of class Vehicule_taxi_DAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idtaxi = 0;
        Vehicule_taxi_DAO instance = new Vehicule_taxi_DAO();//Je crée l'objet DAO Taxi
        instance.setConnection(dbConnect);//J'établis la connexion avec la BD
        Vehicule_taxi obj = new Vehicule_taxi(0, "TesImmatriculation", 50, 100, "TesDescription");
        Vehicule_taxi expResult = instance.create(obj);//Je récupère l'objet crée dans la BD avec son id
        idtaxi = expResult.getIdtaxi();
        Vehicule_taxi result = instance.read(idtaxi);//Je récupère l'objet de la base de donnée dans result

        assertEquals("Immatriculation différents", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("litre de carburant pas identique", expResult.getCarburant(), result.getCarburant());
        assertEquals("différents prix", expResult.getPrixkm(), result.getPrixkm());
        assertEquals("Description différentes", expResult.getDescription(), result.getDescription());
        assertEquals("id non généré(différents)", expResult.getIdtaxi(), result.getIdtaxi());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(expResult);
        // fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Vehicule_taxi_DAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Vehicule_taxi obj = new Vehicule_taxi(0, "TesImmatriculation", 50, 100, "TesDescription");
        Vehicule_taxi_DAO instance = new Vehicule_taxi_DAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        obj.setImmatriculation("TestImmatriculation2");
        obj.setCarburant(100);
        obj.setPrixkm(150);
        obj.setDescription("TestDescription2");
        Vehicule_taxi expResult = obj;//J'enregistre dans expResult l'objet obj modifié
        Vehicule_taxi result = instance.update(obj);//Je modifie l'obj dans la base de donnée et l'enregistre dans result
        assertEquals("Immatriculation différents", expResult.getImmatriculation(), result.getImmatriculation());
        assertEquals("litre de carburant pas identique", expResult.getCarburant(), result.getCarburant());
        assertEquals("différents prix", expResult.getPrixkm(), result.getPrixkm());
        assertEquals("Description différentes", expResult.getDescription(), result.getDescription());
        assertEquals("id non généré(différents)", expResult.getIdtaxi(), result.getIdtaxi());
        instance.delete(result);//Une fois que tous les test ont bien été réalisé je supprime l'objet dans la BD
    }

    /**
     * Test of delete method, of class Vehicule_taxi_DAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Vehicule_taxi obj = new Vehicule_taxi(0, "TesImmatriculation", 50, 100, "TesDescription");
        Vehicule_taxi_DAO instance = new Vehicule_taxi_DAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdtaxi());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }//Je fais une liaison entre les tables pour tester les contraintes de clé étrangere
        Adressetaxi adebut=new Adressetaxi(0,6000,"LocaliteTest1","TestRue1","1");
        Adressetaxi afin=new Adressetaxi(0,7000,"LocaliteTest2","TestRue2","2");
        AdresseDAO ad=new AdresseDAO();
        ad.setConnection(dbConnect);
        adebut=ad.create(adebut);
        afin=ad.create(afin);
        Client_taxi cl=new Client_taxi(0,"NomTest","PrenomTest","0000000000",adebut.getIdadr());
        Client_taxi_DAO cd=new Client_taxi_DAO();
        cd.setConnection(dbConnect);
        cl=cd.create(cl);
        obj=instance.create(obj);//Je recrée l'objet taxi parce que je l'avais supprimé
        Location_taxi loc=new Location_taxi(0,LocalDate.now(),200,10,50,cl.getIdclient(),obj.getIdtaxi(),adebut.getIdadr(),afin.getIdadr());
        Location_taxi_DAO ld=new Location_taxi_DAO();
        ld.setConnection(dbConnect);
        loc=ld.create(loc);
        try{
            instance.delete(obj);
            fail("exception de record de parent clé étrangere");
        }catch(Exception e){}
        ld.delete(loc);//Je supprime tout dans l'ordre des liaisons
        cd.delete(cl);
        ad.delete(adebut);
        ad.delete(afin);
        instance.delete(obj);
    }

   
    /**
     * Test of rechdescption method, of class Vehicule_taxi_DAO.
     */
    @Test
    public void testRechdescption() throws Exception {
        System.out.println("rechdescption");
        String descrech = "TesDescription";
        Vehicule_taxi_DAO instance = new Vehicule_taxi_DAO();
        instance.setConnection(dbConnect);
        Vehicule_taxi obj1 = new Vehicule_taxi(0, "TesImmatriculation", 50, 100, "TesDescription");//Je crée 2 objets avec la même description
        Vehicule_taxi obj2 = new Vehicule_taxi(0, "TesImmatriculation2", 100, 150, "TesDescription");//car ma methode peut en retourner plusieurs
        obj1 = instance.create(obj1);//Je crée mes objets dans la base de donnée
        obj2 = instance.create(obj2);
        List<Vehicule_taxi> result = instance.rechdescption(descrech);//je récupère la liste des objets trouvés lors de la recherche
        boolean ok1 = false, ok2 = false;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getImmatriculation().equalsIgnoreCase(obj1.getImmatriculation())) {
                if (result.get(i).getCarburant() == obj1.getCarburant()) {
                    if (result.get(i).getPrixkm() == obj1.getPrixkm()) {
                        ok1 = true;
                    }
                }
            }
            if (result.get(i).getImmatriculation().equalsIgnoreCase(obj2.getImmatriculation())) {
                if (result.get(i).getCarburant() == obj2.getCarburant()) {
                    if (result.get(i).getPrixkm() == obj2.getPrixkm()) {
                        ok2 = true;
                    }
                }
            }
        }
        if (!ok1) {
            fail("Objet introuvable");
        }
        if (!ok2) {
            fail("Objet introuvable");
        }
        instance.delete(obj1);
        instance.delete(obj2);
    }
}
