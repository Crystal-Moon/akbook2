/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.refinacion;

import akbook.entidades.base.Item;
import akbook.entidades.complementarias.app.Ruta;
import akbook.entidades.complementarias.app.Value;
import static akbook.entidades.complementarias.game.Calidad.orange;
import java.io.IOException;

/**
 *
 * @author Perla
 */
public class Receta extends Item{
    Value dung;
    
    public Value getDung(){
        return this.dung;
    }
    
    public Receta(){}
    public Receta(int id, String name, int lvl) throws IOException{
        this.id_base=id;
        this.nombre[0]=name+" - Lvl: "+lvl;
        this.lvl=lvl;
        this.archivo=Ruta.nucleos.getRuta()+"receta.jpg";
        this.colorBorde=orange;
        this.dung=Value.buscarUbicacion("receta.txt", id);
    }
}
