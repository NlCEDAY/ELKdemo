package com.wyw.elkdemo3.services.logFactory;

import java.util.Properties;

/**
 * @ClassName:Serverlog
 * @Author WYW
 * @Date28/05/202001:21
 * @Description: TODO
 * @Version V1.0
 **/
public class ServerLog {
	private ServerLog() {}

	private static volatile ServerLog serverLog;

	public static ServerLog getInstance(){
		if (serverLog == null){
			synchronized (UserLog.class){
				if (serverLog == null){
					serverLog = new ServerLog();
				}
			}
		}
		return serverLog;
	}

	public String makeServiceLog(){

		try {
			Properties properties = Properties.class.newInstance();

		} catch (Exception e) {
			e.printStackTrace();
		}


		return null;

	}
}
