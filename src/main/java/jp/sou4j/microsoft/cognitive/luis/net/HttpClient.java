package jp.sou4j.microsoft.cognitive.luis.net;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import jp.sou4j.util.Objects;

public class HttpClient {

	private String subscriptionKey;

	public HttpClient(String subscriptionKey) {
		Objects.requireNonNullOrEmpty(subscriptionKey, "Method argument 'subscriptionKey' is null or empty.");
		this.subscriptionKey = subscriptionKey;
	}

	/**
	 * <p>指定されたURIにHTTPのDELETEメソッドでアクセスして、そのレスポンスボディ文字列を返却します。</p>
	 * @param uri URI
	 * @return レスポンスボディ文字列
	 * @throws IOException
	 */
	public String delete(URI uri) throws IOException {
		try( CloseableHttpClient httpClient = HttpClients.createDefault(); ) {
			HttpDelete httpDelete = new HttpDelete(uri);
			httpDelete.setHeader("Content-Type", "application/json");
			httpDelete.setHeader("Ocp-Apim-Subscription-Key", this.subscriptionKey);
			httpDelete.setConfig(this.getDefaultRequestConfig());

			String body = null;
			try ( CloseableHttpResponse httpResponse = httpClient.execute(httpDelete); ) {
				if( httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK ) {
					body = EntityUtils.toString(httpResponse.getEntity());
				}
				else {
					// TODO : もっと適切な例外をスローする
					throw new IOException("ステータスエラー : " + httpResponse.getStatusLine().getStatusCode() + "/ " + EntityUtils.toString(httpResponse.getEntity()));
				}
			}
			catch(Exception exception) {
				throw exception;
			}

			return body;
		}
		catch(IOException exception) {
			throw exception;
		}
	}

	/**
	 * <p>指定されたURIにHTTPのGETメソッドでアクセスして、そのレスポンスボディ文字列を返却します。</p>
	 * @param uri URI
	 * @return レスポンスボディ文字列
	 * @throws IOException
	 */
	public String get(URI uri) throws IOException {
		try( CloseableHttpClient httpClient = HttpClients.createDefault(); ) {
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Content-Type", "application/json");
			httpGet.setHeader("Ocp-Apim-Subscription-Key", this.subscriptionKey);
			httpGet.setConfig(this.getDefaultRequestConfig());

			String body = null;
			try ( CloseableHttpResponse httpResponse = httpClient.execute(httpGet); ) {
				int httpStatus = httpResponse.getStatusLine().getStatusCode();
				if( httpStatus == HttpStatus.SC_OK || httpStatus == HttpStatus.SC_CREATED ) {
					body = EntityUtils.toString(httpResponse.getEntity());
				}
				else {
					// TODO : もっと適切な例外をスローする
					throw new IOException("ステータスエラー : " + httpResponse.getStatusLine().getStatusCode() + "/ " + EntityUtils.toString(httpResponse.getEntity()));
				}
			}
			catch(Exception exception) {
				throw exception;
			}

			return body;
		}
		catch(IOException exception) {
			throw exception;
		}
	}

	/**
	 * <p>指定されたURIにHTTPのPOSTメソッドでアクセスして、そのレスポンスボディ文字列を返却します。</p>
	 * @param uri URI
	 * @return レスポンスボディ文字列
	 * @throws IOException
	 */
	public String post(URI uri, String body) throws IOException {
		try( CloseableHttpClient httpClient = HttpClients.createDefault(); ) {
			HttpPost httpPost = new HttpPost(uri);
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setHeader("Ocp-Apim-Subscription-Key", this.subscriptionKey);
			httpPost.setConfig(this.getDefaultRequestConfig());
			StringEntity requestEntity = new StringEntity(body, "UTF-8");
			httpPost.setEntity(requestEntity);

			try ( CloseableHttpResponse httpResponse = httpClient.execute(httpPost); ) {
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				if( statusCode == HttpStatus.SC_CREATED || statusCode == HttpStatus.SC_ACCEPTED ) {
					body = EntityUtils.toString(httpResponse.getEntity());
				}
				else {
					// TODO : もっと適切な例外をスローする
					throw new IOException("ステータスエラー : " + httpResponse.getStatusLine().getStatusCode() + "/ " + EntityUtils.toString(httpResponse.getEntity()));
				}
			}
			catch(Exception exception) {
				throw exception;
			}

			return body;
		}
		catch(IOException exception) {
			throw exception;
		}
	}
	
	/**
	 * <p>指定されたURIにHTTPのPUTメソッドでアクセスして、そのレスポンスボディ文字列を返却します。</p>
	 * @param uri URI
	 * @return レスポンスボディ文字列
	 * @throws IOException
	 */
	public String put(URI uri, String body) throws IOException {
		try( CloseableHttpClient httpClient = HttpClients.createDefault(); ) {
			HttpPut httpPut = new HttpPut(uri);
			httpPut.setHeader("Content-Type", "application/json");
			httpPut.setHeader("Ocp-Apim-Subscription-Key", this.subscriptionKey);
			httpPut.setConfig(this.getDefaultRequestConfig());
			StringEntity requestEntity = new StringEntity(body, "UTF-8");
			httpPut.setEntity(requestEntity);

			try ( CloseableHttpResponse httpResponse = httpClient.execute(httpPut); ) {
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				if( statusCode == HttpStatus.SC_OK) {
					body = EntityUtils.toString(httpResponse.getEntity());
				}
				else {
					// TODO : もっと適切な例外をスローする
					throw new IOException("ステータスエラー : " + httpResponse.getStatusLine().getStatusCode() + "/ " + EntityUtils.toString(httpResponse.getEntity()));
				}
			}
			catch(Exception exception) {
				throw exception;
			}

			return body;
		}
		catch(IOException exception) {
			throw exception;
		}
	}

	private RequestConfig getDefaultRequestConfig() {
		return RequestConfig.custom()
			//.setSocketTimeout(3000)
			//.setConnectTimeout(3000)
			.build();
	}
}
