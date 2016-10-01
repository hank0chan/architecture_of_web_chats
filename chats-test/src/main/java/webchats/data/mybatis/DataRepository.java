package webchats.data.mybatis;

import webchats.module.user.entity.User;

public class DataRepository extends MybatisRepository {

	@Override
	public void init() {
		init(User.class);
	}

}
