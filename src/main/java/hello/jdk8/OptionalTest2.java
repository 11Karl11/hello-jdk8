package hello.jdk8;

import com.google.common.collect.Lists;


import java.util.Optional;

/**
 * @Description TODO
 * @Date 2020/3/21 16:17
 * @Created karl xie
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Employee zhangsan = new Employee("zhangsan");
        Employee lisi = new Employee("lisi");
        Company company = new Company();
       // company.setEmployees(Lists.newArrayList(zhangsan, lisi));
        company.setName("company1");

        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(
                theCompany -> theCompany.getEmployees())
                .orElse(Lists.newArrayList()));
    }
    //不建议用Optional当做方法参数
    public void test(Optional optional){

    }
}
