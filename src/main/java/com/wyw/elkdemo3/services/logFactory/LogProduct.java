package com.wyw.elkdemo3.services.logFactory;

/**
 * @ClassName:ServerLogFactory
 * @Author WYW
 * @Date28/05/202001:06
 * @Description: TODO
 * @Version V1.0
 **/
public class LogProduct implements LogFactory {

	@Override
	public UserLog createUserLogThread() {
		return UserLog.getInstance("action");
	}

	@Override
	public ServerLog createServerLogThread() {
		return null;
	}
}
