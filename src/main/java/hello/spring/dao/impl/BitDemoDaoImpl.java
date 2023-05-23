package hello.spring.dao.impl;

import hello.spring.dao.BitDemoDao;
import hello.spring.data.BitDemoMapper;
import hello.spring.dto.BitDemoDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BitDemoDaoImpl implements BitDemoDao {
     @Autowired
     private SqlSessionTemplate sqlSession;
     @Override
     public void bitDemoInsert(BitDemoDto bitDemoDto) {
          BitDemoMapper mapper = sqlSession.getMapper(BitDemoMapper.class);
          mapper.insertDemo(bitDemoDto);
     }
     
     @Override
     public List<BitDemoDto> selectAll() {
          List<BitDemoDto> bitDemoDtoList = null;
          BitDemoMapper mapper = sqlSession.getMapper(BitDemoMapper.class);
          bitDemoDtoList = mapper.selectAll();
          return bitDemoDtoList;
     }
}
