package com.teachMng.onlineTeach.autoplan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dto.ClassCoursePara;
import com.teachMng.onlineTeach.dto.ClassCoursePlanPara;
import com.teachMng.onlineTeach.dto.InfoTagItem;
import com.teachMng.onlineTeach.dto.RoomCoursePlanPara;
import com.teachMng.onlineTeach.dto.TeacherCoursePlanPara;
import com.teachMng.onlineTeach.model.ClassRoom;
import com.teachMng.onlineTeach.model.Course;
import com.teachMng.onlineTeach.model.CoursePlanItem;
import com.teachMng.onlineTeach.model.Major;
import com.teachMng.onlineTeach.model.MajorsCourse;
import com.teachMng.onlineTeach.model.SchoolClass;
import com.teachMng.onlineTeach.model.Teacher;
import com.teachMng.onlineTeach.service.IClassRoomService;
import com.teachMng.onlineTeach.service.ICoursePlanItemService;
import com.teachMng.onlineTeach.service.ICourseService;
import com.teachMng.onlineTeach.service.IMajorService;
import com.teachMng.onlineTeach.service.IMajorsCourseService;
import com.teachMng.onlineTeach.service.ISchoolClassService;
import com.teachMng.onlineTeach.service.IStudentService;
import com.teachMng.onlineTeach.service.ITeacherService;

@Component("autoPlan")
@Scope("singleton")
public class AutoPlan {
	boolean isInstToDB = false;
	Queue<String> msgQueue;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
	@Resource(name = "coursePlanUtil")
	CoursePlanUtil _cpu;

	/**
	 * 排列课程表 此方法不会将数据插入数据库
	 * 
	 * @return 排列好的所有课程表
	 */
	public List<CoursePlanItem> beginPlan() {
		status = 1;
		arrange();
		System.out.println(getCurTime() + " 排课结束！");
		msgQueue.add(getCurTime() + " 排课结束!系统正在保存数据，请稍候...");
		status = 3;
		return coursePlan;
	}

	/**
	 * 把课程表插入到数据库中
	 * 
	 * @return true-插入成功。false-插入失败
	 */
	public boolean insToDB() {
		if (null == coursePlan || 0 >= coursePlan.size()) {
			System.out.println(getCurTime() + " 你神经病啊！什么数据都没有，我存什么进去。fuck");
			msgQueue.add(getCurTime() + " 你神经病啊！什么数据都没有，我存什么进去。fuck");
			return false;
		}
		boolean flag = false;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		int _count = 0;
		while (_cpiIter.hasNext()) {
			_cpi = _cpiIter.next(); //
			// System.out.println(cpi.getSchoolClass().getMajor() + ""
			// + cpi.getSchoolClass() + "  " + // cpi.getCourse() + "  " +
			// cpi.getClassRoom() + "  " + // cpi.getTeacher() + "  " +
			// cpi.getCpParagraph());
			// System.out.println(cpi.getSchoolClass().getMajor().getMajorName()
			// + cpi.getSchoolClass().getScName() + "  "
			// + cpi.getCourse().getCourseName() + "  "
			// + cpi.getClassRoom().getCrName() + "  "
			// + cpi.getTeacher().getTeacName() + "           "
			// + cpi.getCpParagraph());
			try {
				coursePlanItemService.insCoursePlanItem(_cpi);
			} catch (Exception e) { // 插入时出错
				deleteAll();
				System.out.println(getCurTime() + " 插入课程表到数据库时出错!插入失败。");
				msgQueue.add(getCurTime() + " 插入课程表到数据库时出错!插入失败。");
				e.printStackTrace();
				return false;
			}
			_count++;
		}
		System.out.println("总共有" + _count + "条");
		msgQueue.add("保存成功!");
		isInstToDB = true;
		return flag;
	}

	/**
	 * 获取自动排课的进度
	 * 
	 * @return 返回一个float类型的进度值，
	 */
	public float getProgress() {
		if (isInstToDB) {
			return (float) 2.0;
		} else {
			return (float) ((getCurCourseCount() + 0.0) / allCourseCount);
		}
	}

	/*
	 * {list:[{id:"1", name:"ds"}]}
	 */
	public String getClassList() {
		String json = "{list:[";
		schoolClasses = new HashSet<SchoolClass>(schoolClassService.allSchoolClass());
		Set<SchoolClass> scs = new HashSet<SchoolClass>(schoolClasses);
		Iterator<SchoolClass> _scIter = scs.iterator();
		SchoolClass _sc;
		while (_scIter.hasNext()) {
			_sc = _scIter.next();
			json += "{id:\"" + _sc.getScID() + "\", name:\""
					+ _sc.getMajor().getMajorName() + " " + _sc.getScName()
					+ "\"}, ";
		}
		json += "], coursePlan:[";
		json += getClassStringById(scs.iterator().next().getScID());
		json += "]}";
		return json;
	}

	public String getClassStringById(int id) {
		String json = "";
		if (null == _cpu.getClassCoursePlanByClassId(id))
			return "";
		Iterator<ClassCoursePlanPara> _rcppIter = _cpu
				.getClassCoursePlanByClassId(id).iterator();
		ClassCoursePlanPara _rcpp = null;
		while (_rcppIter.hasNext()) {
			_rcpp = _rcppIter.next();
			json += "{courseId:\"" + _rcpp.getCourseID() + "\", courseName:\""
					+ _rcpp.getCourseName() + "\", roomId:\""
					+ _rcpp.getRoomID() + "\", roomName:\""
					+ _rcpp.getRoomName() + "\", teacherId:\""
					+ _rcpp.getTeacherID() + "\", teacherName:\""
					+ _rcpp.getTeacherName() + "\", paragraph:\""
					+ _rcpp.getParagraph() + "\"}, ";
		}
		return json;
	}

	public String getTeacherList() {
		String json = "{list:[";
		teachers = teacherService.allTeacher();
		Set<Teacher> teac = new HashSet<Teacher>(teachers);
		Iterator<Teacher> _tIter = teac.iterator();
		Teacher _t;
		while (_tIter.hasNext()) {
			_t = _tIter.next();
			json += "{id:\"" + _t.getTeacID() + "\", name:\""
					+ _t.getTeacName() + "\"}, ";
		}
		json += "], coursePlan:[";
		json += getTeacherStringById(teac.iterator().next().getTeacID());
		json += "]}";
		return json;
	}

	public String getTeacherStringById(int id) {
		String json = "";
		if (null == _cpu.getTeacherCoursePlanByTeacherId(id))
			return "";
		Iterator<TeacherCoursePlanPara> _rcppIter = _cpu
				.getTeacherCoursePlanByTeacherId(id).iterator();
		TeacherCoursePlanPara _rcpp = null;
		while (_rcppIter.hasNext()) {
			_rcpp = _rcppIter.next();
			json += "{courseId:\"" + _rcpp.getCourseID() + "\", courseName:\""
					+ _rcpp.getCourseName() + "\", roomId:\""
					+ _rcpp.getRoomID() + "\", roomName:\""
					+ _rcpp.getRoomName() + "\", majorId:\""
					+ _rcpp.getMajorID() + "\", majorName:\""
					+ _rcpp.getMajorName() + "\", classId:\""
					+ _rcpp.getClassID() + "\", className:\""
					+ _rcpp.getClassName() + "\", paragraph:\""
					+ _rcpp.getParagraph() + "\"}, ";
		}
		return json;
	}

	public String getRoomList() {
		String json = "{list:[";
		classRooms = classRoomService.allClassRoom();
		Set<ClassRoom> crs = new HashSet<ClassRoom>(classRooms);
		Iterator<ClassRoom> _crIter = crs.iterator();
		ClassRoom _cr;
		while (_crIter.hasNext()) {
			_cr = _crIter.next();
			json += "{id:\"" + _cr.getCrID() + "\", name:\"" + _cr.getCrName()
					+ "\"}, ";
		}
		json += "], coursePlan:[";
		json += getRoomStringById(crs.iterator().next().getCrID());
		json += "]}";
		return json;
	}

	public String getRoomStringById(int id) {
		String json = "";
		if (null == _cpu.getRoomCoursePlanByRoomId(id)) {
			return "";
		}
		Iterator<RoomCoursePlanPara> _rcppIter = _cpu
				.getRoomCoursePlanByRoomId(id).iterator();
		RoomCoursePlanPara _rcpp = null;
		while (_rcppIter.hasNext()) {
			_rcpp = _rcppIter.next();
			json += "{majorId:\"" + _rcpp.getMajorID() + "\", majorName:\""
					+ _rcpp.getMajorName() + "\", classId:\""
					+ _rcpp.getClassID() + "\", className:\""
					+ _rcpp.getClassName() + "\", courseId:\""
					+ _rcpp.getCourseID() + "\", courseName:\""
					+ _rcpp.getCourseName() + "\", teacherId:\""
					+ _rcpp.getTeacherID() + "\", teacherName:\""
					+ _rcpp.getTeacherName() + "\", paragraph:\""
					+ _rcpp.getParagraph() + "\"}, ";
		}
		return json;
	}

	/**
	 * 从排课进度消息的开头获取一个消息字符串
	 * 
	 * @return 一个字符串，队列中的最旧的消息
	 */
	public String getMsg() {
		String msg = "[";
		while (!msgQueue.isEmpty()) {
			msg += "\"" + msgQueue.poll() + "\",";
		}
		if (msg.length() > 1)
			msg = msg.substring(0, msg.length() - 1);
		msg += "]";
		return msg;
	}

	/**
	 * 清空数据库表中的所有数据
	 */
	public void deleteAll() {
		coursePlanItemService.deleteAll();
		System.out.println(getCurTime() + " 已成功清除所有数据！");
	}

	public String getInfoTag() {
		classRooms = classRoomService.allClassRoom();
		schoolClasses = new HashSet<SchoolClass>(schoolClassService.allSchoolClass());
		teachers = teacherService.allTeacher();
		Set<InfoTagItem> infoTag = new HashSet<InfoTagItem>();
		InfoTagItem _iti = null;
		Iterator _iter = classRooms.iterator();
		while (_iter.hasNext()) {
			_iti = new InfoTagItem();
			_iti.setName(((ClassRoom) _iter.next()).getCrName());
			_iti.setID(3);
			infoTag.add(_iti);
		}
		_iter = schoolClasses.iterator();
		SchoolClass _sc = null;
		while (_iter.hasNext()) {
			_iti = new InfoTagItem();
			_sc = (SchoolClass) _iter.next();
			_iti.setName(_sc.getMajor().getMajorName() + " " + _sc.getScName());
			_iti.setID(1);
			infoTag.add(_iti);
		}
		_iter = teachers.iterator();
		while (_iter.hasNext()) {
			_iti = new InfoTagItem();
			_iti.setName(((Teacher) _iter.next()).getTeacName());
			_iti.setID(2);
			infoTag.add(_iti);

		}
		_iter = infoTag.iterator();
		String json = "[";
		while (_iter.hasNext()) {
			_iti = (InfoTagItem) _iter.next();
			json += "{\"name\":\"" + _iti.getName() + "\",";
			json += "\"id\":\"" + _iti.getID() + "\"},";
		}
		json += "]";
		// System.out.println(json);
		// return infoTag;
		return json;
	}

	/**
	 * 全部清空
	 */
	public void clean() {
		classRooms = null;
		courses = null;
		majors = null;
		majorsCourse = null;
		schoolClasses = null;
		teachers = null;
		coursePlan = null;
		ccp = null;

		classRoomService = null;
		courseService = null;
		coursePlanItemService = null;
		majorService = null;
		schoolClassService = null;
		studentService = null;
		teacherService = null;
		majorsCourseService = null;
	}

	private AutoPlan() {
		msgQueue = new LinkedList<String>();
	};

	private String getCurTime() {
		return sdf.format(new Date()).toString();
	}

	/**
	 * 获取当前已经排列的课程总数
	 * 
	 * @return 已经排列的班级课程数量
	 */
	private int getCurCourseCount() {
		int curCount = 0;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		while (_cpiIter.hasNext()) {
			_cpiIter.next();
			curCount++;
		}
		return curCount;
	}

	/**
	 * 开始
	 */
	private void arrange() {
		init();
		autoPlan();
	}

	/**
	 * 初始化数据
	 */
	private void init() {
		System.out.println(getCurTime() + " 数据初始化成功，系统准备排课中...");
		msgQueue.add(getCurTime() + " 数据初始化成功，系统准备排课中...");
		classRooms = null;
		courses = null;
		majors = null;
		majorsCourse = null;
		schoolClasses = null;
		teachers = null;
		coursePlan = new ArrayList<CoursePlanItem>();
		ccp = new ArrayList<ClassCoursePara>();

		classRooms = classRoomService.allClassRoom();
		courses = courseService.allCourse();
		majors = majorService.allMajor();
		majorsCourse = majorsCourseService.allMajorsCourse();
		schoolClasses = new HashSet<SchoolClass>(schoolClassService.allSchoolClass());
		teachers = teacherService.allTeacher();

		allCourseCount = getCourseCount();
	}

	/**
	 * 获取所有班级的课程总数
	 * 
	 * @return 班级课程的总数
	 */
	private int getCourseCount() {
		int count = 0;
		MajorsCourse _mc = null;
		Iterator<MajorsCourse> mcIter = majorsCourse.iterator();
		while (mcIter.hasNext()) {
			_mc = mcIter.next();
			count += _mc.getParagraph()
					* _mc.getMajor().getSchoolClasses().size();
		}
		return count;
	}

	/**
	 * 检查班级课程是否还没有排完
	 * 
	 * @param mc
	 *            这个班级所属专业的所有课程
	 * @param sc
	 *            班级
	 * @return true:此专业还有未安排的课程,false:已经排列完所有课程
	 */
	private boolean checkCourse(List<MajorsCourse> mc, SchoolClass sc) {
		Iterator<MajorsCourse> iter = mc.iterator();
		MajorsCourse msc;
		while (iter.hasNext()) {
			msc = iter.next();
			if (msc.getParagraph() > getPlanPara(sc.getScID(), msc.getCourse()
					.getCourseID())) {
				return true; //
			}
		}
		System.out.println(sc.getMajor().getMajorName() + sc.getScName()
				+ "班 over!  ————————   " + mc.size());
		return false;
	}

	/**
	 * 从所有的课程表中根据第几节课取出课程
	 * 
	 * @param paragraph
	 *            第几节课
	 * @return 返回当前节数的所有课程表原子
	 */
	private List<CoursePlanItem> getCoursePlanByParagraph() { //
		List<CoursePlanItem> _list = new ArrayList<CoursePlanItem>();
		Iterator<CoursePlanItem> _iter = coursePlan.iterator();
		CoursePlanItem _cpi;
		// System.out.println(coursePlan.size() +
		// "______________________________***");
		while (_iter.hasNext()) {
			_cpi = _iter.next();
			// System.out.println(_cpi.getCpID() + "_>_" +
			// _cpi.getCourse().getCourseName() + "_>_" + _cpi.getCpParagraph()
			// + "_>_" + paragraph);
			if (_cpi.getCpParagraph() == paragraph) {
				_list.add(_cpi);
			}
		}
		return _list;
	}

	/**
	 * 根据班级编号和课程编号在课程表中查看此班级的这门课是否已经有教师
	 * 
	 * @param courseID
	 *            课程编号
	 * @param scID
	 *            班级编号
	 * @return null-表示没有教师，将获取一个新教师。否则使用返回的教师
	 */
	private Teacher findTeacher(int courseID, int scID) {
		// System.out.println("_________________________");
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		Teacher _teacher = null;
		while (_cpiIter.hasNext()) {
			_cpi = _cpiIter.next();
			if (_cpi.getCourse().getCourseID() == courseID
					&& _cpi.getSchoolClass().getScID() == scID) {
				_teacher = _cpi.getTeacher();
				break;
			}
		}
		return _teacher;
	}

	/**
	 * 获取一个可用的教师
	 * 
	 * @param c
	 *            课程
	 * @param sc
	 *            班级
	 * @param paragraph
	 *            那节课
	 * @return 返回一个可以用的教师
	 */
	private Teacher getAvailableTeacher(Course c, SchoolClass sc) {
		// System.out.println(c.getTeachers());
		Teacher t = getTeacherByParagraph(c, sc);
		if (null == t) {
			rePlanCount++;
			status = 2;
			System.out.println(getCurTime() + " 师资力量不够强大啊！没教师了。第" + rePlanCount
					+ "次重新排列中..........");
			msgQueue.add(getCurTime() + " 师资力量不够强大啊！没教师了。第" + rePlanCount
					+ "次重新排列中..........");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			arrange();
			return null;
		} else {
			return t;
		}
	}

	/**
	 * 检测此节课的老师是否有冲突
	 * 
	 * @param c
	 *            课程
	 * @param sc
	 *            班级
	 * @param paragraph
	 *            那节课
	 * @return 返回一个教师
	 */
	private Teacher getTeacherByParagraph(Course c, SchoolClass sc) {
		List<Teacher> _teachers = new ArrayList<Teacher>(c.getTeachers());
		Teacher t = null;
		Boolean b = true;
		Iterator<Teacher> _iter = _teachers.iterator();
		List<CoursePlanItem> _list = getCoursePlanByParagraph();
		t = findTeacher(c.getCourseID(), sc.getScID());
		if (null != t) {
			return t;
		}
		if (0 == _list.size()) {
			int index = new Random().nextInt(_teachers.size());
			return _teachers.get(index);
		}
		Iterator<CoursePlanItem> _cpiIter = _list.iterator();
		CoursePlanItem _cpi;
		while (_iter.hasNext()) {
			t = _iter.next();
			b = true;
			// System.out.println(t.getTeacName());
			while (_cpiIter.hasNext()) {
				_cpi = _cpiIter.next();
				if (_cpi.getTeacher().getTeacID() == t.getTeacID()) {
					b = false;
					// System.out.println(_cpi.getTeacher().getTeacID() + " + "
					// + t.getTeacID() + "_____" + paragraph);
					break;
				}
			}
			if (b)
				return t;
		}
		if (paragraph < MAXPARAGRAPH) {
			paragraph++;
			return getTeacherByParagraph(c, sc);
		}
		return null;
	}

	/**
	 * 获取同一类型的所有教室
	 * 
	 * @param roomType
	 *            教室类型
	 * @return 返回此类型的所有教室
	 */
	private Set<ClassRoom> getRoomByType(int roomType) {
		Set<ClassRoom> _rooms = new HashSet<ClassRoom>();
		ClassRoom _cr = null;
		Iterator<ClassRoom> _iter = classRooms.iterator();
		while (_iter.hasNext()) {
			_cr = _iter.next();
			if (_cr.getCrType() == roomType) {
				_rooms.add(_cr);
			}
		}
		return _rooms;
	}

	/**
	 * 查看此班级的此课程是否已经排过一次，获取一样的教室
	 * 
	 * @param courseID
	 *            课程编号
	 * @param scID
	 *            班级编号
	 * @return null-将获取一个新的教室。否则用此教室
	 */
	private ClassRoom findClassRoom(int courseID, int scID) {
		ClassRoom _classRoom = null;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		while (_cpiIter.hasNext()) {
			_cpi = _cpiIter.next();
			if (_cpi.getCourse().getCourseID() == courseID
					&& _cpi.getSchoolClass().getScID() == scID) {
				_classRoom = _cpi.getClassRoom();
			}
		}
		return _classRoom;
	}
	private int getRoomCountById(int roomID) {
		int count = 0;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		while(_cpiIter.hasNext()) {
			if(_cpiIter.next().getClassRoom().getCrID() == roomID) count++;
		}
		return count;
	}
	/**
	 * 根据教室类型和上课时间获取一个可用的教室
	 * 
	 * @param courseID
	 *            课程编号
	 * @param scID
	 *            班级编号
	 * @param roomType
	 *            教室类型
	 * @param paragraph
	 *            第几节课
	 * @return 返回一个这个时间段可以使用的教室
	 */
	private ClassRoom getAvailableClassRoom(int courseID, int scID, int roomType) {
		List<CoursePlanItem> _list = getCoursePlanByParagraph();
		Set<ClassRoom> _classRooms = getRoomByType(roomType);
		ClassRoom _cr = findClassRoom(courseID, scID);
		boolean isNeedNew = false;
		if (null != _cr) {
		//	System.out.println(getRoomCountById(_cr.getCrID()) + "__---__-_-__---");
			while(!isNeedNew && findClassRoomById(paragraph, _cr.getCrID())) {
				if (paragraph < MAXPARAGRAPH) {
					paragraph++;
				}
				else {
					paragraph = 1;
				}
				while (isHaveCourse(scID)) {
					paragraph++;
				}
			}
			if(!isNeedNew) {
				return _cr;
			}
		}
		boolean b = true;
		if (0 == _list.size()) {
			// System.out.println( paragraph +
			// "...................................");
			return _classRooms.iterator().next();
		}
		Iterator<CoursePlanItem> _cpiIter = _list.iterator();
		CoursePlanItem _cpi;
		Iterator<ClassRoom> _crIter = _classRooms.iterator();
		while (_crIter.hasNext()) {
			b = true;
			_cr = _crIter.next();
			while (_cpiIter.hasNext()) {
				_cpi = _cpiIter.next();
				// System.out.println(_cpi.getCpParagraph() +
				// _cpi.getClassRoom().getCrName());
				if (_cpi.getClassRoom().getCrID() == _cr.getCrID()) {
					// System.out.println(_cpi.getCpParagraph() + " " +
					// paragraph + " " + _cpi.getClassRoom().getCrID() +
					// "_______________________________________" +
					// _cr.getCrID());
					b = false;
					break;
				}
			}
			if (b) {
				if (findClassRoomById(paragraph, _cr.getCrID())) {
					continue;
				}
				// System.out.println(findClassRoomById(paragraph,
				// _cr.getCrID()));
				return _cr;
			}
		}
		if (paragraph < MAXPARAGRAPH) {
			paragraph++;
			return getAvailableClassRoom(courseID, scID, roomType);
		}
		rePlanCount++;
		status = 2;
		System.out.println(getCurTime() + " 该拨款了！没教室上课了。第" + rePlanCount
				+ "次重新排列中.........");
		msgQueue.add(getCurTime() + " 该拨款了！没教室上课了。第" + rePlanCount
				+ "次重新排列中.........");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		arrange();
		return null;
	}

	private List<CoursePlanItem> getCoursePlanByClassId(int classId) {
		List<CoursePlanItem> _list = new ArrayList<CoursePlanItem>();
		Iterator<CoursePlanItem> _iter = coursePlan.iterator();
		CoursePlanItem _cpi;
		while (_iter.hasNext()) {
			_cpi = _iter.next();
			if (_cpi.getSchoolClass().getScID() == classId) {
				_list.add(_cpi);
			}
		}
		return _list;
	}

	/**
	 * 通过专业编号获取此专业的所有课程
	 * 
	 * @param majorID
	 *            专业编号
	 * @return 此专业的所有课程
	 */
	private List<MajorsCourse> getMajorsCourseByMajorId(int majorID) {
		List<MajorsCourse> _mscs = new ArrayList<MajorsCourse>();
		Iterator<MajorsCourse> _mcIter = majorsCourse.iterator();
		MajorsCourse _msc = null;
		while (_mcIter.hasNext()) {
			_msc = _mcIter.next();
			if (_msc.getMajor().getMajorID() == majorID)
				_mscs.add(_msc);
		}
		return _mscs;
	}

	/**
	 * 此班级的此门课程是否已经排列在课程表中
	 * 
	 * @param scID
	 *            班级编号
	 * @param cID
	 *            课程编号
	 * @return true-排列过，false-没有排列过
	 */
	private boolean findPlanPara(int scID, int cID) {
		if (ccp.size() == 0)
			return false;
		ClassCoursePara _ccp;
		Iterator<ClassCoursePara> _ccpIter = ccp.iterator();
		while (_ccpIter.hasNext()) {
			_ccp = _ccpIter.next();
			if (_ccp.getcID() == cID && _ccp.getScID() == scID) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据班级编号，课程编号查找安排课程节数
	 * 
	 * @param scID
	 *            班级编号
	 * @param cID
	 *            课程编号
	 * @return 当前班级的此课程已经排列了多少节
	 */
	private int getPlanPara(int scID, int cID) {
		int count = 0;
		ClassCoursePara _ccp;
		if (!findPlanPara(scID, cID)) {
			_ccp = new ClassCoursePara();
			_ccp.setScID(scID);
			_ccp.setcID(cID);
			_ccp.setPlanPara(0);
			ccp.add(_ccp);
			// while(true)System.out.println("new insert!" + ccp.size());
			return 0;
		}
		Iterator<ClassCoursePara> _ccpIter = ccp.iterator();
		while (_ccpIter.hasNext()) {
			_ccp = _ccpIter.next();
			if (_ccp.getcID() == cID && _ccp.getScID() == scID) {
				count = _ccp.getPlanPara();
				// System.out.println(count + "_________++++++++_____");
				break;
			}
		}
		return count;
	}

	/**
	 * 根据班级编号，课程编号设置安排课程节数
	 * 
	 * @param scID
	 *            班级编号
	 * @param cID
	 *            课程编号
	 * @param para
	 *            课程的节数
	 */
	private void setPlanPara(int scID, int cID, int para) {
		ClassCoursePara _ccp;
		if (!findPlanPara(scID, cID)) {
			_ccp = new ClassCoursePara();
			_ccp.setScID(scID);
			_ccp.setcID(cID);
			_ccp.setPlanPara(para);
			ccp.add(_ccp);
			return;
		}
		Iterator<ClassCoursePara> _ccpIter = ccp.iterator();
		while (_ccpIter.hasNext()) {
			_ccp = _ccpIter.next();
			if (_ccp.getcID() == cID && _ccp.getScID() == scID) {
				_ccp.setPlanPara(para);
				// System.out.println(para + "_________________________________"
				// + _ccp.getPlanPara());
				break;
			}
		}
	}

	private boolean findClassRoomById(int p, int rid) {
		Iterator<CoursePlanItem> iter = coursePlan.iterator();
		CoursePlanItem cpi;
		if(getRoomCountById(rid) > 30) return false;
		while (iter.hasNext()) {
			cpi = iter.next();
			if (p == cpi.getCpParagraph()
					&& rid == cpi.getClassRoom().getCrID()) {
//				System.out.println(cpi.getCpParagraph() + "  " +
//				 cpi.getClassRoom().getCrID() + "_________");
				System.out.print(p + " _ ");
				return true;
			}
		}
		return false;
	}

	private boolean isHaveCourse(int scID) {
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		//System.out.println("_____________________________" + paragraph);
		while (_cpiIter.hasNext()) {
			// System.out.println(_cpiIter.hasNext());
			//System.out.println(coursePlan.size());
			System.out.print(paragraph + " _ ");
			_cpi = _cpiIter.next();
			if (_cpi.getSchoolClass().getScID() == scID
					&& _cpi.getCpParagraph() == paragraph) {
				//System.out.println(_cpi.getSchoolClass().getScID() + "___" + _cpi.getCpParagraph());
				return true;
			}
		}
		//System.out.println("return false");
		return false;
	}

	/**
	 * 自动排课入口方法
	 */
	private void autoPlan() {
		onProgress = true;
		msgQueue.add(getCurTime() + " 排课开始！");
		System.out.println(getCurTime() + " 排课开始！");
		Random rand = new Random();
		CoursePlanItem cpi = null;
		int index;
		SchoolClass sc = null;
		Teacher t = null;
		ClassRoom cr = null;
		Major major = null;
		Course course = null;
		MajorsCourse msc = null;
		List<MajorsCourse> majorsCourse = null; // 某专业与其课程的对应关系
		Iterator<SchoolClass> scIter = schoolClasses.iterator();
		while (scIter.hasNext()) {
			sc = scIter.next();
			paragraph = 1;
			major = sc.getMajor();
			msgQueue.add(getCurTime() + " 正在为 "
					+ (major.getMajorName() + " " + sc.getScName()) + " 班安排课程");
			majorsCourse = getMajorsCourseByMajorId(major.getMajorID());
			while (checkCourse(majorsCourse, sc)) {

				index = rand.nextInt(majorsCourse.size()); // 随机取课进行排列
				msc = majorsCourse.get(index);
				course = msc.getCourse();
				if (msc.getParagraph() > getPlanPara(sc.getScID(),
						course.getCourseID())) { // 如果取出的课程尚未排完
					t = getAvailableTeacher(course, sc);
					if (null == t)
						return;
					cr = getAvailableClassRoom(course.getCourseID(),
							sc.getScID(), course.getRoomType());
					// System.out.println(findClassRoomById(paragraph,
					// cr.getCrID(), course.getCourseID()));
					if (null == cr)
						return;
					cpi = new CoursePlanItem();
					cpi.setClassRoom(cr);
					cpi.setCourse(course);
					cpi.setCpParagraph(paragraph);
					cpi.setSchoolClass(sc);
					cpi.setTeacher(t);
					coursePlan.add(cpi);
					setPlanPara(sc.getScID(), course.getCourseID(),
							getPlanPara(sc.getScID(), course.getCourseID()) + 1);
					if(paragraph < MAXPARAGRAPH) paragraph++;
					else {
						paragraph = 1;
					}
					
					 try {
					 Thread.sleep(100);
					 } catch (InterruptedException e) {
					 e.printStackTrace();
					 }
				}
			}
		}
		onProgress = false;
	}

	/*
	 * 一大陀getter和setter方法的开始，你尽情的往下滚，我会提示你 "这坨" 的结束位置的。
	 */

	public List<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(List<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public List<MajorsCourse> getMajorsCourse() {
		return majorsCourse;
	}

	public void setMajorsCourse(List<MajorsCourse> majorsCourse) {
		this.majorsCourse = majorsCourse;
	}

	public Set<SchoolClass> getSchoolClasses() {
		return schoolClasses;
	}

	public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<CoursePlanItem> getCoursePlan() {
		return coursePlan;
	}

	public void setCoursePlan(List<CoursePlanItem> coursePlan) {
		this.coursePlan = coursePlan;
	}

	public List<ClassCoursePara> getCcp() {
		return ccp;
	}

	public void setCcp(List<ClassCoursePara> ccp) {
		this.ccp = ccp;
	}

	public IClassRoomService getClassRoomService() {
		return classRoomService;
	}

	@Resource(name = "classRoomService")
	public void setClassRoomService(IClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	@Resource(name = "courseService")
	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public ICoursePlanItemService getCoursePlanItemService() {
		return coursePlanItemService;
	}

	@Resource(name = "coursePlanItemService")
	public void setCoursePlanItemService(
			ICoursePlanItemService coursePlanItemService) {
		this.coursePlanItemService = coursePlanItemService;
	}

	public IMajorService getMajorService() {
		return majorService;
	}

	@Resource(name = "majorService")
	public void setMajorService(IMajorService majorService) {
		this.majorService = majorService;
	}

	public ISchoolClassService getSchoolClassService() {
		return schoolClassService;
	}

	@Resource(name = "schoolClassService")
	public void setSchoolClassService(ISchoolClassService schoolClassService) {
		this.schoolClassService = schoolClassService;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	@Resource(name = "studentService")
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public ITeacherService getTeacherService() {
		return teacherService;
	}

	@Resource(name = "teacherService")
	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public IMajorsCourseService getMajorsCourseService() {
		return majorsCourseService;
	}

	@Resource(name = "majorsCourseService")
	public void setMajorsCourseService(IMajorsCourseService majorsCourseService) {
		this.majorsCourseService = majorsCourseService;
	}

	/*
	 * 这坨setter和getter终于结束了
	 */
	/**
	 * 最大节数
	 */
	public final int MAXPARAGRAPH = 30;

	private static int allCourseCount; // 所有班级的所有课程之和，用于获取排课进度时所需要的变量。

	private int paragraph = 0;
	/**
	 * 检测到冲突时的重排次数
	 */
	public int rePlanCount = 0;
	/**
	 * 当前排课的状态， 0——未进行，1——正在排课，2-检测到冲突进行重排，3——排课完成
	 */
	public int status = 0;

	private List<ClassRoom> classRooms = null;
	private List<Course> courses = null;
	private List<Major> majors = null;
	private List<MajorsCourse> majorsCourse = null;
	private Set<SchoolClass> schoolClasses = null;
	private List<Teacher> teachers = null;
	private List<CoursePlanItem> coursePlan = null;
	private List<ClassCoursePara> ccp = null;

	private IClassRoomService classRoomService;
	private ICourseService courseService;
	private ICoursePlanItemService coursePlanItemService;
	private IMajorService majorService;
	private ISchoolClassService schoolClassService;
	private IStudentService studentService;
	private ITeacherService teacherService;
	private IMajorsCourseService majorsCourseService;
	public boolean onProgress = false;// 正在排课？？？

}
