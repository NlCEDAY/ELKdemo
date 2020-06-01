package com.wyw.elkdemo3.model;

import java.util.Date;

/**
* @author WYW
* @date 29/05/2020 13:26
* @param
* @return
* @description
*/
public class Events {
	private String  clicktime;
	private String browse;

	private static volatile Events events;


	private Events() {
	}

	public static Events getEventInstance(){
		if (events == null){
			synchronized (Events.class){
				if (events == null){
					events = new Events();
				}
			}
		}
		return events;
	}

	public Events(String clicktime, String browse) {
		this.clicktime = clicktime;
		this.browse = browse;
	}

	public String getClicktime() {
		return clicktime;
	}

	public void setClicktime(String clicktime) {
		this.clicktime = clicktime;
	}

	public String getBrowse() {
		return browse;
	}

	public void setBrowse(String browse) {
		this.browse = browse;
	}
}
