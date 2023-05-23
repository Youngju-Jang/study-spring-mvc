package hello.spring.service;

import hello.spring.dto.BitDemoDto;

import java.util.List;

public interface BitDemoService {
     public void bitDemoInsert(BitDemoDto bitDemoDto);
     public List<BitDemoDto> selectAll();
}
