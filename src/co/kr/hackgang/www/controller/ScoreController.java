package co.kr.hackgang.www.controller;

import static co.kr.hackgang.www.controller.AppContext.*;
import java.util.Vector;

import co.kr.hackgang.www.dao.ScoreDao;
import co.kr.hackgang.www.vo.ScoreVo;

public class ScoreController {
	
	public static void doProcess(int command){
		switch(command){
		//case AppContext.OUTPUT:
		case OUTPUT:
			System.out.println("OUPUT!");
			Vector<Vector> rowData = scoreDao.selectAll();
			//System.out.println("�Ѿ?");
			request.put("rowData", rowData);
			//System.out.println("���⵵?");
			break;
		case INPUT:
			System.out.println("INPUT!");
			ScoreVo scoreVo = (ScoreVo)request.get("scoreVo");
			int cnt = ScoreDao.insertScore(scoreVo);
			if(cnt>0){
				System.out.println("ó������");
			}else{
				System.out.println("ó������");
			}
			break;
		case DELETE:
			System.out.println("DELETE!");
	         ScoreVo scoreVoDel = (ScoreVo)(request.get("scoreVo"));
	        // System.out.println("1111111111111111");
	         AppContext.scoreDao.deleteScore(scoreVoDel);
	         //System.out.println("asdqweasd");
			
			break;
			default: System.out.println("�ش� ����!");
		}
	}
	
}
