package hello.spring.service.impl;

import hello.spring.dao.ProductDao;
import hello.spring.dto.ProductRequestDto;
import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.Product;
import hello.spring.entity.User;
import hello.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
     
     private final ProductDao productDao;
     private final String downImagePath = "/Users/joj1043/Documents/repository/inf_subBranch/study-spring-mvc/src/main/webapp/resources/downImage/";
     
     @Override // 상품 Insert
     public void productInsert(ProductRequestDto productRequestDto, User user) {
          // get file String name from multipart
          FileOutputStream fos;
          MultipartFile file = productRequestDto.getFile();
          String fileDemo = createFileName(file.getOriginalFilename());
          saveImage(file, fileDemo);
          // dto to entity
          productDao.productInsert(new Product(productRequestDto, user.getUserId(), fileDemo));
     }
     
     // 이미지 저장하기
     private void saveImage(MultipartFile file, String fileDemo) {
          FileOutputStream fos;
          if (fileDemo.length() > 0) {
               try{
                    fos = new FileOutputStream(downImagePath + fileDemo);
                    fos.write(file.getBytes());
               } catch (Exception e) {
                    e.printStackTrace();
               }
          }
     }
     // 먼저 파일 업로드 시, 파일명을 난수화하기 위해 random으로 돌립니다.
     private String createFileName(String fileName) {
          return UUID.randomUUID().toString().concat(fileName);
     }
     
     @Override
     public List<ProductResponseDto> selectAll(HashMap<String, Object> hashMap) {
          List<Product> productList = productDao.selectAll(hashMap);
          if (productList == null) {
               return null;
          }
          return productList.stream().map(ProductResponseDto::entity2Dto).collect(Collectors.toList());
     }
     
     @Override
     public int countAll() {
          return productDao.countAll();
     }
}
