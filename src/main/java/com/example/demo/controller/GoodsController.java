package com.example.demo.controller;

import com.example.demo.entity.model.Goods;
import com.example.demo.entity.model.JsonResult;
import com.example.demo.service.GoodsService;
import io.swagger.annotations.Api;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "GoodController")
@Setter(onMethod_ = {@Autowired})
public class GoodsController {
  private GoodsService goodsService;

  @GetMapping("selectgoodsbyid/{goodId}")
  public JsonResult<Goods> selectGoodsById(@PathVariable String goodId){

    return new JsonResult("查找成功",goodsService.selectGoodsById(goodId));
  }

  @PostMapping("addgoods")
  public JsonResult<String> addGoods(@ModelAttribute Goods goods){
    if(goodsService.addGoods(goods)){
      return new JsonResult("新增成功");
    }else {
      return new JsonResult("新增失败");
    }
  }

  @PutMapping("updategoods")
  public JsonResult<String> updateGoods(@ModelAttribute Goods goods){
    if(goodsService.updateGoods(goods)){
      return new JsonResult("修改成功");
    }else {
      return new JsonResult("修改失败");
    }
  }

  @DeleteMapping("removegoods/{goodId}")
  public JsonResult<String> removeGoods(@PathVariable String goodId){
    if(goodsService.removeGoods(goodId)){
      return new JsonResult("删除成功");
    }else {
      return new JsonResult("删除失败");
    }
  }

  @DeleteMapping("removeGoodsList")
  public JsonResult<String> removeGoodsList(@ModelAttribute List<String> goodIdList){
    if(goodsService.removeGoodsList(goodIdList)){
      return new JsonResult("删除成功");
    }else {
      return new JsonResult("删除失败");
    }
  }

  @GetMapping("selectgoodslistbyids")
  public JsonResult<List<Goods>> selectGoodsListByIds(@ModelAttribute List<String> goodIdList){

    return new JsonResult("查找成功",goodsService.selectGoodsListByIds(goodIdList));
  }

 @GetMapping("selectgoodsliistbyname/{goodName}")
  public JsonResult<List<Goods>> selectGoodsListByName(@PathVariable String goodName){

   return new JsonResult("查找成功",goodsService.selectGoodsListByName(goodName));
 }

  @GetMapping("selectgoodsliistbyzone/{zone}")
  public JsonResult<List<Goods>> selectGoodsListByZone(@PathVariable String zone){

    return new JsonResult("查找成功",goodsService.selectGoodsListByZone(zone));
  }

  @GetMapping("selectgoodsliistbyvaluesection/{mixValue}/{maxValue}")
  public JsonResult<List<Goods>> selectGoodsListByValueSection(@PathVariable Double mixValue,@PathVariable Double maxValue){

    return new JsonResult("查找成功",goodsService.selectGoodsListByValueSection(mixValue,maxValue));
  }




}
