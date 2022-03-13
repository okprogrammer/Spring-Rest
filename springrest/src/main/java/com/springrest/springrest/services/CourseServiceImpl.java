package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

// this annotation tell about the service layer
@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> list;
	@Autowired
	private CourseDao courseDao;

	public CourseServiceImpl() {
		/*
		 * list = new ArrayList<>(); list.add(new Course(145, "Java Core Course",
		 * "This is Java core course.")); list.add(new Course(146, "Python Course",
		 * "Python Object oriented learning.")); list.add(new Course(4343,
		 * "sprint boot course", "creating rest api using sprint boot."));
		 */
	}

	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	public Course getCourse(long id) {
		/*
		 * Course course = null; for (Course c : list) { if (c.getId() == id) { course =
		 * c; break; } }
		 */
		return courseDao.findAll().stream().filter(e -> e.getId() == id).findFirst().get();
	}

	public Course addNewCourse(Course c) {
		/*
		 * list.add(c); long id = c.getId();
		 */
		courseDao.save(c);
		return c;
	}

	public Course updateCourse(Course c) {
		/*
		 * long id = c.getId(); Course updateCourse = this.getCourse(id);
		 * updateCourse.setTitle(c.getTitle());
		 * updateCourse.setDescription(c.getDescription());
		 */
		/*
		 * list.forEach(e -> { if (e.getId() == c.getId()) { e.setTitle(c.getTitle());
		 * e.setDescription(c.getDescription()); } });
		 */
		courseDao.save(c);
		return c;
	}

	public void deleteCourse(long id) {
		/*
		 * for (Course c : list) { if (c.getId() == id) { list.remove(c); break; } }
		 */
		/*
		 * Here we are filtering those id which are not equal to our id and creating the
		 * list
		 */
		// list = this.list.stream().filter(e -> e.getId() !=
		// id).collect(Collectors.toList());
		courseDao.deleteById(id);
	}
}
