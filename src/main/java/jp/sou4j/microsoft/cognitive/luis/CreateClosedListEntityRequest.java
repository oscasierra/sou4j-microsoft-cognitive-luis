package jp.sou4j.microsoft.cognitive.luis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class CreateClosedListEntityRequest {
	private String name;
	private List<SubList> subLists;

	public CreateClosedListEntityRequest(String name) {
		this.name     = name;
		this.subLists = new ArrayList<SubList>();
	}

	public String getName() {
		return name;
	}

	public List<SubList> getSubLists() {
		return subLists;
	}
	
	public void addSubList(SubList subList) {
		this.subLists.add(subList);
	}

	public String toJsonString() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", this.getName());
		map.put("sublists", this.getSubLists());
		
		String json = new Gson().toJson(map);
		json = json.replace("\"list\":[\"\"]", "\"list\":[]");
		return json;
	}

	
	public class SubList {

		private String id;
		private String canonicalForm;
		private List<String> list;
		
		public SubList(String id, String canonicalForm){
			this.setId(id);
			this.setCanonicalForm(canonicalForm);
			this.list = new ArrayList<String>();
			}
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		public String getCanonicalForm() {
			return canonicalForm;
		}
		
		public void setCanonicalForm(String canonicalForm) {
			this.canonicalForm = canonicalForm;
		}
		
		public List<String> getList() {
			return list;
		}
		
		public void addList(String addList) {
			list.add(addList);
		}
	}

}
