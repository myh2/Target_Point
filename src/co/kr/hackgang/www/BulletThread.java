package co.kr.hackgang.www;

import javax.swing.JLabel;

public class BulletThread extends Thread {
	private JLabel imgBullet;
	private boolean fire;
	int y = 720;
	int speed = 10;
	int x = 330;
	//Game game = new Game();
	
	public BulletThread(JLabel imgBullet, int x, int y) {
		this.imgBullet = imgBullet; 
		this.x = x;
		this.y = y;
	}
	@Override
	public void run() {
		while(fire){
			try {
				Thread.sleep(100);
				y -= speed;
				imgBullet.setBounds(x, y, 30, 30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
