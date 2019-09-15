/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.complementarias.game;

import java.util.ArrayList;

/**
 *
 * @author Perla
 */
public enum EnumsEquipo {
    
    Arma,Accesorio,Armadura;
    
    public static enum Arma{
        Arco,Baculo,Canon,Dagas_Gemelas,Espada_y_Escudo,
        Grimorio,Guadana,Hacha,Katana,Katar,Lira,Lanza,Mandoble,Pistolas,Shuriken;  
    }   
    
    public static enum Accesorio{
        Anillo,Collar,Espalda,Botin;
        
        public static ArrayList<String> namesToString(){
            Accesorio[] values=Accesorio.class.getEnumConstants();
            ArrayList<String> names=new ArrayList<>();
            for (Accesorio x : values) {
                names.add(x.name());
            }
            return names;
        }
    }
    
    public static enum Armadura{
        Cabeza,Cuerpo,Cintura,Manos,Pies;
        
        public static ArrayList<String> namesToString(){
            Armadura[] values=Armadura.class.getEnumConstants();
            ArrayList<String> names=new ArrayList<>();
            for (Armadura x : values) {
                names.add(x.name());
            }
            return names;
        }
    }
    
}
