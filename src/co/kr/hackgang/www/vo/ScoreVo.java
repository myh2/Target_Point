package co.kr.hackgang.www.vo;

public class ScoreVo {
	String user;
	int score;

	public ScoreVo() {
	}

	public ScoreVo(String user, int score) {
		this.user = user;
		this.score = score;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ScoreVo [user=" + user + ", score=" + score + "]";
	}

}
