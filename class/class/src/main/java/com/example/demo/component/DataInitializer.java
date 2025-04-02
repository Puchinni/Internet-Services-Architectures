//package com.example.demo.component;
//
//import com.example.demo.model.Teacher;
//import com.example.demo.model.Class;
//import com.example.demo.service.ClassService;
//import com.example.demo.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import jakarta.annotation.PostConstruct;
//import java.time.LocalDate;
//import java.util.UUID;
//
//@Component
//public class DataInitializer {
//
//    private final ClassService classService;
//    private final TeacherService teacherService;
//
//    @Autowired
//    public DataInitializer(ClassService classService, TeacherService teacherService) {
//        this.classService = classService;
//        this.teacherService = teacherService;
//    }
//
//    @PostConstruct
//    public void initializeData() {
//        Teacher teacher1 = new Teacher(UUID.randomUUID(), "John Pork", 50000, "George Floyd street");
//        Teacher teacher2 = new Teacher(UUID.randomUUID(), "Quandale Dingle", 60000, "CR7 street");
//
//        teacher1 = teacherService.saveTeacher(teacher1);
//        teacher2 = teacherService.saveTeacher(teacher2);
//
//        Class mathClass = new Class(UUID.randomUUID(), "Math", LocalDate.now(), "MEMRMEM", teacher1);
//        Class scienceClass = new Class(UUID.randomUUID(), "PE", LocalDate.now(), "PE DESCR",teacher2);
//
//        classService.saveClass(mathClass);
//        classService.saveClass(scienceClass);
//    }
//}
