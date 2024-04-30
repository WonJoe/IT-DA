package com.itda.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itda.dto.ItemDTO;

@Mapper
public interface ItemMapper {
    
    public void use(ItemDTO dto) throws Exception;

    public void charge(ItemDTO dto) throws Exception;

    public ItemDTO getReadData(Long userNo) throws Exception;

}
