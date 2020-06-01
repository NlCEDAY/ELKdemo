package com.wyw.elkdemo3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:UserAction
 * @Author WYW
 * @Date28/05/202023:40
 * @Description: TODO
 * @Version V1.0
 **/
@Document(indexName = "users2" ,type = "useraction2")
public class UserAction implements Serializable {
	@JsonProperty("id")
	private String id;
	@JsonProperty("browse")
	private String browse;
	@JsonProperty("time")
	private String time;
	@JsonProperty("clicktime")
	private String position;
	@JsonProperty("eventCateGory")
	private String eventCateGory;
	@JsonProperty("userid")
	private String userid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrowse() {
		return browse;
	}

	public void setBrowse(String browse) {
		this.browse = browse;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEventCateGory() {
		return eventCateGory;
	}

	public void setEventCateGory(String eventCateGory) {
		this.eventCateGory = eventCateGory;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
