package hello.material.pattern.factory.other.refactoring;

/**
 * @author karl xie
 * Created on 2021-07-21 14:20
 */
public class MysqlTeacherServiceImpl extends TeacherService {

    @Override
    public void insert(Teacher teacher) {
        System.out.println("mysql中插入一条老师信息");
    }

    @Override
    public Teacher getTeacher(String id) {
        System.out.println("mysql中查到一条老师信息");
        return Teacher.builder().address("小立").classroom("mysql").build();
    }
}