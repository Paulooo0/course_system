package br.com.pauloh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Test;

import br.com.pauloh.dao.IStudentDAO;
import br.com.pauloh.dao.StudentDAO;

public class StudentTest {
    private IStudentDAO studentDAO;
    // TODO: relation with course and registration

    public StudentTest() {
        studentDAO = new StudentDAO();
    }

    @After
    public void tearDown() {
        studentDAO.findAll().forEach(student -> studentDAO.delete(student));
    }

    @Test
    public void createCourseTest() {
        Student student = new Student();

        student.setCode("A1");
        student.setName("Name1");
        student.setLastName("LastName1");
        student = studentDAO.create(student);

        assertNotNull(student);
        assertNotNull(student.getId());
    }

    @Test
    public void findByIdCourseTest() {
        Student student = new Student();

        student.setCode("A2");
        student.setName("Name2");
        student.setLastName("LastName2");
        student = studentDAO.create(student);

        Student findById = studentDAO.read(student.getId());

        assertEquals(findById.getId(), student.getId());
    }

    @Test
    public void updateCourseTest() {
        Student student = new Student();

        student.setCode("A3");
        student.setName("Name3");
        student.setLastName("LastName3");
        student = studentDAO.create(student);

        student.setCode("A4");
        student.setName("Name4");
        student.setLastName("LastName4");
        student = studentDAO.update(student);

        assertNotNull(student);
        assertNotNull(student.getId());
    }

    @Test
    public void deleteCourseTest() {
        Student student = new Student();

        student.setCode("A5");
        student.setName("Name5");
        student.setLastName("LastName5");
        student = studentDAO.create(student);

        studentDAO.delete(student);

        Student deletedStudent = studentDAO.read(student.getId());
        assertNull(deletedStudent);
    }

    @Test
    public void findAllCourseTest() {
        Student student = new Student();

        student.setCode("A6");
        student.setName("Name6");
        student.setLastName("LastName6");
        student = studentDAO.create(student);

        Student student2 = new Student();

        student2.setCode("A7");
        student2.setName("Name7");
        student2.setLastName("LastName7");
        student2 = studentDAO.create(student2);

        assertEquals(2, studentDAO.findAll().size());
    }
}
