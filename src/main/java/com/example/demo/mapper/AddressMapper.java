package com.example.demo.mapper;

import com.example.demo.entity.model.Address;
import com.example.demo.entity.model.AddressExample;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(String addressId);

    int insert(Address row);

    int insertSelective(Address row);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(String addressId);

    int updateByExampleSelective(@Param("row") Address row, @Param("example") AddressExample example);

    int updateByExample(@Param("row") Address row, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address row);

    int updateByPrimaryKey(Address row);
}