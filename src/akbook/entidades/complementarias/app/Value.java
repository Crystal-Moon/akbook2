/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
 */
package akbook.entidades.complementarias.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author crystal
 */
/*
Manejo de archivos .txt, lectura y recopilacion de datos.
*/
public class Value {

    public String[] atributo;

    public Value() {
    }

    public static Value buscarStat(String txt, int id) throws IOException {
       
        Value elStat = new Value();
        InputStream input = Value.class.getResourceAsStream(Ruta.text.getRuta() + txt);
        BufferedReader buffTxt = null;

        Reader reader = new InputStreamReader(input,StandardCharsets.UTF_8);
        boolean hash = true;
        buffTxt = new BufferedReader(reader);
        while (hash) {
            String linea = buffTxt.readLine().trim();
            if (linea.equalsIgnoreCase("")) hash=false;
            else if (linea.startsWith(String.valueOf(id))) {
             //   linea = buffTxt.readLine();
                elStat.atributo = linea.split("#");
                for (int x = 0; x < elStat.atributo.length-1; x++) {
                    elStat.atributo[x]=elStat.atributo[x+1];
                }
                elStat.atributo[elStat.atributo.length-1]="";
                hash = false;
            }
        }
        buffTxt.close();
        
        return elStat;
    }
    
    public static Value buscarUbicacion(String txt, int id) throws IOException{
        
        //revisar todo
        Value ubicacion = new Value();
        InputStream input = Value.class.getResourceAsStream(Ruta.text.getRuta() + txt);
       

        Reader reader = new InputStreamReader(input,StandardCharsets.UTF_8);
        boolean hash = true;
        BufferedReader buffTxt = new BufferedReader(reader);
        while (hash) {
            String linea = buffTxt.readLine().trim();
            if (linea.equalsIgnoreCase("")) hash=false;
            else if (linea.startsWith(String.valueOf(id))) {
             //   linea = buffTxt.readLine();
                ubicacion.atributo = linea.split("#");
                for (int x = 0; x < ubicacion.atributo.length-1; x++) {
                    ubicacion.atributo[x]=ubicacion.atributo[x+1];
                }
                ubicacion.atributo[ubicacion.atributo.length-1]="";
                hash = false;
            }
        }
        buffTxt.close();
        
        return ubicacion;
    }
  
}
