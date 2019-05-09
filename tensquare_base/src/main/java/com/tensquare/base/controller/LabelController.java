package com.tensquare.base.controller;

import com.tensquare.base.service.LabelService;
import com.tensquare.base.pojo.Label;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return  new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public  Result findById(@PathVariable("labelId") String labelId){
        return  new Result(true,StatusCode.OK,"查询成功",labelService.findById(labelId));

    }
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return  new Result(true,StatusCode.OK,"添加成功");
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT )
    public Result update(@PathVariable String labelId,@RequestBody Label label){
        labelService.update(label);
        return  new Result(true,StatusCode.OK,"更新成功");
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public Result daleteById(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return  new Result(true,StatusCode.OK,"删除成功");
    }
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST )
    public  Result findSearch(@RequestBody Label label,@PathVariable int page,@PathVariable int size){
       Page<Label> pageData = labelService.pageQuery(label,page,size);
        return  new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }

}

