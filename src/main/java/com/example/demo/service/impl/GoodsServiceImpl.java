package com.example.demo.service.impl;

import com.example.demo.entity.model.Goods;
import com.example.demo.entity.model.GoodsExample;
import com.example.demo.entity.model.UserExample;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.GoodsService;
import com.example.demo.utils.JwtTokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    public Goods selectGoodsById(String goodId){
        Goods goods=goodsMapper.selectByPrimaryKey(goodId);
        return goods;}

    public Boolean addGoods(Goods goods){
        goodsMapper.insert(goods);
        return true;}

    public Boolean updateGoods(Goods goods){
        goodsMapper.updateByPrimaryKey(goods);
        return true;}

    public Boolean removeGoods(String goodId){
        goodsMapper.deleteByPrimaryKey(goodId);
        return true;}

    public Boolean removeGoodsList(List<String> goodIdList){
        for(String goodId : goodIdList){
            goodsMapper.deleteByPrimaryKey(goodId);
          }
        return true;}

    public List<Goods> selectGoodsListByIds(List<String> goodIdList){
        List<Goods> goodsList=new ArrayList<>();
        for(String goodId : goodIdList){
            goodsList.add(goodsMapper.selectByPrimaryKey(goodId));
        }
        return goodsList;}

    public List<Goods> selectGoodsListByName(String goodName){
        GoodsExample ge=new GoodsExample();
        GoodsExample.Criteria ce=ge.createCriteria();
        ce.andGoodNameLike(goodName);
        List<Goods> goodsList=goodsMapper.selectByExample(ge);
        return goodsList;}

    public List<Goods> selectGoodsListByType(String types){
        GoodsExample ge=new GoodsExample();
        GoodsExample.Criteria ce=ge.createCriteria();
        ce.andGoodNameLike(types);
        List<Goods> goodsList=goodsMapper.selectByExample(ge);
        return goodsList;}

    public List<Goods> selectGoodsListByZone(String zone){
        GoodsExample ge=new GoodsExample();
        GoodsExample.Criteria ce=ge.createCriteria();
        ce.andZoneEqualTo(zone);
        List<Goods> goodsList=goodsMapper.selectByExample(ge);
        return goodsList;}

    public List<Goods> selectGoodsListByValueSection(Double mixValue,Double maxValue){
        GoodsExample ge=new GoodsExample();
        GoodsExample.Criteria ce=ge.createCriteria();
        ce.andGoodValueBetween(mixValue, maxValue);
        List<Goods> goodsList=goodsMapper.selectByExample(ge);
        return goodsList;}


}
