package co.kr.hackgang.www.controller;

import java.util.HashMap;

import co.kr.hackgang.www.Frame2;
import co.kr.hackgang.www.Frame3;
import co.kr.hackgang.www.dao.ScoreDao;

public class AppContext {
	public static final int OUTPUT = 1;
	public static final int INPUT = 2;
	public static final int DELETE = 3;
	
	public static final ScoreDao scoreDao = new ScoreDao();
	public static final ScoreController controller = new ScoreController();
	
	public static final HashMap<String, Object> request = new HashMap<>();

	public static Frame2 f2;
	public static Frame3 f3;
	
}
