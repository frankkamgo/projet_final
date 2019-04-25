
package taxi_DAO;

import dbconnect.dbconnexion;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taxi.metier.View_prixtotal;
import static taxi_DAO.Vehicule_taxi_DAOTest.dbConnect;

/**
 *
 * @author User
 */
public class View_prixtotal_DAOTest {

    static Connection dbConnect;

    public View_prixtotal_DAOTest() {
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
     * Test of prixtotal method, of class View_prixtotal_DAO.
     */
    @Test
    public void testPrixtotal() throws Exception {
        System.out.println("prixtotal");
        View_prixtotal_DAO instance = new View_prixtotal_DAO();
        instance.setConnection(dbConnect);
        try {
            System.out.println(instance.prixtotal());
        } catch (Exception e) {
            fail("Record introuvable");
        }

    }

/**
 * Test of read method, of class View_prixtotal_DAO.
 */
/* @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int id = 0;
        View_prixtotal_DAO instance = new View_prixtotal_DAO();
        View_prixtotal expResult = null;
        View_prixtotal result = instance.read(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class View_prixtotal_DAO.
 */
 /*@Test
    public void testCreate() throws Exception {
        System.out.println("create");
        View_prixtotal obj = null;
        View_prixtotal_DAO instance = new View_prixtotal_DAO();
        View_prixtotal expResult = null;
        View_prixtotal result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class View_prixtotal_DAO.
 */
 /* @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        View_prixtotal obj = null;
        View_prixtotal_DAO instance = new View_prixtotal_DAO();
        View_prixtotal expResult = null;
        View_prixtotal result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class View_prixtotal_DAO.
 */
 /* @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        View_prixtotal obj = null;
        View_prixtotal_DAO instance = new View_prixtotal_DAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
