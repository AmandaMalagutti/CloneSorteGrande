/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3610
 */
public class Conexao {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

       
    public void iniciarConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sortegrande", "root", "123456");            

        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }

    public void fecharConexao() {
        try {
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
