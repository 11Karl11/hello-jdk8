package hello.material.pattern.factory.other.refactoring;

/**
 * @author karl xie
 */
public class ReflectFactory {

    private static String studentServiceClassPath = "hello.material.pattern.factory.other.refactoring.MysqlStudentServiceImpl";
    private static String teacherServiceClassPath = "hello.material.pattern.factory.other.refactoring.MysqlTeacherServiceImpl";


    // private static String studentServiceClassPath = "hello.material.pattern.factory.other.refactoring.SqlserverStudentServiceImpl";
    // private static String teacherServiceClassPath = "hello.material.pattern.factory.other.refactoring.SqlserverTeacherServiceImpl";

    public static StudentService generateStudentService() {
        StudentService studentService = null;
        try {
            studentService = (StudentService) Class.forName(studentServiceClassPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentService;
    }


    public static TeacherService generateTeacherService() {
        TeacherService teacherService = null;
        try {
            teacherService = (TeacherService) Class.forName(teacherServiceClassPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return teacherService;
    }


}