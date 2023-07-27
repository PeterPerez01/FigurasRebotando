package FigsRebotando;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	
	public class ventana extends JFrame implements ActionListener {
	    
		private static final long serialVersionUID = 1L;
		JButton Circulo;  //declara un boton curculo
	    JButton Cuadrado; //declara un boton cuadrado
	    JButton Rec3D;    //declara un boton Rec3d
	    JButton Poligono; //declara un boton poligono

	    JPanel Botones;  // declara un panel Botones
	    JPanel AreaDibujo; // declara un panel AreaDibujo

		hilito mov; // declara una variable mov de la clase hilito
	    public ventana() {  // constructor
	        super("Figuras en Moviento"); // nombre de la ventana
	        mov = new hilito(); // crea un objeto de la clase
	        Container Contenedor = getContentPane(); //crea el contenedor
			Contenedor.setLayout(new FlowLayout());  // le da una estructura FlowLayout al contenedor (izq-der)
			Botones = new JPanel(); // crea un Jpanel "Botones"
			Botones.setLayout(new FlowLayout()); // le da una estructura tipo FlowLayout al panel botones
	        Circulo = new JButton(); // crea el boton circulo
	        Circulo.setText("Circulo relleno"); // le pone un texto al boton
	        Circulo.setPreferredSize(new Dimension(100, 60));//Dimension del boton
	        Circulo.addActionListener (this); // le da un Listener al boton para que realize alguna accion al darle click

	        Cuadrado = new JButton(); // crea el boton cuadrado
	        Cuadrado.setText("Cuadrado"); // le pone texto al boton
	        Cuadrado.setPreferredSize(new Dimension(100, 60));  //le da tamaño
	        Cuadrado.addActionListener(this); // le agrega un listener
	        Rec3D = new JButton();
	        Rec3D.setText("Rectangulo 3D");
	        Rec3D.setPreferredSize(new Dimension(100, 60));    //lo mismo
	        Rec3D.addActionListener(this);
	        Poligono=new JButton();
	        Poligono.setText("Poligono");
	        Poligono.setPreferredSize(new Dimension(100,60));  // lo mismo
	        Poligono.addActionListener(this);
	        
	        
	        AreaDibujo = new JPanel(); // crea un panel "area dibujo"
			AreaDibujo.setLayout(new FlowLayout());   // le da una estructura FlowLayout
			
			Contenedor.add(Botones);  // agrega al contenedor el panel botones
			Botones.add(Circulo);   // agrega al panel cada uno de los botones
			Botones.add(Cuadrado);
	        Botones.add(Rec3D);
	        Botones.add(Poligono);
			Contenedor.add(AreaDibujo);  // al contenedor le agrega el panel areadibujo
	        setVisible(true);  // visibilidad
	        setSize(800,500); // tamaño
	    }
	    public void actionPerformed (ActionEvent e) {   // ActionPerformed accion al darle click
	        if (e.getSource() == Circulo) {
	        	mov = new hilito(300, 200, "C"); //Metodo constructor de la clase hilo
	            add(mov);//agregamos el hilo
	        }
	        else if (e.getSource() == Cuadrado) {   // coordenadas de movimiento
	        	mov = new hilito(300, 200, "R");
	            add(mov);}
	        else if (e.getSource() == Rec3D) {
	            mov = new hilito(300, 200, "3D");
	            add(mov);}
	        else if (e.getSource()==Poligono){
	        	mov=new hilito(300,200, "P");
	        	add(mov);}
	    }
	    public static void main(String[] args) {  // main
	    	ventana v = new ventana();
	        v.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    }
	}