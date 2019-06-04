package jp.sou4j.microsoft.cognitive.luis;

public class Intent {

	private String intent;
	private Double score;

	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
}
