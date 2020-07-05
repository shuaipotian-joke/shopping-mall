package com.cwl.mail.controller;

import com.cwl.mail.entity.RespBean;
import com.cwl.mail.entity.ResultPage;
import com.cwl.mail.pojo.TbContent;
import com.cwl.mail.pojo.TbContentCategory;
import com.cwl.mail.service.ContentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentController {
    @Autowired
    ContentService contentService;
    @GetMapping("/findAllContent")
    public List<TbContent> findAllContent(){
        return contentService.findAllContent();
    }

    @GetMapping("/findAllCategory")
    public List<TbContentCategory> findAllCategory(){
        return contentService.findAllCategory();
    }

    @GetMapping("/findContentByPage")
    public ResultPage findByPage(int pageNum,int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        Page page = (Page)contentService.findAllContent();
        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        return resultPage;
    }

    @PostMapping("/addContent")
    public RespBean addContent(@RequestBody TbContent tbContent){

        try{
            contentService.addContent(tbContent);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");
        }
    }

    @PostMapping("/updateContent")
    public RespBean updateBreand(@RequestBody TbContent tbContent){

        try{
            contentService.updateContent(tbContent);
            return RespBean.ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败");
        }
    }

    @GetMapping("/findOne/{id}")
    public TbContent findOne(@PathVariable long id){
        System.out.println("findOne"+id);
        return contentService.findContentById(id);
    }

    @GetMapping("/deleteContents")
    public RespBean deleteContents(long[] ids){
        System.out.println(ids[0]);
        try{
            contentService.deleteContents(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("删除失败");
        }
    }

    @GetMapping("/findByCatrgoryId")
    public List<TbContent> findByCatrgoryId(Long categoryId){
        return contentService.findByCatrgoryId(categoryId);
    }
}
