package hello.material.pattern.factory.other.refactoring;

/**
 * @author karl xie
 * Created on 2021-07-21 14:20
 */
public class MysqlStudentServiceImpl extends StudentService {

    @Override
    public void insert(Student student) {
        System.out.println("mysql中插入一条学生信息");
    }

    @Override
    public Student getStudent(String id) {
        System.out.println("mysql中查到一条学生信息");
        return Student.builder().age(1).name("张三---mysql").build();
    }
}