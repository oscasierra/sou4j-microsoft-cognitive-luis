package jp.sou4j.microsoft.cognitive.luis;

import java.util.HashMap;

import com.google.gson.Gson;

public class PublishApplicationRequest {

	private String versionId;
	private boolean isStaging;
	private String region;

	public PublishApplicationRequest(String versionId, boolean isStaging, String region) {
		this.versionId = versionId;
		this.isStaging = isStaging;
		this.region    = region;
	}
	public String getVersionId() {
		return versionId;
	}
	public boolean isStaging() {
		return isStaging;
	}
	public String getRegion() {
		return region;
	}

	protected String toJsonString() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("versionId", this.getVersionId());
		map.put("isStaging", this.isStaging);
		map.put("region", this.region);
		return new Gson().toJson(map);
	}
}
