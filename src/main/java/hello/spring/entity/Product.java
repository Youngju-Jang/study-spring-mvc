package hello.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
     private int no;
     private String productName;
     private String productOrigin;
     private int productPrice;
     private String productCategory;
     private String productFileName;
     private String id;
     private String today;
}
