package com.dc.dal;

import com.dc.model.Scpool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class ScpoolRepositoryImpl implements ScpoolRepositoryDAL {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Scpool> findOrderReqByName(String name) throws Exception {
	  List<Scpool> queryResults = new ArrayList<>();
      try {
			Query query = new Query();
			query.addCriteria(Criteria.where("NAME").is(name));
			queryResults = mongoTemplate.find(query, Scpool.class);
      } catch (Exception e) {
        e.printStackTrace();
      }
	  return queryResults;
	}
	
	
	@Override
	public List<Scpool> findOrderReqByCode(String code) throws Exception {
	  List<Scpool> queryResults = new ArrayList<>();
      try {
			Query query = new Query();
			query.addCriteria(Criteria.where("code").is(code));
//			query.with(new Sort(new Order(Direction.DESC,"createTime")));
		  query.with(Sort.by(Sort.Order.desc("createTime")));
			queryResults = mongoTemplate.find(query, Scpool.class);
      } catch (Exception e) {
        e.printStackTrace();
      }
	  return queryResults;
	}
	
	@Override
	public List<Scpool> findAllScpool() throws Exception  {
	  List<Scpool> queryResults = new ArrayList<>();
      try {
			Query query = new Query();
			queryResults = mongoTemplate.find(query, Scpool.class);
      } catch (Exception e) {
        e.printStackTrace();
      }
	  return queryResults;
	}
	
	
	@Override
	public List<Scpool> findAllScpoolByEndDateStr(String endDateStr) throws Exception  {
	  List<Scpool> queryResults = new ArrayList<>();
      try {
			Query query = new Query();
			query.addCriteria(where("createTime").is(endDateStr));
			
			queryResults = mongoTemplate.find(query, Scpool.class);
      } catch (Exception e) {
        e.printStackTrace();
      }
	  return queryResults;
	}

	@Override
	public List<Scpool> findAllScpoolByMonitor(String monitor) throws Exception  {
		List<Scpool> queryResults = new ArrayList<>();
		try {
			Query query = new Query();
			query.addCriteria(where("monitor").is(monitor));
//			query.with(new Sort(new Order(Direction.ASC,"createTime")));
			query.with(Sort.by(Sort.Order.asc("createTime")));
			queryResults = mongoTemplate.find(query, Scpool.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("queryResults.size():"+queryResults.size());
		return queryResults;
	}

	@Override
	public List<Scpool> findAllScpoolByMonitorAndEndDateStr(String monitor, String endDateStr) throws Exception{
		List<Scpool> queryResults = new ArrayList<>();
		try {
			Query query = new Query();
			query.addCriteria(where("monitor").is(monitor));
			query.addCriteria(where("createTime").is(endDateStr));

			queryResults = mongoTemplate.find(query, Scpool.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryResults;
	}

	@Override
	public List<Scpool> findAllScpoolGteEndDateStr(String startDateStr,String nowDate, boolean is88, List<String> monitor) throws Exception  {
		// TODO Auto-generated method stub
		List<Scpool> queryResults = new ArrayList<>();
		try {
			Query query = new Query();
			query.addCriteria(where("createTime").gte(startDateStr).andOperator(where("createTime").lte(nowDate)));
			if(is88){
				Criteria c = new Criteria("monitor").in(monitor);
				query.addCriteria(c);
			}

			queryResults = mongoTemplate.find(query, Scpool.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryResults;
	}

}
