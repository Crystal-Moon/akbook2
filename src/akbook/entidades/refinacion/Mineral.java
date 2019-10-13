/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.refinacion;

import akbook.entidades.base.Item;
import akbook.entidades.complementarias.game.Origen;
import akbook.entidades.complementarias.app.Ruta;
import akbook.entidades.complementarias.app.Value;
import akbook.entidades.complementarias.game.Calidad;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Perla
 */
public class Mineral extends Item {
    
    private final ArrayList<Origen> entidades;
    private Value dung;
    private boolean comerciante;
    private boolean raro;
    
    public ArrayList todaUbicacion() { return this.entidades; }
    public Value getDung(){ return dung; }
    public boolean haveComerciante(){ return this.comerciante; }
    public boolean isRare(){ return this.raro; }
    
    public Mineral() {this.entidades = new ArrayList<>();
}
    
    public static Mineral traerMineral(int id, Connection conn) throws SQLException, IOException{
       
        Statement stmtConsulta=null;
        ResultSet rs = null;
        Mineral mineral=new Mineral();
    
        String laConsulta = "SELECT id, nombre, lvl, calidad, npc, raro, "
                + "e1, e2, e3, e4, archivo "
                + "FROM minerales WHERE id="+id+";";
        stmtConsulta = conn.createStatement(); 
        rs = stmtConsulta.executeQuery(laConsulta); 
        
        while(rs.next()){ 
            mineral.id_base=rs.getInt("id");
            mineral.nombre[0]=rs.getString("nombre");
            mineral.lvl=rs.getInt("lvl");
            mineral.comerciante=Boolean.parseBoolean(rs.getString("npc"));
            mineral.raro=Boolean.parseBoolean(rs.getString("raro"));
            if(mineral.raro){
                mineral.dung=Value.buscarUbicacion("minerales-dung.txt", rs.getInt("id"));
            }else{
            for(int x=1; x<=4; x++){
                int idUbi=rs.getInt("e"+x);
                if(idUbi!=0){
                    Origen origen=Origen.traerOrigen(idUbi, conn);
                    mineral.entidades.add(origen);
                }
            }
            }
            
            mineral.colorBorde=Calidad.valueOf(rs.getString("calidad"));
            mineral.archivo=Ruta.minerales.getRuta()+rs.getString("archivo");
        }
        rs.close();
        stmtConsulta.close();
        
        return mineral;
    }
}