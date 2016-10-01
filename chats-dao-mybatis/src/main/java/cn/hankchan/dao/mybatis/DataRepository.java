package cn.hankchan.dao.mybatis;

import cn.hankchan.data.user.entity.User;

public class DataRepository extends MybatisRepository {

	@Override
	public void init() {
		init(User.class);
	}

}
