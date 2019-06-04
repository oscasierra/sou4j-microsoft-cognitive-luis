package jp.sou4j.microsoft.cognitive.luis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class BatchAddLabelsRequest {

	private List<Map<String, String>> labels = new ArrayList<Map<String, String>>();

	public void add(String text, String intentName) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("text", text);
		map.put("intentName", intentName);

		this.labels.add(map);
	}

	protected String toJsonString() {
		Gson gson = new Gson();
		return gson.toJson(this.labels);
	}
}
