package com.teachMng.onlineTeach.autoplan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.teachMng.onlineTeach.dto.ClassCoursePlanPara;
import com.teachMng.onlineTeach.dto.RoomCoursePlanPara;
import com.teachMng.onlineTeach.dto.TeacherCoursePlanPara;
import com.teachMng.onlineTeach.model.CoursePlanItem;
import com.teachMng.onlineTeach.service.ICoursePlanItemService;
@Component("coursePlanUtil")
public class CoursePlanUtil {
	/*
	 * 获取班级的课程表
	 * classID：班级编号
	 * return：null-传入的班级编号有误。否则返回此班级的课程表
	 */
	public Set<ClassCoursePlanPara> getClassCoursePlanByClassId(int classID) {
		System.out.println(classID);
		List<CoursePlanItem> coursePlan = coursePlanItemService.allCoursePlanByClassId(classID);
		if(0 >= coursePlan.size()) {
			System.out.println("可能是你给我的班级编号有误！此班级没有课程。");
			return null;
		}
		Set<ClassCoursePlanPara> classCoursePlan = new HashSet<ClassCoursePlanPara>();         //班级课程表
		ClassCoursePlanPara _cpp = null;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		while(_cpiIter.hasNext()) {
			_cpi = _cpiIter.next();
			_cpp = new ClassCoursePlanPara();
			_cpp.setCpID(_cpi.getCpID());
			_cpp.setCourseID(_cpi.getCourse().getCourseID());
			_cpp.setCourseName(_cpi.getCourse().getCourseName());
			_cpp.setParagraph(_cpi.getCpParagraph());
			_cpp.setRoomID(_cpi.getClassRoom().getCrID());
			_cpp.setRoomName(_cpi.getClassRoom().getCrName());
			_cpp.setTeacherID(_cpi.getTeacher().getTeacID());
			_cpp.setTeacherName(_cpi.getTeacher().getTeacName());
			classCoursePlan.add(_cpp);
		}
		return classCoursePlan;
	}
	/*
	 * 获取教师的课程表
	 * teacherID：教师编号
	 * return：null-传入的教师编号有误。否则返回此教师的课程表
	 */
	public Set<TeacherCoursePlanPara> getTeacherCoursePlanByTeacherId(int teacherID) {
		List<CoursePlanItem> coursePlan = coursePlanItemService.allCoursePlanByTeacherId(teacherID);
		if(0 >= coursePlan.size()) {
			System.out.println("可能是你给我的教师编号有误！此教师没有课程。");
			return null;
		}
		Set<TeacherCoursePlanPara> teacherCoursePlan = new HashSet<TeacherCoursePlanPara>();         //教师课程表
		TeacherCoursePlanPara _tcpp = null;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		while(_cpiIter.hasNext()) {
			_cpi = _cpiIter.next();
			_tcpp = new TeacherCoursePlanPara();
			_tcpp.setCourseID(_cpi.getCourse().getCourseID());
			_tcpp.setCourseName(_cpi.getCourse().getCourseName());
			_tcpp.setParagraph(_cpi.getCpParagraph());
			_tcpp.setRoomID(_cpi.getClassRoom().getCrID());
			_tcpp.setRoomName(_cpi.getClassRoom().getCrName());
			_tcpp.setClassID(_cpi.getSchoolClass().getScID());
			_tcpp.setClassName(_cpi.getSchoolClass().getScName());
			_tcpp.setMajorID(_cpi.getSchoolClass().getMajor().getMajorID());
			_tcpp.setMajorName(_cpi.getSchoolClass().getMajor().getMajorName());
			_tcpp.setCpID(_cpi.getCpID());
			teacherCoursePlan.add(_tcpp);
		}
		return teacherCoursePlan;
	}
	/*
	 * 获取教室的课程表
	 * roomID：教室编号
	 * return：null-传入的教室编号有误。否则返回此教室的课程表
	 */
	public Set<RoomCoursePlanPara> getRoomCoursePlanByRoomId(int roomID) {
		List<CoursePlanItem> coursePlan = coursePlanItemService.allCoursePlanByRoomId(roomID);
		if(0 >= coursePlan.size()) {
			System.out.println("可能是你给我的教室编号有误！此教室没有课程。");
			return null;
		}
		Set<RoomCoursePlanPara> roomCoursePlan = new HashSet<RoomCoursePlanPara>();         //教室课程表
		RoomCoursePlanPara _rcpp = null;
		Iterator<CoursePlanItem> _cpiIter = coursePlan.iterator();
		CoursePlanItem _cpi;
		while(_cpiIter.hasNext()) {
			_cpi = _cpiIter.next();
			_rcpp = new RoomCoursePlanPara();
			_rcpp.setCourseID(_cpi.getCourse().getCourseID());
			_rcpp.setCourseName(_cpi.getCourse().getCourseName());
			_rcpp.setParagraph(_cpi.getCpParagraph());
			_rcpp.setClassID(_cpi.getSchoolClass().getScID());
			_rcpp.setClassName(_cpi.getSchoolClass().getScName());
			_rcpp.setMajorID(_cpi.getSchoolClass().getMajor().getMajorID());
			_rcpp.setMajorName(_cpi.getSchoolClass().getMajor().getMajorName());
			_rcpp.setTeacherID(_cpi.getTeacher().getTeacID());
			_rcpp.setTeacherName(_cpi.getTeacher().getTeacName());
			_rcpp.setCpID(_cpi.getCpID());
			roomCoursePlan.add(_rcpp);
		}
		return roomCoursePlan;
	}
	
	public ICoursePlanItemService getCoursePlanItemService() {
		return coursePlanItemService;
	}
	@Resource(name="coursePlanItemService")
	public void setCoursePlanItemService(
			ICoursePlanItemService coursePlanItemService) {
		this.coursePlanItemService = coursePlanItemService;
	}
	private ICoursePlanItemService coursePlanItemService;
}
