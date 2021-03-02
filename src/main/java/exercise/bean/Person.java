package exercise.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description
 * @date 2021/1/17-15:34
 */
public class Person {
    /**
     * 可以使用@Value赋值
     * 1 基本数值
     * 2 可以写Spel  #{}
     * 3 可以写${}:取出配置文件（properties）中的值（在运行环境变量里面的值）
     */
    @Value("${person.name}")
    private String name;
    @Value("#{20-2}")
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
