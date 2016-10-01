package webchats.module.user.serivce;

import webchats.module.user.entity.User;

public interface UserDataService {

	public User get(String userId);
	
	public User delete(String userId);
	
	public User insert();
	
	public User update();
	
}
