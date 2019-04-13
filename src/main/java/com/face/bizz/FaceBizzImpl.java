package com.face.bizz;
import com.face.entity.Face;
import com.face.dao.FaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceBizzImpl implements FaceBizz{
    @Autowired
    private FaceMapper FaceMapper;

    @Override
    public Face selectByPrimaryKey(Integer id) {
        System.out.println("进入FaceBizzImpl");
        return FaceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Face> selectall() {
        return FaceMapper.selectall();
    }
}
