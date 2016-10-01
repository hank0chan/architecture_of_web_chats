package webchats.apis.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webchats.lang.APIResult;

/**
 * 响应用户的注册账号等相关请求的API接口
 * @author Hank_  
 * <p>Email:hicth_chan@163.com</p>
 * @version 创建时间: 28 Sep 201610:04:21
 * <p>类说明:
 */
public class AccountAPIs {

	@RequestMapping("/test.json")
	public @ResponseBody APIResult test() {
		APIResult result = APIResult.prepare();
		
		return result.ok("test..");
	}
	
}
