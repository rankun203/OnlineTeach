import javax.annotation.Resource;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.service.IClassRoomService;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@Ignore
public class SpringTest extends AbstractJUnit4SpringContextTests {
	/**
	 * 先确认有数据
	 */
	@Resource(name="classRoomService")
	IClassRoomService classRoomService;
	/**
	 * echo 11
	 */
	public void test() {
		System.out.println(classRoomService.allClassRoom().size());
	}
}
