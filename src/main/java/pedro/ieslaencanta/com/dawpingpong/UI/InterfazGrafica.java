/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawpingpong.UI;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import pedro.ieslaencanta.com.dawpingpong.modelo.Barra;
import pedro.ieslaencanta.com.dawpingpong.modelo.Campo;
import pedro.ieslaencanta.com.dawpingpong.modelo.Coordenada2D;

/**
 *
 * @author Pedro
 * @author Mateo
 */
public class InterfazGrafica extends Application {

    int ancho = 800, alto = 400;
    CanvasLayer canvas;
    Campo campo;
    long last = 0;
    boolean parado = false;
    //va a 24 fps
    long delta = 2800000;//(long) (10e9 / 30);
    //la velocidad de la pelota
    int duplicar_velocidad = 25;
    int contador_velocidad = 0;
    //izquier_arriba,izquierda_abajo,derecha_arriba,derecha_abajo
    boolean pulsados[];

    /**
     *
     * @param stage El campo de juego
     * @throws Exception Este es el throw
     */
    @Override
    public void start(Stage stage) throws Exception {
        this.canvas = new CanvasLayer(this.ancho, this.alto);
        this.campo = new Campo(ancho, alto);
        this.campo.setVelocidad(1.0f);
        this.canvas.setCampo(this.campo);
        this.pulsados = new boolean[4];
        Pane root = new Pane(this.canvas.getFondo(), this.canvas.getPrincipal());
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {

            if (e.getCode() == KeyCode.DOWN) {
                this.pulsados[3] = true;
                //campo.moverBarraDerechaAbajo();
            }
            if (e.getCode() == KeyCode.UP) {
                this.pulsados[2] = true;
                //si la posición de y de la barra es superior a el alto del campo, no se hará el mover barraderechaArriba
                // campo.moverBarraDerechaArriba();
            }
            if (e.getCode() == KeyCode.S) {
                this.pulsados[1] = true;
                //campo.moverBarraIzquierdaAbajo();
            }
            if (e.getCode() == KeyCode.W) {
                this.pulsados[0] = true;
                //campo.moverBarraIzquierdaArriba();
            }

        });
        scene.setOnMouseClicked(e -> {
            parado = !parado;
        });
        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DOWN) {
                this.pulsados[3] = false;
                //campo.moverBarraDerechaAbajo();
            }
            if (e.getCode() == KeyCode.UP) {
                this.pulsados[2] = false;
                //si la posición de y de la barra es superior a el alto del campo, no se hará el mover barraderechaArriba
                // campo.moverBarraDerechaArriba();
            }
            if (e.getCode() == KeyCode.S) {
                this.pulsados[1] = false;
                //campo.moverBarraIzquierdaAbajo();
            }
            if (e.getCode() == KeyCode.W) {
                this.pulsados[0] = false;
                //campo.moverBarraIzquierdaArriba();
            }
        });
        stage.setTitle("Pong Game DAW - Mateo");
        stage.setScene(scene);
        stage.show();
        this.canvas.paintBackground();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - last >= delta) {
                    last = now;
                    if (!parado) {
                        campo.moverPelota();
                        if (campo.detectarColisionBarraDerecha()) {
                            campo.cambiarAnguloColisionBarraDerecha();
                            //System.out.println("Ha colisonado con la barra Derecha");
                        }
                        if (campo.detectarColisionBarraIzquierda() < 10) {
                            campo.cambiarAnguloColisionBarraIzquierda();
                            //System.out.println("Ha colisonado con la barra Izquierda");

                        }
                        //EDITARRRR this.campo.EfectoEspecial();
                        if (pulsados[0]) {
                            campo.moverBarraIzquierdaArriba();
                        }
                        if (pulsados[1]) {
                            campo.moverBarraIzquierdaAbajo();
                        }
                        if (pulsados[2]) {
                            campo.moverBarraDerechaArriba();
                        }
                        if (pulsados[3]) {
                            campo.moverBarraDerechaAbajo();
                        }
                        canvas.paintPrincipal();
                    }
                }
            }
        };
        timer.start();

    }

}
