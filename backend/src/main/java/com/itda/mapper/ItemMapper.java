package com.itda.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itda.dto.ItemDTO;

@Mapper
public interface ItemMapper {
    
    public void use(ItemDTO dto) throws Exception;

}
