package jp.sou4j.microsoft.cognitive.luis;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import jp.sou4j.microsoft.cognitive.luis.net.HttpClient;
import jp.sou4j.util.Objects;

public class LUIS {

	private String appId;
	private String versionId;
	private String location;
	private String subscriptionKey;

	/**
	 * <p>コンストラクタです。</p>
	 * @param appId アプリケーションID
	 * @param versionId バージョンID
	 * @param location ロケーション
	 * @param subscriptionKey サブスクリプションキー
	 */
	public LUIS(String appId, String versionId, String location, String subscriptionKey) {
		this.appId           = Objects.requireNonNullOrEmpty(appId,           "Method argument 'appId' is null or empty.");
		this.versionId       = Objects.requireNonNullOrEmpty(versionId,       "Method argument 'versionId' is null or empty.");
		this.location        = Objects.requireNonNullOrEmpty(location,        "Method argument 'location' is null or empty.");
		this.subscriptionKey = Objects.requireNonNullOrEmpty(subscriptionKey, "Method argument 'subscriptionKey' is null or empty.");
	}

	/**
	 * 
	 * @param clEntity エンティティID
	 * @return サブリストID
	 * @throws LUISException
	 */
	public String addClosedListsSubList(String clEntityId, AddClosedListsSublistRequest request) throws LUISException {
		try {
			// RUISにリクエストを送信します。
			String json = this.getHttpClient().post(URIFactory.getAddClosedListsSublistURI(this.location, this.appId, this.versionId, clEntityId), request.toJsonString());
			return json.replaceAll("\n", "").replaceAll(" ", "");		
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws LUISException
	 */
	public BatchAddLabelsResponse batchAddLabels(BatchAddLabelsRequest request) throws LUISException {
		try {
			// RUISにリクエストを送信します。
			String json = this.getHttpClient().post(URIFactory.getBatchAddLabelsURI(this.location, this.appId, this.versionId), request.toJsonString());
			return new BatchAddLabelsResponse(json);
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 * @param intentName インテント名
	 * @param text ラベルのテキスト
	 * @return 新たに作成したラベルのID
	 * @throws LUISException
	 */
	public int addLabel(AddLabelRequest request) throws LUISException {
		try {
			// RUISにリクエストを送信します。
			String json = this.getHttpClient().post(URIFactory.getAddLabelURI(this.location, this.appId, this.versionId), request.toJsonString());

			// 取得したJSON文字列を解析して、IDを返却します。
			JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
			int exampleId = jsonObject.get("ExampleId").getAsInt();
			return exampleId;
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * <p>新たにリスト型のエンティティを作成します。</p>
	 * @return 新たに作成したエンティティのID
	 * @throws LUISException
	 */
	public String createClosedListEntity(CreateClosedListEntityRequest request) throws LUISException {
		try {
			// RUISにリクエストを送信します。
			String json = this.getHttpClient().post(URIFactory.getCreateClosedListEntityURI(this.location, this.appId, this.versionId), request.toJsonString());
			return json.replaceAll("\"", "");
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * <p>新たにインテントを作成します。</p>
	 * @param name インテント名
	 * @return 新たに作成したインテントのID
	 * @throws LUISException
	 */
	public String createIntent(CreateIntentRequest request) throws LUISException {
		try {
			// RUISにリクエストを送信します。
			String json = this.getHttpClient().post(URIFactory.getCreateIntentURI(this.location, this.appId, this.versionId), request.toJsonString());
			return json.replaceAll("\"", "");
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * <p>指定されたIDのリスト型エンティティを削除します。</p>
	 * @param clEntityId エンティティID
	 * @throws LUISException
	 */
	public void deleteClosedListEntity(String clEntityId) throws LUISException {
		try {
			this.getHttpClient().delete(URIFactory.getDeleteClosedListEntityURI(this.location, this.appId, this.versionId, clEntityId));
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * <p>指定されたIDのラベルを削除します。</p>
	 * @param exampleId ラベルID
	 * @throws LUISException
	 */
	public void deleteExampleLabels(Integer exampleId) throws LUISException {
		try {
			this.getHttpClient().delete(URIFactory.getDeleteExampleLabelsURI(this.location, this.appId, this.versionId, exampleId));
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * <p>指定されたIDのインテントを削除します。</p>
	 * @param intentId インテントID
	 * @throws LUISException
	 */
	public void deleteIntent(String intentId) throws LUISException {
		try {
			// RUISにリクエストを送信します。
			this.getHttpClient().delete(URIFactory.getDeleteIntentURI(this.location, this.appId, this.versionId, intentId));
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * <p>指定されたIDのリスト型エンティティのサブリストを削除します。</p>
	 * @param clEntityId エンティティID
	 * @param subListId サブリストID
	 * @throws LUISException
	 */
	public void deleteSublistEntity(String clEntityId, String subListId) throws LUISException {
		try {
			// RUISにリクエストを送信します。
			this.getHttpClient().delete(URIFactory.getDeleteSublistEntityURI(this.location, this.appId, this.versionId, clEntityId, subListId));
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * <p>リスト型のエンティティの情報を取得します。。</p>
	 * @param intentId インテントID
	 * @throws LUISException
	 */
	public GetClosedListEntityResponse getClosedListEntity(String clEntityId) throws LUISException {
		try {
			String json = this.getHttpClient().get(URIFactory.getClosedListEntityURI(this.location, this.appId, this.versionId, clEntityId));
			GetClosedListEntityResponse listEntity = new Gson().fromJson(json, GetClosedListEntityResponse.class);
			return listEntity;
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * <p>モデルの学習状況を取得します。</p>
	 * @return
	 * @throws LUISException
	 */
	public List<GetVersionTrainingStatusResponseModel> getVersionTrainingStatus() throws LUISException {
		try {
			String json = this.getHttpClient().get(URIFactory.getGetVersionTrainingStatusURI(this.location, this.appId, this.versionId));

			Type type = new TypeToken<List<GetVersionTrainingStatusResponseModel>>(){}.getType();
			return (List<GetVersionTrainingStatusResponseModel>)new Gson().fromJson(json, type);
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * 
	 * @param versionId
	 * @param isStaging
	 * @param region
	 * @throws LUISException 
	 */
	public PublishApplicationResponse publishApplication(PublishApplicationRequest request) throws LUISException {
		try {
			String json = this.getHttpClient().post(URIFactory.getPublishApplication(this.location, this.appId), request.toJsonString());
			return new Gson().fromJson(json, PublishApplicationResponse.class);
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * <p>指定されたクエリ文字列で、Q&amp;Aを検索し、その結果を返却します。</p>
	 * @param query 検索クエリ文字列
	 * @return
	 * @throws LUISException
	 */
	public List<Intent> query(String query) throws LUISException {
		try {
			// LUIS API にアクセスし、レスポンスのJSON文字列を取得します。
			String json = this.getHttpClient().get(URIFactory.getGetPredictionsFromEndpointURI(this.location, this.appId, query));
	
			// 取得したJSON文字列を解析して、Intent情報を返却します。
			JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
			JsonArray intentsJsonArray = jsonObject.getAsJsonArray("intents");
			List<Intent> intents = new ArrayList<Intent>();
			for(int i=0; i<intentsJsonArray.size(); i++) {
				JsonElement element = intentsJsonArray.get(i);
				Intent intent = new Intent();
				intent.setIntent(element.getAsJsonObject().get("intent").getAsString());
				intent.setScore(element.getAsJsonObject().get("score").getAsDouble());
				intents.add(intent);
			}
	
			return intents;
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * <p>エンティティ名を変更します。</p>
	 * @param clEntityId
	 * @return 
	 * @throws LUISException
	 */
	public String renameEntity(String clEntityId, RenameEntityRequest request) throws LUISException {
		try {
			String json = this.getHttpClient().put(URIFactory.getRenameEntityURI(this.location, this.appId, this.versionId, clEntityId), request.toJsonString());
			return json.replaceAll("\"", "");
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	/**
	 * <p>学習を実行します。</p>
	 * @return
	 * @throws LUISException
	 */
	public int trainApplicationVersion() throws LUISException {
		try {
			String json = this.getHttpClient().post(URIFactory.getTrainApplicationVersion(this.location, this.appId, this.versionId), "");

			JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
			return jsonObject.get("statusId").getAsInt();
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}
	
	/**
	 * <p>エンティティのValuesとsynonymsを上書きします。</p>
	 * @return
	 * @throws LUISException
	 */
	public UpdateClosedListEntityResponse updateClosedListEntity(UpdateClosedListEntityRequest request, String clEntityId) throws LUISException {
		try {
			String json = this.getHttpClient().put(URIFactory.getUpdateClosedListEntity(this.location, this.appId, this.versionId, clEntityId), request.toJsonString());
			UpdateClosedListEntityResponse listEntity = new Gson().fromJson(json, UpdateClosedListEntityResponse.class);
			return listEntity;
		}
		catch(Exception exception) {
			throw new LUISException(exception.getMessage(), exception);
		}
	}

	private HttpClient getHttpClient() {
		return new HttpClient(this.subscriptionKey);
	}

}
