import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.fcb.integration.FCBSendSMS;
import com.fcb.integration.config.FCBIntegrationConfig;

public class TestAppClass {

	public static void main(String[] args) {
		ApplicationContext ct=new AnnotationConfigApplicationContext(FCBIntegrationConfig.class);
		FCBSendSMS fcbSendSMS=ct.getBean("FCBSendSMS",FCBSendSMS.class);
		String responce=fcbSendSMS.sendSMS("8084225043", "Hello");
		System.out.println(responce);
	}
}
