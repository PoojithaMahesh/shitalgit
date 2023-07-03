package studentwithhtml.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

import studentwithhtml.dto.Student;

public class StudentDao {

	public EntityManager geEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public Student saveStudent(Student student) {
		EntityManager entityManager=geEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student updateStudent(int id, String name) {
          EntityManager entityManager=geEntityManager();
          Student student=entityManager.find(Student.class, id);
          if(student!=null) {
        	  EntityTransaction entityTransaction=entityManager.getTransaction();
        	  entityTransaction.begin();
        	  student.setId(id);
        	  student.setName(name);
        	  entityManager.merge(student);
        	  entityTransaction.commit();
        	  return student;
          }
		return null;
	}

	public Student findStudentById(int id) {
	EntityManager entityManager=geEntityManager();
	Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			return student;
		}
		return null;
	}

	public Student deleteStudent(int id) {
	EntityManager entityManager=geEntityManager();
	Student student=entityManager.find(Student.class, id);
	if(student!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
	}
		return null;
	}

	public Student getStudentByEmail(String email) {
	EntityManager entityManager=geEntityManager();
	javax.persistence.Query query=entityManager.createQuery("select a from Student a where a.email=?1");
	query.setParameter(1, email);
	Student student=(Student) query.getSingleResult();
	return student;
	
		
	}
	
}
