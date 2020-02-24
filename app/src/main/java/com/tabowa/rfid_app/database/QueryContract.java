package com.tabowa.rfid_app.database;

import com.tabowa.rfid_app.model.Admin;
import com.tabowa.rfid_app.model.Attendance;
import com.tabowa.rfid_app.model.Course;
import com.tabowa.rfid_app.model.Election;
import com.tabowa.rfid_app.model.Grade;
import com.tabowa.rfid_app.model.Medical;
import com.tabowa.rfid_app.model.Student;
import com.tabowa.rfid_app.model.Security;
import com.tabowa.rfid_app.model.Subject;
import com.tabowa.rfid_app.model.TableRowCount;
import com.tabowa.rfid_app.model.TakenSubject;

import java.util.List;

public class QueryContract {


    public interface AdminQuery {
        void createAdmin(Admin admin, QueryResponse<Boolean> response);
        void readAdmin(int adminId, QueryResponse<Admin> response);
        void readAllAdmin(QueryResponse<List<Admin>> response);
        void updateAdmin(Admin admin, QueryResponse<Boolean> response);
        void deleteAdmin(int adminId, QueryResponse<Boolean> response);
    }

    public interface CourseQuery {
        void createCourse(Course course, QueryResponse<Boolean> response);
        void readCourse(int courseId, QueryResponse<Course> response);
        void readAllCourse(QueryResponse<List<Course>> response);
        void updateCourse(Course course, QueryResponse<Boolean> response);
        void deleteCourse(int courseId, QueryResponse<Boolean> response);
    }

    public interface GradeQuery {
        void createGrade(Grade grade, QueryResponse<Boolean> response);
        void readGrade(int gradeId, QueryResponse<Grade> response);
        void readAllGrade(QueryResponse<List<Grade>> response);
        void updateGrade(Grade grade, QueryResponse<Boolean> response);
        void deleteGrade(int gradeId, QueryResponse<Boolean> response);
    }

    public interface MedicalQuery {
        void createMedical(Medical medical, QueryResponse<Boolean> response);
        void readMedical(int medicalId, QueryResponse<Medical> response);
        void readAllMedical(QueryResponse<List<Medical>> response);
        void updateMedical(Medical medical, QueryResponse<Boolean> response);
        void deleteMedical(int medicalId, QueryResponse<Boolean> response);
    }

    public interface SecurityQuery {
        void createSecurity(Security security, QueryResponse<Boolean> response);
        void readSecurity(int securityId, QueryResponse<Security> response);
        void readAllSecurity(QueryResponse<List<Security>> response);
        void updateSecurity(Security security, QueryResponse<Boolean> response);
        void deleteSecurity(int securityId, QueryResponse<Boolean> response);
    }

    public interface AttendanceQuery {
        void createAttendance(Attendance attendance, QueryResponse<Boolean> response);
        void readAttendance(int attendanceId, QueryResponse<Attendance> response);
        void readAllAttendance(QueryResponse<List<Attendance>> response);
        void updateAttendance(Attendance attendance, QueryResponse<Boolean> response);
        void deleteAttendance(int attendanceId, QueryResponse<Boolean> response);
    }

    public interface ElectionQuery {
        void createElection(Election election, QueryResponse<Boolean> response);
        void readElection(int electionId, QueryResponse<Election> response);
        void readAllElection(QueryResponse<List<Election>> response);
        void updateElection(Election election, QueryResponse<Boolean> response);
        void deleteElection(int electionId, QueryResponse<Boolean> response);
    }

    public interface StudentQuery {
        void createStudent(Student student, QueryResponse<Boolean> response);
        void readStudent(int studentId, QueryResponse<Student> response);
        void readAllStudent(QueryResponse<List<Student>> response);
        void updateStudent(Student student, QueryResponse<Boolean> response);
        void deleteStudent(int studentId, QueryResponse<Boolean> response);
    }

    public interface SubjectQuery {
        void createSubject(Subject subject, QueryResponse<Boolean> response);
        void readAllSubject(QueryResponse<List<Subject>> response);
        void updateSubject(Subject subject, QueryResponse<Boolean> response);
        void deleteSubject(int subjectId, QueryResponse<Boolean> response);
    }

    public interface TakenSubjectQuery {
        void createTakenSubject(int studentId, int subjectId, QueryResponse<Boolean> response);
        void readAllTakenSubjectByStudentId(int studentId, QueryResponse<List<Subject>> response);
        void readAllSubjectWithTakenStatus(int studentId, QueryResponse<List<TakenSubject>> response);
        void deleteTakenSubject(int studentId, int subjectId, QueryResponse<Boolean> response);
    }

    public interface TableRowCountQuery {
        void getTableRowCount(QueryResponse<TableRowCount> response);
    }
}