package dev.itboot.rest.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<Teacher> findAll(Pageable pageable) {
        RowBounds rowBouds = new RowBounds((int) pageable.getOffset(), pageable.getPageSize());

        List<Teacher> teachers = mapper.selectAll(rowBouds);

        Long total = mapper.count();
        return new PageImpl<>(teachers, pageable, total);
    }

    public Teacher findById(Long id) {
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
