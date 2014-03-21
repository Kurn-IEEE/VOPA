package ventanaVOPA;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;



public class panelPaint extends JPanel implements KeyListener {

	//declaracion de las variables
	public static JButton boton;
	public static int n=0,n1=0,n2=0,n3=0,n4=0,n5=0,n6=0,n7=0,n8=0;
	public static int buffer=0,buffer1=0,buffer2=0,buffer3=0,buffer4=0,buffer5=0,buffer6=0,buffer7=0,buffer8=0;
	int x=1, y=1, xx=0, yy=0, ab=0, ar=0, izq=0, der=0;
	public static Graphics2D g;
	public String l;
	boolean dibuja = false, zoom = false;
	int[][] matriz = new int[3000][2];//declaramos las matrices para almacenar nuestro dibujo
	int[][] matriz1 = new int[3000][2];
	int[][] matriz2 = new int[3000][2];
	int[][] matriz3 = new int[3000][2];
	int[][] matriz4 = new int[3000][2];
	int[][] matriz5 = new int[3000][2];
	int[][] matriz6 = new int[3000][2];
	int[][] matriz7 = new int[3000][2];
	int[][] matriz8 = new int[3000][2];
	int v[]=new int[2];
	int ancho=20, largo=20, mover=20, zo=0, variable =0, u =0;
	int rojo=0, verde=0, azul=0,negro=0;
	int grgb=0, grgb1=0, grgb2=0, grgb3=0, grgb4=0;
	float q=1;
	
////////////////Escala de gris /////////////////////
Color colorGris15=new Color(38, 38, 38); // Color (R,G,B)
Color colorGris30=new Color(77, 77, 77);
Color colorGris45=new Color(115, 115, 115);
Color colorGris60=new Color(153, 153, 153);
Color colorGris75=new Color(191, 191, 191);
	

	
	public panelPaint(){
		
		n=buffer;
		n1=buffer1;
		n2=buffer2;
		n3=buffer3;
		n4=buffer4;
		n5=buffer5;
		n6=buffer6;
		n7=buffer7;
		n8=buffer8;
		
		boton = new JButton();//llamamos al boton
		boton.setBounds(x, y, ancho, largo);
	
		setLayout(null);
		setBounds(201,0,1400,800);
		setBackground(Color.white);//he cambiado el color
		add(boton);
		boton.addKeyListener(this);
		
	}
	
///////////////////////////////////////////////////////////////////
	public void zoom(){	
		
		if(zoom){
			
		ancho = (int) (ancho*q);// se multiplica para darle proporcion a las dimensiones y el movimiento del puntero
		largo = (int) (largo*q);
		mover = (int) (mover*q);
		
		y = (int) (y*q); // calibrar el puntero
		x = (int) (x*q);
		
		int j;
		
		for(j=0;j<buffer;j++){
			
			matriz[j][0] = (int) (matriz[j][0]*q);
			matriz[j][1] = (int) (matriz[j][1]*q);
			repaint();
			zo=1;
			}
		////////////////////////////////demas colores////////////////////
		for(j=0;j<buffer1;j++){
			
			matriz1[j][0] = (int) (matriz1[j][0]*q);
			matriz1[j][1] = (int) (matriz1[j][1]*q);
			repaint();
			rojo=1;
			}
		
		for(j=0;j<buffer2;j++){
			
			matriz2[j][0] = (int) (matriz2[j][0]*q);
			matriz2[j][1] = (int) (matriz2[j][1]*q);
			repaint();
			verde=1;
			}
		
		for(j=0;j<buffer3;j++){
			
			matriz3[j][0] = (int) (matriz3[j][0]*q);
			matriz3[j][1] = (int) (matriz3[j][1]*q);
			repaint();
			azul=1;
			}
		
		for(j=0;j<buffer4;j++){
			
			matriz4[j][0] = (int) (matriz4[j][0]*q);
			matriz4[j][1] = (int) (matriz4[j][1]*q);
			repaint();
			grgb=1;
			}
		
		for(j=0;j<buffer5;j++){
			
			matriz5[j][0] = (int) (matriz5[j][0]*q);
			matriz5[j][1] = (int) (matriz5[j][1]*q);
			repaint();
			grgb1=1;
			}
		
		for(j=0;j<buffer6;j++){
			
			matriz6[j][0] = (int) (matriz6[j][0]*q);
			matriz6[j][1] = (int) (matriz6[j][1]*q);
			repaint();
			grgb2=1;
			}
		
		for(j=0;j<buffer7;j++){
			
			matriz7[j][0] = (int) (matriz7[j][0]*q);
			matriz7[j][1] = (int) (matriz7[j][1]*q);
			repaint();
			grgb3=1;
			}
		
		for(j=0;j<buffer8;j++){
			
			matriz8[j][0] = (int) (matriz8[j][0]*q);
			matriz8[j][1] = (int) (matriz8[j][1]*q);
			repaint();
			grgb4=1;
			}
		/////////////////////////////////////
		}
		zoom=false;
		x=0;
		y=0;
		boton.setBounds(x, y, ancho, largo);
		
	}
	

/////////////////metodos con el teclado////////////////////////////
	@Override
	public void keyPressed(KeyEvent e) {
				
		l = e.getKeyText(e.getKeyCode());

			if(l.equals("Arriba")){

			v[0]=boton.getX();
			v[1]=boton.getY();
			buffer();
			buffer1();
			buffer2();
			buffer3();
			buffer4();
			buffer5();
			buffer6();
			buffer7();
			buffer8();
			
				if(boton.getY()==largo*0.5){////restriccion de movimiento
					ar=0;
				}
				else if(boton.getY()>largo*0.5){
				
					y-=mover;
					ar=1;
				}
			
			}

			else if(l.equals("Abajo")){

			v[0]=boton.getX();
			v[1]=boton.getY();
			buffer();
			buffer1();
			buffer2();
			buffer3();
			buffer4();
			buffer5();
			buffer6();
			buffer7();
			buffer8();
			
				if(boton.getY()== 750-ancho*0.5){
					ab=0;
				}
				else if(boton.getY()<750-ancho*0.5){
				
					y+=mover;
					ab=1;
				}
			
			
			
			}

			else if(l.equals("Derecha")){

			v[0]=boton.getX();
			v[1]=boton.getY();
			buffer();
			buffer1();
			buffer2();
			buffer3();
			buffer4();
			buffer5();
			buffer6();
			buffer7();
			buffer8();
			
				if(boton.getX()== 1370-ancho*0.5){
					der=0;
				}
				else if(boton.getX()<1370-ancho*0.5){
				
					x+=mover;
					der=1;
				}
			

			}

			else if(l.equals("Izquierda")){

			v[0]=boton.getX();
			v[1]=boton.getY();
			buffer();
			buffer1();
			buffer2();
			buffer3();
			buffer4();
			buffer5();
			buffer6();
			buffer7();
			buffer8();
			
				if(boton.getX()==ancho*0.5){
					izq=0;
				}
				else if(boton.getX()>ancho*0.5){
					
					x-=mover;
					izq=1;
				}
			
			}
			
			else if(l.equals("A")){
				System.out.println("HE PULSADO A \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz[buffer][0]=xx;
				matriz[buffer][1]=yy;
				n=1+n;
				buffer=n;
				negro=1;
				dibuja=true;
			}
			
			else if(l.equals("S")){
				System.out.println("HE PULSADO S \n");
				xx = boton.getX();
				yy = boton.getY();
				v[0]=xx;
				v[1]=yy;
				
				for(int k=1;k<=buffer;k++)
				{
					if(matriz[k][0]==(v[0]))
					{
						if(matriz[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz[k][0]=matriz[k-1][0];
							matriz[k][1]=matriz[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer1;k++)
				{
					if(matriz1[k][0]==(v[0]))
					{
						if(matriz1[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz1[k][0]=matriz1[k-1][0];
							matriz1[k][1]=matriz1[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer2;k++)
				{
					if(matriz2[k][0]==(v[0]))
					{
						if(matriz2[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz2[k][0]=matriz2[k-1][0];
							matriz2[k][1]=matriz2[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer3;k++)
				{
					if(matriz3[k][0]==(v[0]))
					{
						if(matriz3[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz3[k][0]=matriz3[k-1][0];
							matriz3[k][1]=matriz3[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer4;k++)
				{
					if(matriz4[k][0]==(v[0]))
					{
						if(matriz4[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz4[k][0]=matriz4[k-1][0];
							matriz4[k][1]=matriz4[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer5;k++)
				{
					if(matriz5[k][0]==(v[0]))
					{
						if(matriz5[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz5[k][0]=matriz5[k-1][0];
							matriz5[k][1]=matriz5[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer6;k++)
				{
					if(matriz6[k][0]==(v[0]))
					{
						if(matriz6[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz6[k][0]=matriz6[k-1][0];
							matriz6[k][1]=matriz6[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer7;k++)
				{
					if(matriz7[k][0]==(v[0]))
					{
						if(matriz7[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz7[k][0]=matriz7[k-1][0];
							matriz7[k][1]=matriz7[k-1][1];
							
						}
					}
				}
				for(int k=1;k<=buffer8;k++)
				{
					if(matriz8[k][0]==(v[0]))
					{
						if(matriz8[k][1]==(v[1]))//elimino la posicion de la matriz pintar
						{
							matriz8[k][0]=matriz8[k-1][0];
							matriz8[k][1]=matriz8[k-1][1];
							
						}
					}
				}
			}
			
			else if(l.equals("Q")){
				// Llama al metodo zoom y multiplica la constante q
				
				if(u!=2){
					if(u<2 && u>=0){
						u++;
						q=(float) 0.5;
						zoom=true;
						zoom();
					}
				}
			}
			
			else if(l.equals("W")){
				
				if(u!=0){
					if(u<3){
						u--;
						q=2;
						zoom=true;
						zoom();
						}
					}
			}
			
			else if(l.equals("R")){
				System.out.println("HE PULSADO R \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz1[buffer1][0]=xx;
				matriz1[buffer1][1]=yy;
				n1=1+n1;
				buffer1=n1; 
				rojo=1;
			}
			
			else if(l.equals("G")){
				System.out.println("HE PULSADO G \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz2[buffer2][0]=xx;
				matriz2[buffer2][1]=yy;
				n2=1+n2;
				buffer2=n2; 
				verde=1;
			}
			
			else if(l.equals("B")){
				System.out.println("HE PULSADO B \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz3[buffer3][0]=xx;
				matriz3[buffer3][1]=yy;
				n3=1+n3;
				buffer3=n3; 
				azul=1;
			}
			
			else if(l.equals("H")){
				System.out.println("HE PULSADO H \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz4[buffer4][0]=xx;
				matriz4[buffer4][1]=yy;
				n4=1+n4;
				buffer4=n4;
				grgb=1;
			}
			
			else if(l.equals("J")){
				System.out.println("HE PULSADO J \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz5[buffer5][0]=xx;
				matriz5[buffer5][1]=yy;
				n5=1+n5;
				buffer5=n5;
				grgb1=1;
			}
			else if(l.equals("K")){
				System.out.println("HE PULSADO K \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz6[buffer6][0]=xx;
				matriz6[buffer6][1]=yy;
				n6=1+n6;
				buffer6=n6;
				grgb2=1;
			}
			
			else if(l.equals("L")){
				System.out.println("HE PULSADO L \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz7[buffer7][0]=xx;
				matriz7[buffer7][1]=yy;
				n7=1+n7;
				buffer7=n7;
				grgb3=1;
			}
			
			else if(l.equals("M")){
				System.out.println("HE PULSADO M \n");
				xx = boton.getX();
				yy = boton.getY();
				matriz8[buffer8][0]=xx;
				matriz8[buffer8][1]=yy;
				n8=1+n8;
				buffer8=n8;
				grgb4=1;
			}
			
			
			/////////////////visualizar el puntero///////////////////////
		
			if(ar==1)
			{
				boton.setBounds(x, y, ancho, largo);
				ar=0;
			}
			if(ab==1)
			{
				boton.setBounds(x, y, ancho, largo);
				ab=0;
			}
			if(izq==1)
			{
				boton.setBounds(x, y, ancho, largo);
				izq=0;
			}
			if(der==1)
			{
				boton.setBounds(x, y, ancho, largo);
				der=0;
			}

		/////////////////////////////////////////////////////////////////////////
		
	}
		
	
	/////////////metodos para repintar las posiciones y que no se borren
	public void buffer (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer;j++)
		{
			if(matriz[j][0]==(v[0]))
			{
				if(matriz[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					dibuja=true;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	public void buffer1 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer1;j++)
		{
			if(matriz1[j][0]==(v[0]))
			{
				if(matriz1[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					rojo=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}	
	}
	
	public void buffer2 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer2;j++)
		{
			if(matriz2[j][0]==(v[0]))
			{
				if(matriz2[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					verde=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	public void buffer3 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer3;j++)
		{
			if(matriz3[j][0]==(v[0]))
			{
				if(matriz3[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					azul=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	public void buffer4 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer4;j++)
		{
			if(matriz4[j][0]==(v[0]))
			{
				if(matriz4[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					grgb=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	public void buffer5 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer5;j++)
		{
			if(matriz5[j][0]==(v[0]))
			{
				if(matriz5[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					grgb1=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	public void buffer6 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer6;j++)
		{
			if(matriz6[j][0]==(v[0]))
			{
				if(matriz6[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					grgb2=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	public void buffer7 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer7;j++)
		{
			if(matriz7[j][0]==(v[0]))
			{
				if(matriz7[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					grgb3=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	public void buffer8 (){//comprobamos en la matriz las posiciones pintadas
		int j;
		for(j=0;j<=buffer8;j++)
		{
			if(matriz8[j][0]==(v[0]))
			{
				if(matriz8[j][1]==(v[1]))
				{
					xx = boton.getX();
					yy = boton.getY();
					grgb4=1;//pasa por las direcciones y pinta el cuadrado en la posicion de la guardada en la matriz
				}
			}
		}
	}
	
	/////////////////////////////////////////////////////
	public void paintComponent(Graphics g){
		
				super.paintComponent(g);
				g = (Graphics2D) g;
				
				if(zo==1){//pintar el zoom//////////////////////
					if(negro==1)
					{
						
						for(int j=0;j<buffer;j++)
						{
						g.setColor(Color.black);
						xx = matriz[j][0];
						yy = matriz[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(rojo==1)
					{
						
						for(int j=0;j<buffer1;j++)
						{
						g.setColor(Color.red);
						xx = matriz1[j][0];
						yy = matriz1[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(verde==1)
					{
						
						for(int j=0;j<buffer2;j++)
						{
						g.setColor(Color.green);
						xx = matriz2[j][0];
						yy = matriz2[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(azul==1)
					{
						
						for(int j=0;j<buffer3;j++)
						{
						g.setColor(Color.blue);
						xx = matriz3[j][0];
						yy = matriz3[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(grgb==1)
					{
						
						for(int j=0;j<buffer4;j++)
						{
							g.setColor(colorGris15);
						xx = matriz4[j][0];
						yy = matriz4[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(grgb1==1)
					{
						
						for(int j=0;j<buffer5;j++)
						{
							g.setColor(colorGris30);
						xx = matriz5[j][0];
						yy = matriz5[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(grgb2==1)
					{
						
						for(int j=0;j<buffer6;j++)
						{
							g.setColor(colorGris45);
						xx = matriz6[j][0];
						yy = matriz6[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(grgb3==1)
					{
						
						for(int j=0;j<buffer7;j++)
						{
							g.setColor(colorGris60);
						xx = matriz7[j][0];
						yy = matriz7[j][1];
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
					if(grgb4==1)
					{
						
						for(int j=0;j<buffer8;j++)
						{
							g.setColor(colorGris75);
						xx = matriz8[j][0];
						yy = matriz8[j][1];				
						g.fillRect(xx,yy, ancho, largo);
						}	
				zo=0;
					}
				}////////////////////////////////////////////////

				if (x > -1 && y > -1){
				
					if(dibuja){
						
						g.setColor(Color.black);
						g.fillRect(xx,yy, ancho, largo);
						dibuja=false;
						}
				
					}
					
				if(rojo==1){
					g.setColor(Color.red);
					g.fillRect(xx, yy, ancho, largo);
					rojo=0;
				}
					
				if(verde==1){
					g.setColor(Color.green);
					g.fillRect(xx, yy, ancho, largo);
					verde=0;
				}
					
				if(azul==1){
					g.setColor(Color.blue);
					g.fillRect(xx, yy, ancho, largo);
					azul=0;
				}
										
				if(grgb==1){
					g.setColor(colorGris15);
					g.fillRect(xx, yy, ancho, largo);
					grgb=0;
				}
				
				if(grgb1==1){
					g.setColor(colorGris30);
					g.fillRect(xx, yy, ancho, largo);
					grgb1=0;
				}
				
				if(grgb2==1){
					g.setColor(colorGris45);
					g.fillRect(xx, yy, ancho, largo);
					grgb2=0;
				}
				
				if(grgb3==1){
					g.setColor(colorGris60);
					g.fillRect(xx, yy, ancho, largo);
					grgb3=0;
				}
				
				if(grgb4==1){
					g.setColor(colorGris75);
					g.fillRect(xx, yy, ancho, largo);
					grgb4=0;
				}
				
			}
	


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
