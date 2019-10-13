/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
*/
package akbook.layout.controller;

import akbook.entidades.base.CtrlPrincipal;
import akbook.entidades.base.ErrorAK;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Perla
 */
public class HelpController extends CtrlPrincipal implements Initializable {

    @FXML
    private Label lblHelp; 
    @FXML
    private Hyperlink database;
    @FXML
    private Hyperlink overfly;
    @FXML
    private Hyperlink puertoSkandia;
    @FXML
    private Hyperlink consejos;
    @FXML
    private Hyperlink pageOficial;
    @FXML
    private Label lblAutor;
    @FXML
    private Hyperlink linkAutor;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblHelp.setText("Aura Kingdom - Recipe's Book\n\n" +
        "Seccion 'Buscar' - 'Alimentos'\n" +
        "Seleccione todos los status que desee encontrar. Precione el boton 'Buscar' para visualizar una lista de todos los resultados que contengan los atributos seleccionados.\n" +
        "Seleccione cualquier item de la tabla para ver detalles de la preparacion en la seccion 'Cocina'.\n" +
        "El boton 'Ubicacion' desplegara una mini ventana con el/los mapas donde se encuentra dicho ingrediente. Esta ventana se mantiene superpuesta aun dentro del juego.\n"+
        "\n" +
        "Seccion 'Buscar' - 'Mineria'\n" +
        "Seleccione el nivel y el tipo de equipamiento a buscar. Seleccione cualquier item de la lista para ver mas detalles en la seccion 'Herreria'.\n" +
        "\n" +
        "Seccion 'Cocina'\n" +
        "Haga click en cualquiera de los items para ver detalles como ubicacion de los ingredientes, ubicacion de los NPC y detalles de los status otorgados por el alimento resultante.\n" +
        "\n" +
        "Seccion 'Herreria'\n" +
        "Puede hacer click en cualquier item para ver mas detalles en el cuadro inferior derecho, como localización o detalles generales.\n"+
        "Presione el boton 'Set' para buscar y mostrar todos los items que correspondan asi como tambien los beneficios de equipar el set completo. Haga click en cada item del set para ver detalles de cada uno.\n"+
        "El boton 'Ubicacion' desplegara una mini ventana con el/los mapas donde se encuentra dicho mineral. Esta ventana se mantiene superpuesta aun dentro del juego.\n"+
        "\n");
        lblHelp.setFocusTraversable(true); //hacer foco en el primer label
        lblAutor.setText("Aura Kingdom Recipe's Book ©2018\nCreated by CrystalMoon.");
        
        overfly.setOnAction((ActionEvent e) -> {    
            try {
                Desktop.getDesktop().browse(new URI("http://overflyx.com/"));
            } catch (IOException | URISyntaxException ex) {
                ErrorAK.errorDeRed(ex);
            }
        });
    
        database.setOnAction((ActionEvent e) -> {    
            try {
                Desktop.getDesktop().browse(new URI("http://www.aurakingdom-db.com/"));
            } catch (IOException | URISyntaxException ex) {
                ErrorAK.errorDeRed(ex);
            }
        });
        
        puertoSkandia.setOnAction((ActionEvent e) -> {    
            try {
                Desktop.getDesktop().browse(new URI("http://es.portskandia.com/"));
            } catch (IOException | URISyntaxException ex) {
                ErrorAK.errorDeRed(ex);
            }
        });
        
        consejos.setOnAction((ActionEvent e) -> {
            try {
                Desktop.getDesktop().browse(new URI("https://sites.google.com/site/aurakingdomguia/"));
            } catch (IOException | URISyntaxException ex) {
                ErrorAK.errorDeRed(ex);
            }
        });
        
        pageOficial.setOnAction((ActionEvent e) -> {
            try {
                Desktop.getDesktop().browse(new URI("https://es.aurakingdom.aeriagames.com/"));
            } catch (IOException | URISyntaxException ex) {
                ErrorAK.errorDeRed(ex);
            }
        });
        
        linkAutor.setOnAction((ActionEvent e) -> {    
            try {
                Desktop.getDesktop().browse(new URI("http://www.linkedin.com/in/perla-stto"));
            } catch (IOException | URISyntaxException ex) {
                ErrorAK.errorDeRed(ex);
            }
        });
    }    

}
