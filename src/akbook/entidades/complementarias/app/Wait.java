/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.complementarias.app;

import akbook.entidades.base.CtrlPrincipal;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Perla
 */
public class Wait implements Runnable{

    private Stage stage;
   // private Thread t;

    public Wait() {
    }

    @Override
    public void run() {

        
        stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        Image img = new Image(getClass().getResourceAsStream("/akbook/layout/frames/loading.gif"));
        ImageView gif = new ImageView(img);
        //  this.textArea = new TextArea();
        // this.textArea.setPrefSize(800, 300);
        // this.textArea.setEditable(false);
        AnchorPane root = new AnchorPane();
        root.getChildren().add(gif);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //stage.setAlwaysOnTop(true);
        stage.show();

    }

    public void setControl() {
        this.stage.close();
    }
}
