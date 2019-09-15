/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
*/
package akbook.entidades.complementarias.game;

import akbook.entidades.complementarias.app.Ruta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Perla
 */
/*
Ubicacion de cada item recolectable.
Son entidades que existen en distintos mapas.
*/
public class Origen {
    
   // private int id_base;
    private String nombre;
    private String mapa1;
    private String mapa2;
    private String mapa3;
    private String mapa4;
    private String fileObjeto;

    public String getNombreObj() { return nombre; }
    public String getFileObjeto(){ return fileObjeto; }
    
    public String getNameMap1(){ return this.mapa1; }
    public String getArchivoMapa1(){ return Ruta.maps.getRuta()+this.mapa1+"-"+this.nombre+".jpg"; }
    
    public String getNameMap2(){ return this.mapa2; }
    public String getArchivoMapa2(){ return Ruta.maps.getRuta()+this.mapa2+"-"+this.nombre+".jpg"; }
    
    public String getNameMap3(){ return this.mapa3; }
    public String getArchivoMapa3(){ return Ruta.maps.getRuta()+this.mapa3+"-"+this.nombre+".jpg"; }
    
    public String getNameMap4(){ return this.mapa4; }
    public String getArchivoMapa4(){ return Ruta.maps.getRuta()+this.mapa4+"-"+this.nombre+".jpg"; }
    
    public boolean map2Exist(){
        return this.mapa2!=null;
    }
    public boolean map3Exist(){
        return this.mapa3!=null;
    }
    public boolean map4Exist(){
        return this.mapa4!=null;
    }
    
    
    public Origen() {}
    
//------- DAO ---------
    public static Origen traerOrigen(int id, Connection conn) throws SQLException{
       /*
        id - identificador unico en la db
        conn - conexion compartida entre toda la busqueda
        */
    Statement stmtConsulta=null;
    ResultSet rs = null;
    Origen elOrigen=new Origen();
     
    String laConsulta = "SELECT id, nombre, "
            + " mapa1, mapa2, mapa3, mapa4, archivo "
            + "FROM origen WHERE id="+id+";";
    stmtConsulta = conn.createStatement(); 
    rs = stmtConsulta.executeQuery(laConsulta); 
        
    while(rs.next()){
        //elOrigen.id_base=rs.getInt("id");
   // System.out.println(rs.getInt("id"));
        elOrigen.nombre=rs.getString("nombre");
   //  System.out.println(rs.getString("mapa1"));
      //  if(!rs.getString("mapa1").equalsIgnoreCase("")) 
            elOrigen.mapa1=Mapas.valueOf(rs.getString("mapa1")).getNombre();
  //   System.out.println(rs.getString("mapa2"));
        if(rs.getString("mapa2")!=null) elOrigen.mapa2=Mapas.valueOf(rs.getString("mapa2")).getNombre();
  //   System.out.println(rs.getString("mapa3"));
        if(rs.getString("mapa3")!=null) elOrigen.mapa3=Mapas.valueOf(rs.getString("mapa3")).getNombre();
  //   System.out.println(rs.getString("mapa4"));
        if(rs.getString("mapa4")!=null) elOrigen.mapa4=Mapas.valueOf(rs.getString("mapa4")).getNombre();
        elOrigen.fileObjeto=Ruta.fonts.getRuta()+rs.getString("archivo");
    }
    rs.close();
    stmtConsulta.close();
       
    return elOrigen;
    }
}
