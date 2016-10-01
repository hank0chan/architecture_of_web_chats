package cn.hankchan.webchats.lang;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.hankchan.webchats.util.EntityUtils;

/**
 * 作为数据库操作中占位符的入参参数Map集合
 * @author Hank_  
 * <p>Email:hicth_chan@163.com</p>
 * @version 创建时间: 18 Sep 201616:29:03
 * <p>类说明: 就是说可以作为SqlSession中的CRUD操作方法的形参中的输入参数。如：
 * <p>org.apache.ibatis.session.SqlSession.delete(String statement, Object parameter)
 *    中的parameter可以使用Criteria类直接设置key-value值，key对应SQL占位符，value对应占位符的值。
 * <p>推荐使用new Criteria().with("key", "prepareStatementParameter")作为上面方法的parameter参数值。
 * <p>因为直接使用new HashMap("key", "prepareStatementParameter")传参会失败。
 */
@SuppressWarnings({ "serial", "unchecked" })
public class Criteria extends HashMap<String, Object> {

	public static final boolean ASC = true;
	public static final boolean DESC = false;
	public static final Object[] NO_ARGS = new Object[0];

	public static Criteria of(Object target) {
		Criteria result = new Criteria();
		try {
			for(Map.Entry<String, Method> entry : EntityUtils.getGetters(target.getClass()).entrySet()) {
				result.put(entry.getKey(), entry.getValue().invoke(target, NO_ARGS));
			}
		} catch(Exception x) {
			throw new RuntimeException(x);
		}
		return result;
	}

	/** 
	 * 在Statement传参时可以直接new（如果直接new HashMap()会无效），示例如下：
	 * repository.delete(MessageQueue.class, new Criteria().with("messageId", messageId)) 
	 */
	public Criteria with(String key, Object value) {
		put(key, value);
		return this;
	}

	public Criteria without(String key, int value) {
		put("_" + key + "Not", value);
		return this;
	}

	public Criteria eq(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public Criteria ge(String key, Object value) {
		super.put("_" + key + "Min", value);
		return this;
	}

	public Criteria le(String key, Object value) {
		super.put("_" + key + "Max", value);
		return this;
	}

	public Criteria between(String key, Object minValue,  Object maxValue) {
		ge(key, minValue);
		le(key, maxValue);
		return this;
	}

	public Criteria like(String key, Object value) {
		super.put("_" + key + "Like", value);
		return this;
	}

	public Criteria order(String key, boolean ascOrDesc) {
		Map<String, Boolean> orders = (Map<String, Boolean>)get("_orders");
		if(orders == null) {
			orders = new LinkedHashMap<String, Boolean>();
			put("_orders", orders);
		}
		orders.put(key, ascOrDesc);
		return this;
	}

	public Criteria asc(String key) {
		return order(key, true);
	}

	public Criteria desc(String key) {
		return order(key, false);
	}

	public Criteria limit(int limit) {
		super.put("_limit", limit);
		return this;
	}

	public Criteria limit(int offset, int limit) {
		super.put("_offset", offset);
		super.put("_limit", limit);
		return this;
	}

}
