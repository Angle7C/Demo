package com.example.demo.service;

import com.example.demo.entity.model.Shelves;

import java.util.List;

public interface ShelvesService {
    default List<Shelves> selectAllShelves(){ return null;}
    default Shelves selectShelves(Integer shelvesId){ return null;}
    default Boolean addShelves(Shelves shelves){return  false;}
    default Boolean addShelvesList(List<Shelves> shelvesList){return  false;};
    default Boolean updateShelves(Shelves shelves){return  false;}
    default Boolean removeShelves(Integer shelvesId){return  false;}
    default Boolean removeShelvesList(List<Integer> shelvesIdList){return  false;}
    default List<Shelves> selectShelvesByTime(String mixTime,String maxTime){ return null;}


}
