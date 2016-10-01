package test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hankchan.dao.mybatis.DataRepository;
import cn.hankchan.user.service.UserDataServiceImpl;

public class Test {

	@org.junit.Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext xml = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
//		DataSource dataSource = (DataSource) xml.getBean("dataSource");
//		System.out.println(dataSource);
//		DataRepository repository = (DataRepository) xml.getBean("dataRepository");
//		System.out.println(repository);
		UserDataServiceImpl userDataService = (UserDataServiceImpl) xml.getBean("userDataService");
		System.out.println(userDataService);
		System.out.println(userDataService.getUserById("100001"));
	}
}
