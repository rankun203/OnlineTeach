import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.teachMng.onlineTeach.dto.ClassCoursePara;
import com.teachMng.onlineTeach.model.ClassRoom;
import com.teachMng.onlineTeach.model.Course;
import com.teachMng.onlineTeach.model.CoursePlanItem;
import com.teachMng.onlineTeach.model.Major;
import com.teachMng.onlineTeach.model.MajorsCourse;
import com.teachMng.onlineTeach.model.SchoolClass;
import com.teachMng.onlineTeach.model.Student;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.service.IClassRoomService;
import com.teachMng.onlineTeach.service.ICoursePlanItemService;
import com.teachMng.onlineTeach.service.ICourseService;
import com.teachMng.onlineTeach.service.IMajorService;
import com.teachMng.onlineTeach.service.IMajorsCourseService;
import com.teachMng.onlineTeach.service.ISchoolClassService;
import com.teachMng.onlineTeach.service.IStudentService;
import com.teachMng.onlineTeach.service.ITeacherService;

/*
 * 自动排课测试
 */
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class DaoTest extends AbstractJUnit4SpringContextTests{
	List<Student> students = null;
	List<ClassRoom> classRooms = null;
	List<Course> courses = null;
	List<Major> majors = null;
	List<MajorsCourse> majorsCourse = null;
	List<SchoolClass> schoolClasses = null;
	List<Teacher> teachers = null;
	List<CoursePlanItem> coursePlan = null;
	List<ClassCoursePara> ccp = null;
	@Resource(name="classRoomService")
	IClassRoomService classRoomService;
	@Resource(name="courseService")
	ICourseService courseService;
	@Resource(name="coursePlanItemService")
	ICoursePlanItemService coursePlanItemService;
	@Resource(name="majorService")
	IMajorService majorService;
	@Resource(name="schoolClassService")
	ISchoolClassService schoolClassService;
	@Resource(name="studentService")
	IStudentService studentService;
	@Resource(name="teacherService")
	ITeacherService teacherService;
	@Resource(name="majorsCourseService")
	IMajorsCourseService majorsCourseService;

	public void init() {    //初始化数据
		students = null;
		classRooms = null;
		courses = null;
		majors = null;
		majorsCourse = null;
		schoolClasses = null;
		teachers = null;
		coursePlan = new ArrayList<CoursePlanItem>();
		ccp = new ArrayList<ClassCoursePara>();		
		
		students = studentService.allStudent();
		classRooms = classRoomService.allClassRoom();
		courses = courseService.allCourse();
		majors = majorService.allMajor();
		majorsCourse = majorsCourseService.allMajorsCourse();
		schoolClasses = schoolClassService.allSchoolClass();
		teachers = teacherService.allTeacher();
	}
	public boolean checkCourse(List<MajorsCourse> mc, SchoolClass sc) {        //检查班级课程是否还没有排完
		Iterator<MajorsCourse> iter = mc.iterator();
		MajorsCourse msc ;
		while(iter.hasNext()) {
			msc = iter.next();
			//System.out.println(msc.getCourse().getCourseName() + "-->" + msc.getParagraph() + "-->" + getPlanPara(sc.getScID(), msc.getCourse().getCourseID()));
			if(msc.getParagraph() > getPlanPara(sc.getScID(), msc.getCourse().getCourseID())) {
				//System.out.println(msc.getCourse().getCourseName() + "-->" + msc.getParagraph() + "-->" + sc.getPlanPara());
				return true;    //此专业还有未安排的课程
			}
		}
		System.out.println(sc.getMajor().getMajorName() + sc.getScName() + "班 over!  ————————   " + mc.size());
		return false;
	}
	public List<CoursePlanItem> getCoursePlanByParagraph(int paragraph) {       //从所有的课程表中根据第几节课取出课程
		List<CoursePlanItem> _list = new ArrayList<CoursePlanItem>();
		Iterator<CoursePlanItem> _iter = coursePlan.iterator();
		CoursePlanItem _cpi;
		//System.out.println(coursePlan.size() + "______________________________***");
		while(_iter.hasNext()) {
			_cpi = _iter.next();
			//System.out.println(_cpi.getCpID() + "_>_" + _cpi.getCourse().getCourseName() + "_>_" + _cpi.getCpParagraph() + "_>_" + paragraph);
			if(_cpi.getCpParagraph() == paragraph) {
				_list.add(_cpi);
			}
		}
		return _list;
	}
	public Teacher findTeacher(int courseID, int scID) {        //看看此班级的这门课是否已经有教师
		//System.out.println("_________________________");
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		Teacher _teacher = null;
		while(_cpiIter.hasNext()) {
			_cpi = _cpiIter.next();
			if(_cpi.getCourse().getCourseID() == courseID && _cpi.getSchoolClass().getScID() == scID) {
				_teacher = _cpi.getTeacher();
				break;
			}
		}
		return _teacher;
	}
	private Teacher getAvailableTeacher(Course c, SchoolClass sc, int paragraph) {        //获取一个可用的教师
		//System.out.println(c.getTeachers());
		List<Teacher> _teachers = new ArrayList<Teacher>( c.getTeachers());
		Teacher t = null;
		Boolean b = true;
		Iterator<Teacher> _iter = _teachers.iterator();
		List<CoursePlanItem> _list = getCoursePlanByParagraph(paragraph);
		t = findTeacher(c.getCourseID(), sc.getScID());
		if(null != t) {
			return t;
		}
		if(0 == _list.size()) {
			int index = new Random().nextInt(_teachers.size());
			return _teachers.get(index);
		}
		Iterator<CoursePlanItem> _cpiIter = _list.iterator();
		while(_iter.hasNext()) {
			t = _iter.next();
			b = true;
			while(_cpiIter.hasNext()) {
				if(_cpiIter.next().getTeacher().getTeacID() == t.getTeacID()) {
					b = false;
					break;
				}
			}
			if(b) return t;
		}
		System.out.println("师资力量不够强大啊！没教师了。重新排列中..........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		start();
		return null;
	}
	public List<ClassRoom> getRoomByType(int roomType) {
		List<ClassRoom> _rooms = new ArrayList<ClassRoom>();
		ClassRoom _cr = null;
		Iterator<ClassRoom> _iter = classRooms.iterator();
		while(_iter.hasNext()) {
			_cr = _iter.next();
			if(_cr.getCrType() == roomType) {
				_rooms.add(_cr);
			}
		}
		return _rooms;
	}
	public ClassRoom findClassRoom(int courseID, int scID) {          //查看此班级的此课程是否已经排过一次，获取一样的教室
		ClassRoom _classRoom = null;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		while(_cpiIter.hasNext()) {
			_cpi = _cpiIter.next();
			if(_cpi.getCourse().getCourseID() == courseID && _cpi.getSchoolClass().getScID() == scID) {
				_classRoom = _cpi.getClassRoom();
			}
		}
		return _classRoom;
	}
	public ClassRoom getAvailableClassRoom(int courseID, int scID, int roomType, int paragraph) {           //根据教室类型和上课时间获取一个可用的教室
		List<CoursePlanItem> _list = getCoursePlanByParagraph(paragraph);
		List<ClassRoom> _classRooms = getRoomByType(roomType);
		ClassRoom _cr = findClassRoom(courseID, scID);
		if(null != _cr) return _cr;
		boolean b = true;
		if(0 == _list.size()) {
			int index = new Random().nextInt(_classRooms.size());
			return _classRooms.get(index);
		}
		Iterator<CoursePlanItem> _cpiIter = _list.iterator();
		CoursePlanItem _cpi;
		Iterator<ClassRoom> _crIter = _classRooms.iterator();
		while(_crIter.hasNext()) {
			b = true;
			_cr = _crIter.next();
			while(_cpiIter.hasNext()) {
				_cpi = _cpiIter.next();
				if(_cpi.getClassRoom().getCrID() == _cr.getCrID()) {
					//System.out.println(_cpi.getCpParagraph() + " " + paragraph + " " + _cpi.getClassRoom().getCrID() + "_______________________________________" + 
						//	_cr.getCrID());
					b = false;
					break;
				}
			}
			if(b) return _cr;
		}
		System.out.println("该拨款了！没教室上课了。重新排列中.........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		start();
		return null;
	}
	private List<MajorsCourse> getMajorsCourseByMajorId(int majorID) {
		List<MajorsCourse> _mscs = new ArrayList<MajorsCourse>();
		Iterator<MajorsCourse> _mcIter = majorsCourse.iterator();
		MajorsCourse _msc = null;
		while(_mcIter.hasNext()) {
			_msc = _mcIter.next();
			if(_msc.getMajor().getMajorID() == majorID) 
				_mscs.add(_msc);
		}
		return _mscs;
	}
	public boolean findPlanPara(int scID, int cID) {
		if(ccp.size() == 0) return false;
		ClassCoursePara _ccp;
		Iterator<ClassCoursePara> _ccpIter = ccp.iterator();
		while(_ccpIter.hasNext()) {
			_ccp = _ccpIter.next();
			if(_ccp.getcID() == cID && _ccp.getScID() == scID) {
				return true;
			}
		}		
		return false;
	}
	public int getPlanPara(int scID, int cID)    {       //根据班级编号，课程编号查找安排课程节数
		int count = 0;
		ClassCoursePara _ccp;
		if(!findPlanPara(scID, cID)) {
			_ccp = new ClassCoursePara();
			_ccp.setScID(scID);
			_ccp.setcID(cID);
			_ccp.setPlanPara(0);
			ccp.add(_ccp);
			//while(true)System.out.println("new insert!" + ccp.size());
			return 0;
		}
		Iterator<ClassCoursePara> _ccpIter = ccp.iterator();
		while(_ccpIter.hasNext()) {
			_ccp = _ccpIter.next();
			if(_ccp.getcID() == cID && _ccp.getScID() == scID) {
				count = _ccp.getPlanPara();
				//System.out.println(count + "_________++++++++_____");
				break;
			}
		}
		return count;
	}
	public void setPlanPara(int scID, int cID, int para)    {       //根据班级编号，课程编号设置安排课程节数
		ClassCoursePara _ccp;
		if(!findPlanPara(scID, cID)) {
			_ccp = new ClassCoursePara();
			_ccp.setScID(scID);
			_ccp.setcID(cID);
			_ccp.setPlanPara(para);
			ccp.add(_ccp);
			return;
		}
		Iterator<ClassCoursePara> _ccpIter = ccp.iterator();
		while(_ccpIter.hasNext()) {
			_ccp = _ccpIter.next();
			if(_ccp.getcID() == cID && _ccp.getScID() == scID) {
				_ccp.setPlanPara(para);
				//System.out.println(para + "_________________________________" + _ccp.getPlanPara());
				break;
			}
		}
	}
	
	public void autoPlan() {       //自动排课开始方法
		System.out.println("start!");
		Random rand = new Random();
		CoursePlanItem cpi = null;
		int index, paragraph = 1;
		SchoolClass sc = null;
		Teacher t = null;
		ClassRoom cr = null;
		Major major = null;
		Course course = null;
		//List<Course> specCourse = null;       //某专业的所有课程
		MajorsCourse msc = null;
		List<MajorsCourse> majorsCourse = null;     //某专业与其课程的对应关系
		System.out.println(schoolClasses.size() + "***************************************************88");
		Iterator<SchoolClass> scIter = schoolClasses.iterator();
		while(scIter.hasNext()) {
			sc = scIter.next();
			paragraph = 1;
			major = sc.getMajor();
			majorsCourse = getMajorsCourseByMajorId(major.getMajorID());
			//System.out.println(checkCourse(majorsCourse, sc) + "_____________________________________----");
			while(checkCourse(majorsCourse, sc)) {
				//System.out.println("AAAAAAAAAAAAAAAAAAAA");
				//System.out.println(index + " _    " + majorsCourse.size());
				//System.out.println(msc.getCourse().getCourseName() + "  " + msc.getParagraph() + "      " + msc.getPlanPara());
				//System.out.println("**" + msc.getParagraph() + "->" + msc.getPlanPara());
				index = rand.nextInt(majorsCourse.size());      //随机取课进行排列
				msc = majorsCourse.get(index);
				course = msc.getCourse();
				if(msc.getParagraph() > getPlanPara(sc.getScID(), course.getCourseID())) {        //如果取出的课程尚未排完
					//System.out.println("AAAAAAAA");
					t = getAvailableTeacher(course, sc, paragraph);
					cr = getAvailableClassRoom(course.getCourseID(), sc.getScID(), course.getRoomType(), paragraph);
					cpi = new CoursePlanItem();
					cpi.setClassRoom(cr);
					cpi.setCourse(course);
					cpi.setCpParagraph(paragraph);
					cpi.setSchoolClass(sc);
					cpi.setTeacher(t);
					coursePlan.add(cpi);
					setPlanPara(sc.getScID(), course.getCourseID(), getPlanPara(sc.getScID(), course.getCourseID()) + 1);
					//System.out.println("**" + msc.getParagraph() + "->" + msc.getPlanPara());
					//System.out.println("**" + majorsCourse.get(index).getParagraph() + "->" + majorsCourse.get(index).getPlanPara());
					//System.out.println(major + " " + sc + "__" + course + "__" + t + "_____ " + cr + "______" + paragraph);
					//System.out.println(major.getMajorName() + sc.getScName() + "__" + course.getCourseName() + "__" + t.getTeacName() + "_____ " + cr.getCrName() + "______" + paragraph);
					paragraph++;
				}
			}
		}	
	}
	public void start() {             //开始
		init();
		autoPlan();
	}
	@Test
	public void test() {
		start();
		Iterator<CoursePlanItem> cpiIter = coursePlan.iterator();
		CoursePlanItem cpi ;
		System.out.println("专业班级                      课程                教室              教师               第几节");
		int count = 0;
		while(cpiIter.hasNext()) {
			cpi = cpiIter.next();
//			System.out.println(cpi.getSchoolClass().getMajor() + "" + cpi.getSchoolClass() + "  " +
//					cpi.getCourse() + "  " + cpi.getClassRoom() + "  " + 
//					cpi.getTeacher() + "  " + cpi.getCpParagraph());
			System.out.println(cpi.getSchoolClass().getMajor().getMajorName() + cpi.getSchoolClass().getScName() + "  " +
					cpi.getCourse().getCourseName() + "  " + cpi.getClassRoom().getCrName() + "  " + 
					cpi.getTeacher().getTeacName() + "           " + cpi.getCpParagraph());
			//coursePlanItemDao.insCoursePlanItem(cpi);
			count++;
		}
		System.out.println("总共有" + count + "条");
	}
//	@Test
//	public void deleteAll(){
//		coursePlanItemService.deleteAll();
//	}
}
