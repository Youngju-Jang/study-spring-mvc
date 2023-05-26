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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
     
     private final ProductDao productDao;
     private final String downImagePath = "/Users/joj1043/Documents/repository/inf_subBranch/study-spring-mvc/src/main/webapp/resources/downImage";
     
     @Override
     public void productInsert(ProductRequestDto productRequestDto, User user) {
          // get file String name from multipart
          String fileName = null;
          try {
               fileName = saveFile(productRequestDto.getFile(), downImagePath);
          } catch (Exception e) {
               e.printStackTrace();
          }
          // dto to entity
          Product product = new Product(productRequestDto, user.getUserId(), fileName);
          productDao.productInsert(product);
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
     
     public String saveFile(MultipartFile file, String directoryPath) throws IOException {
          // parent directory를 찾는다.
          Path directory = Paths.get(directoryPath).toAbsolutePath().normalize();
          
          // directory 해당 경로까지 디렉토리를 모두 만든다.
          Files.createDirectories(directory);
          
          // 파일명을 바르게 수정한다.
          String fileName = StringUtils.cleanPath(file.getOriginalFilename());
          
          // 파일명에 '..' 문자가 들어 있다면 오류를 발생하고 아니라면 진행(해킹및 오류방지)
          Assert.state(!fileName.contains(".."), "Name of file cannot contain '..'");
          // 파일을 저장할 경로를 Path 객체로 받는다.
          Path targetPath = directory.resolve(fileName).normalize();
          
          // 파일이 이미 존재하는지 확인하여 존재한다면 오류를 발생하고 없다면 저장한다.
          Assert.state(!Files.exists(targetPath), fileName + " File already exists.");
          file.transferTo(targetPath);
          
          return fileName;
     }
}
