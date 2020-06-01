package com.wyw.elkdemo3.model;

/**
 * @ClassName:Browsers
 * @Author WYW
 * @Date28/05/202000:48
 * @Description: TODO
 * @Version V1.0
 **/
public class BrowserInfos {
	private int custid;
	private String eventCateGory;
	private Events events;
	private String timezone;
	private static BrowserInfos browserInfos;


	public static BrowserInfos getBrowserInstance(){
		if (browserInfos == null){
			synchronized (BrowserInfos.class){
				if (browserInfos == null){
					browserInfos = new BrowserInfos();
				}
			}
		}
		return browserInfos;
	}

	private BrowserInfos(){}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getEventCateGory() {
		return eventCateGory;
	}

	public void setEventCateGory(String eventCateGory) {
		this.eventCateGory = eventCateGory;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
}
