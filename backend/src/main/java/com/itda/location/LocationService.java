package com.itda.location;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LocationService {
    
    @Transactional
    public Location save(Location location){
        return locationRepository.save(location);
    }
}
