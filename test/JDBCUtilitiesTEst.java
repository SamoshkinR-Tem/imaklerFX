import jdbc.JDBCUtilities;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by R-Tem on 25.09.2015.
 */
public class JDBCUtilitiesTEst {
    @Test
    public void test(){
        try {
            JDBCUtilities jdbcUtilities = new JDBCUtilities("properties/mysql-properties.xml");
            jdbcUtilities.getConnection();
            jdbcUtilities.getConnection("samoshkin", "tKtrnhjy1610-19");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
