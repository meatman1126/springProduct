package com.example.springProduct.infrastructure.db.mapper.generated;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.infrastructure.db.generated.GenUsers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GenUsersMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Id userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(GenUsers row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(GenUsers row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    GenUsers selectByPrimaryKey(Id userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(GenUsers row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(GenUsers row);
}