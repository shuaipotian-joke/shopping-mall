package com.cwl.mail.controller;

import com.cwl.mail.entity.RespBean;
import com.cwl.mail.entity.ResultPage;
import com.cwl.mail.pojo.TbSpecification;
import com.cwl.mail.pojogroup.Specification;
import com.cwl.mail.service.SpecificationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecificationController {
    @Autowired
    SpecificationService specificationService;
    @GetMapping("/findAllSpecification")
    public List<TbSpecification> findAllSpecification(){
        return specificationService.findAllSpecification();
    }
    @GetMapping("/findSpecificationByPage")
    public ResultPage findSpecificationByPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<TbSpecification> page = (Page)specificationService.findAllSpecification();
        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        return resultPage;
    }
    @PostMapping("/addSpecification")
    public RespBean addSpecification(@RequestBody Specification specification){
        System.out.println("specification");
        try{
            specificationService.addSpecification(specification);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");
        }
    }
    @GetMapping("/findOneSpecification/{id}")
    public Specification findOneSpecification(@PathVariable long id){
        System.out.println("selectOneSpecification:id="+id);
        return specificationService.findOneSpecification(id);
    }
    @PostMapping("/updateSpecification")
    public RespBean updateSpecification(@RequestBody Specification specification){
        try{
            specificationService.updateSpecification(specification);
            return RespBean.ok("修改成功");
        }catch (Exception e){
            return RespBean.error("修改失败");
        }
    }

    @GetMapping("/deleteSpecification")
    public RespBean deleteSpecification(long[] ids){
        try{
            specificationService.deleteSpecification(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            return RespBean.error("删除失败");
        }
    }
}
