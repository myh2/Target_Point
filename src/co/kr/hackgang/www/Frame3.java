package co.kr.hackgang.www;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame3 extends JFrame{
	public JPanel contentPane;
	JLabel label01, label02, label03, label04,
			label05, label06, label07, label08;
	public Frame3() {
		init();
		draw();
		setVisible(true);
	}

	private void draw() {
		setLayout(null);
		label01.setBounds(100, 100, 200, 80);
		label02.setBounds(100, 180, 200, 80);
		label03.setBounds(100, 260, 200, 80);
		label04.setBounds(100, 340, 200, 80);
		label05.setBounds(100, 420, 200, 80);
	}

	private void init() {
		contentPane = new JPanel();
		setContentPane(contentPane);

		label01 = new JLabel("게임 스타트 => space bar");
		label02 = new JLabel("게임 일시정지 => s키");
		label03 = new JLabel("방향키 => 좌, 우, 위, 아래");
		label04 = new JLabel("미사일 발사 => ctrl");
		label05 = new JLabel("메뉴바 선택 => alr+1, alr+2");
		label06 = new JLabel("");
		label07 = new JLabel("");
		label08 = new JLabel("");
		
		
		contentPane.add(label01);
		contentPane.add(label02);
		contentPane.add(label03);
		contentPane.add(label04);
		contentPane.add(label05);
		contentPane.add(label06);
		contentPane.add(label07);
		contentPane.add(label08);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//makeTable();

		setTitle("설명서");
		setSize(400, 850);
		setLocation(200, 70);
	}


}
