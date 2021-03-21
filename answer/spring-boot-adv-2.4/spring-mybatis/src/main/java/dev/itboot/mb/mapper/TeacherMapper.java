package dev.itboot.mb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dev.itboot.mb.model.Teacher;

@Mapper
public interface TeacherMapper {

    @Select("SELECT * FROM teacher")
    List<Teacher> selectAll();
}
