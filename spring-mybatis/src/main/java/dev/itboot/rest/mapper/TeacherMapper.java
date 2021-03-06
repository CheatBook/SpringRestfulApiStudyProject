package dev.itboot.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import dev.itboot.rest.model.Teacher;

@Mapper
public interface TeacherMapper {

    Long count();

    // @Select("select * from teacher")
    List<Teacher> selectAll(RowBounds rowBounds);

//    @Select({ "Select * From teacher", "Where id = #{id}" })
    Teacher selectByPrimaryKey(Long id);

//    @Insert({ "Insert Into teacher(user_name, email)", "Values(#{userName}, #{email})" })
    int insert(Teacher recode);

//    @Update({ "Update teacher", "Set user_name = #{userName}, email = #{email}", "where id = #{id}" })
    int updateByPrimaryKey(Teacher record);

//    @Delete({ "Delete from teacher", "Where id = #{id}" })
    int deleteByPrimaryKey(Long id);

}
