/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baserelacionald;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author oracle
 */
public class BaserelacionalD {

    String usuario = "hr";
    String password = "hr";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    ResultSetMetaData rsmd;
    Statement st;
    ResultSet rs;

    public BaserelacionalD() {
        try {
            DriverManager.deregisterDriver(new OracleDriver());
            System.err.println("*Se ha registrado el Driver de Oracle. ");
        } catch (SQLException ex) {
            Logger.getLogger(BaserelacionalD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection conectarse() throws SQLException {
        Connection conn = DriverManager.getConnection(url, usuario, password);
        return conn;
    }

    public void tamColumnas() throws SQLException {
        st = conectarse().createStatement();
        rs = st.executeQuery("select produtos.* from produtos");
        rsmd = rs.getMetaData();
        System.out.println(rsmd.getColumnName(1) + ", " + rsmd.getColumnTypeName(1) + ", " + rsmd.getColumnDisplaySize(1));
        System.out.println(rsmd.getColumnName(2) + ", " + rsmd.getColumnTypeName(2) + ", " + rsmd.getColumnDisplaySize(2));
        System.out.println(rsmd.getColumnName(3) + ", " + rsmd.getColumnTypeName(3) + ", " + rsmd.getColumnDisplaySize(3));

    }

    public static void main(String[] args) throws SQLException {
        new BaserelacionalD().tamColumnas();
    }

}
