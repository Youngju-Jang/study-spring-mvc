package hello.spring.service.impl;

import hello.spring.dao.BitDemoDao;
import hello.spring.dto.BitDemoDto;
import hello.spring.service.BitDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitDemoServiceImpl implements BitDemoService {
     
     @Autowired
     private BitDemoDao dao;
     @Override
     public void bitDemoInsert(BitDemoDto bitDemoDto) {
          dao.bitDemoInsert(bitDemoDto);
     }
     
     @Override
     public List<BitDemoDto> selectAll() {
          return dao.selectAll();
     }
}
