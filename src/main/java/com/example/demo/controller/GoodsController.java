package com.example.demo.controller;

import com.example.demo.entity.model.Goods;
import com.example.demo.entity.model.JsonResult;
import com.example.demo.service.GoodsService;
import io.swagger.annotations.Api;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



}
