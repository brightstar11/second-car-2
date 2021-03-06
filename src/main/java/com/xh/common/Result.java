package com.xh.common;
public class Result {

	/** 响应码 */
	private Integer code;

	/** 提示信息 */
	private String msg;

	/** 具体的内容 */
	private Object data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
         this.code = code;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}