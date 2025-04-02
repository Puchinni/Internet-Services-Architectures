package com.example.demo.service;

import com.example.demo.model.Class;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassService {

    private final ClassRepository classRepository;

    private final TeacherService teacherService;

    @Autowired
    public ClassService(ClassRepository classRepository, TeacherService teacherService) {
        this.classRepository = classRepository;

        this.teacherService = teacherService;
    }

    // Delegate to repository to fetch all classes
    @Transactional
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    // Delegate to repository to find a class by ID
    @Transactional
    public Class getClassById(UUID id) {
        return classRepository.findById(id).orElse(null);
    }

    // Delegate to repository to save a class
    @Transactional
    public Class saveClass(Class classEntity) {
        return classRepository.save(classEntity);
    }

    // Delegate to repository to delete a class by ID
    @Transactional
    public void deleteClass(UUID id) {
        Class c = getClassById(id);
        teacherService.deleteClass(c.getTeacher(), c);
        classRepository.deleteById(id);
    }

    // Delegate to repository to find classes by a teacher
    @Transactional
    public List<Class> getClassesByTeacher(UUID teacherId) {
        return classRepository.findByTeacherId(teacherId);
    }
}
