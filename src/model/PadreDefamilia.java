/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.image.Image;

/**
 *
 * @author jesus
 */
public class PadreDefamilia extends Usuario implements java.io.Serializable{
    
    public PadreDefamilia(String nommbreUsuario, int codigoUsuario, Image foto) {
        super(nommbreUsuario, codigoUsuario, foto);
    }
     
}
