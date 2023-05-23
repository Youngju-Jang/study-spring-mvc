package hello.spring.dao;

import hello.spring.dto.BitDemoDto;

import java.util.List;

public interface BitDemoDao {
     public void bitDemoInsert(BitDemoDto bitDemoDto);
     
     List<BitDemoDto> selectAll();
}
