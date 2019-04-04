package com.xh.common;

public class ResultUtil {
	public static Result success(Object data) {
		Result result= new Result();
		result.setCode(200);
		result.setMsg("执行成功");
		result.setData(data);
		return result;
	}

	public static Result error(String msg) {
		Result result = new Result();
		result.setCode(500);
		if(msg==null || "".equals(msg)){
			result.setMsg("执行出错");
		}else{
			result.setMsg(msg);
		}
		return result;
	}
}

