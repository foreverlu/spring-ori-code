import com.cww.config.AppConfig;
import com.cww.service.IndexService;
import com.cww.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//		ac.getBean(UserService.class);
		ac.getBean(IndexService.class);
	}


}
