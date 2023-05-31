package hello.spring.service.impl;

import hello.spring.dao.CartDao;
import hello.spring.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
     private final CartDao cartDao;
     
     
}
