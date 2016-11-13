package window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements KeyListener{

	public static Rectangle2D shuttle;
	public static double shuttleX;
	public static double shuttleY;
	public static Laser laser;
	public static boolean isShot;
	
	public MainPanel(){
		setOpaque(true);
		setBackground(Color.black);
		addKeyListener(this);
		setFocusable(true);
		shuttle = new Rectangle2D.Double(5, 1280, 50, 50);
		shuttleX = shuttle.getX();
		shuttleY = shuttle.getY();
		laser = new Laser();
		isShot = false;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(new Color(255,255,255));
		gg.fill(shuttle);
		shootLaser(g);
		
	}	
	
	public void shootLaser(Graphics g){
			Graphics2D gg = (Graphics2D) g;
				laser.drawLaser(gg);
				repaint();
			if(Laser.lasersInteger.size() > 1){
			try {
				Laser.a.join(1);
			} catch (InterruptedException e) {
				System.out.println("Caught exception: " +e.getMessage() +"gadeem");
				e.printStackTrace();
			}
			Laser.b.start();
		}
	}
	
	public void armLaser(){
		isShot = true;
		laser.instantiateLaser();
		repaint();
		
	}
	
	public void syncShuttle(){
		shuttleX = shuttle.getX();
		shuttleY = shuttle.getY();
	}
	

	public void right(){
		if(shuttle.getX() >= 5.0 && shuttle.getMaxX() < 2555.0){
		shuttleX += 100.0;
		shuttle.setFrame(shuttleX,shuttleY,shuttle.getWidth(),shuttle.getHeight());
		repaint();
		}
		syncShuttle();
	}
	
	public void left(){
		if(shuttle.getMaxX() >= 80.0 && shuttle.getMaxX() <= 2555.0){	
		shuttleX -= 100.0;
		shuttle.setFrame(shuttleX,shuttleY,shuttle.getWidth(),shuttle.getHeight());
		repaint();
		}
		syncShuttle();
	}
	
	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE){
			armLaser();
		}
		if(code == KeyEvent.VK_RIGHT){
			right();
		}
		if(code == KeyEvent.VK_LEFT){
			left();
		}
	}

	@Override
	public void keyReleased(KeyEvent e){}
}
