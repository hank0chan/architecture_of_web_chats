package cn.hankchan.webchats.api.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hankchan.data.user.entity.User;
import cn.hankchan.user.UserDataService;
import cn.hankchan.user.service.UserDataServiceImpl;
import cn.hankchan.webchats.api.result.APIResult;

@Controller
public class UserAPIs {

	@Autowired
	UserDataServiceImpl userDataService;
	
	@RequestMapping("/test.json")
	public @ResponseBody APIResult test(HttpServletRequest req, HttpServletResponse rsp) {
		APIResult result = APIResult.prepare();
		Map<String, String> map = new HashMap<>();
		map.put("name", "DavidBeckham");
		map.put("age", "35");
		map.put("team", "Man United");
		map.put("time", new Date().toString());
		return map != null ? result.ok(map) : result.error("failure..");
	}
	
	@RequestMapping("/user.json")
	public @ResponseBody APIResult getUser() {
		APIResult result = APIResult.prepare();
		User user = userDataService.getUserById("100001");
		if(user != null) {
			return result.ok(user);
		} else {
			return result.error("query failure..");
		}
	}
	
}
