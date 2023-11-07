package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Course;

public class CourseDAO extends GenericDAO<Course> implements ICourseDAO {
    public CourseDAO() {
        super(Course.class); 
        new GenericDAO<>(Course.class);
    }
}
