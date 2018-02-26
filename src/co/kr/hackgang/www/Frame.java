package co.kr.hackgang.www;


import javax.swing.JFrame;


public class Frame extends JFrame{
//	int dx, dy;
	
	public Frame() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		this.setTitle("¹ð±â °ÔÀÓ");
		this.setSize(700, 850);
		/*this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					dx -= 10;
				case KeyEvent.VK_RIGHT:
					dx += 10;
				}
			}
				
		});
*/	
	}
	
}
