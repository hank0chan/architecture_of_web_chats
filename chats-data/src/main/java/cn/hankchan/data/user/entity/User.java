package cn.hankchan.data.user.entity;

public class User {

	private String userId;
	private String username;
	private String age;
	private String birth;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", age=" + age + ", birth=" + birth + "]";
	}
	
}
