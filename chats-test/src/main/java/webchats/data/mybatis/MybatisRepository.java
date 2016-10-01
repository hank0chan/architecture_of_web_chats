package webchats.data.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * 封装Mybatis的操作
 * @author Hank_  
 * <p>Email:hicth_chan@163.com</p>
 * @version 创建时间: 28 Sep 201610:52:50
 * <p>类说明:
 */
public abstract class MybatisRepository {

	public static final String SUFFIX_MAPPER = "Mapper";
	
	protected String config = "config/mybatis/mybatis.xml";
	public void setConfig(String config) {
		this.config = config;
	}
	
	protected SqlSessionFactory sqlSessionFactory;
	
	protected DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	TransactionFactory transactionFactory;
	public void setTransactionFactory(TransactionFactory transactionFactory) {
		this.transactionFactory = transactionFactory;
	}
	
	public abstract void init();
	
	public void init(Class<?> ... resultClasses) {
		if(dataSource != null) {
			if(transactionFactory == null) transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("current", transactionFactory, dataSource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(new Configuration(environment));
		} else {
			try {
				InputStream inputStream = Resources.getResourceAsStream(config);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		Configuration configuration = sqlSessionFactory.getConfiguration();
		for(Class<?> resultClass : resultClasses) {
			try {
				Class<?> mapperClass = Class.forName(resultClass.getName() + SUFFIX_MAPPER);
				configuration.addMapper(mapperClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public void destory() { };
	
	/** 新增记录 */
	public <T> T create(T object) { // （在openSession方法中形参boolean autoCommit为true）
		try(SqlSession session = sqlSessionFactory.openSession(true)) {
			int n = session.insert(object.getClass().getName() + SUFFIX_MAPPER + ".create", object);
			return n > 0 ? object : null;
		}
	}
	/** 新增记录 */
	public <T> void insert(T object) { // 
		try(SqlSession session = sqlSessionFactory.openSession()) {
			session.selectOne(object.getClass().getName() + SUFFIX_MAPPER + ".insert", object);
		}
	}
	/** 删除记录 */
	public <T> int delete(Class<T> resultClass, Object param) { // （占位符参数直接使用实体类传参）
		try(SqlSession session = sqlSessionFactory.openSession(true)) {
			return session.delete(resultClass.getName() + SUFFIX_MAPPER + ".delete", param);
		}
	}
	/** 更新记录 */
	public <T> T update(T object) { // 
		try(SqlSession session = sqlSessionFactory.openSession(true)) {
			int n = session.update(object.getClass().getName() + SUFFIX_MAPPER + ".update", object);
			return n > 0 ? object : null;
		}
	}
	/** 获取单条记录 */
	public <T> T get(String verb, Class<T> resultClass, Object param) { // 
		try(SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne(resultClass.getName() + SUFFIX_MAPPER + "." + verb, param);
		}
	}
	/** 获取多条记录 */
	public <T> List<T> query(String verb, Class<T> resultClass, Object param) { // 
		try(SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectList(resultClass.getName() + SUFFIX_MAPPER + "." + verb, param);
		}
	}
	
}

