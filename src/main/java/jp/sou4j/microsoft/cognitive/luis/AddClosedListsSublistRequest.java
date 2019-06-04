package jp.sou4j.microsoft.cognitive.luis;

import java.util.HashMap;

import com.google.gson.Gson;

public class AddClosedListsSublistRequest {

	private String canonicalForm;
	private String list[];

	public AddClosedListsSublistRequest(String canonicalForm, String[] list) {
		this.canonicalForm = canonicalForm;
		this.list          = list;
	}
	
	public String getCanonicalForm() {
		return canonicalForm;
	}

	public String[] getList() {
		return list;
	}

	protected String toJsonString() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("canonicalForm", this.getCanonicalForm());
		map.put("list", this.getList());
		return new Gson().toJson(map);
	}
}
