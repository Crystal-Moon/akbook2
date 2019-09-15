/* 
    Created on : 25/07/2018, 21:03:11
    Author     : crystal
*/
package akbook.entidades.base;

import akbook.start.AKRun;

/**
 *
 * @author Perla
 */
public abstract class CtrlPrincipal {
    
    protected static AKRun main; //static por una falla en el handlerHelp de HerreriaController, lo miuestra como null :/
    
    protected static CtrlPrincipal ctrlBook; //setear aqui el controller de BookController q es el principal de casi todo (quizas con el main alcance)
    protected static CtrlPrincipal ctrlOther; //setear aqui cada nuevo controller q se carga para acceder a el facil desde la clase
    
    public void setMain(AKRun windows){
        this.main=windows;
    } 
    
    
    public static void setControllerBook(CtrlPrincipal book){
        CtrlPrincipal.ctrlBook=book;
    }
    
    public static void setControllerOther(CtrlPrincipal controller){
        CtrlPrincipal.ctrlOther=controller;
    }
    
    
}
