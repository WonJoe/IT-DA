package com.itda.location;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itda.dto.LocationDTO;
import com.itda.mapper.LocationMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapper locationMapper;

    @Transactional
    public Location save(Location location){

        Double ADJUSTED_LNG = location.getLng();
        Double ADJUSTED_LAT = location.getLat();

        Random random = new Random();

        //실제 좌표에서 0.0~500.0m 얼마나 떨어트릴지 랜덤으로 정하고
        int randomNumber = random.nextInt(499);

        //randomNumber = x^2 + y^2

        //떨어진 좌표에서 x y 값을 x 기준으로 정함
        double x = random.nextInt(randomNumber);
        double y = Math.sqrt((randomNumber * randomNumber) - (x * x));

        //x y 는 제곱근 이므로 부호 랜덤으로 정함
        int sign = random.nextInt(3);

        if(sign==0){
        }else if(sign==1){
            y = (y*(-1));
        }else if(sign==2){
            x = (x*(-1));
        }else{
            x = (x*(-1));
            y = (y*(-1));
        }

        //보정치 적용
        // 경도 1m = 0.0000111~0.0000113
        // 위도 1m = 0.0000084~0.0000091
        ADJUSTED_LNG = ADJUSTED_LNG + (x*0.0000113);
        ADJUSTED_LAT = ADJUSTED_LAT + (y*0.0000091);

        location.setAdjustedLat(ADJUSTED_LAT);
        location.setAdjustedLng(ADJUSTED_LNG);

        return locationRepository.save(location);
    }

    @Transactional(readOnly = true)
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    
    public int maxNum() throws Exception{
        return locationMapper.maxNum();
    }
	
	public void insertData(LocationDTO dto) throws Exception{
        locationMapper.insertData(dto);
    }
	
	public int getDataCount(String searchKey, String searchValue) throws Exception{
        return locationMapper.getDataCount(searchKey, searchValue);
    }
	
	public List<LocationDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception{
        return locationMapper.getList(start, end, searchKey, searchValue);
    }
	
	public LocationDTO getReadData(int num) throws Exception{
        return locationMapper.getReadData(num);
    }
	
	public void updateHitCount(int num) throws Exception{
        locationMapper.updateHitCount(num);
    }
	
	public void updateData(LocationDTO dto) throws Exception{
        locationMapper.updateData(dto);
    }
	
	public void deleteData(int num) throws Exception{
        locationMapper.deleteData(num);
    }

    public List<LocationDTO> getMatchingDistance(long num) throws Exception{
        return locationMapper.getMatchingDistance(num);
    }

}
