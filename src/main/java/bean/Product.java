package bean;

import lombok.Data;

import java.util.Date;
@Data
public class Product {
    private Integer pid;
    private String pname;
    private String type;
    private double price;
    private Date createTime;


    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", create_time=" + createTime +
                '}';
    }
}
