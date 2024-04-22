package com.itda.item;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itda.dto.ItemDTO;
import com.itda.mapper.ItemMapper;
import com.itda.users.Users;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Transactional
    public void use(ItemDTO dto) throws Exception{
        itemMapper.use(dto);
    }

    @Transactional
    public Item save(Users users){

        Item item = new Item();

        item.setUserNo(users.getUserNo());

        return itemRepository.save(item);
    }

}
