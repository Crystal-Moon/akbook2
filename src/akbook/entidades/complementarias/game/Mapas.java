/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akbook.entidades.complementarias.game;

/**
 *
 * @author Perla
 */
public enum Mapas {
    
    Abadia("Abadia de la casa"),
    navea("Navea"),
    helonia("Costa de Helonia"),
    creciente("Colina Creciente"),
    arbkra("Arboleda Katakara"),
    mina("Mina del Prodigio"),
    candeo("Cienaga Candeo"),
    juicio("Altiplano del Juicio"),
    vendaval("Praderas Vendaval"),
    olvido("Bosque del Olvido"),
    astral("Desierto Astral"),
    amanita("Floresta Amanita"),
    aguasverdes("Humedal Aguasverdes"),
    meteoro("Meseta Meteoro"),
    tundra("Tundra Silenciosa"),
    morton("Morton"),
    coleus("Colina Coleus"),
    esmeralda("Praderas Esmeralda"),
    desolacion("Valle de la Desolacion"),
    cascadas("Selva de Cascadas"),
    cazacol("Valle Cazacol"),
    perpetuo("Bosque Perpetuo"),
    tempestuoso("Desierto Tempestuoso"),
    frigga("Montañas Frigga"),
    desolate("Desierto Desolado"),
    forest("Secret Forest Lake"),
    drowsy("Drowsy Cave"),
    gloomy("Gloomy Ridge"),
    hidden("Hidden Valley");
    
    String nombre;
    
    public String getNombre(){ return nombre; }
    
    Mapas(String name){
        this.nombre=name;
    }
}
