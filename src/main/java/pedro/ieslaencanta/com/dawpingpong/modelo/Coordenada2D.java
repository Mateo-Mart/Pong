/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawpingpong.modelo;

/**
 *
 * @author Pedro
 * @author Mateo
 */
public class Coordenada2D {

    private int x;
    private int y;

    public Coordenada2D() {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * 
     * @param inc Este parametro es el valor que se incrementa a la X
     */
    public void incX(int inc){
        x+=inc;
    }
    /**
     * 
     * @param inc Este parametro es el valor que se decrementa a la X
     */
    public void decX(int inc){
        x-=inc;
    }
    /**
     * 
     * @param inc Este parametro es el valor que se incrementa a la Y
     */
    public void decY(int inc){
        y-=inc;
    }
    /**
     * 
     * @param inc Este parametro es el valor que se decrementa a la Y
     */
    public void incY(int inc){
        y+=inc;
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

}
