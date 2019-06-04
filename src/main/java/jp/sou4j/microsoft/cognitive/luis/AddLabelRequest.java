package jp.sou4j.microsoft.cognitive.luis;

import java.util.HashMap;

import com.google.gson.Gson;

public class AddLabelRequest {

	private String intentName;
	private String text;

	public AddLabelRequest(String intentName, String text) {
		this.intentName = intentName;
		this.text       = text;
	}

	public String getIntentName() {
		return intentName;
	}

	public String getText() {
		return text;
	}

	protected String toJsonString() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("text", this.text);
		map.put("intentName", this.intentName);
		return new Gson().toJson(map);
	}
}
