package hello.spring.dto;

import hello.spring.entity.Product;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequestDto {
     private int no;
     private String productName;
     private String productOrigin;
     private int productPrice;
     private String productCategory;
     private MultipartFile file;
     private String id;
     private String seller;
     private String regdate;
}
