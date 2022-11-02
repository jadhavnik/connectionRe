package com.sts.springrest.serviceImp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sts.springrest.dao.CourseDao;
import com.sts.springrest.entities.Course;
import com.sts.springrest.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	SessionFactory factory;

	List<Course> list;

	
	public CourseServiceImpl() {
		list = new ArrayList<>();
//		list.add(new Course(1,"nik","nik disc"));
//		list.add(new Course(2,"jadh","jadhav disc"));
	}

	@Override
//	@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
@Transactional
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
//		list = courseDao.findAll();
//		return list;
		try
		{
//			SELECT a FROM Author a LEFT JOIN FETCH a.books
//			from Region r JOIN FETCH r.pays
			Session session=factory.getCurrentSession();
			Query q=session.createQuery("from Course c LEFT JOIN FETCH c.questions",Course.class);
//			Query q=session.createQuery("from Course",Course.class);
			list= q.list();
			System.out.println(list);
 
		}
		catch (Exception e)
		{}
		finally
		{
			return list;
		}
	}

	
	@Override
	@Transactional
	public Course getCourse(long courseId) throws FileNotFoundException {

		// TODO Auto-generated method stub
//		Course cc= null;
//		Optional<Course> cc = courseDao.findById(courseId);
		Session session=factory.getCurrentSession();
		Query q=session.createQuery("from Course c LEFT JOIN FETCH c.questions where c.id=:id",Course.class);
		q.setParameter("id", courseId);
		List<Course> courseList= q.list();
		Course cc= courseList.get(0);
//		Course cc =	session.get(Course.class,courseId);
		FileOutputStream fos = new FileOutputStream("src/main/java/nikhil.jpg");
		byte[] data = cc.getImage();
		try {
			fos.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(Course course : list) {
//			if(course.getId() == courseId ) {
//				c= course;
//				break;
//			}
//		}
		return cc ;

	}
	
	
	
//	@Override
//	public Course getCourse(long courseId) throws FileNotFoundException {
//
//		// TODO Auto-generated method stub
////		Course cc= null;
//		Optional<Course> cc = courseDao.findById(courseId);
//		FileOutputStream fos = new FileOutputStream("src/main/java/nikhil.jpg");
//		byte[] data = cc.get().getImage();
//		try {
//			fos.write(data);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		for(Course course : list) {
////			if(course.getId() == courseId ) {
////				c= course;
////				break;
////			}
////		}
//		return cc.get() ;
//
//	}
	
	
	@Override
	@Transactional
	public Course addCourse(Course course) throws IOException {
//		list.add(course);
		try {
			FileInputStream fin = new FileInputStream("src/main/java/abc.jpg");
			byte[] data = new byte[fin.available()];
			fin.read(data);
			
			course.setImage(data);
			Session session=factory.getCurrentSession();
			session.save(course);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return course;
	}


//	@Override
//	public Course addCourse(Course course) throws IOException {
////		list.add(course);
//		try {
//			FileInputStream fin = new FileInputStream("src/main/java/abc.jpg");
//			byte[] data = new byte[fin.available()];
//			fin.read(data);
//			
//			course.setImage(data);
////			Certificatess ss = new Certificatess();
////			ss.setCourseDuration("nns");
////			ss.setCourseName("nejeemje");
////			course.setCertificate(ss);
////			System.out.println(course.getCertificate());
//			courseDao.save(course);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return course;
//	}

	
	@Override
	@Transactional
	public void deleteCourse(long courseId) {
		
		Session session=factory.getCurrentSession();
		Course c=session.get(Course.class, courseId);
		session.delete(c);

	}
	
//	@Override
//	public void deleteCourse(long courseId) {
//
////		Course abc = courseDao.getOne(courseId);
//		courseDao.deleteById(courseId);
////	list =	list.stream().filter(x->x.getId() != courseId ).collect(Collectors.toList());
//	}

	@Override
	@Transactional
	public Course updateCourse(Course course) {

		Session session=factory.getCurrentSession();
//		Course c=session.get(Course.class, courseId);
		session.update(course);
		return course;
	}

	@Override
	public List<Course> findByTitle(String title) {
		// TODO Auto-generated method 
		List<Course> courseList=	this.courseDao.findByTitle(title);
		return courseList;
	}

	@Override
	public List<Course> findByDescriptionAndTitle(String desc, String title) {
		// TODO Auto-generated method stub
		List<Course> courseList=	this.courseDao.findByDescriptionAndTitle(desc,title);
		return courseList;
	}
	
	
//	@Override
//	public Course updateCourse(Course course) {
////		list.forEach(c->{
////			if(c.getId() == course.getId()) {
////				c.setDescription(course.getDescription());
////				c.setTitle(course.getTitle());
////			}
////		});
//
//		courseDao.save(course);
//		return course;
//	}

}
