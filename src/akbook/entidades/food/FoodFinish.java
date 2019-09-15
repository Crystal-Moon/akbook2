/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
 */
package akbook.entidades.food;

import akbook.entidades.base.Conexion;
import akbook.entidades.base.Item;
import akbook.entidades.complementarias.game.Money;
import static akbook.entidades.complementarias.game.Calidad.green;
import akbook.entidades.complementarias.app.Ruta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author crystal
 */
public class FoodFinish extends Item {

    private Ingrediente ingPrincipal;
    private int cantIngPrincipal;
    private FoodBase base;
    private Money costoCocina;
    private Ingrediente ing2;
    private int cantIng2;
    private FoodBase base2;
    private int cantBase2;

    @Override
    public String getNombre() {
        if (this.nombre[0].equals("")) {
            return this.getBase().getNombre();
        } else {
            return this.nombre[0];
        }
    }

    @Override
    public StringProperty getNombreProperty() {
        String name = this.nombre[0];
        if (name.equals("")) {
            name = this.getBase().getNombre();
        } else {
            name = this.nombre[0];
        }
        StringProperty nameP = new SimpleStringProperty(name);
        return nameP;
    }

    public String getNombreGreen() { return nombre[0] + nombre[1]; }
    public String getNombreOrange() { return nombre[0] + nombre[2]; }
    public String getNombrePurple() { return nombre[0] + nombre[3]; }
    public String getNombreGold() { return nombre[0] + nombre[4]; }

    public Ingrediente getIngPrincipal() { return ingPrincipal; }
    public FoodBase getBase() { return base; }
    public Money getCostoCocina() { return costoCocina; }
    public Ingrediente getIng2() { return ing2; }
    public FoodBase getBase2() { return base2; }
    public int getCantIngPrincipal() { return cantIngPrincipal; }
    public int getCantIng2() { return cantIng2; }
    public int getCantBase2() { return cantBase2; }

    public FoodFinish() {}

    public static ArrayList traerFoodFinish(int lvl) throws SQLException, Exception {
try{
        Connection laConexion = null;
        Statement stmtConsulta = null;
        ResultSet rs = null;
        ArrayList<FoodFinish> foods = new ArrayList();

        laConexion = Conexion.getConnection();      
        String laConsulta = "SELECT id, nombre, lvl, "
                + "name_green, name_orange, name_purple, name_golden, "
                + "ip, c_ip, base, i2, c_i2 ,b2, c_b2, "
                + "g, s, archivo FROM food_finish WHERE lvl>=" + lvl + " order by lvl;";
        System.out.println(laConsulta);
        stmtConsulta = laConexion.createStatement();
        rs = stmtConsulta.executeQuery(laConsulta);

        while (rs.next()) {
            FoodFinish comidaFinal = new FoodFinish();
            comidaFinal.id_base = rs.getInt("id");
            comidaFinal.nombre[0] = rs.getString("nombre");
            comidaFinal.nombre[1] = rs.getString("name_green");
            comidaFinal.nombre[2] = rs.getString("name_orange");
            comidaFinal.nombre[3] = rs.getString("name_purple");
            comidaFinal.nombre[4] = rs.getString("name_golden");
            comidaFinal.lvl = rs.getInt("lvl");
            comidaFinal.ingPrincipal = Ingrediente.traerIngrediente(rs.getInt("ip"), laConexion);
            comidaFinal.cantIngPrincipal = rs.getInt("c_ip");
            comidaFinal.base = FoodBase.traerFoodBase(rs.getInt("base"), laConexion);
            comidaFinal.ing2 = Ingrediente.traerIngrediente(rs.getInt("i2"), laConexion);
            comidaFinal.cantIng2 = rs.getInt("c_i2");
            comidaFinal.base2 = FoodBase.traerFoodBase(rs.getInt("b2"), laConexion);
            comidaFinal.cantBase2 = rs.getInt("c_b2");
            comidaFinal.costoCocina = new Money(rs.getInt("g"), rs.getInt("s"));
            comidaFinal.archivo = Ruta.foods.getRuta() + rs.getString("archivo");
            comidaFinal.colorBorde = green;
            foods.add(comidaFinal);
        }
        rs.close();
        stmtConsulta.close();
        laConexion.close();

        return foods;
}catch(Exception e){
    System.out.println(" error en la clase Food Finish" + e);
    return null;
}
        
    }
}
