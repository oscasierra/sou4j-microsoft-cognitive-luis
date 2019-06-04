package jp.sou4j.microsoft.cognitive.luis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.GsonBuilder;

import jp.sou4j.microsoft.cognitive.luis.util.StringListUtils;

public class UpdateClosedListEntityRequest {

	private String name;
	private List<SubListUpdate> subLists;

	public UpdateClosedListEntityRequest(String name) {
		this.name     = name;
		this.subLists = new ArrayList<SubListUpdate>();
	}

	public String getName() {
		return name;
	}

	public List<SubListUpdate> getSubLists() {
		return subLists;
	}
	
	public void addSubList(SubListUpdate subList) {
		this.subLists.add(subList);
	}

	protected String toJsonString() {
		List<SubListUpdate> sublist = this.getSubLists();
		for(SubListUpdate update : sublist) {
			if( update.getList() != null ) {
				update.setList(StringListUtils.slim(update.getList()));
			}
		}

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", this.getName());
		map.put("sublists", sublist);
		return new GsonBuilder().serializeNulls().create().toJson(map);
	}

	
	public class SubListUpdate {
		private String id;
		private String canonicalForm;
		private List<String> list;
		
		public SubListUpdate(String id, String canonicalForm){
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

		public void setList(List<String> list) {
			this.list = list;
		}
	}

}
