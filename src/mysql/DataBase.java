package mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

/**
 * @author dii
 */
public class DataBase {

    private String USER = "usuario2";
    private String PASS = "Usuario2";
    private String CON_STR = "jdbc:mysql://148.225.67.86/bd_usuario2?useSSL=false";

    private Connection con;

    public DataBase() {
        try {
            this.con = (Connection) DriverManager.getConnection(this.CON_STR, this.USER, this.PASS);
            System.out.println("conexion exitosa");
        } catch (SQLException e) {
            System.out.println("conexion fallida " + e.getMessage());
        }
    }

    public ResultSet Consulta(String query) {
        try {
            Statement stm = this.con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error en metodo de consulta: " + e.getMessage());
            return null;
        }
    }

    public String[][] ConvertirMatriz(ResultSet rs) {
        try {
            ResultSetMetaData meta = rs.getMetaData();
            int ColumnasCant = meta.getColumnCount();
            rs.last();
            int ReglonesCant = rs.getRow();
            rs.first();

            String[][] resultados = new String[ReglonesCant][ColumnasCant];

            int contadorRenglon = 0;
            do {
                for (int i = 0; i < ColumnasCant; i++) {
                    resultados[contadorRenglon][i] = rs.getString(i + 1);
                }
                contadorRenglon++;
            } while (rs.next());
            return resultados;
        } catch (Exception e) {
            System.out.println("no jalo");
            return null;
        }
    }

    public void insertar(String insert) {
        try {
            Statement stm = this.con.createStatement();
            stm.executeUpdate(insert);
        } catch (SQLException e) {
            System.out.println("Error al Actualizar/Insertar " + e.getMessage());
        }
    }

}
