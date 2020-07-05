package com.cwl.mail.controller;

import com.cwl.mail.entity.RespBean;
import com.cwl.mail.entity.ResultPage;
import com.cwl.mail.pojo.TbTypeTemplate;
import com.cwl.mail.service.TemplateService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TemplateComtroller {
    @Autowired
    TemplateService templateService;
    @GetMapping("/findAllTemplate")
    public List<TbTypeTemplate> findAllTemplate(){
        System.out.println("到了");
        return templateService.findAllTemplate();
    }

    @GetMapping("/findSpecList")
    public List<Map> findSpecList(){
        return templateService.findSpecList();
    }

    @GetMapping("/findBrandList")
    public List<Map> findBrandList(){
        return templateService.findBrandList();
    }

    @GetMapping("/findOne")
    public TbTypeTemplate findOne (long id){
        System.out.println("findOne"+id);
        return templateService.findOne(id);
    }

    @GetMapping("/findTemplateByPage")
    public ResultPage findTemplateByPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)templateService.findAllTemplate();
        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        return resultPage;
    }

    @PostMapping("/updateTemplate")
    public RespBean updateTemplate(@RequestBody TbTypeTemplate tbTypeTemplate){
        System.out.println(tbTypeTemplate.getSpecIds());
        try{
            templateService.updateTemplate(tbTypeTemplate);
            return RespBean.ok("修改成功");
        }catch (Exception e) {
            return RespBean.error("修改失败");
        }
    }

    @PostMapping("/addTemplate")
    public RespBean addTemplate(@RequestBody TbTypeTemplate tbTypeTemplate){
        System.out.println(tbTypeTemplate.getSpecIds());
        try{
            templateService.addTemplate(tbTypeTemplate);
            return RespBean.ok("修改成功");
        }catch (Exception e) {
            return RespBean.error("修改失败");
        }
    }

    @GetMapping("/deleteTemplate")
    public RespBean deleteTemplate(long[] ids){
        System.out.println("deleteTemplate:id"+ids);
        try{
            templateService.deleteTemplate(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e) {
            return RespBean.error("删除失败");
        }
    }

    @RequestMapping("/findBySpecList")
    public List<Map> findSpecList(Long id){
        return templateService.findSpecList(id);
    }
}
