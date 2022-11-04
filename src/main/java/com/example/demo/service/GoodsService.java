package com.example.demo.service;

import com.example.demo.entity.model.Goods;

import java.util.List;

public interface GoodsService {
    default Goods selectGoodsById(String goodId){return null;}
    default Boolean addGoods(Goods goods){return false;}
    default Boolean updateGoods(Goods goods){return false;}
    default Boolean removeGoods(String goodId){return false;}
    default Boolean addGoodsList(List<Goods> goodsList){return false;}
    default Boolean removeGoodsList(List<String> goodIdList){return false;}
    default List<Goods> selectGoodsListByName(String goodName){return null;}
    default List<Goods> selectGoodsListByType(String types){return null;}
    default List<Goods> selectGoodsListByZone(String zone){return null;}
    default List<Goods> selectGoodsListByValueSection(Double value1,Double value2){return null;}



}
