package methodreference;

/**
 * @Description TODO
 * @Date 2020/3/21 21:18
 * @Created karl xie
 */
public class StudentComparator {
    public int compareStudentBySore(Student student1,Student student2){
        return student1.getScore()-student2.getScore();
    }

    public int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());
    }
}
