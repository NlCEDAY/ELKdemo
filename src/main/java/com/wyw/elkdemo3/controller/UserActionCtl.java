package com.wyw.elkdemo3.controller;



import com.wyw.elkdemo3.model.TempBIObject;
import com.wyw.elkdemo3.services.UserActionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
* @author WYW
* @date 29/05/2020 14:55
* @param
* @return
* @description
*/
@RestController
public class UserActionCtl {
	@Autowired
	private UserActionServices uas;

	@RequestMapping("/fenzu")
	public Map<String,List<TempBIObject>> groupAndCount(){
		return uas.findCount();
	}
}
