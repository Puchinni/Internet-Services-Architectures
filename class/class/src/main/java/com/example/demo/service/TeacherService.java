package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.model.Class;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherRepository bookRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository, TeacherRepository bookRepository) {
        this.teacherRepository = teacherRepository;
        this.bookRepository = bookRepository;
    }

    // Delegate to repository to fetch all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Delegate to repository to find a teacher by ID
    public Teacher getTeacherById(UUID id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher getTeacherByName(String name) {
        return teacherRepository.findByName(name).orElse(null);
    }

    // Delegate to repository to save a teacher
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Delegate to repository to delete a teacher by ID
    public void deleteTeacher(UUID id) {
        teacherRepository.deleteById(id);
    }


    public void deleteClass(Teacher teacher, Class clazz) {
        teacher.getClasses().remove(clazz);
        teacherRepository.save(teacher);
    }
}
