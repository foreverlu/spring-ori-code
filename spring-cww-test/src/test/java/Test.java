import com.cww.config.APpConfig;
import com.cww.lookupmethod.CommandClient;
import com.cww.service.IndexService;
import com.cww.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(APpConfig.class);
		CommandClient commandClient = ac.getBean("commandClient", CommandClient.class);
		commandClient.execute();
//		ac.getBean(UserService.class);
//		ac.getBean(IndexService.class);

//		UserService userService = new UserService();
//		userService.i=10;
//		GenericApplicationContext gac = new GenericApplicationContext();
//		gac.refresh();
//		gac.getBeanFactory().registerSingleton("userService",userService);
//		UserService userService1 = gac.getBean("userService", UserService.class);
//		System.out.println(userService1.i);

	}


}
