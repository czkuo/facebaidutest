package com.face.bizz;


import com.face.entity.Face;

import java.util.List;

public interface FaceBizz {
    Face selectByPrimaryKey(Integer id);
    List<Face> selectall();

}
