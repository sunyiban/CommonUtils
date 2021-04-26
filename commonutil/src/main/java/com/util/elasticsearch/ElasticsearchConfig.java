package com.util.elasticsearch;

import java.io.Serializable;

public class ElasticsearchConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -104530860504612409L;

	private String connectionStr;
	
	private String clusterName;
	
	private String shieldUser;
	
	private String intervalTime;
	
	private Boolean sniff =true;
	
	private String httpUrl;
	
	private String username;
	
	private String password;
	
	private Boolean useAuth =true;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getUseAuth() {
		return useAuth;
	}

	public void setUseAuth(Boolean useAuth) {
		this.useAuth = useAuth;
	}

	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

	public Boolean getSniff() {
		return sniff;
	}

	public void setSniff(Boolean sniff) {
		this.sniff = sniff;
	}

	public String getConnectionStr() {
		return connectionStr;
	}

	public void setConnectionStr(String connectionStr) {
		this.connectionStr = connectionStr;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getShieldUser() {
		return shieldUser;
	}

	public void setShieldUser(String shieldUser) {
		this.shieldUser = shieldUser;
	}

	public String getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}
}
