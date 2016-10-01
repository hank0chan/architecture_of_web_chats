package cn.hankchan.user.service;

import cn.hankchan.dao.mybatis.DataRepository;
import cn.hankchan.data.user.entity.User;
import cn.hankchan.user.UserDataService;

public class UserDataServiceImpl implements UserDataService {

	DataRepository dataRepository;
	public void setDataRepository(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	public User getUserById(String userId) {
		return dataRepository.get("get", User.class, userId);
	}
}
