package exercise.bean;

/**
 * @Description
 * @date 2021/3/1 0001-20:54
 */
public class car {
    public car(){
        System.out.println("car is constructing...");
    }
    public void init(){
        System.out.println("car init...");
    }
    public void destroy(){
        System.out.println("car destroy...");
    }
}
