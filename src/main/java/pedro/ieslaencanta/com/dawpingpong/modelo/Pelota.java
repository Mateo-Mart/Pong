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
public class Pelota {

    private float x;
    private float y;
    private float angulo =180;//(int) (Math.random()*360);
    private float velocidad = 0.1f;
    private int radio = 20;

    public Pelota() {
        this.x = 0;
        this.y = 0; //new Coordenada2D();
    
    }

    public Pelota(Coordenada2D posicion, int radio) {
        this.x = posicion.getX();
        this.y = posicion.getY();
        this.radio = radio;
     }

    public void mover() {
        float x = (float) ((float) getVelocidad() * Math.cos(Math.toRadians(getAngulo())));
        float y = (float) ((float) getVelocidad() * Math.sin(Math.toRadians(getAngulo())));
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
     
    }

    

    /**
     * @return the angulo
     */
    public float getAngulo() {
        return angulo;
    }

    /**
     * @param angulo the angulo to set
     */
    public void setAngulo(float angulo) {
        
        this.angulo = angulo;
         if (this.angulo > 360) {
            this.angulo=this.angulo%360;
        }else{
            if(this.angulo <0){
                this.angulo+=360;
            }
        }
       

    }
    /**
     * 
     * @param angulo Se le pasa por parámetro el ángulo que queremos añadir
     */
    public void addAngulo(float angulo) {
        this.angulo += angulo;
       
    }

    /**
     * @return the radio
     */
    public int getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(int radio) {
        this.radio = radio;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the velocidad
     */
    public float getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

}
