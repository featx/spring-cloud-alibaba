package org.featx.templet.springcloudalibaba.domian.mapper;

import org.featx.templet.springcloudalibaba.domian.model.ThirdPartChannel;
import org.featx.templet.springcloudalibaba.entity.Channel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ChannelMapper {
    @Insert({"insert into t_coin(name, code, type) values(",
            "#{coin.name},","#{coin.code},","#{coin.type}",
            ")"})
    int insert(@Param("coin") ThirdPartChannel coin);

    int insertSelective(ThirdPartChannel coin);

    int updateByPrimaryKeySelective(ThirdPartChannel coin);

    int updateByPrimaryKey(ThirdPartChannel coin);

    @Update({"update t_coin set deleted = 1 where id=#{id}"})
    int deleteByPrimaryKey(Long id);

    @Select({"select * from t_coin where deleted = 0 and id=#{id}"})
    Channel selectByPrimaryKey(Long id);

    @Select({"select * from t_coin where deleted = 0 and code=#{code}"})
    Channel selectByCode(String code);
}