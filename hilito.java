package FigsRebotando;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class hilito extends JPanel implements Runnable {  // clase hilito hereda de Jpanel e implementa Runable
	/**
	 * 
	 */
	private static final long serialVersionUID = 030201;
	int X = 0;// variables de las cordenadas de las Figuras
	int Y = 0;
	int xValues[] = { 20, 40, 50, 30, 20, 15 };//un vector con las coordenadas para dibujar un Poligono
    int yValues[] = { 50, 50, 60, 80, 80, 60 };
    boolean DireccionX;  // mas variables de direcciones
    boolean DireccionY;
    Thread Hilo;  // declara el hilo
    String Forma;
    Random rnd = new Random();
    Color randomc = new Color(rnd.nextInt());
    public hilito() {  //constructor nulo
    }
    public hilito(int A, int B, String Figura) { //al constructor se le pasan las coordenadas donde aparesera y la figura
        X = A;    // se hacen las asignaciones
        Y = B;
        Forma = Figura;
        repaint();
        setVisible(true);  // visibilidad
        setSize(50, 50);  // tamaño

        Hilo = new Thread(this);  // crea el hilo
        Hilo.start();   // lo pone en run (ejecucion)
    }
    public void paint(Graphics Graficos) { //metodo donde se dibujaran las figuras
        	if(Forma == "C") {
            Graficos.setColor(randomc);  //color
            Graficos.fillOval(0, 0, 50, 50);    // coordenadas a dibujar
        }
        if(Forma == "R") {
        	Graficos.setColor(randomc);  //lo mismo
        	Graficos.fillRect(0, 0, 50, 50);
        }
        if(Forma == "3D") {
            Graficos.setColor(randomc);   // lo mismo
            Graficos.fill3DRect(0, 0, 100, 30, true);
        }
        if(Forma== "P"){
        	Polygon polygon1 = new Polygon( xValues, yValues, 6 ); // crea el poligono y le pasa como parametros sus cordenadas a dibujar
             Graficos.drawPolygon( polygon1 ); // con el objeto de la clase graphics llama al metodo drawPolygon
             Graficos.setColor(randomc); // le da color
       }
    }
    public void run() {  // metodo del hilo , sus direcciones
        for(;;) {
    		try {
    			if(X == 10) {  // si llega al tope
    							DireccionX = false;	  // cambia el sentido
    								}
    			else if((X + 50) >= 750) { //Margen de la ventana
    				DireccionX = true; 	}
                		if(Y ==80) { 		DireccionY = true;	}
                else if((Y) >= 400) { //MArgen
                	DireccionY = false;
                }
                if((DireccionX == false) && (DireccionY == false)) { // SUbe del punto de salida
                    X = X + 1;                     Y = Y - 1;
                }
                else if((DireccionX == false) && (DireccionY == true)) { //Baja desde un punto rebota
                    X = X + 1;                    Y = Y + 1;
                }
                else if((DireccionX == true) && (DireccionY == false)) { // reboto Baja
                    X = X - 1;  Y = Y - 1;
                }
                else if((DireccionX == true) && (DireccionY == true)) { //Sube
                    X = X - 1;   Y = Y + 1;
                }
                        setBounds(X, Y, 100, 100); //Q posicion aparecera la figura
                Thread.sleep(6);  
    								}
    		catch(InterruptedException IE) {
    		} 
    			}
        } 
   }