package webchats.apis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import webchats.lang.APIResult;
import webchats.util.TimeUtils;

/**
 * 响应用户的注册账号等相关请求的API接口
 * @author Hank_  
 * <p>Email:hicth_chan@163.com</p>
 * @version 创建时间: 28 Sep 201610:04:21
 * <p>类说明:
 */
@Controller
public class TestAPIs {

	// ==success
	@RequestMapping("/test.json")
	public @ResponseBody APIResult test() {
		APIResult result = APIResult.prepare();
		Map<String, String> map = new HashMap<>();
		map.put("name", "DavidBeckham");
		map.put("age", "35");
		map.put("team", "Man United");
		map.put("time", TimeUtils.YYYYMMDDHHMMSSFFF.format(new Date()));
		return map != null ? result.ok(map) : result.error("failure..");
	}
}
