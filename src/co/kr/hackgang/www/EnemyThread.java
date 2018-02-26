package co.kr.hackgang.www;

import javax.swing.JLabel;

public class EnemyThread extends Thread {
	private JLabel imgEnemy01;
	int y = 0;
	int speed = 10;
	int x = 0;
	public EnemyThread() {}

	public EnemyThread(JLabel imgEnemy01) {
		this.imgEnemy01 = imgEnemy01;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
				y += speed;
				x += (int)(Math.random()*40);
				x -= (int)(Math.random()*40);
				int w =80, h = 80;
				if((y/10)%2 == 0){
					w = 100;
					h = 100;
				}else{
					w = 80;
					h = 80;
				}
				imgEnemy01.setBounds(300+x, y, w, h);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
