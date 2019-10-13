/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
*/
package akbook.layout.controller;

import akbook.entidades.base.CtrlPrincipal;
import akbook.entidades.complementarias.game.Origen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Perla
 */
public class MapController extends CtrlPrincipal implements Initializable {

    @FXML
    private ImageView imgMap1;
    @FXML
    private ImageView imgMap2;
    @FXML
    private ImageView imgMap3;
    @FXML
    private ImageView imgMap4;
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private Tab tab4;

    private static Origen ubicacionElegida;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tab1.setDisable(true);
        tab2.setDisable(true);
        tab3.setDisable(true);
        tab4.setDisable(true);
 
        imgMap1.setImage(new Image(getClass().getResourceAsStream(ubicacionElegida.getArchivoMapa1())));
        tab1.setText(ubicacionElegida.getNameMap1());
        tab1.setDisable(false);
       
        if (ubicacionElegida.map2Exist()) {
            imgMap2.setImage(new Image(getClass().getResourceAsStream(ubicacionElegida.getArchivoMapa2())));
            tab2.setText(ubicacionElegida.getNameMap2());
            tab2.setDisable(false);
        }
        if (ubicacionElegida.map3Exist()) {
            imgMap3.setImage(new Image(getClass().getResourceAsStream(ubicacionElegida.getArchivoMapa3())));
            tab3.setText(ubicacionElegida.getNameMap3());
            tab3.setDisable(false);
        }
        if (ubicacionElegida.map4Exist()) {
            imgMap4.setImage(new Image(getClass().getResourceAsStream(ubicacionElegida.getArchivoMapa4())));
            tab4.setText(ubicacionElegida.getNameMap4());
            tab4.setDisable(false);
        }
    }

    public static void setarUbicacion(Origen ubi) {
        ubicacionElegida = ubi;
    }

}
