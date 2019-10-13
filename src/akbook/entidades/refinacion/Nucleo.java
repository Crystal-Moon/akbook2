/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.refinacion;

import akbook.entidades.base.Item;
import static akbook.entidades.complementarias.game.Calidad.orange;
import akbook.entidades.complementarias.app.Ruta;
import akbook.entidades.complementarias.app.Value;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Perla
 */
public class Nucleo extends Item{
    
    private SemiFacturado aleacion;
    private int cantAleacion;
    private Mineral mineral1;
    private int cantM1;
    private Mineral mineral2;
    private int cantM2;
    private Mineral mineral3;
    private int cantM3;
    private Value prefijos;
    
    public SemiFacturado getAleacion() { return aleacion; }
    public int getCantAleacion() { return cantAleacion; }
    public Mineral getMineral1() { return mineral1; }
    public int getCantM1() { return cantM1; }
    public Mineral getMineral2() { return mineral2; }
    public int getCantM2() { return cantM2; }
    public Mineral getMineral3() { return mineral3; }
    public int getCantM3() { return cantM3; }
    public Value getPrefijos(){ return this.prefijos; }
    
    public Nucleo() {}
    
    public static Nucleo traerNucleo(int id, Connection conn) throws SQLException, IOException{
 
        Statement stmtConsulta = null;
        ResultSet rs = null;
        Nucleo nucleo=new Nucleo();

        String laConsulta = "SELECT id, nombre, lvl, pre, "
                + "sf, c_sf, m1, c_m1, m2, c_m2, m3, c_m3, "
                + "archivo FROM nucleos WHERE id=" + id + ";";
        stmtConsulta = conn.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            
            nucleo.id_base = rs.getInt("id");
            nucleo.nombre[0] = rs.getString("nombre");
            nucleo.lvl = rs.getInt("lvl");
            nucleo.aleacion=SemiFacturado.traerAleacion(rs.getInt("sf"),conn);
            nucleo.cantAleacion=rs.getInt("c_sf");
            
            nucleo.cantM1=rs.getInt("c_m1");
            if(nucleo.cantM1!=0) nucleo.mineral1=Mineral.traerMineral(rs.getInt("m1"),conn);
            nucleo.cantM2=rs.getInt("c_m2");
            if(nucleo.cantM2!=0) nucleo.mineral2=Mineral.traerMineral(rs.getInt("m2"),conn);
            nucleo.cantM3=rs.getInt("c_m3");
            if(nucleo.cantM3!=0) nucleo.mineral3=Mineral.traerMineral(rs.getInt("m3"),conn);
            
            nucleo.prefijos=Value.buscarStat("prefijos-nucleo.txt", rs.getInt("pre"));
            nucleo.archivo=Ruta.nucleos.getRuta()+rs.getString("archivo");
            nucleo.colorBorde=orange;
        }
        rs.close();
        stmtConsulta.close();
        
        return nucleo;
    } 
}
