package dev.itboot.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dev.itboot.rest.model.Teacher;

@Mapper
public interface TeacherMapper {
    
    @Select("select * from teacher")
    List<Teacher> selectAll();
}
