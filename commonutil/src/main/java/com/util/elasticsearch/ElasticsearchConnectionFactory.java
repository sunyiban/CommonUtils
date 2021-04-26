package com.util.elasticsearch;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ElasticsearchConnectionFactory {

	private ElasticsearchConfig config;

	private RestHighLevelClient client;

	public void init() {
		if (client == null) {
			String[] adsport = config.getConnectionStr().split(";");
			String[] _str;
			HttpHost[] h = new HttpHost[adsport.length];

			for (int i = 0; i < adsport.length; i++) {
				_str = adsport[i].split(":");
				h[i] = new HttpHost(_str[0], Integer.parseInt(_str[1]));
			}

			RestClientBuilder builder = RestClient.builder(h);

			if (config.getUseAuth()) {
				final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
				credentialsProvider.setCredentials(AuthScope.ANY,
						new UsernamePasswordCredentials(config.getUsername(), config.getPassword()));

				builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
					@Override
					public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
						return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
					}
				});
			}
			client = new RestHighLevelClient(builder);
		}
	}

	public void setConfig(ElasticsearchConfig config) {
		this.config = config;
	}

	public RestHighLevelClient getClient() {
		return client;
	}

	public void close() {
		try {
			if (client != null) {
				client.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
