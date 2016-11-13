package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Laser extends Rectangle2D{
	
	private static double x;
	private static double y;
	private static double width;
	private static double height;
	private static ArrayList<Double> lasers;
	private static int laserCount;
	private static boolean drawLaser;
	public static ArrayList<Integer> lasersInteger;
	private static int i = 1;
	public static Thread a;
	public static Thread b;
	public Laser(){
		super();
		x = MainPanel.shuttleX+21;
		//y = new double[(int)MainPanel.shuttleY];
		y = MainPanel.shuttleY;
		width = 10;
		height = 10;
		lasers = new ArrayList<Double>();
		lasersInteger = new ArrayList<Integer>();
		drawLaser = false;
	}
	
	public void drawLaser(Graphics g){
		if(drawLaser){

			Graphics2D gg = (Graphics2D) g;
			Graphics2D gg2 = (Graphics2D) g;
			gg.setColor(new Color(23,200,154));
			//System.out.println(lasers.get(laserCount-lasersInteger.get(0)).y);
			gg.fill((Shape) lasers.get(laserCount-lasersInteger.get(0)));
				Runnable runnable = new Runnable(){
						public void run(){
						if(lasers.get(laserCount-lasersInteger.get(0)).y != 0 && MainPanel.isShot == true){
							
							lasers.get(laserCount-lasersInteger.get(0)).y -= 1;
							lasers.set(laserCount-lasersInteger.get(0), new Laser.Double(x, lasers.get(laserCount-lasersInteger.get(0)).y, width, height));
							//NONONONONO--->StartupWindow.panel.paintComponents(gg);
							//System.out.println(lasers.get(laserCount-lasersInteger.get(0)).y);
							}
						}
					};
					
				Runnable runnable2 = new Runnable(){
					
						public void run(){	
						if(lasers.get(laserCount-lasersInteger.get(0)).y <= 1000 && MainPanel.isShot == true){
							MainPanel.isShot = true;
							instantiateLaser();
							//StartupWindow.panel.repaint();
							gg2.setColor(new Color(130,230,40));
							gg2.fill((Shape) lasers.get(laserCount-lasersInteger.get(1)));
							lasers.get(laserCount-lasersInteger.get(1)).y -= 1;
							lasers.set(laserCount-lasersInteger.get(1), new Laser.Double(x, lasers.get(laserCount-lasersInteger.get(1)).y, width, height));
							StartupWindow.panel.paintComponents(gg2);
							System.out.println(lasers.get(laserCount-lasersInteger.get(1)).y);
							}
						}
					};
				
					a = new Thread(runnable, "Thread 1");
					b = new Thread(runnable2, "Thread 2");
					a.start();
					
					
					


				
//|| lasers.get(laserCount-lasersInteger.get(1)).y == 0){
			if(lasers.get(laserCount-lasersInteger.get(0)).y == 0){ 
				lasers.get(laserCount-lasersInteger.get(0)).y -= 0;
				gg.clearRect((int)lasers.get(laserCount-lasersInteger.get(0)).getX(), (int)lasers.get(laserCount-lasersInteger.get(0)).getY(), (int)lasers.get(laserCount-lasersInteger.get(0)).getWidth(), (int)lasers.get(laserCount-lasersInteger.get(0)).getHeight());
				gg.setColor(Color.black);
				gg.fillRect((int)lasers.get(laserCount-lasersInteger.get(0)).getX(), (int)lasers.get(laserCount-lasersInteger.get(0)).getY(), (int)lasers.get(laserCount-lasersInteger.get(0)).getWidth(), (int)lasers.get(laserCount-lasersInteger.get(0)).getHeight());
				lasers.set(laserCount-lasersInteger.get(0), new Laser.Double(x, lasers.get(laserCount-lasersInteger.get(0)).y, width, height));
				StartupWindow.panel.repaint();
				syncVariables();
			}
			/*if(lasers.get(laserCount-lasersInteger.get(1)).y == 0){
				lasers.get(laserCount-lasersInteger.get(1)).y -= 0;
				gg.clearRect((int)lasers.get(laserCount-lasersInteger.get(1)).getX(), (int)lasers.get(laserCount-lasersInteger.get(1)).getY(), (int)lasers.get(laserCount-lasersInteger.get(1)).getWidth(), (int)lasers.get(laserCount-lasersInteger.get(1)).getHeight());
				gg.setColor(Color.black);
				gg.fillRect((int)lasers.get(laserCount-lasersInteger.get(1)).getX(), (int)lasers.get(laserCount-lasersInteger.get(1)).getY(), (int)lasers.get(laserCount-lasersInteger.get(1)).getWidth(), (int)lasers.get(laserCount-lasersInteger.get(1)).getHeight());
				lasers.set(laserCount-lasersInteger.get(1), new Laser.Double(x, lasers.get(laserCount-lasersInteger.get(1)).y, width, height));
				StartupWindow.panel.repaint();
				syncVariables();
			}*/
		}
	}
	

	public void instantiateLaser(){
		
		drawLaser = true;
		x = MainPanel.shuttleX+21;
		y = MainPanel.shuttleY;
		width = 10;
		height = 10;
		lasers.add(new Laser.Double(x, y, width, width));
		lasersInteger.add(new Integer(i));
		i++;
		laserCount++;
			
	}
	
	public void syncVariables(){
		
		MainPanel.isShot = false;
		drawLaser = false;
		
	}
	
	@Override
	public void setRect(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
	}

	@Override
	public int outcode(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
