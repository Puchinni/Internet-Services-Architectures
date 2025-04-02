package org.example.demo.service;

import org.example.demo.event.impl.TeacherEventRestImpl;
import org.example.demo.model.Teacher;
import org.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherEventRestImpl teacherEventRestRep;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherEventRestImpl teacherEventRestRep) {
        this.teacherRepository = teacherRepository;
        this.teacherEventRestRep = teacherEventRestRep;
    }

    @Transactional
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Transactional
    public Teacher getTeacherById(UUID id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Transactional
    public Teacher saveTeacher(Teacher teacher) {
        teacherEventRestRep.create(teacher.getId());
        return teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteTeacher(UUID id) {
        teacherEventRestRep.delete(id);
        teacherRepository.deleteById(id);
    }
}
