package co.kr.hackgang.www;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class GraphicsTest extends Frame{

	public GraphicsTest() {
		add(new Canvas(){
			public void paint(Graphics g){
				g.setColor(Color.red);
				
				//g.draw3DRect(0, 0, 46, 36, true);
				//g.draw3DRect(50, 0, 46, 36, false);
				
				//g.drawOval(150, 0, 46, 36);
				//g.drawArc(200, 0, 46, 36, 0, 300);
				
				int x1[] = new int[] { 50, 120, 120, 50 };
				int y1[] = new int[] { 50, 120, 120, 50 };
				g.drawPolygon(x1, y1, 4);
				
				
			}
		});
	}
	

	public static void main(String[] args) {
		GraphicsTest f = new GraphicsTest();
		
		f.setTitle("polygon");
		f.setSize(1200, 1290);
		f.setVisible(true);
	}

}
