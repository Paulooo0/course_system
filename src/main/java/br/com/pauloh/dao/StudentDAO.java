package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Student;

public class StudentDAO extends GenericDAO<Student> implements IStudentDAO {
    public StudentDAO() {
        super(Student.class);
        new GenericDAO<>(Student.class);
    }
}
