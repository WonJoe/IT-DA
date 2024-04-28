package com.itda.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itda.dto.LocationDTO;
import com.itda.dto.LocationSelectedDTO;
import com.itda.mapper.LocationMapper;
import com.itda.users.Users;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LocationSelectedService {

    @Autowired
    private LocationSelectedRepository locationSelectedRepository;

    @Autowired
    private LocationMapper locationMapper;

   
    // @Transactional
    // public LocationSelected save(Users users){

    //     LocationSelected locationSelected = new LocationSelected();

    //     locationSelected.setUserNo(users.getUserNo());

    //     return locationSelectedRepository.save(locationSelected);
    // }

    @Transactional
    public void selected(LocationSelectedDTO dto) throws Exception{

        locationMapper.selected(dto);

    }

   
}
