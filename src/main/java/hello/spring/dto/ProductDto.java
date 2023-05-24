package hello.spring.dto;

import hello.spring.dao.ProductDao;
import hello.spring.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {
     private int no;
     private String productName;
     private String productOrigin;
     private int productPrice;
     private String productCategory;
     private String fileName;
     private String id;
     private String seller;
     private String regdate;
     
     public static ProductDto entity2Dto(Product entity){
          return new ProductDtoBuilder()
               .no(entity.getNo())
               .productName(entity.getProductName())
               .productOrigin(entity.getProductOrigin())
               .productPrice(entity.getProductPrice())
               .productCategory(entity.getProductCategory())
               .fileName(entity.getProductFileName())
               .id(entity.getId())
               .regdate(entity.getToday())
               .build();
     }
}
