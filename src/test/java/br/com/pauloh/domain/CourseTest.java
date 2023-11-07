package br.com.pauloh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Test;

import br.com.pauloh.dao.CourseDAO;
import br.com.pauloh.dao.ICourseDAO;

public class CourseTest {
    private ICourseDAO courseDAO;
    // TODO: relation with Student

    public CourseTest() {
        courseDAO = new CourseDAO();
    }

    @After
    public void tearDown() {
        courseDAO.findAll().forEach(course -> courseDAO.delete(course));
    }

    @Test
    public void createCourseTest() {
        Course course = new Course();

        course.setCode("A1");
        course.setDecription("Curso teste");
        course.setName("curso de Java Backend");
        course = courseDAO.create(course);

        assertNotNull(course);
        assertNotNull(course.getId());
    }

    @Test
    public void findByIdCourseTest() {
        Course course = new Course();

        course.setCode("A2");
        course.setDecription("Curso teste");
        course.setName("curso de Java Backend");
        course = courseDAO.create(course);

        Course findById = courseDAO.read(course.getId());

        assertEquals(findById.getId(), course.getId());
    }

    @Test
    public void updateCourseTest() {
        Course course = new Course();

        course.setCode("A3");
        course.setDecription("Curso teste");
        course.setName("curso de Java Backend");
        course = courseDAO.create(course);

        course.setCode("A4");
        course.setDecription("Curso teste");
        course.setName("curso de Java Backend");
        course = courseDAO.update(course);

        assertNotNull(course);
        assertNotNull(course.getId());
    }

    @Test
    public void deleteCourseTest() {
        Course course = new Course();

        course.setCode("A5");
        course.setDecription("Curso teste");
        course.setName("curso de Java Backend");
        course = courseDAO.create(course);

        courseDAO.delete(course);

        Course deletedCourse = courseDAO.read(course.getId());
        assertNull(deletedCourse);
    }

    @Test
    public void findAllCourseTest() {
        Course course = new Course();

        course.setCode("A6");
        course.setDecription("Curso teste");
        course.setName("curso de Java Backend");
        course = courseDAO.create(course);

        Course course2 = new Course();

        course2.setCode("A7");
        course2.setDecription("Curso teste");
        course2.setName("curso de Java Backend");
        course2 = courseDAO.create(course2);

        assertEquals(2, courseDAO.findAll().size());
    }
}
