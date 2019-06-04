package jp.sou4j.microsoft.cognitive.luis;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

public class URIFactory {

	/**
	 * <p>"models - add closed list's sublist" の Request URI を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param clEntityId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/590c5dc65aca2f04a0d3d684
	 * @throws URISyntaxException 
	 */
	public static URI getAddClosedListsSublistURI(String location, String appId, String versionId, String clEntityId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/closedlists/"+clEntityId+"/sublists")
			.build();
	}
	
	/**
	 * <p>"example utterances - Add label" の Request URI を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @throws URISyntaxException 
	 */
	public static URI getAddLabelURI(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/example")
			.build();
	}

	/**
	 * <p>"patterns - Add pattern" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getAddPatternURI(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/patternrule")
			.build();
	}

	/**
	 * <p>"example utterances - Batch add labels" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getBatchAddLabelsURI(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/examples")
			.build();
	}
	
	/**
	 * <p>"models - Get closed list entity" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param clEntityId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/5890b47c39e2bb052c5b9c26
	 * @throws URISyntaxException
	 */
	public static URI getClosedListEntityURI(String location, String appId, String versionId, String clEntityId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/closedlists/"+clEntityId)
			.build();
	}
	
	/**
	 * <p>"models - Create closed list entity" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/5890b47c39e2bb052c5b9c14
	 * @throws URISyntaxException
	 */
	public static URI getCreateClosedListEntityURI(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/closedlists")
			.build();
	}

	/**
	 * <p>"models - Create intent" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/5890b47c39e2bb052c5b9c0c
	 * @throws URISyntaxException
	 */
	public static URI getCreateIntentURI(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/intents")
			.build();
	}
	
	/**
	 * <p>"models - Delete closed list entity" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param clEntityId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/5890b47c39e2bb052c5b9c29
	 * @throws URISyntaxException
	 */
	public static URI getDeleteClosedListEntityURI(String location, String appId, String versionId, String clEntityId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/closedlists/"+clEntityId)
			.build();
	}
	
	/**
	 * <p>"models - Delete sublist entity" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param clEntityId
	 * @param subListId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/5890b47c39e2bb052c5b9c2c
	 * @throws URISyntaxException
	 */
	public static URI getDeleteSublistEntityURI(String location, String appId, String versionId,String clEntityId, String subListId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/closedlists/"+clEntityId+"/sublists/"+subListId)
			.build();
	}

	/**
	 * <p>"example utterances - Delete example labels" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param exampleId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getDeleteExampleLabelsURI(String location, String appId, String versionId, Integer exampleId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/examples/"+exampleId)
			.build();
	}

	/**
	 * <p>"models - Delete intent" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param intentId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getDeleteIntentURI(String location, String appId, String versionId, String intentId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/intents/"+intentId)
			.build();
	}

	/**
	 * <p>"train - Get version training status" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getGetVersionTrainingStatusURI(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/train")
			.build();
	}

	/**
	 * <p>"v2.0 Response - Get predictions from endpoint" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param q
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getGetPredictionsFromEndpointURI(String location, String appId, String q) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/v2.0/apps/"+appId)
			.setParameter("q", q)
			.setParameter("timezoneOffset", "0")
			.setParameter("verbose", "true")
			.setParameter("spellCheck", "false")
			.setParameter("staging", "false")
			.build();
	}
	
	/**
	 * <p>"models - Rename entity" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param entityId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/5890b47c39e2bb052c5b9c1e
	 * @throws URISyntaxException
	 */
	public static URI getRenameEntityURI(String location, String appId, String versionId, String entityId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/entities/"+entityId)
			.build();
	}

	/**
	 * <p>"example utterances - Review labeled examples" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getReviewLabeledExamplesURI(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/examples")
			.build();
	}

	/**
	 * <p>"train - Train application version" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getTrainApplicationVersion(String location, String appId, String versionId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/train")
			.build();
	}

	/**
	 * <p>"apps - Publish application" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @return
	 * @throws URISyntaxException
	 */
	public static URI getPublishApplication(String location, String appId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/publish")
			.build();
	}
	
	/**
	 * <p>"apps - Update closed list entity" の Request URL を、URI オブジェクトで返却します。</p>
	 * @param location
	 * @param appId
	 * @param versionId
	 * @param clEntityId
	 * @return
	 * @see https://westus.dev.cognitive.microsoft.com/docs/services/5890b47c39e2bb17b84a55ff/operations/5890b47c39e2bb052c5b9c27
	 * @throws URISyntaxException
	 */
	public static URI getUpdateClosedListEntity(String location, String appId, String versionId, String clEntityId) throws URISyntaxException {
		return new URIBuilder()
			.setScheme("https")
			.setHost(location+".api.cognitive.microsoft.com")
			.setPath("/luis/api/v2.0/apps/"+appId+"/versions/"+versionId+"/closedlists/"+clEntityId)
			.build();
	}
	
}
