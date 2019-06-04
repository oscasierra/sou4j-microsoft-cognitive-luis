package jp.sou4j.microsoft.cognitive.luis;

import java.util.ArrayList;
import java.util.List;

public class GetClosedListEntityResponse {
	private String id;
	private String name;
	private List<SubListResponse> subLists;
	
	public GetClosedListEntityResponse(String id, String name) {
		this.id = id;
		this.name = name;
		this.subLists = new ArrayList<SubListResponse>();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubListResponse> getSubLists() {
		return subLists;
	}

	public void addSubList(SubListResponse subList) {
		this.subLists.add(subList);
	}


	public class SubListResponse {
		private String id;
		private String canonicalForm;
		private List<String> list;
		
		public SubListResponse(String id, String canonicalForm){
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
		
		public void setList(String addList) {
			list.add(addList);
		}
	}
}

