package com.wyw.elkdemo3.dao;



import com.wyw.elkdemo3.model.UserAction;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
* @author WYW
* @date 29/05/2020 14:55
* @param
* @return
* @description
*/
public interface UserActionDAO extends ElasticsearchRepository<UserAction,String> {

}
