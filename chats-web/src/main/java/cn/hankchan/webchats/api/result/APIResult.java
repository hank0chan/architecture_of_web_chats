package cn.hankchan.webchats.api.result;

import java.util.HashMap;

public class APIResult extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	long timestamp;

	public APIResult() {
		super();
		timestamp = System.currentTimeMillis();
	}

	public static APIResult prepare() {
		return new APIResult();
	}

	public APIResult ok(Object result) {
		this.put("ok", true);
		this.put("result", result);
		this.put("elapsed",  System.currentTimeMillis() - timestamp);
		return this;
	}

	public APIResult error(String message) {
		this.put("ok", false);
		//this.put("code", -1);
		this.put("message", message);
		this.put("elapsed",  System.currentTimeMillis() - timestamp);
		return this;
	}

	public APIResult error(int code, String message) {
		this.put("ok", false);
		//this.put("code", code);
		this.put("message", message);
		this.put("elapsed",  System.currentTimeMillis() - timestamp);
		return this;
	}

}
