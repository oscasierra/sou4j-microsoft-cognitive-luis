package jp.sou4j.microsoft.cognitive.luis;

import java.util.Date;

public class GetVersionTrainingStatusResponseModel {

	private String modelId;
	private Details details;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public class Details {

		private int statusId;
		private String status;
		private int exampleCount;
		private Date trainingDateTime;
		private String failureReason;

		public int getStatusId() {
			return statusId;
		}
		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getExampleCount() {
			return exampleCount;
		}
		public void setExampleCount(int exampleCount) {
			this.exampleCount = exampleCount;
		}
		public Date getTrainingDateTime() {
			return trainingDateTime;
		}
		public void setTrainingDateTime(Date trainingDateTime) {
			this.trainingDateTime = trainingDateTime;
		}
		public String getFailureReason() {
			return failureReason;
		}
		public void setFailureReason(String failureReason) {
			this.failureReason = failureReason;
		}

	}

}
