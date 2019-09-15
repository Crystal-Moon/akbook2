/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.refinacion;

import akbook.entidades.base.Conexion;
import akbook.entidades.base.Item;
import akbook.entidades.complementarias.game.Calidad;
import akbook.entidades.complementarias.game.EnumsEquipo.Accesorio;
import akbook.entidades.complementarias.game.EnumsEquipo.Armadura;
import akbook.entidades.complementarias.app.Ruta;
import akbook.entidades.complementarias.app.Value;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Perla
 */
public class Equipamiento extends Item {
    
    private String parte;
    private int setId;
    private Value stat;
    private Value dung;
    private Equipamiento base;
    private Nucleo nucleo;
    private boolean refinado;
    private Receta receta;

    public String getParte() { return parte; }
    public Value getDung() { return dung; }
    public int getSet() { return setId; }
    public Value getStat() { return stat; }
    public Equipamiento getBase() { return base; }
    public Nucleo getNucleo() { return nucleo;  }
    public boolean isRefinado(){ return this.refinado; }
    public Receta getReceta(){ return this.receta; }
    
    public StringProperty getColorProperty(){
        String clr=this.colorBorde.name();
        StringProperty color=new SimpleStringProperty(clr);     
        return color;
    }
    
    public Equipamiento() {}
    
    public static ArrayList traerTodoEquipo(int lvl, String tabla) throws SQLException, Exception {

        Connection conn = null;
        Statement stmtConsulta = null;
        ResultSet rs = null;
        ArrayList<Item> equipos = new ArrayList();

        conn = Conexion.getConnection();      
        String laConsulta = "SELECT id, nombre, lvl, calidad, set_id, refinado, receta, nucleo, base, archivo "
                + "FROM "+tabla+" WHERE lvl=" + lvl + ";";
        stmtConsulta = conn.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            Equipamiento elEquipo = new Equipamiento();
            elEquipo.id_base = rs.getInt("id");
            elEquipo.nombre[0] = rs.getString("nombre");
            elEquipo.lvl = lvl;
            elEquipo.colorBorde=Calidad.valueOf(rs.getString("calidad"));
            elEquipo.parte=tabla;
            elEquipo.setId=rs.getInt("set_id");
            elEquipo.stat=Value.buscarStat(tabla+"-stats.txt", rs.getInt("id"));
            elEquipo.dung=Value.buscarUbicacion(tabla+"-dung.txt", rs.getInt("id"));
            elEquipo.archivo = Ruta.equipo.getRuta()+tabla+"/"+rs.getString("archivo");
            elEquipo.refinado=Boolean.parseBoolean(rs.getString("refinado"));
            elEquipo.receta=(rs.getInt("receta")!=0)? new Receta(rs.getInt("receta"), elEquipo.nombre[0], lvl) : null;
            if(elEquipo.refinado){
                elEquipo.nucleo=Nucleo.traerNucleo(rs.getInt("nucleo"), conn);
                elEquipo.base=Equipamiento.traerEquipamientoDropeable(rs.getInt("base"), tabla, conn);
            }
            System.out.println("id: "+elEquipo.id_base+"nombre: "+elEquipo.nombre[0]+"lvl: "+elEquipo.lvl+"parte: "+elEquipo.parte+"setID: "+elEquipo.setId
                    +"stat: "+elEquipo.stat.atributo[0]+"dung: "+elEquipo.dung.atributo[0]+"archivo: "+elEquipo.archivo+"rafinado: "
                    +elEquipo.refinado+"receta: "+elEquipo.receta);
            equipos.add(elEquipo);
        }
        rs.close();
        stmtConsulta.close();
        conn.close();

        return equipos;
    }
    
    /*
    public static ArrayList traerTodoEquipo(int lvl, String tabla) throws SQLException, Exception {

        Connection laConexion = null;
        Statement stmtConsulta = null;
        ResultSet rs = null;
        ArrayList<Item> equipos = new ArrayList();

        laConexion = Conexion.getConnection();      
        String laConsulta = "SELECT id, nombre, lvl, calidad "
                + "FROM "+tabla+" WHERE lvl=" + lvl + ";";
        stmtConsulta = laConexion.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            Equipamiento elEquipo = new Equipamiento();
            elEquipo.id_base = rs.getInt("id");
            elEquipo.nombre[0] = rs.getString("nombre");
            elEquipo.lvl = rs.getInt("lvl_requerido");
            elEquipo.colorBorde=Calidad.valueOf(rs.getString("calidad"));
            equipos.add(elEquipo);
        }
        rs.close();
        stmtConsulta.close();
        laConexion.close();

        return equipos;
    }
    
    public static Equipamiento traerEquipamientoRefinado(int id, String tabla) throws SQLException, IOException, Exception{
        
        Connection laConexion = null;
        Statement stmtConsulta = null;
        ResultSet rs = null;
        Equipamiento equipo = new Equipamiento();

        laConexion = Conexion.getConnection();
        String laConsulta = "SELECT id, nombre, lvl, "
                + "nucleo, base, set, calidad, archivo "
                + "FROM "+tabla+" WHERE id=" + id + ";";
        stmtConsulta = laConexion.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            equipo.id_base = rs.getInt("id");
            equipo.nombre[0] = rs.getString("nombre");
            equipo.lvl = rs.getInt("lvl");
            equipo.parte=tabla;
            equipo.set_id=rs.getInt("set");
            equipo.nucleo=Nucleo.traerNucleo(rs.getInt("nucleo"), laConexion);
            equipo.base=Equipamiento.traerEquipamientoDropeable(rs.getInt("base"), tabla);
            equipo.colorBorde=Calidad.valueOf(rs.getString("calidad"));
            equipo.stat=Value.buscarStat("archivo de txt", rs.getInt("id"));
            equipo.archivo = Ruta.equipo.getRuta()+tabla+"/"+rs.getString("archivo");
            equipo.refinado=true;
        }
        rs.close();
        stmtConsulta.close();
        laConexion.close();
        
        return equipo;
    }
    */
    
    
    public static Equipamiento traerEquipamientoDropeable(int id, String tabla, Connection conn) throws SQLException, IOException, Exception{
        
        //Connection laConexion = null;
        Statement stmtConsulta = null;
        ResultSet rs = null;
        Equipamiento equipo = new Equipamiento();

        //laConexion = Conexion.getConnection();
        String laConsulta = "SELECT id, nombre, lvl, "
                + "set_id, calidad, archivo "
                + "FROM "+tabla+" WHERE id=" + id + ";";
        stmtConsulta = conn.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            equipo.id_base = rs.getInt("id");
            equipo.nombre[0] = rs.getString("nombre");
            equipo.lvl = rs.getInt("lvl");
            equipo.parte=tabla;
            equipo.setId=rs.getInt("set_id");
            equipo.colorBorde=Calidad.valueOf(rs.getString("calidad"));
            equipo.stat=Value.buscarStat(tabla+"-stats.txt", rs.getInt("id"));
            equipo.archivo = Ruta.equipo.getRuta()+tabla+"/"+rs.getString("archivo");
            equipo.dung=Value.buscarUbicacion(tabla+"-dung.txt", rs.getInt("id"));
            equipo.refinado=false;
        }
        rs.close();
        stmtConsulta.close();
       // laConexion.close();
        
        return equipo;
    }
    
    public static ArrayList traerSet(int idSet, String parte) throws SQLException, Exception{
        
        Connection laConexion = Conexion.getConnection();
        ArrayList<Equipamiento> setCompleto = new ArrayList();
        
        ArrayList listElegida = new ArrayList();
        ArrayList<String> armadura =Armadura.namesToString();
        ArrayList<String> acc =Accesorio.namesToString();
        
        
        /*Armadura arm1[]= Armadura.values();
        armadura=(ArrayList)Arrays.asList(arm1);
        Accesorio acc1[] = Accesorio.values();
        acc=(ArrayList)Arrays.asList(acc1);
        /*
        for (Accesorio item : Accesorio.values()) { acc.add(item.name()); }
        for (Armadura item : Armadura.values()) { armadura.add(item.name()); }
        */
        if(armadura.contains(parte)){
            listElegida=armadura; 
            listElegida.remove(parte);
        }
        if(acc.contains(parte)){ 
            listElegida=acc; 
            listElegida.remove(parte);
        }
        
      
        //listElegida.remove(parte);
        
        for(int x=0;x<listElegida.size();x++){
            String tabla=(String) listElegida.get(x);
            Statement stmtConsulta = laConexion.createStatement();
            String laConsulta = "SELECT id, nombre, lvl, calidad, set_id, refinado, receta, nucleo, base, archivo "
                + "FROM "+ tabla +" WHERE set_id=" + idSet + ";";
            ResultSet rs = stmtConsulta.executeQuery(laConsulta);

            while (rs.next()) {
                Equipamiento equipo = new Equipamiento();
                equipo.id_base = rs.getInt("id");
                equipo.nombre[0] = rs.getString("nombre");
                equipo.lvl = rs.getInt("lvl");
                equipo.colorBorde=Calidad.valueOf(rs.getString("calidad"));
                equipo.parte=tabla;
                equipo.stat=Value.buscarStat(tabla+"-stats.txt", rs.getInt("id"));
                equipo.dung=Value.buscarUbicacion(tabla+"-dung.txt", rs.getInt("id"));
                equipo.archivo = Ruta.equipo.getRuta()+tabla+"/"+rs.getString("archivo");
                equipo.refinado=Boolean.parseBoolean(rs.getString("refinado"));
                equipo.receta=(rs.getInt("receta")!=0)? new Receta(rs.getInt("receta"), equipo.nombre[0], equipo.lvl) : null;
            //    equipo.receta=rs.getBoolean("receta");
                if(equipo.refinado){
                    equipo.nucleo=Nucleo.traerNucleo(rs.getInt("nucleo"), laConexion);
                    equipo.base=Equipamiento.traerEquipamientoDropeable(rs.getInt("base"), tabla, laConexion);
                }
                setCompleto.add(equipo);
            }
            rs.close();
            stmtConsulta.close();
        }
        laConexion.close();

        return setCompleto;
    }
    
}
