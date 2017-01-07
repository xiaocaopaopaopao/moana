package lab.io.rush.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import lab.io.rush.dto.Dto;

/**
 * 响应帮助类
 * @author cqy
 * @data 2017年1月7日 下午1:09:49
 */
public class ResponseHelper {
	
	/**
	 * 向客户端返回响应消息
	 * @param response 响应对象
	 * @param dto 数据传输对象
	 */
	public void send(HttpServletResponse response, Dto dto){
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			out = response.getWriter();
			out.write(dto.toJson().toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}
	
	/**
	 * 向客户端返回响应消息(重载)
	 * @param response 响应对象
	 * @param message 消息文本
	 */
	public void send(HttpServletResponse response, String message){
		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		try {
			out = response.getWriter();
			out.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}
}
