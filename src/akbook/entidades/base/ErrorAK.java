
package akbook.entidades.base;

import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Perla
 */
/*
Clase controladora de errores en tiempo de ejecucion.
 */
public abstract class ErrorAK extends Exception{
    
    //SQLExceptions
    public static void errorBaseDatos(SQLException ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al conectar");
        alert.setContentText("No se ha podido conectar el banco de datos. "
                + "Revise la ruta de ejecucion del programa.\n"
                + "Una correcta reinstalacion solucionaria el problema"
                +"\n"+ex.getSQLState()+"\n"+ex.getMessage());
        alert.showAndWait();
    }
    //IOExceptions
    public static void errorTxt(String txt, IOException ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No se encontro el archivo");
        alert.setContentText("No se ha podido encontrar el archivo '"+txt+"'. "
                + "Revise la ruta de ejecucion del programa.\n"
                + "Una correcta reinstalacion solucionaria el problema"
                +"\n"+ex.getMessage());
        alert.showAndWait();
    }
    //Exceptions
    public static void errorGenerico(Exception ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No se encontro el archivo");
        alert.setContentText("Se ha producido un error indeterminado.\nDetalles: "
                +ex.getMessage());
        alert.showAndWait();
    }
    //IOException | URISyntaxException
    public static void errorDeRed(Exception ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("No se ha podido encontrar la URL especificada o "
                + "bien revise su coneccion a internet."+ex.getMessage());
        alert.showAndWait();
    }
    
}
