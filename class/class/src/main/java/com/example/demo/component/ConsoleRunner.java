//package com.example.demo.component;
//
//import com.example.demo.model.Class;
//import com.example.demo.model.Teacher;
//import com.example.demo.service.ClassService;
//import com.example.demo.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Scanner;
//import java.util.UUID;
//
//@Component
//public class ConsoleRunner implements CommandLineRunner {
//
//    private final ClassService classService;
//    private final TeacherService teacherService;
//
//    @Autowired
//    public ConsoleRunner(ClassService classService, TeacherService teacherService) {
//        this.classService = classService;
//        this.teacherService = teacherService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        boolean running = true;
//
//        while (running) {
//            printCommands();
//            String command = scanner.nextLine();
//
//            switch (command.toLowerCase()) {
//                case "list categories":
//                    listCategories();
//                    break;
//                case "list elements":
//                    listElements();
//                    break;
//                case "add element":
//                    addElement(scanner);
//                    break;
//                case "delete element":
//                    deleteElement(scanner);
//                    break;
//                case "exit":
//                    running = false;
//                    System.out.println("Exiting the application...");
//                    break;
//                default:
//                    System.out.println("Unknown command. Please try again.");
//            }
//        }
//
//        scanner.close();
//    }
//
//    private void printCommands() {
//        System.out.println("\nAvailable commands:");
//        System.out.println("list categories - List all teachers (categories)");
//        System.out.println("list elements - List all classes (elements)");
//        System.out.println("add element - Add a new class (element)");
//        System.out.println("delete element - Delete an existing class (element)");
//        System.out.println("exit - Stop the application");
//        System.out.print("Enter a command: ");
//    }
//
//    private void listCategories() {
//        List<Teacher> teachers = teacherService.getAllTeachers();
//        if (teachers.isEmpty()) {
//            System.out.println("No categories (teachers) available.");
//        } else {
//            System.out.println("Categories (Teachers):");
//            for (Teacher teacher : teachers) {
//                System.out.println(teacher.getId() + " - " + teacher.getName());
//            }
//        }
//    }
//
//    private void listElements() {
//        List<Class> classes = classService.getAllClasses();
//        if (classes.isEmpty()) {
//            System.out.println("No elements (classes) available.");
//        } else {
//            System.out.println("Elements (Classes):");
//            for (Class clazz : classes) {
//                System.out.println(clazz.getId() + " - " + clazz.getName() + " (Teacher: " + clazz.getTeacher().getName() + ")");
//            }
//        }
//    }
//
//    private void addElement(Scanner scanner) {
//        System.out.println("Enter class name:");
//        String className = scanner.nextLine();
//
//        System.out.println("Enter class date (YYYY-MM-DD):");
//        LocalDate classDate = LocalDate.parse(scanner.nextLine());
//
//        System.out.println("Enter description:");
//        String classDescription = scanner.nextLine();
//
//        List<Teacher> teachers = teacherService.getAllTeachers();
//        if (teachers.isEmpty()) {
//            System.out.println("No teachers available. Please add a teacher first.");
//            return;
//        }
//
//        System.out.println("Available Teachers:");
//        for (int i = 0; i < teachers.size(); i++) {
//            System.out.println((i + 1) + ". " + teachers.get(i).getName());
//        }
//
//        System.out.println("Select teacher by number:");
//        int teacherIndex = Integer.parseInt(scanner.nextLine()) - 1;
//
//        if (teacherIndex < 0 || teacherIndex >= teachers.size()) {
//            System.out.println("Invalid selection. Aborting.");
//            return;
//        }
//
//        Teacher selectedTeacher = teachers.get(teacherIndex);
//
//        Class newClass = new Class(UUID.randomUUID(), className, classDate, classDescription, selectedTeacher);
//        classService.saveClass(newClass);
//
//        System.out.println("Class added successfully.");
//    }
//
//    private void deleteElement(Scanner scanner) {
//        listElements();
//
//        System.out.println("Enter class ID to delete:");
//        String classId = scanner.nextLine();
//        Class cl = classService.getClassById(UUID.fromString(classId));
//        try {
//            UUID classUUID = UUID.fromString(classId);
//            classService.deleteClass(classUUID);
//            System.out.println("Class deleted successfully.");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Invalid ID format. Aborting deletion.");
//        }
//    }
//}
//
