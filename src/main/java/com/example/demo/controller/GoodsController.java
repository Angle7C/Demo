package com.example.demo.controller;

import com.example.demo.entity.model.Goods;
import com.example.demo.entity.model.JsonResult;
import com.example.demo.entity.model.Shelves;
import com.example.demo.service.GoodsService;
import com.example.demo.service.ShelvesService;
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
  private ShelvesService shelvesService;

  //根据goodId查找商品
  @GetMapping("selectgoodsbyid/{goodId}")
  public JsonResult<Goods> selectGoodsById(@PathVariable String goodId){

    return new JsonResult("查找成功",goodsService.selectGoodsById(goodId));
  }

  //查询所有商品
    @GetMapping("selectallgoods")
  public JsonResult<List<Goods>> selectAllGoods(){

      return new JsonResult("查找成功",goodsService.selectAllGoods());
  }

  //新增goods
  @PostMapping("addgoods")
  public JsonResult<String> addGoods(@ModelAttribute Goods goods){
    if(goodsService.addGoods(goods)){
      return new JsonResult("新增成功");
    }else {
      return new JsonResult("新增失败");
    }
  }

  //更新goods
  @PutMapping("updategoods")
  public JsonResult<String> updateGoods(@ModelAttribute Goods goods){
    if(goodsService.updateGoods(goods)){
      return new JsonResult("修改成功");
    }else {
      return new JsonResult("修改失败");
    }
  }

  //删除单个goods
  @DeleteMapping("removegoods/{goodId}")
  public JsonResult<String> removeGoods(@PathVariable String goodId){
    if(goodsService.removeGoods(goodId)){
      return new JsonResult("删除成功");
    }else {
      return new JsonResult("删除失败");
    }
  }

  //删除多个goods
  @DeleteMapping("removegoodslist")
  public JsonResult<String> removeGoodsList(@ModelAttribute List<String> goodIdList){
    if(goodsService.removeGoodsList(goodIdList)){
      return new JsonResult("删除成功");
    }else {
      return new JsonResult("删除失败");
    }
  }

  //根据多个goodId查找商品-查看订单
  @GetMapping("selectgoodslistbyids")
  public JsonResult<List<Goods>> selectGoodsListByIds(@ModelAttribute List<String> goodIdList){

    return new JsonResult("查找成功",goodsService.selectGoodsListByIds(goodIdList));
  }

  //模糊查询goods
  @GetMapping("selectgoodslistbyname/{goodName}")
   public JsonResult<List<Goods>> selectGoodsListByName(@PathVariable String goodName){

    return new JsonResult("查找成功",goodsService.selectGoodsListByName(goodName));
 }

  //根据类型查找goods
  @GetMapping("selectgoodslistbytype/{type}")
  public JsonResult<List<Goods>> selectGoodsListByType(@PathVariable String type){

    return new JsonResult("查找成功",goodsService.selectGoodsListByType(type));
  }

  //根据产区查找goods
  @GetMapping("selectgoodslistbyzone/{zone}")
  public JsonResult<List<Goods>> selectGoodsListByZone(@PathVariable String zone){

    return new JsonResult("查找成功",goodsService.selectGoodsListByZone(zone));
  }

  //根据价格区间查找goods
  @GetMapping("selectgoodslistbyvaluesection/{mixValue}/{maxValue}")
  public JsonResult<List<Goods>> selectGoodsListByValueSection(@PathVariable Double mixValue,@PathVariable Double maxValue){

    return new JsonResult("查找成功",goodsService.selectGoodsListByValueSection(mixValue,maxValue));
  }

  //查找所有上架商品
  @GetMapping("selectallshelves")
  public JsonResult<List<Shelves>> selectAllShelves(){

      return new JsonResult("查找成功",shelvesService.selectAllShelves());
  }

  //根据shelvesId查找上架商品
  @GetMapping("selectshelves/{shelvesId}")
    public JsonResult<Shelves> selectShelves(@PathVariable Integer shelvesId){

      return new JsonResult("查找成功",shelvesService.selectShelves(shelvesId));
  }

  //新增上架
  @PostMapping("addshelves")
    public JsonResult<String> addShelves(@ModelAttribute Shelves shelves){
      if(shelvesService.addShelves(shelves)){
          return  new JsonResult("上架成功");
      }else{
          return  new JsonResult("上架失败");
      }
  }
  //批量上架
  @PostMapping("addshelveslist")
  public JsonResult<String> addShelvesList(@ModelAttribute List<Shelves> shelvesList){
      if(shelvesService.addShelvesList(shelvesList)){
          return  new JsonResult("上架成功");
      }else{
          return  new JsonResult("上架失败");
      }
  }

  //更新上架商品信息
  @PutMapping("updateshelves")
    public JsonResult<String> updateShelves(@ModelAttribute Shelves shelves){
      if(shelvesService.updateShelves(shelves)){
          return  new JsonResult("更新成功");
      }else {
          return  new JsonResult("更新失败");
      }
  }

  //下架单个商品
  @DeleteMapping("removeshelves/{shelvesId}")
  public JsonResult<String> removeShelves(@PathVariable Integer shelvesId){
      if(shelvesService.removeShelves(shelvesId)){
          return  new JsonResult("删除成功");
      }else {
          return  new JsonResult("删除失败");
      }
  }

    //批量下架
    @DeleteMapping("removeshelveslist")
    public JsonResult<String> removeShelvesList(@ModelAttribute List<Integer> shelvesIdList){
        if(shelvesService.removeShelvesList(shelvesIdList)){
            return  new JsonResult("删除成功");
        }else {
            return  new JsonResult("删除失败");
        }
    }

    //根据上架时间区间查找上架商品
    @GetMapping("selectshelvesbytime/{mixTime}/{maxTime}")
    public JsonResult<List<Shelves>> selectShelvesByTime(@PathVariable String mixTime,@PathVariable String maxTime){

      return  new JsonResult("查询成功",shelvesService.selectShelvesByTime(mixTime,maxTime));
    }




}
