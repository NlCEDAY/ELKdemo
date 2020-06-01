package com.wyw.elkdemo3.services;


import com.wyw.elkdemo3.dao.UserActionDAO;
import com.wyw.elkdemo3.model.TempBIObject;
import com.wyw.elkdemo3.model.UserAction;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:UserActionServices
 * @Author WYW
 * @Date28/05/202023:36
 * @Description: TODO
 * @Version V1.0
 **/
@Service
public class UserActionServices {
	@Autowired
	private UserActionDAO uad;

	// 分组查询
	public Map<String,List<TempBIObject>> findCount(){
		org.elasticsearch.script.Script script = new Script("doc['time'].values + '#' + doc['eventCateGory'].values");
		TermsAggregationBuilder group = AggregationBuilders.terms("niceday").script(script).size(1000);
		NativeSearchQueryBuilder nqb = new NativeSearchQueryBuilder();
		nqb.addAggregation(group);
		AggregatedPage<UserAction> acts = (AggregatedPage<UserAction>)uad.search(nqb.build());
		StringTerms terms = (StringTerms)acts.getAggregation("niceday");
		List<StringTerms.Bucket> buckets = terms.getBuckets();
		Map<String, List<TempBIObject>> change = change(buckets);
		for (Map.Entry<String, List<TempBIObject>> stringListEntry : change.entrySet()) {
			System.out.println(stringListEntry.getKey() + "+" + stringListEntry.getValue());
		}
		return change;

	}


	private Map<String,List<TempBIObject>> change(List<StringTerms.Bucket> bck){
		Map<String, List<TempBIObject>> groups = new HashMap<>();
		// 将所有数据封装成对象中
		for (StringTerms.Bucket bucket : bck) {
			String[] split = bucket.getKeyAsString().split("#");
			// 通过事件的名称到分组集合中获取事件组集合
			List<TempBIObject> tbo = null;
			//填充map的链表
			if(groups.containsKey(split[0])){
				tbo = groups.get(split[0]);
			}else {
				tbo = new ArrayList<>();
				groups.put(split[0],tbo);
			}
			// 塞成排序对象，将对象塞到链表里
			TempBIObject tempBIObject = new TempBIObject();
			tempBIObject.setValue(bucket.getDocCount());
			tempBIObject.setName(split[1]);
			tbo.add(tempBIObject);
		}
		return groups;
	}
}
