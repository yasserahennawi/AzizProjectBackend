
package com.ht.AzizBackend;

import com.google.gson.Gson;
import com.ht.AzizBackend.DBLayer.ClassesRepository;
import com.ht.AzizBackend.DBLayer.StaffRepository;
import com.ht.AzizBackend.DBLayer.StudentsRepository;
import com.ht.AzizBackend.DBLayer.Sub_deptsRepository;
import com.ht.AzizBackend.DBLayer.SubjectsRepository;
import com.ht.AzizBackend.ModelLayer.Classes;
import com.ht.AzizBackend.ModelLayer.Staff;
import com.ht.AzizBackend.ModelLayer.Student;
import com.ht.AzizBackend.ModelLayer.Sub_dept;
import com.ht.AzizBackend.ModelLayer.Subject;
import java.util.ArrayList;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class main {

  public static void main(String[] args) {
    StaffRepository staffRepository = new StaffRepository();
    ClassesRepository classesRepository = new ClassesRepository();
    StudentsRepository studentsRepository = new StudentsRepository();
    Sub_deptsRepository sub_deptsRepository = new Sub_deptsRepository();
    SubjectsRepository subjectsRepository = new SubjectsRepository();
    ArrayList<Staff> staff;
    

    enableCORS("*", "*", "*");

    Gson gson = new Gson();

    get("/", (Request req, Response res) -> {
      System.out.println("wzza tezo 7mra");
      return "Hello world";
    });

    get("/api/staffs", (req, res) -> {
      try {
        String json = gson.toJson(staffRepository.getAllStaff());
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/staffs/:staff_id", (req, res) -> {
      try {
        String json = gson.toJson(staffRepository.getStaffByID(req.params(":staff_id")));
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });
    post("/api/staffs", (req, res) -> {
      try {
        Staff newStaff = new Staff(req.queryParams("id"), req.queryParams("firstname"), req.queryParams("secondname"), req.queryParams("gender"), req.queryParams("degree"), req.queryParams("address"));
        res.type("application/json");
        return staffRepository.addStaff(newStaff);
      } catch (Exception e) {
        return e;
      }
    });
    
    patch("/api/staffs/:staff_id", (req, res) -> {
      try {
        Staff oldStaff = staffRepository.getStaffByID(req.params(":staff_id")).get(0);
        Staff newStaff = new Staff(req.queryParams("id"), req.queryParams("firstname"), req.queryParams("secondname"), req.queryParams("gender"), req.queryParams("degree"), req.queryParams("address"));
        res.type("application/json");
        return staffRepository.editStaff(oldStaff, newStaff);
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/classes", (req, res) -> {
      try {
        String json = gson.toJson(classesRepository.getAllClasses());
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/classes/:class_id", (req, res) -> {
      try {
        String json = gson.toJson(classesRepository.getClassesByID(req.params(":class_id")));
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });
    post("/api/classes", (req, res) -> {
      try {
        Classes newClass = new Classes(req.queryParams("id"), req.queryParams("type"));
        res.type("application/json");
        return classesRepository.addClasses(newClass);
      } catch (Exception e) {
        return e;
      }
    });
    
    patch("/api/classes/:class_id", (req, res) -> {
      try {
        Classes oldClass = classesRepository.getClassesByID(req.params(":class_id")).get(0);
        Classes newClass = new Classes(req.queryParams("id"),req.queryParams("type"));
        res.type("application/json");
        return classesRepository.editClass(oldClass, newClass);
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/students", (req, res) -> {
      try {
        String json = gson.toJson(studentsRepository.getAllStudent());
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/students/:student_id", (req, res) -> {
      try {
        String json = gson.toJson(studentsRepository.getStudentByID(req.params(":student_id")));
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });
    post("/api/students", (req, res) -> {
      try {
        Student newStudent = new Student(req.queryParams("id"), req.queryParams("firstname"), req.queryParams("lastname"), req.queryParams("gender"), req.queryParams("section"), req.queryParams("division"), req.queryParams("stage"), req.queryParams("address"));
        res.type("application/json");
        return studentsRepository.addStudent(newStudent);
      } catch (Exception e) {
        return e;
      }
    });
    
    patch("/api/students/:student_id", (req, res) -> {
      try {
        Student oldStudent = studentsRepository.getStudentByID(req.params(":student_id")).get(0);
        Student newStudent = new Student(req.queryParams("id"),req.queryParams("firstname"),req.queryParams("lastname"),req.queryParams("gender"),req.queryParams("section"),req.queryParams("division"),req.queryParams("stage"),req.queryParams("address"));
        res.type("application/json");
        return studentsRepository.editStudent(oldStudent, newStudent);
      } catch (Exception e) {
        return e;
      }
    });
    
    get("/api/subjects", (req, res) -> {
      try {
        String json = gson.toJson(subjectsRepository.getAllSubject());
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/subjects/:subject_id", (req, res) -> {
      try {
        String json = gson.toJson(subjectsRepository.getSubjectByID(req.params(":subject_id")));
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });

    post("/api/subjects", (req, res) -> {
      try {
        Subject newSubject = new Subject(req.queryParams("id"), req.queryParams("subdeptname"), req.queryParams("subjectname"), req.queryParams("chr"), req.queryParams("degree"));
        res.type("application/json");
        return subjectsRepository.addSubject(newSubject);
      } catch (Exception e) {
        return e;
      }
    });
    
    patch("/api/subjects/:subject_id", (req, res) -> {
      try {
        Subject oldSubject = subjectsRepository.getSubjectByID(req.params(":subject_id")).get(0);
        Subject newSubject = new Subject(req.queryParams("id"), req.queryParams("subdeptname"), req.queryParams("subjectname"), req.queryParams("chr"), req.queryParams("degree"));
        res.type("application/json");
        return subjectsRepository.editSubject(oldSubject, newSubject);
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/sub_depts", (req, res) -> {
      try {
        String json = gson.toJson(sub_deptsRepository.getAllSub_dept());
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });

    get("/api/sub_depts/:sub_dept_id", (req, res) -> {
      try {
        String json = gson.toJson(sub_deptsRepository.getSub_deptByID(req.params(":sub_dept_id")));
        res.type("application/json");
        return json;
      } catch (Exception e) {
        return e;
      }
    });

    post("/api/sub_depts", (req, res) -> {
      try {
        Sub_dept newSub_dept = new Sub_dept(req.queryParams("id"), req.queryParams("name"));
        res.type("application/json");
        return sub_deptsRepository.addSub_dept(newSub_dept);
      } catch (Exception e) {
        return e;
      }
    });
    
    patch("/api/sub_depts/:sub_dept_id", (req, res) -> {
      try {
        Sub_dept oldSub_dept = sub_deptsRepository.getSub_deptByID(req.params(":sub_dept_id")).get(0);
        Sub_dept newSub_dept = new Sub_dept(req.queryParams("id"), req.queryParams("name"));
        res.type("application/json");
        return sub_deptsRepository.editSub_dept(oldSub_dept, newSub_dept);
      } catch (Exception e) {
        return e;
      }
    });
    
    delete("/api/classes/:classes_id", (req, res) -> {
      try {
        res.type("application/json");
        return 
          gson.toJson(
            classesRepository.deleteClass(
              classesRepository.getClassesByID(req.params(":classes_id")).get(0)
            )
          );
      } catch (Exception e) {
        res.status(400);
        res.body(gson.toJson(e));
        res.type("application/json");
        return res.body();
      }
    });

    delete("/api/staff/:staff_id", (req, res) -> {
      try {
        res.type("application/json");
        return 
          gson.toJson(
            staffRepository.deleteStaff(
              staffRepository.getStaffByID(req.params(":staff_id")).get(0)
            )
          );
      } catch (Exception e) {
        res.status(400);
        res.body(gson.toJson(e));
        res.type("application/json");
        return res.body();
      }
    });

    delete("/api/student/:student_id", (req, res) -> {
      try {
        res.type("application/json");
        return 
          gson.toJson(
            studentsRepository.deleteStudent(
              studentsRepository.getStudentByID(req.params(":student_id")).get(0)
            )
          );
      } catch (Exception e) {
        res.status(400);
        res.body(gson.toJson(e));
        res.type("application/json");
        return res.body();
      }
    });

    delete("/api/sub_dept/:sub_dept_id", (req, res) -> {
      try {
        res.type("application/json");
        return 
          gson.toJson(
            sub_deptsRepository.deleteSub_dept(
              sub_deptsRepository.getSub_deptByID(req.params(":sub_dept_id")).get(0)
            )
          );
      } catch (Exception e) {
        res.status(400);
        res.body(gson.toJson(e));
        res.type("application/json");
        return res.body();
      }
    });

    delete("/api/subject/:subject_id", (req, res) -> {
      try {
        res.type("application/json");
        return 
          gson.toJson(
            subjectsRepository.deleteSubject(
              subjectsRepository.getSubjectByID(req.params(":subject_id")).get(0)
            )
          );
      } catch (Exception e) {
        res.status(400);
        res.body(gson.toJson(e));
        res.type("application/json");
        return res.body();
      }
    });

  }

  private static void enableCORS(final String origin, final String methods, final String headers) {

    options("/*", (request, response) -> {

      String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
      if (accessControlRequestHeaders != null) {
        response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
      }

      String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
      if (accessControlRequestMethod != null) {
        response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
      }

      return "OK";
    });

    before((request, response) -> {
      response.header("Access-Control-Allow-Origin", origin);
      response.header("Access-Control-Request-Method", methods);
      response.header("Access-Control-Allow-Headers", headers);
      // Note: this may or may not be necessary in your particular application
      response.type("application/json");
    });
  }
}
