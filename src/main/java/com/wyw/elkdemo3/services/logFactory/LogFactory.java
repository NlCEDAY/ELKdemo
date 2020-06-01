package com.wyw.elkdemo3.services.logFactory;

public interface LogFactory{
	UserLog createUserLogThread();
	ServerLog createServerLogThread();
}
