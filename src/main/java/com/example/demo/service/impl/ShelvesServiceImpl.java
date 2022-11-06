package com.example.demo.service.impl;

import com.example.demo.entity.model.Shelves;
import com.example.demo.entity.model.ShelvesExample;
import com.example.demo.mapper.ShelvesMapper;
import com.example.demo.service.ShelvesService;
import com.example.demo.utils.JwtTokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class ShelvesServiceImpl implements ShelvesService {
    @Resource
    private ShelvesMapper shelvesMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    public List<Shelves> selectAllShelves(){
        ShelvesExample se=new ShelvesExample();
        ShelvesExample.Criteria ce=se.createCriteria();
        ce.andShelvesIdIsNull();
        List<Shelves> shelvesList=shelvesMapper.selectByExample(se);
        return shelvesList;}

    public Shelves selectShelves(Integer shelvesId){
        Shelves shelves=shelvesMapper.selectByPrimaryKey(shelvesId);
        return shelves;}

    public Boolean addShelves(Shelves shelves){
        shelvesMapper.insert(shelves);
        return  true;}


    public Boolean addShelvesList(List<Shelves> shelvesList){
        for (Shelves shelves:shelvesList){
            shelvesMapper.insert(shelves);
        }
        return true;
    }

    public Boolean updateShelves(Shelves shelves){
        shelvesMapper.updateByPrimaryKey(shelves);
        return  true;}

    public Boolean removeShelves(Integer shelvesId){
        shelvesMapper.deleteByPrimaryKey(shelvesId);
        return  true;}

    public Boolean removeShelvesList(List<Integer> shelvesIdList){
        for(Integer shelvesId :shelvesIdList){
            shelvesMapper.deleteByPrimaryKey(shelvesId);
        }
        return  true;}

    public List<Shelves> selectShelvesByTime(String mixTime,String maxTime){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        ShelvesExample se=new ShelvesExample();
        ShelvesExample.Criteria ce=se.createCriteria();
        try {
            ce.andTimesBetween(sdf.parse(mixTime),sdf.parse(maxTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Shelves> shelvesList=shelvesMapper.selectByExample(se);
        return shelvesList;}
}
