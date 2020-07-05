package com.cwl.mail.controller;

import com.cwl.mail.entity.RespBean;
import com.cwl.mail.entity.ResultPage;
import com.cwl.mail.pojo.TbBrand;
import com.cwl.mail.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;
    @GetMapping("/findAllBrand")
    public List<TbBrand> findAllBrand(){
        return brandService.findAllBrand();
    }

    @GetMapping("/findByPage")
    public ResultPage findByPage(int pageNum,int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)brandService.findAllBrand();
        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        return resultPage;
    }

    @PostMapping("/addBrand")
    public RespBean addBrand(@RequestBody TbBrand tbBrand){

        try{
            brandService.addBrand(tbBrand);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");
        }
    }

    @PostMapping("/updateBrand")
    public RespBean updateBreand(@RequestBody TbBrand tbBrand){

        try{
            brandService.updateBreand(tbBrand);
            return RespBean.ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败");
        }
    }

    @GetMapping("/findOne/{id}")
    public TbBrand findOne(@PathVariable long id){
        return brandService.findBrandById(id);
    }

    @GetMapping("/deleteBrands")
    public RespBean deleteBrands(long[] ids){
        System.out.println(ids[0]);
        try{
            brandService.deleteBreands(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("删除失败");
        }
    }
}
