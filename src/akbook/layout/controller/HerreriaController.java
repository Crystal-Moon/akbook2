/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.layout.controller;

import akbook.entidades.base.CtrlPrincipal;
import akbook.entidades.base.ErrorAK;
import akbook.entidades.base.Item;
import akbook.entidades.complementarias.app.Ruta;
import akbook.entidades.complementarias.game.Origen;
import akbook.entidades.complementarias.app.Value;
import akbook.entidades.complementarias.game.Calidad;
import static akbook.entidades.complementarias.game.Calidad.orange;
import akbook.entidades.refinacion.Equipamiento;
import akbook.entidades.refinacion.Mineral;
import akbook.entidades.refinacion.Nucleo;
import akbook.entidades.refinacion.Receta;
import akbook.entidades.refinacion.SemiFacturado;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringJoiner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Perla
 */
public class HerreriaController extends CtrlPrincipal implements Initializable {

    @FXML
    private ImageView item1;
    @FXML
    private ImageView item2;
    @FXML
    private ImageView item3;
    @FXML
    private ImageView item4;
    @FXML
    private ImageView item5;
    @FXML
    private VBox bordeItem1;
    @FXML
    private VBox bordeItem2;
    @FXML
    private VBox bordeItem3;
    @FXML
    private VBox bordeItem4;
    @FXML
    private VBox bordeItem5;
    @FXML
    private ImageView arrow0;
    @FXML
    private ImageView arrow1;
    @FXML
    private ImageView arrow2;
    @FXML
    private ImageView arrow3;
    @FXML
    private ImageView arrow4;
    @FXML
    private Label nombreItem;
    @FXML
    private Label lblNvlItem;
    @FXML
    private Label lblStats;
    @FXML
    private Label lblSetCompleto;
    @FXML
    private ImageView imgNucleo;
    @FXML
    private ImageView imgBase;   
    @FXML
    private ImageView imgReceta;
    @FXML
    private ImageView imgNucleoDer;
    @FXML
    private ImageView imgAleacionNucleo;
    @FXML
    private ImageView imgM1Nucleo;
    @FXML
    private ImageView imgM2Nucleo;
    @FXML
    private ImageView imgM3Nucleo;
    @FXML
    private Label cAleacion;
    @FXML
    private Label lblCM1nucleo;
    @FXML
    private Label lblCM2nucleo;
    @FXML
    private Label lblCM3nucleo;
    @FXML
    private ImageView imgSF;
    @FXML
    private ImageView imgM1SF;
    @FXML
    private ImageView imgM2SF;
    @FXML
    private ImageView imgM3SF;
    @FXML
    private Label lblCM1SF;
    @FXML
    private Label lblCM2SF;
    @FXML
    private Label lblCM3SF;
    @FXML
    private Label lblParte;
    @FXML
    private ImageView imgDetalles;
    @FXML
    private Label nombreDetalles;
    @FXML
    private AnchorPane anchorInfo;
    @FXML
    private Label lblInfo;
    @FXML
    private AnchorPane anchorMineral;
    @FXML
    private Label lblEntidad1;
    @FXML
    private Tab tabEnt1;
    @FXML
    private ImageView imgEntidad1;
    @FXML
    private Tab tabEnt2;
    @FXML
    private Label lblEntidad2;
    @FXML
    private ImageView imgEntidad2;
    @FXML
    private Tab tabEnt3;
    @FXML
    private Label lblEntidad3;
    @FXML
    private ImageView imgEntidad3;
    @FXML
    private Tab tabEnt4;
    @FXML
    private Label lblEntidad4;
    @FXML
    private ImageView imgEntidad4;
    @FXML
    private Button btnEnt1;
    @FXML
    private Button btnEnt2;
    @FXML
    private Button btnEnt3;
    @FXML
    private Button btnEnt4;
    @FXML
    private Label lblBooleanComerciante;
    
    private static Equipamiento equipoDerecha;
    private static Equipamiento equipo0;
    private static Equipamiento equipo1;
    private static Equipamiento equipo2;
    private static Equipamiento equipo3;
    private static Equipamiento equipo4;
    private static Mineral mineralEntidad;
    private final ArrayList<ImageView> arrows = new ArrayList();
    @FXML
    private Button btnSet;
    @FXML
    private VBox bordeReceta;
    @FXML
    private VBox bordeNucleo;
    @FXML
    private VBox bordeBase;
    @FXML
    private VBox bordeNucleoDer;
    @FXML
    private VBox bordeAleacionNucleo;
    @FXML
    private VBox bordeM1Nucleo;
    @FXML
    private VBox bordeM2Nucleo;
    @FXML
    private VBox bordeM3Nucleo;
    @FXML
    private VBox bordeSF;
    @FXML
    private VBox bordeM1SF;
    @FXML
    private VBox bordeM2SF;
    @FXML
    private VBox bordeM3SF;
    @FXML
    private VBox bordeDetalles;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     /*   
        tabEnt1.setDisable(true);
        tabEnt2.setDisable(true);
        tabEnt3.setDisable(true);       //toda esta parte ya esta eb clearDer()
        tabEnt4.setDisable(true);
        lblBooleanComerciante.setVisible(false);
        
      */
        clearAll();
        cargarItem(equipo0, 0);
        
    }

    @FXML
    private void handlerBtnSet(ActionEvent event) {
        ArrayList<Equipamiento> setCompleto = new ArrayList();
        int idSet = equipo0.getSet();
        String parteElegida = equipo0.getParte();
        
        if(idSet!=0){
            try {
                setCompleto = Equipamiento.traerSet(idSet, parteElegida);
                equipo1 = setCompleto.get(0);
                equipo2 =(setCompleto.size()>1)? setCompleto.get(1):null;
                equipo3 =(setCompleto.size()>2)? setCompleto.get(2):null;
                equipo4 =(setCompleto.size()>3)? setCompleto.get(3):null;

                cargarIconosSet();
                                
                Value statSetCompleto=Value.buscarStat("stats-sets.txt", idSet);
               // StringJoiner statSet =new StringJoiner("");
               /* for (String atributo : statSetCompleto.atributo) {
                //statSet = statSet + "\n" + atributo;
                statSet.add(atributo+"\n");
                }  */ 
               // lblSetCompleto.setText(statSet.toString());
                lblSetCompleto.setText(String.join("\n", statSetCompleto.atributo));
                
            } catch (SQLException ex) {
            ErrorAK.errorBaseDatos(ex);
            } catch (IOException ex) {
            ErrorAK.errorTxt("stats-sets",ex);
            } catch (Exception ex) {
            ErrorAK.errorGenerico(ex);
            }
            
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText("");
            alert.setContentText("Este articulo no posee algun set conocido");
            alert.showAndWait();
        }
    }


    @FXML
    private void handlerBtnUbicacion(ActionEvent event) {
        Button btnUbi=(Button) event.getSource();
        Origen origen= new Origen();
        ArrayList<Origen> entidades= mineralEntidad.todaUbicacion();
        if(btnUbi.equals(btnEnt1)){
            origen=entidades.get(0);
            MapController.setarUbicacion(origen);
        }else if(btnUbi.equals(btnEnt2)){
            origen=entidades.get(1);
            MapController.setarUbicacion(origen);
        }else if(btnUbi.equals(btnEnt3)){
            origen=entidades.get(2);
            MapController.setarUbicacion(origen);
        }else if(btnUbi.equals(btnEnt4)){
            origen=entidades.get(3);
            MapController.setarUbicacion(origen);
        }
        super.main.ventanaInterna("map.fxml");
    }

    public static void setEquipo0(Equipamiento equipo) {
        HerreriaController.equipo0 = equipo;
    }

    private void cambiarStacke(AnchorPane pane) {
        anchorInfo.setVisible(false);
        anchorMineral.setVisible(false);
        pane.setVisible(true);
    }

    private void cargarItem(Equipamiento equipo, int arrow) {
        clearDer();
        if (equipo!=null) {
            Image imgItem1 = new Image(getClass().getResourceAsStream(equipo0.getArchivo()));
            this.item1.setImage(imgItem1);
            this.bordeItem1.setStyle(equipo0.getColorBorde().getStyle());
            equipoDerecha=equipo;
    //panel Izquierdo            
            this.nombreItem.setText(equipo.getNombre());
            this.nombreItem.setId(equipo.getColorBorde().name());
            this.lblParte.setText(equipo.getParte());
            this.lblNvlItem.setText("Nivel "+equipo.getLvl()+" o superior.");
            verArrow(arrow);
            
            Value status = equipo.getStat();
           // StringJoiner stat = new StringJoiner("");
         /*   for (String atributo : status.atributo) {
                //stat = stat + atributo+"\n" ;
                stat.add(atributo+"\n");  
            }*/
            lblStats.setText(String.join("\n", status.atributo));
            if(equipo.getSet()!=0){
                btnSet.setDisable(false);
            }else{
                btnSet.setDisable(true);
            }
            
            /*              /// esta parte est aen el boton buscar set
            Value statSetCompleto=null;
            try{
                statSetCompleto=Value.buscarStat("sets-stats.txt", equipo.getSet());
                } catch (IOException ex) {
                ErrorAK.errorTxt("statsSets",ex);
                }
            StringJoiner statSet =new StringJoiner("");
            for (String atributo : statSetCompleto.atributo) {
                //statSet = statSet + "\n" + atributo;
                statSet.add(atributo);
            }   
            lblSetCompleto.setText(statSet.toString());
            */
            
            if(equipo.isRefinado()){
                Equipamiento thisBase=equipo.getBase();
                Nucleo thisNucleo=equipo.getNucleo();
                SemiFacturado thisSf=equipo.getNucleo().getAleacion();
                
                Image receta = new Image(
                        getClass().getResourceAsStream(Ruta.nucleos.getRuta()+"receta.jpg"));
                this.imgReceta.setImage(receta);
                this.bordeReceta.setStyle(Calidad.orange.getStyle());
                
                Image nucleo = new Image(
                        getClass().getResourceAsStream(thisNucleo.getArchivo()));
                this.imgNucleo.setImage(nucleo);
                this.bordeNucleo.setStyle(thisNucleo.getColorBorde().getStyle());
                
                Image base = new Image(
                        getClass().getResourceAsStream(thisBase.getArchivo()));
                this.imgBase.setImage(base);  
                this.bordeBase.setStyle(thisBase.getColorBorde().getStyle());
    //panel Derecho
        //--Nucleo
                Image nucleoDer = new Image(
                        getClass().getResourceAsStream(thisNucleo.getArchivo()));
                this.imgNucleoDer.setImage(nucleoDer);
                this.bordeNucleoDer.setStyle(thisNucleo.getColorBorde().getStyle());
                
                Image aleacion = new Image(
                        getClass().getResourceAsStream(thisSf.getArchivo()));
                this.imgAleacionNucleo.setImage(aleacion);
                this.bordeAleacionNucleo.setStyle(thisSf.getColorBorde().getStyle());
                
                Image nM1 = new Image(
                        getClass().getResourceAsStream(thisNucleo.getMineral1().getArchivo()));
                this.imgM1Nucleo.setImage(nM1);
                this.bordeM1Nucleo.setStyle(equipo.getNucleo().getMineral1().getColorBorde().getStyle());
                
              if(thisNucleo.getMineral2()!=null) { 
                Image nM2 = new Image(
                        getClass().getResourceAsStream(thisNucleo.getMineral2().getArchivo()));
                this.imgM2Nucleo.setImage(nM2);
                this.bordeM2Nucleo.setStyle(thisNucleo.getMineral2().getColorBorde().getStyle());
              }
              if(thisNucleo.getMineral3()!=null){
                Image nM3 = new Image(
                        getClass().getResourceAsStream(thisNucleo.getMineral3().getArchivo()));
                this.imgM3Nucleo.setImage(nM3);
                this.bordeM3Nucleo.setStyle(thisNucleo.getMineral3().getColorBorde().getStyle());
              }
              
                this.cAleacion.setText(String.valueOf(equipo.getNucleo().getCantAleacion()));
                this.lblCM1nucleo.setText((thisNucleo.getCantM1()!=0)?String.valueOf(thisNucleo.getCantM1()):"");
                this.lblCM2nucleo.setText((thisNucleo.getCantM2()!=0)?String.valueOf(thisNucleo.getCantM2()):"");
                this.lblCM3nucleo.setText((thisNucleo.getCantM3()!=0)?String.valueOf(thisNucleo.getCantM3()):"");
            
          //-- Aleacion semifacturada
                Image sf = new Image(
                        getClass().getResourceAsStream(thisSf.getArchivo()));
                this.imgSF.setImage(sf);
                this.bordeSF.setStyle(thisSf.getColorBorde().getStyle());
                
                Image sfM1 = new Image(
                        getClass().getResourceAsStream(thisSf.getMineral1().getArchivo()));
                this.imgM1SF.setImage(sfM1);
                this.bordeM1SF.setStyle(thisSf.getMineral1().getColorBorde().getStyle());
                
              if(thisSf.getMineral2()!=null){  
                Image sfM2 = new Image(
                        getClass().getResourceAsStream(thisSf.getMineral2().getArchivo()));
                this.imgM2SF.setImage(sfM2);
                this.bordeM2SF.setStyle(equipo.getNucleo().getAleacion().getMineral2().getColorBorde().getStyle());
              }
              if(thisSf.getMineral3()!=null){
                Image sfM3 = new Image(
                        getClass().getResourceAsStream(thisSf.getMineral3().getArchivo()));
                this.imgM3SF.setImage(sfM3);
                this.bordeM3SF.setStyle(thisSf.getMineral3().getColorBorde().getStyle());
              }

                this.lblCM1SF.setText((thisSf.getCantM1()!=0)?String.valueOf(thisSf.getCantM1()):"");
                this.lblCM2SF.setText((thisSf.getCantM2()!=0)?String.valueOf(thisSf.getCantM2()):"");
                this.lblCM3SF.setText((thisSf.getCantM3()!=0)?String.valueOf(thisSf.getCantM3()):"");  
                
                handlerReceta(null);
            } else{
                clearDer();
                cambiarStacke(anchorInfo);
                setAnchorInfo(equipoDerecha.getDung());
            }
        } else {
            clearAll();
        }
    }

    private void verArrow(int index) {
        arrows.forEach((arrow) -> {
            arrow.setVisible(false);
        });
        arrows.get(index).setVisible(true);
    }

    private void cargarIconosSet() {
        try {
            if(equipo1!=null){
                Image set1 = new Image(getClass().getResourceAsStream(equipo1.getArchivo()));
                item2.setImage(set1);
                bordeItem2.setStyle(equipo1.getColorBorde().getStyle());
            } else bordeItem2.setStyle("");
            
            if(equipo2!=null){
                Image set2 = new Image(getClass().getResourceAsStream(equipo2.getArchivo()));
                item3.setImage(set2);
                bordeItem3.setStyle(equipo2.getColorBorde().getStyle());
            } else bordeItem3.setStyle("");
            
            if(equipo3!=null){
                Image set3 = new Image(getClass().getResourceAsStream(equipo3.getArchivo()));
                item4.setImage(set3);
                bordeItem4.setStyle(equipo3.getColorBorde().getStyle());
            } else bordeItem4.setStyle("");
            
            if(equipo4!=null){
                Image set4 = new Image(getClass().getResourceAsStream(equipo4.getArchivo()));
                item5.setImage(set4);
                bordeItem5.setStyle(equipo4.getColorBorde().getStyle());
            } else bordeItem5.setStyle("");
            
        } catch (NullPointerException ex) {          
            ErrorAK.errorGenerico(ex);
        }
    }

    private void clearAll() {

        clearIzq();
        clearDer();
        arrows.add(0, arrow0);
        arrows.add(1, arrow1);
        arrows.add(2, arrow2);
        arrows.add(3, arrow3);
        arrows.add(4, arrow4);
        
        arrows.forEach((arrow) -> {
            arrow.setVisible(false);
        });
    }
    
    private void clearIzq(){
        ArrayList<ImageView> images = new ArrayList();
        images.add(item1);
        images.add(item2);
        images.add(item3);
        images.add(item4);
        images.add(item5);
        
        images.forEach((img) -> {
            img.setImage(null);
            img.setStyle("");
        });
        
        ArrayList<VBox> bordes = new ArrayList();
        bordes.add(bordeItem1);
        bordes.add(bordeItem2);
        bordes.add(bordeItem3);
        bordes.add(bordeItem4);
        bordes.add(bordeItem5);
        
        bordes.forEach((img) -> {
            img.setStyle("");
        });
         
        ArrayList<Label> labels = new ArrayList();
        labels.add(nombreItem);
        labels.add(lblParte);
        labels.add(lblNvlItem);
        labels.add(lblStats);
        labels.add(lblSetCompleto);
        
        labels.forEach((lbl) -> {
            lbl.setText("");
        });
    }
    
    private void clearDer(){
        ArrayList<ImageView> images = new ArrayList();
        images.add(imgReceta);
        images.add(imgNucleo);
        images.add(imgBase);
        images.add(imgNucleoDer);
        images.add(imgAleacionNucleo);
        images.add(imgM1Nucleo);
        images.add(imgM2Nucleo);
        images.add(imgM3Nucleo);
        images.add(imgSF);
        images.add(imgM1SF);
        images.add(imgM2SF);
        images.add(imgM3SF);
        images.add(imgDetalles);
        images.add(imgEntidad1);
        images.add(imgEntidad2);
        images.add(imgEntidad3);
        images.add(imgEntidad4);
        
        images.forEach((img) -> {
            img.setImage(null);
            img.setStyle("");
        });
        
        ArrayList<VBox> bordes = new ArrayList();
        bordes.add(bordeReceta);
        bordes.add(bordeNucleo);
        bordes.add(bordeBase);
        bordes.add(bordeNucleoDer);
        bordes.add(bordeAleacionNucleo);
        bordes.add(bordeM1Nucleo);
        bordes.add(bordeM2Nucleo);
        bordes.add(bordeM3Nucleo);
        bordes.add(bordeSF);
        bordes.add(bordeM1SF);
        bordes.add(bordeM2SF);
        bordes.add(bordeM3SF);
        bordes.add(bordeDetalles);

        
        bordes.forEach((img) -> {
            img.setStyle("");
        });
        
        ArrayList<Label> labels = new ArrayList();
        labels.add(cAleacion);
        labels.add(lblCM1nucleo);
        labels.add(lblCM2nucleo);
        labels.add(lblCM3nucleo);
        labels.add(lblCM1SF);
        labels.add(lblCM2SF);
        labels.add(lblCM3SF);
        labels.add(nombreDetalles);
        labels.add(lblInfo);
        labels.add(lblEntidad1);
        labels.add(lblEntidad2);
        labels.add(lblEntidad3);
        labels.add(lblEntidad4);
        lblBooleanComerciante.setVisible(false);
        
        labels.forEach((lbl) -> {
            lbl.setText("");
        });
        
        tabEnt1.setDisable(true);
        tabEnt2.setDisable(true);
        tabEnt3.setDisable(true);
        tabEnt4.setDisable(true);
        tabEnt1.getTabPane().getSelectionModel().select(tabEnt1);
        
    }
    
    @FXML
    private void handlerNucleo(MouseEvent event) {
        if(equipoDerecha.isRefinado()){
        cambiarStacke(anchorInfo);
        setearDetalles(equipoDerecha.getNucleo());        
        setAnchorInfo(equipoDerecha.getNucleo().getPrefijos());
        }
    }

    @FXML
    private void handlerBase(MouseEvent event) {
        if(equipoDerecha.isRefinado()){
            Equipamiento base=new Equipamiento();
            base=equipoDerecha.getBase();
            cambiarStacke(anchorInfo);
            setearDetalles(base);
            Value ubicaciones=base.getDung();
            setAnchorInfo(ubicaciones);
        }
    }

    @FXML
    private void handlerItem(MouseEvent event) {
        ImageView click=(ImageView) event.getSource();
        if(click.equals(item1)){
            cargarItem(equipo0, 0);
        }else if(click.equals(item2)){
            cargarItem(equipo1, 1);
        }else if(click.equals(item3)){
            cargarItem(equipo2, 2);
        }else if(click.equals(item4)){
            cargarItem(equipo3, 3);
        }else if(click.equals(item5)){
            cargarItem(equipo4, 4);
        }
    }

    @FXML
    private void handlerMineral(MouseEvent event) { 
  
        tabEnt1.setDisable(true);
        tabEnt2.setDisable(true);
        tabEnt3.setDisable(true);
        tabEnt4.setDisable(true);
        tabEnt1.getTabPane().getSelectionModel().select(tabEnt1);
        
        ImageView click=(ImageView) event.getSource();
        Mineral mineral=new Mineral();
        
        if(click.equals(imgM1Nucleo)){
            mineral=equipoDerecha.getNucleo().getMineral1();
            mineralEntidad=mineral;
        } else if(click.equals(imgM2Nucleo)){
            mineral=equipoDerecha.getNucleo().getMineral2();
            mineralEntidad=mineral;
        }else if(click.equals(imgM3Nucleo)){
            mineral=equipoDerecha.getNucleo().getMineral3();
            mineralEntidad=mineral;
        }else if(click.equals(imgM1SF)){
            mineral=equipoDerecha.getNucleo().getAleacion().getMineral1();
            mineralEntidad=mineral;
        }else if(click.equals(imgM2SF)){
            mineral=equipoDerecha.getNucleo().getAleacion().getMineral2();
            mineralEntidad=mineral;
        }else if(click.equals(imgM3SF)){
            mineral=equipoDerecha.getNucleo().getAleacion().getMineral3();
            mineralEntidad=mineral;
        }
        
        setearDetalles(mineral);
        lblBooleanComerciante.setVisible(mineral.haveComerciante());
        
        if(mineral.isRare()){
            cambiarStacke(anchorInfo);  
            Value ubicaciones=mineral.getDung();
            setAnchorInfo(ubicaciones);
        }else{
            cambiarStacke(anchorMineral);
            ArrayList<Origen> entidades=mineral.todaUbicacion();
         //   if(entidades.size()>2){
                tabEnt1.setDisable(false);
                lblEntidad1.setText(entidades.get(0).getNombreObj());
                imgEntidad1.setImage(new Image(getClass().getResourceAsStream(entidades.get(0).getFileObjeto())));
          /*  }else {
                tabEnt1.setDisable(true);*/
           // }
            if(entidades.size()>=2){
                tabEnt2.setDisable(false);
                lblEntidad2.setText(entidades.get(1).getNombreObj());
                imgEntidad2.setImage(new Image(getClass().getResourceAsStream(entidades.get(1).getFileObjeto())));
            }/*else {
                tabEnt2.setDisable(true);
            }*/
            if(entidades.size()>=3){
                tabEnt3.setDisable(false);
                lblEntidad3.setText(entidades.get(2).getNombreObj());
                imgEntidad3.setImage(new Image(getClass().getResourceAsStream(entidades.get(2).getFileObjeto())));
            }/*else {
                tabEnt3.setDisable(true);
            }*/
            if(entidades.size()==4){
                tabEnt4.setDisable(false);
                lblEntidad4.setText(entidades.get(3).getNombreObj());
                imgEntidad4.setImage(new Image(getClass().getResourceAsStream(entidades.get(3).getFileObjeto())));
            }/*else {
                tabEnt4.setDisable(true);
            }*/
        }
    }

    private void setearDetalles(Item item) {       
        Image detalle=new Image(getClass().getResourceAsStream(item.getArchivo()));
        imgDetalles.setImage(detalle);
        bordeDetalles.setStyle(item.getColorBorde().getStyle());
        nombreDetalles.setText(item.getNombre());
        nombreDetalles.setId(item.getColorBorde().name());
        lblBooleanComerciante.setVisible(false);
    }
 
    private void setAnchorInfo(Value value){
      /*  String dungs = "";
            for (String ubicacion : value.atributo) {
                dungs = dungs + "\n" + ubicacion;
                lblInfo.setText(dungs);
            }*/
           lblInfo.setText(String.join("\n", value.atributo));
    }

    @FXML
    private void handlerHelp(MouseEvent event) {
        super.main.ventanaInterna("help.fxml");
    }

    @FXML
    private void handlerReceta(MouseEvent event) {
        if(equipoDerecha.isRefinado()){
        cambiarStacke(anchorInfo);       
        Receta receta=equipoDerecha.getReceta();
        setearDetalles(receta);
       
        setAnchorInfo(receta.getDung());      
        }
    }
}
