package jp.sou4j.microsoft.cognitive.luis;

import java.util.HashMap;

import com.google.gson.Gson;

public class CreateIntentRequest {

	private String name;

	public CreateIntentRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	protected String toJsonString() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("name", this.getName());
		return new Gson().toJson(map);
	}
}
