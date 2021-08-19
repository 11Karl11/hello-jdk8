package hello.material.pattern.factory.other.refactoring;

import hello.utils.CodeUtils;

/**
 * 利用反射来优化抽象工厂
 * todo 用配置文件优化ReflectFactory
 * @author karl xie
 */
public class Client {

    public static void main(String[] args) {
        StudentService studentService = ReflectFactory.generateStudentService();
        Student student = studentService.getStudent("000");
        System.out.println(student);

        CodeUtils.spilt();

        TeacherService teacherService = ReflectFactory.generateTeacherService();
        teacherService.insert(Teacher.builder().build());
    }
}