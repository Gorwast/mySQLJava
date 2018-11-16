
package mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author dii
 */
public class Mysql {
    
    public static void main(String[] args) {
        DataBase db = new DataBase();
        //String query = "SELECT * FROM Cliente";
        String query = "INSERT INTO Cliente VALUES (7,'Walter White','308 Negra Arroyo Lane',6621237645)";
        //ResultSet rs = db.Consulta(query);
        
        try {
            db.insertar(query);
        } catch (Exception e){
            System.out.println("Sucedio un error: " + e.getMessage());
        }
    }
}
