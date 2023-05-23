package hello.spring.dao.impl;

import hello.spring.dao.BitDemoDao;
import hello.spring.data.BitDemoMapper;
import hello.spring.dto.BitDemoDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BitDemoDaoImpl implements BitDemoDao {
     @Autowired
     private SqlSessionTemplate sqlSession;
     @Override
     public void bitDemoInsert(BitDemoDto bitDemoDto) {
          BitDemoMapper mapper = sqlSession.getMapper(BitDemoMapper.class);
          mapper.insertDemo(bitDemoDto);
     }
}
