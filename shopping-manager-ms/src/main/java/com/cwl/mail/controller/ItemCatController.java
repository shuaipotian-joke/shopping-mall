package com.cwl.mail.controller;

import com.cwl.mail.pojo.TbItemCat;
import com.cwl.mail.service.ItemCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemCatController {
    @Autowired
    private ItemCateService itemCateServicel;

    @RequestMapping("/selectItemCat1List")
    public List<TbItemCat> selectItemCat1List(long parentId){
        System.out.println("parentId="+parentId);
        return itemCateServicel.selectItemCat1List(parentId);
    }

    @RequestMapping("/findOneitemCat")
    public TbItemCat findOne(long id){

        return itemCateServicel.findOne(id);
    }

    @GetMapping("/findItemCatList")
    public List<TbItemCat> findItemCatList(){
        return itemCateServicel.findItemCatList();
    }
}
