package webchats.module.user.serivce;

import webchats.data.mybatis.DataRepository;
import webchats.lang.Criteria;
import webchats.module.user.entity.User;

public class UserDataServiceImpl implements UserDataService {

	DataRepository dataRepository;
	public void setDataRepository(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	@Override
	public User get(String userId) {
		//return dataRepository.get("get", User.class, userId);
		User result = dataRepository.get("get", User.class, new Criteria().with("userId", userId));
		return result != null ? result : null;
	}

	@Override
	public User delete(String userId) {
		return null;
	}

	@Override
	public User insert() {
		return null;
	}

	@Override
	public User update() {
		return null;
	}

}
