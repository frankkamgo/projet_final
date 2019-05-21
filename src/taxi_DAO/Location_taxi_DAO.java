package taxi_DAO;

/**
 * classe de mappage poo-relationnel location_taxi
 *
 * @author frank kamgo
 * @version 1.0
 * @see Location_taxi
 */
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import taxi.metier.Client_taxi;
import taxi.metier.Location_taxi;
import taxi.metier.Vehicule_taxi;

public class Location_taxi_DAO extends DAO<Location_taxi> {

    /**
     * création d'une location sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj location à créer
     * @return location_taxi créé
     */
    @Override
    public Location_taxi create(Location_taxi obj) throws SQLException {
        String req1 = "insert into api_locationtaxi (dateloc,kmtotal,acompte,total,idclient,idtaxi,idadrdebut,idadrfin) values(?,?,?,?,?,?,?,?)";
        String req2 = "select idloc from api_locationtaxi where dateloc=? and acompte=? and total=? and idtaxi=? and kmtotal=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm1.setDouble(2, obj.getKmtotal());
            pstm1.setDouble(3, obj.getAcompte());
            pstm1.setDouble(4, obj.getTotal());

            pstm1.setInt(5, obj.getIdclient());
            pstm1.setInt(6, obj.getIdtaxi());
            pstm1.setInt(7, obj.getIdadrdebuit());
            pstm1.setInt(8, obj.getIdadrfin());
            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation location, aucune ligne créée");
            }
            pstm2.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));
            pstm2.setDouble(5, obj.getKmtotal());
            pstm2.setDouble(2, obj.getAcompte());
            pstm2.setDouble(3, obj.getTotal());
            pstm2.setInt(4, obj.getIdtaxi());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idloc = rs.getInt(1);
                    obj.setIdloc(idloc);
                    return read(idloc);
                } else {
                    throw new SQLException("erreur de création location, record introuvable");
                }
            }
        }
    }

    @Override
    /**
     * récupération des données d'une location sur base de son identifiant
     *
     * @throws SQLException code inconnu
     * @param idloc identifiant de la location
     * @return location trouvé
     */
    public Location_taxi read(int idloc) throws SQLException {

        String req = "select * from api_locationtaxi where idloc = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idloc);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    LocalDate dateloc = rs.getDate("DATELOC").toLocalDate();//transformer une Date sql en LocalDate
                    int kmtotal = rs.getInt("KMTOTAL");
                    int acompte = rs.getInt("ACOMPTE");
                    int total = rs.getInt("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    int idadrdebut = rs.getInt("IDADRDEBUT");
                    int idadrfin = rs.getInt("IDADRFIN");

                    return new Location_taxi(idloc, dateloc, kmtotal, acompte, total, idclient, idtaxi, idadrdebut, idadrfin);

                } else {
                    throw new SQLException("Code inconnu");
                }

            }
        }
    }

    /**
     * mise à jour des données de la location sur base de son identifiant
     *
     * @return Location_taxi
     * @param obj location à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Location_taxi update(Location_taxi obj) throws SQLException {
        String req = "update api_locationtaxi set dateloc=?,kmtotal=?,acompte=?,total=?,idclient=?,idtaxi=?,idadrdebut=?,idadrfin=? where idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(9, obj.getIdloc());
            pstm.setDate(1, java.sql.Date.valueOf(obj.getDateloc()));//transformer une LocalDate en Date sql
            pstm.setDouble(2, obj.getKmtotal());
            pstm.setDouble(3, obj.getAcompte());
            pstm.setDouble(4, obj.getTotal());
            pstm.setInt(5, obj.getIdclient());
            pstm.setInt(6, obj.getIdtaxi());
            pstm.setInt(7, obj.getIdadrdebuit());
            pstm.setInt(8, obj.getIdadrfin());
            System.out.println(req);
            int n = pstm.executeUpdate();
            System.out.println(req);
            if (n == 0) {
                throw new SQLException("aucune ligne location mise à jour");
            }
            return read(obj.getIdloc());
        }
    }

    /**
     * effacement de la location sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj location à effacer
     */
    @Override
    public void delete(Location_taxi obj) throws SQLException {
        String req = "delete from api_locationtaxi where idloc= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdloc());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne location effacée");
            }

        }
    }

    /**
     * méthode permettant de récupérer la date de la dernière commande d'un
     * client
     *
     * @param idloc identifiant recherché
     * @return total de la location
     * @throws SQLException location sans commande
     */
    public Double aff(int idloc) throws SQLException {
        System.out.println("");
        Double tot = null;
        String req = "select * from total_paid where idloc=?";
        System.out.println("fjodjfodjf");
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idloc);
            System.out.println("fjodjfodjf");
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    tot = rs.getDouble("total");
                    System.out.println("" + tot);
                    return tot;
                } else {
                    throw new SQLException("Aucune location n'a cet id ");
                }
            }
        }

    }
    
     public List<Location_taxi> rechloc(int idrech) throws SQLException {
        List<Location_taxi> plusieurs = new ArrayList<>();
        String req = "select * from api_locationtaxi where idtaxi= ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1,idrech );
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idloc = rs.getInt("idloc");
                    LocalDate date=rs.getDate("dateloc").toLocalDate();
                   int kmtotal = rs.getInt("kmtotal");
                   int acompte = rs.getInt("acompte");
                   int total = rs.getInt("total");
                   int idclient = rs.getInt("idclient");
                   int idtaxi = rs.getInt("idtaxi");
                   int idadrdebut = rs.getInt("idadrdebut");
                   int idadrfin = rs.getInt("idadrfin");
                    
                    plusieurs.add(new Location_taxi(idloc,date,kmtotal,acompte,total,idclient,idtaxi,idadrdebut,idadrfin));
                }

                if (!trouve) {
                    throw new SQLException(" tout les location inexistant");
                } else {
                    return plusieurs;
                }
            }
        }
     }

}
