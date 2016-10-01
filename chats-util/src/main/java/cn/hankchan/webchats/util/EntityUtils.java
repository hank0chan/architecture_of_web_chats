package cn.hankchan.webchats.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 实体类工具类
 * @author Hank_  
 * <p>Email:hicth_chan@163.com</p>
 * @version 创建时间: 18 Sep 201616:27:39
 * <p>类说明: 获取实体类的属性及方法等
 */
public class EntityUtils {

	static Map<Class<?>, Map<String, Method>> gettersCache = new HashMap<Class<?>, Map<String, Method>>();

	public static Map<String, Method> fetchGetters(Class<?> targetClass) {
		try {
			Map<String, Method> getters = new HashMap<String, Method>();
			Field[] fields = targetClass.getDeclaredFields();
			Method[] methods = targetClass.getDeclaredMethods();
			for(Field field : fields) {
				String key = field.getName();
				for(Method method : methods) {
					if(method.getName().equalsIgnoreCase("get" + key) && method.getParameterTypes().length == 0) {
						getters.put(key, method);
					}
				}
			}
			return getters;
		} catch(Exception x) {
			throw new RuntimeException(x);
		}
	}

	public static Map<String, Method> getGetters(Class<?> targetClass) {
		synchronized(gettersCache) {
			if(gettersCache.containsKey(targetClass)) return gettersCache.get(targetClass);
			Map<String, Method> getters = fetchGetters(targetClass);
			gettersCache.put(targetClass, getters);
			return getters;
		}
	}

}
