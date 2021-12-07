package edu.soft1.pojo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.ws.soap.Addressing;

@Data
public class User {
    String username;
    int age;
    @DateTimeFormat(pattern = "yyyy-mm-dd")//类型转换
    Data birthday;
    //自定义对象类型
    Address address;
}
