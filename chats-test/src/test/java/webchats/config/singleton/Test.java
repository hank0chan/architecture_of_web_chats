package webchats.config.singleton;

public class Test {

	@org.junit.Test
	public void test() {
		ConfigSingleton configSingleton = ConfigSingleton.getInstance();
		System.out.println(configSingleton);
	}
}
