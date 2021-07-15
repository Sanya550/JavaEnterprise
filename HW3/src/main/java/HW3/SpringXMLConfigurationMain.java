package HW3;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class SpringXMLConfigurationMain {
    public static void main(String[] args) throws IOException {
        File file = ResourceUtils.getFile("E:\\TestOfSpring\\src\\main\\resources\\CSV.csv");
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.print(content);
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ContextOfApplication.xml");

        Data data = (Data) ac.getBean("data");
        String name = data.getName();
        System.out.print(name + ";");
        String surname = data.getSurname();
        System.out.print(surname + ";");
        int age = data.getAge();
        System.out.print(age + ";");
        String country = data.getCountry();
        System.out.print(country + ";");
        double weight = data.getWeight();
        System.out.print(weight + ";");
        double height = data.getHeight();
        System.out.print(height + ";");
        long phone = data.getPhone();
        System.out.print(phone);
        ac.close();
    }

}
