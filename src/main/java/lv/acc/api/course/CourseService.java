package lv.acc.api.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	private CourseRepository courseRepository;
	
//	List<Course> Courses = new ArrayList<Course>(Arrays.asList(new Course("spring", "Spring Framework", "Cool description"),
//			new Course("java", "Java Framework ", "Java description"),
//			new Course("javascript", "Javascript Framework", "Javascript description")));

	public List<Course> getAllCourses(String topicId) {
		logger.info("getAllCourses executed");
		//return Courses;
		List<Course> Courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(Courses::add);
		return Courses;
	}

	public Course getCourse(String id) {
		//return Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Optional<Course> res =  courseRepository.findById(id);
		return res.isPresent() ? res.get() : null;
	}

	public void addCourse(Course Course) {
		courseRepository.save(Course);

	}

	public void updateCourse(Course Course) {
//		for (int i = 0; i < Courses.size(); i++) {
//			Course t = Courses.get(i);
//			if (t.getId().equals(id)) {
//				Courses.set(i, Course);
//				logger.info("updated Course with Id: " + id);
//				return;
//			}
//		}
		
		courseRepository.save(Course);

	}

	public void deleteCourse(String id) {
//		Predicate<Course> CourseDeletePredicate = (Course t) -> {
//			if (t.getId().equals(id)) {
//				logger.info("removing Course with Id: " + id);
//				return true;
//			}
//			return false;
//		};
//		Courses.removeIf(CourseDeletePredicate);
		courseRepository.deleteById(id);

	}
}
