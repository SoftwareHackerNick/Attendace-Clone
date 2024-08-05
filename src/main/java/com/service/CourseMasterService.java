package com.service;

import java.util.List;


import com.model.CourseMaster;

public interface CourseMasterService {

	CourseMaster addCourseMaster(CourseMaster course);
	
	List<CourseMaster> getCourseMaster();
	
    Boolean deleteCourse(int id);
	
    CourseMaster updateCourse(CourseMaster course,int id);
}
