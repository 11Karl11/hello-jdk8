package hello.methodreference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/3/21 17:34
 * @Created karl xie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private int score;

    public static int compareStudentByScore(Student student1, Student student2) {
        return student1.getScore()-student2.getScore();
    }
    public static int compareStudentByName(Student student1,Student student2){
        return student1.getName().compareTo(student2.getName());

    }

    public int compareByScore(Student student){
        return this.getScore()-student.getScore();
    }

    public int compareByName(Student student){
        return this.getName().compareToIgnoreCase(student.getName());
    }

}
