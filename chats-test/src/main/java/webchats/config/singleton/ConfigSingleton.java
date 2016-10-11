package webchats.config.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置一个用于读取配置信息的单例类模式
 * @author Hank_  
 * <p>Email:hicth_chan@163.com</p>
 * @version 创建时间: 11 Oct 2016 14:19:33
 * <p>类说明:
 */
public class ConfigSingleton {

	/** 配置信息 */
	public List<ConfigEntity> lists = null;
	public List<ConfigEntity> getLists() {
		return lists;
	}
	
	// 单例模式
	private static class ConfigSingleHolder {
		private static ConfigSingleton instance = new ConfigSingleton();
	}
	public static ConfigSingleton getInstance() {
		return ConfigSingleHolder.instance;
	}
	
	/** 只供内部调用的构造器 */
	private ConfigSingleton() {
		lists = new ArrayList<>();
		loadData();
	}
	
	/** 提供重新加载文件的方法（可以创建一个全局单例模式接口，并且提供该方法由子类实现，如此达到动态加载的目的） */
	public void reloadData() {
		lists.clear();
		loadData();
	}
	
	/** 加载文件获取配置信息 */
	public void loadData() {
		//TODO 具体实现，略
	}
}
