package jp.sou4j.microsoft.cognitive.luis;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class BatchAddLabelsResponse {

	private List<Result> results = new ArrayList<Result>();

	public BatchAddLabelsResponse(String json) {
		JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
		for(int i=0; i<jsonArray.size(); i++) {
			JsonElement element = jsonArray.get(i);
			JsonObject value = element.getAsJsonObject().get("value").getAsJsonObject();

			String  utteranceText = value.get("UtteranceText").getAsString();
			Integer exampleId     = value.get("ExampleId").getAsInt();
			Boolean hasError      = element.getAsJsonObject().get("hasError").getAsBoolean();

			this.results.add(new Result(utteranceText, exampleId, hasError));
		}
	}

	public List<Result> getResults() {
		return this.results;
	}

	public class Result {

		private String utteranceText;
		private Integer exampleId;
		private Boolean error;

		public Result(String utteranceText, Integer exampleId, Boolean error) {
			this.utteranceText = utteranceText;
			this.exampleId     = exampleId;
			this.error         = error;
		}

		public String getUtteranceText() {
			return utteranceText;
		}
		public void setUtteranceText(String utteranceText) {
			this.utteranceText = utteranceText;
		}
		public Integer getExampleId() {
			return exampleId;
		}
		public void setExampleId(Integer exampleId) {
			this.exampleId = exampleId;
		}
		public Boolean hasError() {
			return error;
		}
		public void setError(Boolean error) {
			this.error = error;
		}
	}
}
