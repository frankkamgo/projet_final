
package taxi_DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import taxi.metier.Adressetaxi;
import taxi.metier.Client_taxi;
public class AdresseDAO extends DAO<Adressetaxi>{

/**
 *
 * @author Hp
 */

    /**
     * récupération des données d'une Adresse  sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idadr identifiant du Adresse
     * @return Adresse trouvé
     */

    @Override
    public Adressetaxi read(int idadr) throws SQLException {
        String req = "select * from api_adressetaxi where idadr= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idadr);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    int cp = rs.getInt("CP");
                    String localite = rs.getString("LOCALITE");
                    String rue = rs.getString("RUE");
                    String num = rs.getString("NUM");

                    return new Adressetaxi(idadr, cp, localite, rue, num);

                } else {
                    throw new SQLException("Code inconnu");
                }
            }
        }
    }
    /**
     * création d'une Adresse  sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj Adresse à créer
     * @return Adresse créé
     */
    @Override
    public Adressetaxi create(Adressetaxi obj) throws SQLException {
        String req1 = "insert into api_adressetaxi (cp,localite,rue,num) values(?,?,?,?)";
        String req2 = "select idadr from api_adressetaxi where rue=? and localite=? and num=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setInt(1, obj.getIdadr());
            pstm1.setString(2, obj.getLocalite());
            pstm1.setString(3, obj.getRue());
            pstm1.setString(4, obj.getNum());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation adresse, aucune ligne créée");
            }
            pstm2.setString(2, obj.getLocalite());
            pstm2.setString(1, obj.getRue());
            pstm2.setString(3, obj.getNum());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idadr = rs.getInt(1);
                    obj.setIdadr(idadr);
                    return read(idadr);
                } else {
                    throw new SQLException("erreur de création adresse, record introuvable");
                }
            }
        }

    }
/**
     * mise à jour des données de l'Adresse sur base de l'dentifiant
     *
     * @return Adresse
     * @param obj Adresse à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Adressetaxi update(Adressetaxi obj) throws SQLException {
        String req = "update api_adressetaxi set cp=?,localite=?,rue=?,num=? where idadr=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            
            pstm.setInt(1, obj.getCp());
            pstm.setString(2, obj.getLocalite());
            pstm.setString(2, obj.getRue());
            pstm.setString(3, obj.getNum());
            pstm.setInt(4, obj.getIdadr());
            
            System.out.println(req);
            int n = pstm.executeUpdate();
            System.out.println(req);
            if (n == 0) {
                throw new SQLException("aucune ligne adresse mise à jour");
            }
            return read(obj.getIdadr());
        }
        
    }
/**
     * effacement de l'Adresse sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj Adresse à effacer
     */
    @Override
    public void delete(Adressetaxi obj) throws SQLException {
        String req = "delete from api_adressetaxi where idadr= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdadr());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne adresse effacée");
            }

        }
    }

}
