/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.refinacion;

import akbook.entidades.base.Item;
import static akbook.entidades.complementarias.game.Calidad.orange;
import akbook.entidades.complementarias.app.Ruta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Perla
 */
public class SemiFacturado extends Item{
    
    private Mineral mineral1;
    private int cantM1;
    private Mineral mineral2;
    private int cantM2;
    private Mineral mineral3;
    private int cantM3;

    public Mineral getMineral1() { return mineral1; }
    public int getCantM1() { return cantM1; }
    public Mineral getMineral2() { return mineral2; }
    public int getCantM2() { return cantM2; }
    public Mineral getMineral3() { return mineral3; }
    public int getCantM3() { return cantM3; }

    public SemiFacturado() {}
    
    public static SemiFacturado traerAleacion(int id, Connection conn) throws SQLException, IOException{
        /*
        id - identificador unico en la db
        conn - conexion compartida entre toda la busqueda
        */
        Statement stmtConsulta = null;
        ResultSet rs = null;
        SemiFacturado aleacion=new SemiFacturado();

        String laConsulta = "SELECT id, nombre, lvl, "
                +"m1, c_m1, m2, c_m2, m3, c_m3, archivo "
                +"FROM semifacturado WHERE id=" + id + ";";
        stmtConsulta = conn.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            
            aleacion.id_base = rs.getInt("id");
            aleacion.nombre[0] = rs.getString("nombre");
            aleacion.lvl= rs.getInt("lvl");
            
            aleacion.cantM1=rs.getInt("c_m1");
            if(aleacion.cantM1!=0) aleacion.mineral1=Mineral.traerMineral(rs.getInt("m1"),conn);
            aleacion.cantM2=rs.getInt("c_m2");
            if(aleacion.cantM2!=0) aleacion.mineral2=Mineral.traerMineral(rs.getInt("m2"),conn);
            aleacion.cantM3=rs.getInt("c_m3");
            if(aleacion.cantM3!=0) aleacion.mineral3=Mineral.traerMineral(rs.getInt("m3"),conn);
            
            aleacion.archivo=Ruta.nucleos.getRuta()+rs.getString("archivo");
            aleacion.colorBorde=orange;
        }
        rs.close();
        stmtConsulta.close();
        
        return aleacion;
    } 
}
