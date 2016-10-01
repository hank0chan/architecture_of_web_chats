package webchats.module.user;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import webchats.module.user.entity.User;
import webchats.module.user.serivce.UserDataServiceImpl;

public class TestDataService {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext xml = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		UserDataServiceImpl userDataService = (UserDataServiceImpl) xml.getBean("userDataService");
		User result = userDataService.get("100001");
		System.out.println(result);
	}
}
