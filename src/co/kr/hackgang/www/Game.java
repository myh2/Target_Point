package co.kr.hackgang.www;

import java.awt.Image;
import java.awt.Label;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import co.kr.hackgang.www.controller.AppContext;

public class Game extends Frame implements Runnable, ActionListener, KeyListener {
	private JPanel ctp;
	private JButton btn;
	private BufferedImage bi = null;
	Label l1;

	JLabel imgShooter;
	ImageIcon shooter;

	JLabel imgShot;
	ImageIcon shot;

	JLabel[] enemyImgs = new JLabel[14];

	JLabel[] bossImgs = new JLabel[3];
	JLabel imgBoss01;
	ImageIcon boss01;
	JLabel imgBoss02;
	ImageIcon boss02;
	JLabel imgBoss03;
	ImageIcon boss03;

	JLabel imgEnemy01;
	ImageIcon enemy01;
	JLabel imgEnemy02;
	ImageIcon enemy02;
	JLabel imgEnemy03;
	ImageIcon enemy03;
	JLabel imgEnemy04;
	ImageIcon enemy04;
	JLabel imgEnemy05;
	ImageIcon enemy05;
	JLabel imgEnemy06;
	ImageIcon enemy06;
	JLabel imgEnemy07;
	ImageIcon enemy07;
	JLabel imgEnemy08;
	ImageIcon enemy08;
	JLabel imgEnemy09;
	ImageIcon enemy09;
	JLabel imgEnemy10;
	ImageIcon enemy10;
	JLabel imgEnemy11;
	ImageIcon enemy11;
	JLabel imgEnemy12;
	ImageIcon enemy12;
	JLabel imgEnemy13;
	ImageIcon enemy13;
	JLabel imgEnemy14;
	ImageIcon enemy14;

	JLabel imgFighter;
	ImageIcon fighter;

	JLabel[] bulletImgs = new JLabel[6];
	JLabel imgBullet01;
	ImageIcon bullet01;
	JLabel imgBullet02;
	ImageIcon bullet02;
	JLabel imgBullet03;
	ImageIcon bullet03;
	JLabel imgBullet04;
	ImageIcon bullet04;
	JLabel imgBullet05;
	ImageIcon bullet05;
	JLabel imgBullet06;
	ImageIcon bullet06;
	
	// JLable[] imgEnemy01 = {};
	JLabel paintComponents;
	ImageIcon paint;

	// score 異쒕젰�쓣 �쐞�븳 JLabel
	JLabel scores;
	JLabel lifes;
	JLabel record;
	JLabel first;
	JLabel second;
	JLabel third;

	JLabel imgFail;
	ImageIcon fail;
	
	JLabel imgBackground;
	ImageIcon background;

	// private BufferedImage bi = null;
	// private JLabel bi;
	// int score = 0;

	private boolean left = false, right = false, up = false, down = false;
	private boolean fire = false;
	private ArrayList<Enemy> enemyList = null;
	private ArrayList<Ms> misileList = null;
	private boolean start = false, end = false, bm = true, bc = true;
	Image fighter1;
	// Fighter fighterClass;
	private ArrayList<Boss> bossList = null;

	// boolean start = true;

	// Fighter�쓽 x�� y醫뚰몴瑜� �쓽誘명븯怨� �뿬湲곗꽌 �떆�옉�릺硫� �궎�엯�젰�뿉 �뜑�빐吏꾨떎.
	int x = 330, y = 680, w = 80, h = 80, xw = 40, xh = 40;
	// �궎�엯�젰�뿉�꽌 �엯�젰諛쏆븘 run�뿉�꽌 fighter�쓽 x醫뚰몴�� y醫뚰몴�뿉 �뜑�빐吏�硫댁꽌
	// 鍮꾪뻾湲곗쓽 ��吏곸엫�씠 蹂�寃쎈맂�떎.
	int dx, dy;
	JMenuItem g1, g2, sys1, sys2;

	private ArrayList imgEnemy = null;

	public Game() {
		ctp = (JPanel) this.getContentPane();
		this.addKeyListener(this);
		// bi = new BufferedImage(300, 500, BufferedImage.TYPE_INT_RGB);
		// bi =
		// menuLayout();
		init();
		start();

		// paintComponents();
		// fighterClass = new Fighter(this);
		enemyList = new ArrayList<Enemy>();
		misileList = new ArrayList<Ms>();
		imgEnemy = new ArrayList();
		bossList = new ArrayList<Boss>();
		// enemyImgs = {imgEnemy01, imgEnemy02, imgEnemy03, imgEnemy04};
		new Thread(this).start();
		/*
		 * scores = new JLabel("score : " + score); scores.setBounds(40, 40, 70,
		 * 70); ctp.add(scores);
		 */
		// JLabel scores;

		JLabel record;
		JLabel first;
		JLabel second;
		JLabel third;
		ctp.add(imgBackground);
		menuLayout();
		// new EnemyThread(imgEnemy01).start();
		// new BulletThread(imgBullet, fire, this.x, this.y).start();
	}

	private void menuLayout() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu1 = new JMenu("寃뚯엫");
		menu1.setMnemonic('1');
		g1 = new JMenuItem("�옱�떆�옉");
		g2 = new JMenuItem("score �닚�쐞");

		JMenu menu2 = new JMenu("�떆�뒪�뀥");
		menu2.setMnemonic('2');
		sys1 = new JMenuItem("寃뚯엫 �꽕紐�");
		sys2 = new JMenuItem("醫낅즺");

		menu1.add(g1);
		menu1.add(g2);
		menu2.add(sys1);
		menu2.add(sys2);
		menuBar.add(menu1);
		menuBar.add(menu2);
		setJMenuBar(menuBar);

		g1.addActionListener(this);
		g2.addActionListener(this);
		sys1.addActionListener(this);
		sys2.addActionListener(this);
		// ctp.add(menuBar);

	}

	private void init() {
		this.setLayout(null);
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		/*
		 * Graphics gs = bi.getGraphics(); gs.setColor(Color.black);
		 * gs.fillRect(0, 0, 300, 500); gs.setColor(Color.black); gs.drawString(
		 * "�젏�닔 : "+ score, 40, 60);
		 */

		l1 = new Label("11111111");
		btn = new JButton("諛쒖궗");
		btn.setBounds(590, 730, 80, 40);

		shooter = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\shooter.png");
		imgShooter = new JLabel(shooter);
		imgShooter.setBounds(20, 720, 80, 80);

		shot = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\shot.png");
		imgShot = new JLabel(shot);
		imgShot.setBounds(20, 720, 30, 30);

		// JLabel imgEnemy01;
		// ImageIcon enemy01;
		// JLabel[] enemyImgs = new JLabel[7];
		enemy01 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy1.png");
		imgEnemy01 = new JLabel(enemy01);

		// JLabel imgBackground;
		// ImageIcon background;
		background = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\background.png");
		imgBackground = new JLabel(background);
		imgBackground.setBounds(0, 0, 700, 850);

		enemy02 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy2.png");
		imgEnemy02 = new JLabel(enemy02);
		// imgEnemy02.setBounds(70, 70, 70, 70);

		enemy03 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy3.png");
		imgEnemy03 = new JLabel(enemy03);
		enemy04 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy4.png");
		imgEnemy04 = new JLabel(enemy04);
		enemy05 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy5.png");
		imgEnemy05 = new JLabel(enemy05);
		enemy06 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy6.png");
		imgEnemy06 = new JLabel(enemy06);
		enemy07 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy7.png");
		imgEnemy07 = new JLabel(enemy07);
		enemy08 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy1.png");
		imgEnemy08 = new JLabel(enemy08);
		enemy09 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy2.png");
		imgEnemy09 = new JLabel(enemy02);
		enemy10 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy3.png");
		imgEnemy10 = new JLabel(enemy03);
		enemy11 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy4.png");
		imgEnemy11 = new JLabel(enemy04);
		enemy12 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy5.png");
		imgEnemy12 = new JLabel(enemy05);
		enemy13 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy6.png");
		imgEnemy13 = new JLabel(enemy06);
		enemy14 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\enemy7.png");
		imgEnemy14 = new JLabel(enemy07);

		enemyImgs[0] = imgEnemy01;
		// enemyImgs[0].setBounds(20, 20, 70, 70);
		enemyImgs[1] = imgEnemy02;
		// enemyImgs[1].setBounds(70, 70, 70, 70);
		enemyImgs[2] = imgEnemy03;
		enemyImgs[3] = imgEnemy04;
		enemyImgs[4] = imgEnemy05;
		enemyImgs[5] = imgEnemy06;
		enemyImgs[6] = imgEnemy07;
		enemyImgs[7] = imgEnemy08;
		// enemyImgs[0].setBounds(20, 20, 70, 70);
		enemyImgs[8] = imgEnemy09;
		// enemyImgs[1].setBounds(70, 70, 70, 70);
		enemyImgs[9] = imgEnemy10;
		enemyImgs[10] = imgEnemy11;
		enemyImgs[11] = imgEnemy12;
		enemyImgs[12] = imgEnemy13;
		enemyImgs[13] = imgEnemy14;

		boss01 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\boss01.png");
		imgBoss01 = new JLabel(boss01);
		boss02 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\boss02.png");
		imgBoss02 = new JLabel(boss02);
		boss03 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\boss03.png");
		imgBoss03 = new JLabel(boss03);

		/*JLabel imgFail;
		ImageIcon fail;*/
		fail = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\fail.jpg");
		imgFail = new JLabel(fail);
		
		// bossImgs[0] = imgBoss01;
		// bossImgs[1] = imgBoss02;
		// bossImgs[2] = imgBoss03;
		// enemyImgs = imgEnemy01,imgEnemy02,imgEnemy03,imgEnemy04;
		/*
		 * enemyImgs[0].setBounds(20, 20, 50, 50); enemyImgs[1].setBounds(70,
		 * 70, 50, 50); enemyImgs[2].setBounds(120, 120, 50, 50);
		 * enemyImgs[3].setBounds(170, 170, 50, 50); enemyImgs[4].setBounds(220,
		 * 220, 50, 50); enemyImgs[5].setBounds(270, 270, 50, 50);
		 * enemyImgs[6].setBounds(320, 320, 50, 50);
		 */
		// JLabel[] imgEnemy01;
		// imgEnemy01 = new JLabel[]{ new JLable(enemy01)};
		// imgEnemy01.setBounds(330, 0, 80, 80);

		fighter = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\fighter1.png");
		imgFighter = new JLabel(fighter);
		imgFighter.setBounds(330, 680, 80, 80);

		bullet01 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\bullet1.png");
		imgBullet01 = new JLabel(bullet01);
		bullet02 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\bullet2.png");
		imgBullet02 = new JLabel(bullet02);
		bullet03 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\bullet3.png");
		imgBullet03 = new JLabel(bullet03);
		bullet04 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\bullet4.png");
		imgBullet04 = new JLabel(bullet04);
		bullet05 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\bullet5.png");
		imgBullet05 = new JLabel(bullet05);
		bullet06 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\bullet6.png");
		imgBullet06 = new JLabel(bullet06);
		bulletImgs[0] = imgBullet01;
		bulletImgs[1] = imgBullet02;
		bulletImgs[2] = imgBullet03;
		bulletImgs[3] = imgBullet04;
		bulletImgs[4] = imgBullet05;
		bulletImgs[5] = imgBullet06;
		// ArrayList bList = new ArrayList();
		// JLabel[] bList1 = { imgBullet, imgBullet, imgBullet, imgBullet,
		// imgBullet, imgBullet, imgBullet };
		// imgBullet.setBounds(330, 720, 30, 30);
		// fighter1 =
		// Toolkit.getDefaultToolkit().getImage("C:\\Workspace\\workspace\\TargetPoint\\src\\fighter1.png");

		paint = new ImageIcon("�븞�뀞�븯�꽭�슂");
		paintComponents = new JLabel(paint);
		paintComponents.setBounds(40, 40, 80, 80);

		record = new JLabel("湲곕줉 : ");
		record.setBounds(550, 40, 60, 60);

		first = new JLabel("1�쐞 : ");
		first.setBounds(550, 100, 60, 60);
		second = new JLabel("2�쐞 : ");
		second.setBounds(550, 160, 60, 60);
		third = new JLabel("3�쐞 : ");
		third.setBounds(550, 220, 60, 60);
		// ctp.add(btn);
		// ctp.add(imgShooter);
		// ctp.add(imgShot);
		/*
		 * Graphics gs = this.getGraphics(); ge.drawImage(bi, 0, 0, 300, 500,
		 * this);
		 */
		// Boss1, 2, 3 �씠誘몄� 異붽�
		bullet01 = new ImageIcon("C:\\Workspace\\workspace\\TargetPoint\\src\\bullet1.png");
		imgBullet01 = new JLabel(bullet01);

		// scores = new JLabel("score : " + score);
		// scores.setBounds(40, 40, 70, 70);
		int en = 10;
		
		
		ctp.add(record);
		ctp.add(first);
		ctp.add(second);
		ctp.add(third);
		ctp.add(imgEnemy01);
		ctp.add(imgEnemy02);
		ctp.add(imgEnemy03);
		ctp.add(imgEnemy04);
		ctp.add(imgEnemy05);
		ctp.add(imgEnemy06);
		ctp.add(imgEnemy07);
		ctp.add(imgEnemy08);
		ctp.add(imgEnemy09);
		ctp.add(imgEnemy10);
		ctp.add(imgEnemy11);
		ctp.add(imgEnemy12);
		ctp.add(imgEnemy13);
		ctp.add(imgEnemy14);

		ctp.add(imgFighter);
		ctp.add(l1);

		ctp.add(imgBullet01);
		ctp.add(imgBullet02);
		ctp.add(imgBullet03);
		ctp.add(imgBullet04);
		ctp.add(imgBullet05);
		ctp.add(imgBullet06);

		ctp.add(imgBoss01);
		ctp.add(imgBoss02);
		ctp.add(imgBoss03);

		// Graphics gs = bi.getGraphics();
		// gs.drawString("Score : "+Integer.toString(score), 80, 80);
		// ctp.add(scores);
		ctp.add(imgFail);
		ctp.add(paintComponents);
		// ctp.add(imgBackground);
		// JLabel scores = new JLabel("score : " + score);

	}

	private void start() {
		btn.addActionListener(this);

	}

	/*
	 * private void score(){ JTextArea ta = new JTextArea(40,40); //ad }
	 */
	/*
	 * // score �굹���궡湲�
	 * 
	 * @Override public void paintComponents(Graphics g) { g.drawString(
	 * "Score : ", 40, 40); g.drawLine(40, 40, 80, 80); g.drawRect(10, 30, 100,
	 * 100); }
	 */

	/* int y = 720; */

	int score = 0;
	int life = 3;
	int bossLife = 6;
	@Override
	public void run() {
		// System.out.println(dx);
		// System.out.println(keyControl());
		int enCnt = 0;
		int msCnt = 0;
		int boCnt = 0;
		/*
		 * System.out.println("�쁽�옱 score : " + score); scores = new JLabel(
		 * "score : " + score); scores.setBounds(40, 40, 90, 90);
		 * 
		 * scores.setSize(70, 70); ctp.add(scores); ctp.add(imgBackground);
		 */
		while (true) {
			try {
				Thread.sleep(60);

				if(life == 0){
					start = false;
					imgFail.setBounds(270, 150, 200, 150);
					end = true;
					score = 0;
					
				}
				if (start) {
					// fihter�쓽 諛⑺뼢�궎 �엯�젰 媛�
					/*if(bossLife==0){
						bossList.remove(0);
					}*/
					if (keyControl() == dx) {
						x += keyControl();
					} else if (keyControl() == dy)
						y += keyControl();
					imgFighter.setBounds(x, y, 80, 80);

					// enemy�쓽 �깮�꽦
					if (enCnt > 850) {
						enemyCreate();
						enCnt = 0;
					}
					if (msCnt >= 50) {
						fireMs();
						msCnt = 0;
					}
					if(boCnt >= 300){
						bossCrashChk();
						boCnt = 0;
					}
					msCnt += 10;
					enCnt += 10;
					boCnt += 10;
					draw();
					crashChk();
					
					// System.out.println(life);
					// System.out.println(msCnt);
					if (score > 500 && bc == true) {
						bossCreate();
						bc = false;
					}
					//System.out.println("�쟾�닾湲곗쓽 �씪�씠�봽"+life+"\n");
					//System.out.println("蹂댁뒪�쓽 �씪�씠�봽" + bossLife);
					System.out.println("�쁽�옱 score : "+ score);
					System.out.println("�쁽�옱 life : " + life);
					System.out.println("�쁽�옱 bossLife : " + bossLife);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// System.out.println("\n�쐞 y�쓽 媛�"+keyControl()+up);
			// System.out.println("�븘�옒 y�쓽 媛�"+keyControl()+down);
			// System.out.println("�쇊履� x�쓽 媛�"+keyControl()+left);
			// System.out.println("�삤瑜몄そ x�쓽 媛�"+keyControl()+right+"\n");
		}
	}

	public void bossCreate() {
		int n = 1;
		if (n == 1) {
			Boss bo = new Boss(50, 50);
			bossList.add(bo);
			n = 0;
		}
		//System.out.println("bbbbbbbbbbbbbbbb留뚮벉?");
	}
	//paint瑜� �궗�슜�븯硫� 
	public void paint(){
		
	}
	// 紐⑤뱺 媛앹껜瑜� 洹몃젮二쇰뒗 硫붿꽌�뱶
	
	public void draw() {

		/*
		 * scores = new JLabel("score : " + score); scores.setBounds(40, 40, 70,
		 * 70); ctp.add(scores);
		 */
		// System.out.println("�쁽�옱 score : " + score);
		scores = new JLabel("score :  ");
		scores = new JLabel("score :  " + score);
		scores.setBounds(40, 40, 100, 60);

		lifes = new JLabel("lifes : ");
		lifes = new JLabel("lifes : " + life);
		lifes.setBounds(40, 80, 60, 60);
		// JLabel life;
		// scores.setSize(70, 70);
		ctp.add(lifes);
		ctp.add(scores);
		ctp.add(imgBackground);
		// System.out.println("�쁽�옱 score : " + score);
		/*
		 * Graphics gs = bi.getGraphics(); gs.fillRect(0, 0, 100, 100);
		 * gs.setColor(Color.BLACK); gs.drawString("Score : "
		 * +Integer.toString(score), w , 70);
		 */

		// 誘몄궗�씪�쓽 異쒕젰怨� ��吏곸엫�쓣 �떞�떦.
		for (int i = 0; i < misileList.size(); i++) {
			// System.out.println("誘몄궗�씪�쓽 媛��닔�쓽 �궗�씠利� "+ misileList.size());
			Ms m = (Ms) misileList.get(i);
			bulletImgs[i].setBounds(m.x, m.y, m.w, m.h);
			/*
			 * if(m.y < -80){ misileList.remove(i); }
			 */
			m.moveMs();
		}

		// JLabel[] enemyImgs = new JLabel[7];
		// �쟻湲곗쓽 異쒕젰怨� ��吏곸엫�쓣 �떞�떦.
		for (int i = 0; i < enemyList.size(); i++) {
			// System.out.println("�쟻湲곗쓽 媛��닔�쓽 �궗�씠利�" + enemyList.size());
			Enemy e = (Enemy) enemyList.get(i);
			enemyImgs[i].setBounds(e.x, e.y, e.w, e.h);
			// imgEnemy01.setBounds(e.x, e.y, e.w, e.h);
			if (score >= 300) {
				e.moveEn(15);
			}
			e.moveEn(5);
			// �쁽�옱
			// 肉뚮젮二쇱뿀�뜕 �쟻湲� 媛앹껜留뚯쓣 �젣嫄고빐二쇱뼱�빞 �븯�뒗�뜲
			// if(e.y > y+350){ if(i>6){ enemyList.remove(i); } }
			// if(score >= 500){ e.moveEn(15); }else{ }
		}
		// boss�쓽 異쒕젰怨� ��吏곸엫�쓣 �떞�떦.
		for (int i = 0; i < bossList.size(); i++) {
			// System.out.println("蹂댁뒪 異쒗쁽濡쒖쭅");
			Boss b = (Boss) bossList.get(0);
			imgBoss02.setBounds(b.x, b.y, b.w, b.h);
			// System.out.println("蹂댁뒪 ��吏곸엫");
			if (b.x == 0) {
				bm = true;
			} else if (b.x == 1000 - 500) {
				bm = false;
			}
			if (bm == true) {
				b.moveEn();
				b.moveHeight();
			} else if (bm == false) {
				b.moveEn2();
				b.moveHeight2();
			}
		}

		/*if (end == true || life == 0) {

		}*/
		/*
		 * for (int i = 0; i < enemyList.size(); i++) { Enemy e = (Enemy)
		 * enemyList.get(i); if (e.y > y) { enemyList.remove(i); } if (score >=
		 * 300) { e.moveEn(20); } else { e.moveEn(10); } }
		 */
	}

	// enemy �깮�꽦
	public void enemyCreate() {
		for (int i = 0; i < 6; i++) {
			double rx = Math.random() * 700;
			double ry = Math.random() * 50;
			Enemy en = new Enemy((int) rx, (int) ry);
			enemyList.add(en);

			Enemy e = enemyList.get(i);
			if (e.y > y + 350) {
				enemyList.remove(i);
			}
		}
	}

	// 異⑸룎 泥댄겕
	public void crashChk() {
		Polygon p = null;
		Polygon p1 = null;
		for (int i = 0; i < misileList.size(); i++) {
			Ms m = misileList.get(i);
			for (int j = 0; j < enemyList.size(); j++) {
				Enemy e = enemyList.get(j);
				/*
				 * if(m.x < e.w && m.x > e.x && m.y < e.h && m.y >e.y){
				 * System.out.println(
				 * "異⑸룎 諛쒖깮!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 * misileList.remove(i); enemyList.remove(i); score += 20; }
				 */
				// 誘몄궗�씪 x醫뚰몴, 誘몄궗�씪 x醫뚰몴+誘몄궗�씪�쓽�몢猿�, 誘몄궗�씪�쓽 x醫뚰몴+誘몄궗�씪�쓽�몢猿�, 留덉궗�씪�쓽 x醫뚰몴
				int[] xpoints = { m.x, (m.x + m.w), (m.x + m.w), m.x };
				int[] ypoints = { m.y, m.y, (m.y + m.h), (m.y + m.h) };
				p = new Polygon(xpoints, ypoints, 4);
				if (p.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {
					//bulletImgs[i].setBounds(-30, 0, 0, 0);
					misileList.remove(i);
					//enemyImgs[j].setBounds(0, 0, 0, 0);
					enemyList.remove(j);
					// misileList.remove(i);
					// enemyList.remove(j);
					score += 20;
				}

			}
		}
		int x = 330, y = 720, w = 80, h = 80, xw = 40, xh = 40;
		// �궎�엯�젰�뿉�꽌 �엯�젰諛쏆븘 run�뿉�꽌 fighter�쓽 x醫뚰몴�� y醫뚰몴�뿉 �뜑�빐吏�硫댁꽌
		// 鍮꾪뻾湲곗쓽 ��吏곸엫�씠 蹂�寃쎈맂�떎.
		int dx, dy;
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			// System.out.println("留뚮뱾�뼱議뚮땲?");
			// 330, 330+40, 330+40, 330
			int[] xpoints = { this.x, (this.x + this.xw), (this.x + this.xw), this.x };
			// 720,
			int[] ypoints = { this.y, this.y, (this.y + this.xh), (this.y + this.xh) };
			p1 = new Polygon(xpoints, ypoints, 4);
			if (p1.intersects((double) e.x, (double) e.y, (double) e.w, (double) e.h)) {
				enemyList.remove(i);
				life = life - 1;
			}
		}

	}
	
	// �쟾�닾湲곗� 蹂댁뒪���쓽 異⑸룎 怨꾩궛
	public void bossCrashChk(){
		Polygon p2 = null;
		Polygon p3 = null;
		for (int i = 0; i < bossList.size(); i++) {
			Boss b = (Boss) bossList.get(0);
			int[] xpoints = { this.x, (this.x + this.xw), (this.x + this.xw), this.x };
			int[] ypoints = { this.y, this.y, (this.y + this.xh), (this.y + this.xh) };
			p2 = new Polygon(xpoints, ypoints, 4);
			if (p2.intersects((double) b.x, (double) b.y, (double) b.w, (double) b.h)) {
				life = life -1;
				
			}
		}
		//誘몄궗�씪怨� 蹂댁뒪���쓽 異⑸룎濡� �씤�븳 蹂댁뒪 �씪�씠�봽寃뚯씠吏� 媛먯냼
		for(int i=0; i<misileList.size(); i++){
			Ms m = misileList.get(i);
			for(int j=0; j<bossList.size(); j++){
				Boss b = bossList.get(j);
				int[] xpoints = { m.x, (m.x + m.w), (m.x + m.w), m.x };
				int[] ypoints = { m.y, m.y, (m.y + m.h), (m.y + m.h) };
				p3 = new Polygon(xpoints, ypoints, 4);
				if(p3.intersects((double)b.x, (double)b.y, (double)b.w, (double)b.h)){
					if(bossLife==0){
						score= score+500;
						imgBoss02.setBounds(0, 0, 0, 0);
						
						bossList.remove(j);
					}
					misileList.remove(i);
					bossLife = bossLife -1;
					
				}
			}
		}
		
	}
	
	
	public int keyControl() {
		if (left == true) {
			dx = -20;
			return dx;
		}
		if (right == true) {
			dx = 20;
			return dx;
		}
		if (up == true) {
			dy = -20;
			return dy;
		}
		if (down == true) {
			dy = 20;
			return dy;
		}
		return 0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			// System.out.println("�삤瑜몄そ");
			// dx += 3;
			right = true;
			break;
		case KeyEvent.VK_LEFT:
			// System.out.println("�쇊履�");
			// dx -= 3;
			left = true;
			break;
		case KeyEvent.VK_UP:
			// System.out.println("�쐞");
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			// System.out.println("�븘�옒");
			down = true;
			break;
		case KeyEvent.VK_CONTROL:
			// System.out.println("誘몄궗�씪 鍮듭빞");
			fire = true;
			// new BulletThread(imgBullet, x, y).start();;
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("�젙吏��떆�궗爰쇱빞!!!!!!!!!!!");
			start = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			//System.out.println("false濡� 諛붽퓭以�!!!!!!!!");
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_CONTROL:
			fire = false;
			break;
		case KeyEvent.VK_SPACE:
			start = true;
			end = false;
			//Thread.this.start();
			break;
		case KeyEvent.VK_S:
			start = false;
			break;
		}

	}

	// 誘몄궗�씪 諛쒖궗 硫붿꽌�뱶
	public void fireMs() {
		if (fire == true) {
			if (misileList.size() < 100) {
				Ms m = new Ms(this.x, this.y);
				misileList.add(m);
			}
			for (int i = 0; i < misileList.size(); i++) {
				Ms m = misileList.get(i);
				if (m.y < -80) {
					misileList.remove(i);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("�굹媛��깘?");
		// flag = true;
		Object sc = e.getSource();
		if (sc == g1) {
			System.out.println("�옱�떆�옉");
			// new EnemyThread(imgEnemy01).start();
			// new BulletThread(imgBullet, fire, this.x, this.y).start();
			start = true;
			new Thread().start();
			//new Game();
		} else if (sc == g2) {
			System.out.println("score �닚�쐞");
			AppContext.f2 = new Frame2();

		} else if (sc == sys1) {
			System.out.println("議곗옉諛⑸쾿");
			AppContext.f3 = new Frame3();
		} else if (sc == sys2) {
			System.exit(0);
			// stop
		}

		/*
		 * switch(sc){ case "g1": break; case 2: break; case 3: break;
		 * 
		 * }
		 */

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	class Ms {
		int x;
		int y;
		int w = 30;
		int h = 30;

		public Ms(int x, int y) {
			this.x = x + 25;
			this.y = y + 25;
		}

		public void moveMs() {
			/*
			 * double xmove = Math.random() * 100; if ((int) xmove % 2 == 1) { x
			 * -= 10; } else { x += 10; }
			 */

			y = y - 30;
		}

	}

	class Enemy {
		int x;
		int y;
		int w = 80;
		int h = 80;

		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void moveEn(int i) {
			/*
			 * double xmove = Math.random() * 100; if ((int) xmove % 2 == 1) { x
			 * -= 20; } else { x += 20; }
			 */

			y = y + 10 + i;
		}

	}

	class Boss {
		int x;
		int y;
		int w = 350;
		int h = 250;

		public Boss(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void moveEn() {
			x = x + 10;
		}

		public void moveEn2() {
			x = x - 5;
		}

		public void moveHeight() {
			y = y + 10;
		}

		public void moveHeight2() {
			y = y - 5;
		}

	}
	/*
	 * class Panel extends JPanel{ //score �굹���궡湲�
	 * 
	 * @Override public void paintComponents(Graphics g) { g.drawString(
	 * "Score : " , 40, 40); g.drawLine(40, 40, 80, 80); g.drawRect(10, 30, 100,
	 * 100); }
	 * 
	 * }
	 */

}
