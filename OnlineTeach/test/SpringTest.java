import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.service.IClassRoomService;

@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest extends AbstractJUnit4SpringContextTests {
	@Resource(name="classRoomService")
	IClassRoomService classRoomService;
	@Test
	public void test() {
		System.out.println(classRoomService.allClassRoom().size());
	}
}
