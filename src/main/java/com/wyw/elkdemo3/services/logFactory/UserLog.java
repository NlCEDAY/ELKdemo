package com.wyw.elkdemo3.services.logFactory;


import com.wyw.elkdemo3.util.InfosWriter;

/**
 * @ClassName:UserlogProduct
 * @Author WYW
 * @Date28/05/202001:06
 * @Description: TODO
 * @Version V1.0
 **/

//@Configuration
//如果只有一个主配置类文件，@PropertySource可以不写
//@PropertySource("classpath:application.yml")
public class UserLog extends Thread {
	private static volatile UserLog userlog;


	private UserLog(String threadName) {
		setName(threadName);
	}

	// 单例
	public static UserLog getInstance(String threadName){
		if (userlog == null){
			synchronized (UserLog.class){
				if (userlog == null){
					userlog = new UserLog(threadName);
				}
			}
		}
		return userlog;
	}



	@Override
	public void run(){
		InfosWriter infosWriter = new InfosWriter();
		String name = Thread.currentThread().getName();
		int circle = 300;
		if (name.equalsIgnoreCase("action")){
			circle = 100000;
		}
		for (int i = 0; i < circle; i++) {
			infosWriter.writeLog(name);
		}
	}








}
