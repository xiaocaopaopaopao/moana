package lab.io.rush.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import lab.io.rush.dto.Dto;

/**
 * ��Ӧ������
 * @author cqy
 * @data 2017��1��7�� ����1:09:49
 */
public class ResponseHelper {
	
	/**
	 * ��ͻ��˷�����Ӧ��Ϣ
	 * @param response ��Ӧ����
	 * @param dto ���ݴ������
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
	 * ��ͻ��˷�����Ӧ��Ϣ(����)
	 * @param response ��Ӧ����
	 * @param message ��Ϣ�ı�
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
