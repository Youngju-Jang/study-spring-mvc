package hello.spring.data;

import hello.spring.dto.BitDemoDto;

import java.util.List;

public interface BitDemoMapper {
     void insertDemo(BitDemoDto bitDemoDto);
     List<BitDemoDto> selectAll();
}
