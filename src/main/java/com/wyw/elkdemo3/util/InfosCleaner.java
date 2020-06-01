package com.wyw.elkdemo3.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyw.elkdemo3.model.BrowserInfos;

/**
 * @ClassName:InfosCleaner
 * @Author WYW
 * @Date28/05/202020:52
 * @Description: TODO
 * @Version V1.0
 **/
public class InfosCleaner {
	private static volatile InfosCleaner infosCleaner;
	final private static ObjectMapper om  = new ObjectMapper();


	private InfosCleaner(){}

	public static InfosCleaner getCleanerInstance(){
		if (infosCleaner == null){
			synchronized (InfosCleaner.class){
				if (infosCleaner == null){
					infosCleaner = new InfosCleaner();
				}
			}
		}
		return infosCleaner;
	}
	/**
	* @author WYW
	* @date 28/05/2020 20:55
	* @param
	* @return java.lang.String
	* @description  产生行为日志
	*/
	public String makeActionLog(){
		// 拿到信息处理器
		InfosCollector infosCollector = InfosCollector.infosHandlerInstance();

		String str = null;
		try {
			// 处理器收集events，再整合Browsers，并将其信息对象转换为json字符串,
			BrowserInfos bi = infosCollector.collectBrowserInfos(infosCollector.collectEventInfos());
			str = bi.getCustid() + "|" + bi.getEventCateGory() + "|" + om.writeValueAsString(infosCollector.collectEventInfos())
			+ "|" + bi.getTimezone();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
