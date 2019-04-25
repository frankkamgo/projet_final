
package taxi_DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import taxi.metier.View_prixtotal;

/**
 *
 * @author Kamgo
 */
public class View_prixtotal_DAO extends DAO<View_prixtotal> {

    public int prixtotal() throws SQLException {
        String req = "select * from prix_total";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("prix total");
                } else {
                    return 0;
                }
            }
        }

    }

    @Override
    public View_prixtotal read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public View_prixtotal create(View_prixtotal obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public View_prixtotal update(View_prixtotal obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(View_prixtotal obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
