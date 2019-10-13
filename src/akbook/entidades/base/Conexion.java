/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
*/
package akbook.entidades.base;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Conexion {
    
    public Conexion() {}

    public static Connection getConnection() throws Exception
    {
        try{
        File archivoDB= new File("aurakingdom.db");//new File("aurakingdom1.db");
        String rutaDB=archivoDB.getAbsolutePath().replaceAll(" ", "%20");
        String base = "jdbc:sqlite::resource:file:/"+ rutaDB; // 'file:/' para win y 'file:' para linux
        Class.forName("org.sqlite.JDBC").newInstance();
        return DriverManager.getConnection(base);
        }catch (Exception e){
            return null;
        }
    }
    
}
