package jp.sou4j.microsoft.cognitive.luis;

public class PublishApplicationResponse {

	private String endpointUrl;
	private String subscriptionKey;
	private String westus;
	private boolean isStaging;

	public String getEndpointUrl() {
		return endpointUrl;
	}
	public void setEndpointUrl(String endpointUrl) {
		this.endpointUrl = endpointUrl;
	}
	public String getSubscriptionKey() {
		return subscriptionKey;
	}
	public void setSubscriptionKey(String subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}
	public String getWestus() {
		return westus;
	}
	public void setWestus(String westus) {
		this.westus = westus;
	}
	public boolean isStaging() {
		return isStaging;
	}
	public void setStaging(boolean isStaging) {
		this.isStaging = isStaging;
	}

}
