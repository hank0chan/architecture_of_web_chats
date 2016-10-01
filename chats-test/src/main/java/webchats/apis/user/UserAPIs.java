package webchats.apis.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webchats.lang.APIResult;
import webchats.module.user.entity.User;
import webchats.module.user.serivce.UserDataService;

/**
 * 响应用户个人信息相关的API接口
 * @author Hank_  
 * <p>Email:hicth_chan@163.com</p>
 * @version 创建时间: 28 Sep 201610:29:08
 * <p>类说明:
 */
@Controller
public class UserAPIs {

	@Autowired
	UserDataService userDataService;
	
	@RequestMapping("/user/getuserby-{userId0}.json")
	public @ResponseBody APIResult getUserById(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("userId0") String userId0,
			@RequestParam(value="userId",required=false) String userId) {
		APIResult result = APIResult.prepare();
		User user = userDataService.get(userId0);
		if(user != null) {
			return result.ok(user);
		} else {
			return result.error("Failure..");
		}
	}
}
