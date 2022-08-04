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
public class Campo {

    private static int width, height;
    private Barra barraizquierda, barraderecha;
    private Pelota pelota;
    private int borde = 10;
    private int marcador1, marcador2;

    public Campo(int anchopixels, int altopixels) {
        this.width = anchopixels;
        this.height = altopixels;
        this.pelota = new Pelota(new Coordenada2D(anchopixels / 2 - borde, altopixels / 2 - borde), 20);
        this.barraderecha = new Barra(new Coordenada2D(anchopixels - borde * 6, altopixels / 2 - 50), borde*2, height/4);
        this.barraizquierda = new Barra(new Coordenada2D(borde * 4, altopixels / 2 - 50), borde*2, height/4);
    }

    private void initPelota() {
        this.pelota.setX(width / 2.5f);
        this.pelota.setY(height / 2);
        //testeando rebote barra arriba
        this.pelota.setY(borde);
        this.pelota.setAngulo(145);
    }

    /**
     *
     * @return colision barra derecha
     */
    public boolean detectarColisionBarraDerecha() {
        boolean colision = false;
        //System.out.println( " BOLA DEBAJO DE PARTE DE ARRIBA DE BARRA ==TRUE "+this.barraderecha.getPosicion().getY()+" < "+((int)this.pelota.getY() + (int)this.pelota.getRadio()) +" "+ ( this.barraderecha.getPosicion().getY() < (int) this.pelota.getY() + (int) this.pelota.getRadio()));
        //System.out.println( " BOLA ENCIMA DE PARTE DE ABAJO DE BARRA == TRUE "+(this.barraderecha.getPosicion().getY()+ (int) this.barraderecha.getAlto())+" > "+((int)this.pelota.getY() +" "+ ( this.barraderecha.getPosicion().getY() + (int) this.barraderecha.getAlto() > (int) this.pelota.getY())));
        //System.out.println("PX "+(int) (this.pelota.getX()+this.pelota.getRadio())+" BX "+(this.barraderecha.getPosicion().getX()+(int) this.pelota.getX()) +" "+  (this.pelota.getRadio() == this.barraderecha.getPosicion().getX()));
        if ( (this.barraderecha.getPosicion().getX() -(int) (this.pelota.getX()+ (int)this.pelota.getRadio()))< (int)this.getVelocidad()
                && this.barraderecha.getPosicion().getY() < ((int) this.pelota.getY() + (int) this.pelota.getRadio())
                
                && (this.barraderecha.getPosicion().getY() + (int) this.barraderecha.getAlto()) > (int) this.pelota.getY()){ 

            colision = true;
        }
      
        return colision;
    }

/**
 * 
 * @return  int Devuelve 2 colision normal 1 colision por arriba 0 no colisión
 */
    public int detectarColisionBarraIzquierda() {
        int colision = 0;
        
        //System.out.println( "BIzY "+this.barraizquierda.getPosicion().getY()+ " BIzYMax "+ (this.barraizquierda.getPosicion().getY()+ (int)this.barraizquierda.getAlto())+ "  PY "+((int)this.pelota.getY() + (int)this.pelota.getRadio()));
        /*if ((this.barraizquierda.getPosicion().getY()-(int)this.pelota.getY())<(int)this.getVelocidad()
                && this.barraizquierda.getPosicion().getY() < (int) this.pelota.getY() + (int) this.pelota.getRadio()
                && this.barraizquierda.getPosicion().getY() + (int) this.barraizquierda.getAlto() > (int) this.pelota.getY()) {
            colision =1;
            
        }*/
        //PARTE DE ABAJO DE LA BOLA ESTÉ EN EL MISMO SITIO QUE LA PARTE DE ARIBA DE LA BARRA
        boolean comparacion1=((((int)this.pelota.getY()+(int)this.pelota.getRadio())==this.barraizquierda.getPosicion().getY()));
        //PARTE DERECHA DE LA BOLA A LA IZQUIERDA DE LA PARTE DERECHA DE LA BARRA || PARTE DE LA IZQUIERDA DE LA BOLA A LA IZQUIERDA DE PARTE DEERCHA DE LA BARRA
        boolean comparacion2= (((int)this.pelota.getX() + (int) this.pelota.getRadio())<= (this.barraizquierda.getPosicion().getX()+this.barraizquierda.getAncho())||((int)this.pelota.getX()<=(this.barraizquierda.getPosicion().getX()+this.barraizquierda.getAncho())));
        boolean comparacion3=(((int)this.pelota.getX()>(this.barraizquierda.getPosicion().getX()))||(((int)this.pelota.getX()+this.pelota.getRadio())>(this.barraizquierda.getPosicion().getX())));
        if (comparacion1==true&& comparacion2==true && comparacion3==true)
            //&& (this.barraizquierda.getPosicion().getY()-(int)this.pelota.getY())<(int)this.pelota.getRadio()
               {
            System.out.println(" Py+Pr==By "+comparacion1+"          Px+Pr<Bx+Bancho "+comparacion2+"            Px>Bx || Px+Pr>Bx "+comparacion3);
            System.out.println("resultado total = "+(comparacion1&&comparacion2 && comparacion3));
            colision =1;
            
        }else{
            //QUE REBOTE EN LA PARTE DERECHA DE LA BARRA
            if (((int)this.pelota.getX() - (this.barraizquierda.getPosicion().getX() + this.barraizquierda.getAncho()))< this.getVelocidad()
                && this.barraizquierda.getPosicion().getY() < (int) this.pelota.getY() + (int) this.pelota.getRadio()
                && this.barraizquierda.getPosicion().getY() + (int) this.barraizquierda.getAlto() > (int) this.pelota.getY()) {
            colision = 2;
        }
            System.out.println(" Py+Pr==By "+comparacion1+"          Px+Pr<Bx+Bancho "+comparacion2+"            Px>Bx || Px+Pr>Bx "+comparacion3);
        }
        return colision;
    }

    public void cambiarAnguloColisionBarraIzquierda() {
        if (this.detectarColisionBarraIzquierda()==2) {
            this.getPelota().setAngulo(180-this.getPelota().getAngulo());

        }
        if (this.detectarColisionBarraIzquierda()==1) {
            this.pelota.setAngulo(360 - this.pelota.getAngulo());

        }
        /*if (detectarColisionBarraIzquierda() == true){
            this.pelota.setAngulo(300);
        }*/
    }

    public void cambiarAnguloColisionBarraDerecha() {
        this.getPelota().setAngulo(180-this.getPelota().getAngulo());
    }

    public void moverPelota() {
        this.pelota.mover();
        //angulo -180 + 180
        if (this.pelota.getX() < this.pelota.getRadio() / 2) {
            
            setMarcador2(getMarcador2() + 1);
            System.out.println("Punto para el Jugador de la Derecha!" + " Jugador Izquierda " + getMarcador1() + " Jugador Derecha " + getMarcador2());
            this.initPelota();
            // ESTE ES GENIAL PARA HACER QUE UN AL REBOTAR EN LA DERECHA REBOTE BIEN this.pelota.setAngulo((180 - this.pelota.getAngulo()));
            this.pelota.setAngulo(( this.pelota.getAngulo()));
            /*DATOS ERRONEOS, PASAR DE ESTO
                    if (this.detectarColisionBarraIzquierda() == true) {
                /    this.pelota.setAngulo((360-this.pelota.getAngulo())+200);

                }*/
        }
        if (this.pelota.getX() > (width - borde * 2) - this.pelota.getRadio() / 2) {
            //ESTE ES GENIAL PARA HACER QUE AL REBOTAR EN LA IZQUIERD REBOTE BIEN this.pelota.setAngulo((180 - this.pelota.getAngulo()));
            /* DATOS ERRONEOS, PASAR DE ESTO
                if (this.detectarColisionBarraDerecha()== true) {
                   this.pelota.setAngulo((360-this.pelota.getAngulo())+200);
                }*/
            setMarcador1(getMarcador1() + 1);
            System.out.println("Punto para el Jugador de la Izquierda!" + " Jugador Izquierda " + getMarcador1() + " Jugador Derecha " + getMarcador2());
            this.initPelota();
            this.pelota.setAngulo((this.pelota.getAngulo()));

        }

        if (this.pelota.getY() > (height - borde * 2) - this.pelota.getRadio() / 2) {
            this.pelota.setAngulo(360 - this.pelota.getAngulo());

        }
        if (this.pelota.getY() < (borde * 2) - this.pelota.getRadio() / 2) {
            this.pelota.setAngulo(360 - this.pelota.getAngulo());

        }
    }

    public void moverBarraIzquierdaArriba() {
        this.barraizquierda.moverArriba();

        if (this.barraizquierda.getPosicion().getY() <= this.borde) {
            this.barraizquierda.getPosicion().setY(this.borde);
        }
    }

    public void moverBarraIzquierdaAbajo() {
        this.barraizquierda.moverAbajo();
        if (this.barraizquierda.getPosicion().getY() + this.barraizquierda.getAlto() >= this.height - borde) {
            this.barraizquierda.getPosicion().setY(this.height - borde - 100);
        }
    }

    public void moverBarraDerechaArriba() {
        this.barraderecha.moverArriba();
        if (this.barraderecha.getPosicion().getY() <= this.borde) {
            this.barraderecha.getPosicion().setY(this.borde);
        }
    }

    public void moverBarraDerechaAbajo() {
        this.barraderecha.moverAbajo();
        if (this.barraderecha.getPosicion().getY() + this.barraderecha.getAlto() >= this.height - borde) {
            this.barraderecha.getPosicion().setY(this.height - borde - 100);
        }
    }
    public void EfectoEspecial(){
    if (this.getMarcador2()>= 3) {
        this.pelota.setVelocidad(this.pelota.getVelocidad()+1);
        System.out.println("Velocidad Aumentada!");
    }}
    public void rotateX() {

    }

    /**
     *
     * @param velocidad Se pasa la velocidad nueva que se quiere que tenga la
     * pelota
     */
    public void setVelocidad(float velocidad) {
        this.pelota.setVelocidad(velocidad);
    }

    /**
     *
     * @return velocidad de pelota
     */
    public float getVelocidad() {
        return this.pelota.getVelocidad();
    }

    /**
     * @return the barraizquierda
     */
    public Barra getBarraizquierda() {
        return barraizquierda;
    }

    /**
     * @return the barraderecha
     */
    public Barra getBarraderecha() {
        return barraderecha;
    }

    /**
     * @return the pelota
     */
    public Pelota getPelota() {
        return pelota;
    }

    /**
     * @return the borde
     */
    public int getBorde() {
        return borde;
    }

    /**
     * @return the width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public static int getHeight() {
        return height;
    }

    /**
     * @param aWidth the width to set
     */
    public static void setWidth(int aWidth) {
        width = aWidth;
    }

    /**
     * @param aHeight the height to set
     */
    public static void setHeight(int aHeight) {
        height = aHeight;
    }

    /**
     * @param borde the borde to set
     */
    public void setBorde(int borde) {
        this.borde = borde;
    }

    /**
     * @param barraizquierda the barraizquierda to set
     */
    public void setBarraizquierda(Barra barraizquierda) {
        this.barraizquierda = barraizquierda;
    }

    /**
     * @param barraderecha the barraderecha to set
     */
    public void setBarraderecha(Barra barraderecha) {
        this.barraderecha = barraderecha;
    }

    /**
     * @return the marcador1
     */
    public int getMarcador1() {
        return marcador1;
    }

    /**
     * @param marcador1 the marcador1 to set
     */
    public void setMarcador1(int marcador1) {
        this.marcador1 = marcador1;
    }

    /**
     * @return the marcador2
     */
    public int getMarcador2() {
        return marcador2;
    }

    /**
     * @param marcador2 the marcador2 to set
     */
    public void setMarcador2(int marcador2) {
        this.marcador2 = marcador2;
    }
}
