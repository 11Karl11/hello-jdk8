package hello.advance.pattern.builder.first;

/**
 * @author karl xie
 */
public class MyBuilder {

    public MyBuilder() {
        this.setName("default name");
        this.setYear("default year");
        this.setSex("default sex");
    }

    private String name;

    private String year;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    MyBuilder withName(String name) {
        this.setName(name);
        return this;
    }


    MyBuilder withYear(String year) {
        this.setYear(year);
        return this;
    }


    MyBuilder withSex(String sex) {
        this.setSex(sex);
        return this;
    }

    @Override
    public String toString() {
        return "MyBuilder{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}