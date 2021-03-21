package dev.itboot.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.rest.mapper.TeacherMapper;
import dev.itboot.rest.model.Teacher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class TeacherService {
    
    private final TeacherMapper mapper;
    
    public List<Teacher> findAll() {
        return mapper.selectAll();
    }
    
    public Teacher findById(Long id ) {
        return mapper.selectByPrimaryKey(id);
    }

    public void save(Teacher teacher) {
        if (teacher.getId() == null) {
            mapper.insert(teacher);
        } else { 
            mapper.updateByPrimaryKey(teacher);
        }
    }
    
    public void deleteById(Long id) { 
        mapper.deleteByPrimaryKey(id);
    }
}
