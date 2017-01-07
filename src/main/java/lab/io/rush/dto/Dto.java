package lab.io.rush.dto;

import org.json.JSONObject;

/**
 * 数据传输传顶级接口
 * @author cqy
 * @data 2017年1月7日 下午1:01:23
 */
public interface Dto {
	
	/**
	 * 转成json格式 
	 * @return json对象
	 */
	JSONObject toJson();

}
