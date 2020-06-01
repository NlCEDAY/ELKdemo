package com.wyw.elkdemo3.util;


import com.wyw.elkdemo3.model.BrowserInfos;
import com.wyw.elkdemo3.model.Events;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
* @author WYW
* @date 29/05/2020 13:37
* @param
* @return
* @description
*/
public class InfosCollector {
	private static Random random = new Random();
	private static Properties proInstance = new Properties();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static Date date;
	private static Calendar cal = Calendar.getInstance();
	private static InputStream resourceAsStream = InfosCollector.class.getClassLoader().getResourceAsStream("browserinfos.properties");
	static {
		cal.set(2000,1,1,0,0,0);
		date = cal.getTime();
	}

	private static volatile InfosCollector infosCollector;

	private InfosCollector(){}

	public static InfosCollector infosHandlerInstance() {
		if (infosCollector == null){
			synchronized (InfosCollector.class){
				if (infosCollector == null){
					infosCollector = new InfosCollector();
				}
			}
		}
		return infosCollector;

	}

	private Properties readProperties(){
		try {
			proInstance.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return proInstance;
	}



	private int randNum(int bound){
		return random.nextInt(bound);
	}


	public Events collectEventInfos(){
		Events eventInstance = Events.getEventInstance();

		// 给对象赋值
		eventInstance.setBrowse(readProperties().getProperty("browserInfos[" + randNum(2) + "].browse"));
		eventInstance.setClicktime(sdf.format(date));


		cal.add(Calendar.MINUTE,1);
		date = cal.getTime();

		return eventInstance;
	}


	public BrowserInfos collectBrowserInfos(Events events){
		BrowserInfos browserInfos = BrowserInfos.getBrowserInstance();

		// 给对象赋值
		browserInfos.setCustid(10000 + randNum(80000));
		browserInfos.setEventCateGory(readProperties().getProperty("browserInfos[" + randNum(3) + "].eventCateGory"));
		browserInfos.setEvents(events);
		browserInfos.setTimezone(readProperties().getProperty("browserInfos[" + randNum(2) + "].timezone"));


		return browserInfos;
	}
}
