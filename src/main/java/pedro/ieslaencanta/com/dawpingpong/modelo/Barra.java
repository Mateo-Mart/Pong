/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawpingpong.modelo;

import javax.swing.text.Position;

/**
 *
 * @author Pedro
 * @author Mateo
 */
public class Barra {
    private Coordenada2D posicion;
    private int ancho;
    private int alto;
  
    private int incremento=1;
    public Barra(){
        this.posicion= new Coordenada2D();
        
       
      
    }
    public Barra(Coordenada2D posicion,int ancho, int alto){
        this.posicion= posicion;
      
        this.ancho=ancho;
       
        this.alto=alto;
       
    }  
    
    public void moverArriba(){
        this.posicion.decY(incremento);
    }

    public void moverAbajo(){
        this.posicion.incY(incremento);
    }

    /**
     * @return the posicion
     */
    public Coordenada2D getPosicion() {
        return posicion;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }
   
    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(Coordenada2D posicion) {
        this.posicion = posicion;
    }
    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }    
}

