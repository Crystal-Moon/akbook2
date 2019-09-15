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
        String base="";
        try{
        /* esto esta sin probar aun */
       // File database=new File(Conexion.class.getResource("/akbook/recursos/database/data1").toString());
        InputStream data =Conexion.class.getResourceAsStream("/akbook/recursos/database/data1");
       //  System.out.println( "ruta de ejecucion "+Conexion.class.getProtectionDomain().getCodeSource().getLocation());
         String rutaa=Conexion.class.getProtectionDomain().getCodeSource().getLocation().toString();
         File archivoDB= new File("aurakingdom.db");//new File("aurakingdom1.db");
         
         long fileSizeInBytes = archivoDB.length();
// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
long fileSizeInKB = fileSizeInBytes / 1024;
// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
long fileSizeInMB = fileSizeInKB / 1024;

      //      System.out.println("tamano del archivo .... "+fileSizeInBytes);
         String rutaDB=archivoDB.getAbsolutePath().replaceAll(" ", "%20");
      //   System.out.println( "el archivo esta en ....   "+ rutaDB);
       //     System.out.println("lo q hay q lograr es ... "+"jdbc:sqlite::resource:"+Conexion.class.getResource("/akbook/recursos/database/data1"));
         
         
         //base = "jdbc:sqlite::resource:"+ Conexion.class.getProtectionDomain().getCodeSource().getLocation()+ "/recursos/database/aurakingdom.db";
         base = "jdbc:sqlite::resource:file:/"+ rutaDB; // 'file:/' para win y 'file:' para linux
        //esto parece funci0onar bien por ahora, sol ahay q modificar las consultas en cada clase para probar
     //   System.out.println(base);
        
        Class.forName("org.sqlite.JDBC").newInstance();
        return DriverManager.getConnection(base);
        
        }catch (Exception e){
            System.out.println("erro en conexxion "+e.getMessage());
            return null;
        }
       /* URL resource = ClassLoader.getResource("resource.ext");
File file = new File(resource.toURI());
FileInputStream input = new FileInputStream(file);

Path temp = Files.createTempFile("resource-", ".ext");
Files.copy(ClassLoader.getResourceAsStream("resource.ext"), temp, StandardCopyOption.REPLACE_EXISTING);
FileInputStream input = new FileInputStream(temp.toFile());
*/

        
        //System.out.println( "otra opcion ... "+Conexion.class.getClass().getProtectionDomain().getCodeSource().getLocation());
        /*----------------------------------------*/
        
        
        
        //String base = "jdbc:sqlite::resource:"+Conexion.class.getResource("/akbook/recursos/database/data1");     
        /*
        Class.forName("org.sqlite.JDBC").newInstance();
        return DriverManager.getConnection(base);
*/
    }
    
}
