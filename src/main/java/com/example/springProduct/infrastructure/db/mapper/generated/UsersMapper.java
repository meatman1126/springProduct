package com.example.springProduct.infrastructure.db.mapper.generated;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.infrastructure.db.generated.Users;
import com.example.springProduct.infrastructure.db.generated.UsersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UsersMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UsersExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UsersExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Id userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Users row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Users row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Users> selectByExample(UsersExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Users> selectByExample(UsersExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Users selectByPrimaryKey(Id userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Users row, @Param("example") UsersExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Users row, @Param("example") UsersExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Users row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Users row);
}