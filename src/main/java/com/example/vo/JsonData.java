package com.example.vo;

/**
 * 返回JSON数据
 * @author amos
 */  
public class JsonData {
	private int code;
	private String tip = "";
	private Object data = new Object();

	public String getTip() {
		if (tip == "") {
			tip = "success";
		}
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
