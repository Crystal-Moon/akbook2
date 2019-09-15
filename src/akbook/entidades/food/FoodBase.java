/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
 */
package akbook.entidades.food;

import akbook.entidades.base.Item;
import akbook.entidades.complementarias.game.NPC;
import akbook.entidades.complementarias.game.Money;
import static akbook.entidades.complementarias.game.Calidad.white;
import akbook.entidades.complementarias.app.Ruta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author crystal
 */
/*

*/
public class FoodBase extends Item {

    private NPC npcVendedor;
    private Money costoCompra;

    public NPC getNpcVendedor() { return npcVendedor; }
    public Money getCostoCompra() { return costoCompra; }

    public FoodBase() {}

//------- DAO ---------
    public static FoodBase traerFoodBase(int id, Connection conn) throws SQLException {
        /*
        id - identificador unico en la db
        conn - conexion compartida entre toda la busqueda
        */
        Statement stmtConsulta = null;
        ResultSet rs = null;
        FoodBase comidaBase = new FoodBase();

        String laConsulta = "SELECT id, nombre, lvl, npc, "
                + "g, s, archivo FROM food_base WHERE id=" + id + ";";
        stmtConsulta = conn.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            comidaBase.id_base = rs.getInt("id");
            comidaBase.nombre[0] = rs.getString("nombre");
            comidaBase.lvl = rs.getInt("lvl");
            comidaBase.npcVendedor = NPC.traerNpc(rs.getInt("npc"), conn);
            comidaBase.costoCompra = new Money(rs.getInt("g"), rs.getInt("s"));
            comidaBase.archivo = Ruta.foods.getRuta() + rs.getString("archivo");
            comidaBase.colorBorde = white;
        }

        rs.close();
        stmtConsulta.close();
        
        return comidaBase;
    }
}
