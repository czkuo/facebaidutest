package com.face.rest;

import com.face.bizz.FaceBizzImpl;
import com.face.bizz.FaceDetect;
import com.face.entity.Face;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jsp")
@ResponseBody
public class FaceRest {
    @Autowired
    public FaceBizzImpl FaceBizzImpl;

    @RequestMapping("/selectByPrimaryKey")
    Face selectByPrimaryKey(Integer id){
        System.out.println("进入rest");
        id=1;
       return FaceBizzImpl.selectByPrimaryKey(id);
    }
    @RequestMapping("/selectall")
    List<Face> selectall(){
        System.out.println("进入rest");
        return FaceBizzImpl.selectall();
    }
    @RequestMapping("/list")
    public ModelAndView itemsList() {
        List<Face> list  =FaceBizzImpl.selectall();
        ModelAndView mav = new ModelAndView("/WEB-INF/views/items.jsp");
        mav.addObject("list", list);
        return mav;
    }
    @PostMapping("/getBaseStr")
    public String getBaseStr(String baseStr) {
        String result=FaceDetect.detect(baseStr);
        return result ;
    }
}
