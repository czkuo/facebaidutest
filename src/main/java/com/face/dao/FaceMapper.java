package com.face.dao;

import com.face.entity.Face;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Face record);

    int insertSelective(Face record);

    Face selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Face record);

    int updateByPrimaryKey(Face record);
    List<Face> selectall();
}