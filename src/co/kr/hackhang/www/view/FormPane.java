package co.kr.hackhang.www.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.ControllerEventListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.kr.hackgang.www.controller.*;
import co.kr.hackgang.www.vo.*;

//Panel상속받은 클래스는 패널이다. 패널 자체이다. 
public class FormPane extends JPanel {
	public static JLabel userLbl = new JLabel("USER");
	public static JTextField userTxt = new JTextField(8);
	public static JLabel scoreLbl = new JLabel("SCORE");
	public static JTextField scoreTxt = new JTextField(8);
	public static JButton okBtn1 = new JButton("Insert");
	public static JButton okBtn2 = new JButton("Delete");

	public FormPane() {
		this.add(userLbl);
		this.add(userTxt);
		this.add(scoreLbl);
		this.add(scoreTxt);
		this.add(okBtn1);
		this.add(okBtn2);

		okBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = userTxt.getText();
				int score = Integer.parseInt(scoreTxt.getText());

				ScoreVo scoreVo = new ScoreVo(user, score);
				AppContext.request.put("scoreVo", scoreVo);

				ScoreController.doProcess(AppContext.INPUT);
				AppContext.f2.outputList();

				userTxt.setText("");
				scoreTxt.setText("");

			}
		});
		okBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ScoreVo scoreVo = new ScoreVo(user, score);
				String user = userTxt.getText();
				ScoreVo scoreVoDel = new ScoreVo(user, 0);
				AppContext.request.put("scoreVo", scoreVoDel);

				ScoreController.doProcess(AppContext.DELETE);
				AppContext.f2.outputList();
				userTxt.setText("");
				/*ScoreController.doProcess(AppContext.DELETE);
				AppContext.f2.outputList();*/
			}
		});

	}

}