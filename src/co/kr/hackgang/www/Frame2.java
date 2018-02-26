package co.kr.hackgang.www;

import java.awt.BorderLayout;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.kr.hackgang.www.controller.AppContext;
import co.kr.hackgang.www.controller.ScoreController;
import co.kr.hackhang.www.view.FormPane;

//import org.comstudy21.sist.Day23JTableEx2.view.FormPane;

public class Frame2 extends JFrame{
	
	public JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;

	private Vector<Vector> rowData;
	private Vector colNames;
	
	public Frame2() {
		init();
		start();
		setVisible(true);
	}


	private void init() {
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		makeTable();

		setTitle("점수 기록창");
		setSize(450, 850);
		setLocation(1300, 70);
		
	}

	private void makeTable() {
		Object[] colNameArr = {"USER", "SCORE"};
		
		colNames = new Vector<>(Arrays.asList(new Object[] { "USER", "SCORE" }));


		tableModel = new DefaultTableModel(rowData, colNames);
		table = new JTable(tableModel);

		// contentPane.add(table);
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		FormPane formPane = new FormPane();
		contentPane.add(formPane, BorderLayout.SOUTH);
		
		outputList();
	}

	public void outputList() {
		ScoreController.doProcess(AppContext.OUTPUT);

		rowData = (Vector<Vector>) (AppContext.request.get("rowData"));
		System.out.println("rowData의 확인");
		tableModel.setDataVector(rowData, colNames);
	}

	private void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
