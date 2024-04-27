package com.itda.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.itda.dto.ItemDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @CrossOrigin
    @PostMapping("/useDia")
    public void use(@RequestBody Item  item) throws Exception{

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setUserNo(item.getUserNo());
        itemDTO.setDia(item.getDia());
        itemDTO.setPinn(item.getPinn());

        itemService.use(itemDTO);
    }
    
    

}
