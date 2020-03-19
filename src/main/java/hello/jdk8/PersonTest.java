package hello.jdk8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Date 2020/3/19 21:01
 * @Created karl xie
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wanwu", 40);
        ArrayList<Person> persons = Lists.newArrayList(person1, person2, person3);
        PersonTest personTest = new PersonTest();
//        List<Person> result = personTest.getPersonByUsername("zhangsan", persons);
//        result.forEach(person -> System.out.println(person.getUsername()));
//        List<Person> personByAge = personTest.getPersonByAge(20, persons);
//        personByAge.forEach(person -> System.out.println(person.getAge()));
//        List<Person> result=personTest.getPersonAge2(20,persons,
//                (age,personList)->personList.stream().filter(
//                        person -> person.getAge()>age
//                ).collect(Collectors.toList()));
//        result.stream().forEach(person -> System.out.println(person.getAge()));

        List<Person> result=personTest.getPersonAge2(20,persons,
                (age,personList)->personList.stream().filter(
                        person -> person.getAge()<=age
                ).collect(Collectors.toList()));
        result.stream().forEach(person -> System.out.println(person.getAge()));

    }


    public List<Person> getPersonByUsername(String username, List<Person> persons) {
        return persons.stream().filter(
                person -> username.equals(person.getUsername()))
                .collect(Collectors.toList());

    }

    public List<Person> getPersonByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction =
                (ageOfPerson, personList) -> personList.stream().
                        filter(person -> person.getAge() > ageOfPerson)
                        .collect(Collectors.toList());
        return biFunction.apply(age, persons);
    }

    public List<Person> getPersonAge2(int age, List<Person> persons
            , BiFunction<Integer, List<Person>, List<Person>> biFunction) {

        return biFunction.apply(age, persons);
    }
}
