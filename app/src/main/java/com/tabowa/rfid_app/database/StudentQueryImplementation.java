package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Student;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class StudentQueryImplementation implements QueryContract.StudentQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createStudent(Student student, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForStudent(student);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_STUDENT, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                student.setId((int) id);
            }
            else
                response.onFailure("Failed to create student. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readStudent(int studentId, QueryResponse<Student> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readStudent", "readStudent doing it!");
            cursor = sqLiteDatabase.query(TABLE_STUDENT, null,
                    STUDENT_ID + " =? ", new String[]{String.valueOf(studentId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Student student = getStudentFromCursor(cursor);
                response.onSuccess(student);
            }
            else
                response.onFailure("Student not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllStudent(QueryResponse<List<Student>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Student> studentList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllStudent", "readAllStudent doing it!");
            cursor = sqLiteDatabase.query(TABLE_STUDENT, null, null, null, null, null, null);
            Log.d("readAllStudent", "readAllStudent doing it!-1");
            Log.d("readAllStudent", cursor.getColumnNames()[0]);
            Log.d("readAllStudent", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Student student = getStudentFromCursor(cursor);
                    Log.d("readAllStudent", "readAllStudent doing it!-2");
                    Log.d("readAllStudent", student.getEmail());
                    studentList.add(student);
                } while (cursor.moveToNext());

                response.onSuccess(studentList);
            } else
                response.onFailure("There are no student in database");

        } catch (Exception e){
            Log.d("readAllStudent", "readAllStudent doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllStudent", "readAllStudent doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateStudent(Student student, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForStudent(student);

        try {
            long rowCount = sqLiteDatabase.update(TABLE_STUDENT, contentValues,
                    STUDENT_ID + " =? ", new String[]{String.valueOf(student.getId())});
            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("No data is updated at all");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void deleteStudent(int studentId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE_STUDENT, STUDENT_ID + " =? ",
                    new String[]{String.valueOf(studentId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete student. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForStudent(Student student){
        ContentValues contentValues = new ContentValues();

//        contentValues.put(STUDENT_NAME, student.getName());
//        contentValues.put(STUDENT_REGISTRATION_NUM, student.getRegistrationNumber());
//        contentValues.put(STUDENT_PHONE, student.getPhone());
//        contentValues.put(STUDENT_EMAIL, student.getEmail());

        contentValues.put(STUDENT_PHOTO, student.getPhoto().toString());
        contentValues.put(STUDENT_NAME, student.getName());
        contentValues.put(STUDENT_REGISTRATION_NUM, student.getRegistrationNumber());
        contentValues.put(STUDENT_PHONE, student.getPhone());
        contentValues.put(STUDENT_EMAIL, student.getEmail());
        contentValues.put(STUDENT_DEPARTMENT, student.getDepartment());
        contentValues.put(STUDENT_SCHOOL, student.getSchool());
        contentValues.put(STUDENT_PROGRAME, student.getProgram());
        contentValues.put(STUDENT_CATEGORY, student.getCategory());
        contentValues.put(STUDENT_SESSION, student.getSession());
        contentValues.put(STUDENT_BLOODGROUP, student.getBloodGroup());
        contentValues.put(STUDENT_NOK, student.getNoK());
        contentValues.put(STUDENT_NOKADDR, student.getNoKAddr());
        contentValues.put(STUDENT_NOKPHONE, student.getNoKPhone());
        contentValues.put(STUDENT_STATE, student.getState());
        contentValues.put(STUDENT_LGA, student.getlGA());
        contentValues.put(STUDENT_HOMETOWN, student.getHomeTown());
        contentValues.put(STUDENT_HEALTHNO, student.getHealthCardNo());
        contentValues.put(STUDENT_DOB, student.getDoB());
        contentValues.put(STUDENT_EXPDATE, student.getExpiryDate());
        contentValues.put(STUDENT_GENDER, student.getGender());
        contentValues.put(STUDENT_NIN, student.getNiN());
        contentValues.put(STUDENT_MEDICALNO, student.getMedicalCardNo());
        contentValues.put(STUDENT_THUMBPRINT, " ");
                return contentValues;
    }

    private Student getStudentFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
//        String name = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(STUDENT_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(STUDENT_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(STUDENT_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllStudent", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllStudent", s);
        }
        Log.d("readAllStudent", "Done!" );
        Log.d("readAllStudent", "ID-a:" );
        Log.d("readAllStudent",Integer.toString(cursor.getColumnIndex(STUDENT_ID)));
        Log.d("readAllStudent", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
        Log.d("readAllStudent", Integer.toString(id) );

        Log.d("readAllStudent", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(STUDENT_ID));
        Log.d("readAllStudent", Integer.toString(id3) );
        Uri photo = Uri.parse(cursor.getString(cursor.getColumnIndex(STUDENT_PHOTO)));
        String name = cursor.getString(cursor.getColumnIndex(STUDENT_NAME));
        String registration = cursor.getString(cursor.getColumnIndex(STUDENT_REGISTRATION_NUM));
        String phone = cursor.getString(cursor.getColumnIndex(STUDENT_PHONE));
        String email = cursor.getString(cursor.getColumnIndex(STUDENT_EMAIL));
        String department = cursor.getString(cursor.getColumnIndex(STUDENT_DEPARTMENT));
        String school = cursor.getString(cursor.getColumnIndex(STUDENT_SCHOOL ));
        String program = cursor.getString(cursor.getColumnIndex(STUDENT_PROGRAME));
        String category = cursor.getString(cursor.getColumnIndex(STUDENT_CATEGORY));
        String session = cursor.getString(cursor.getColumnIndex(STUDENT_SESSION ));
        String bloodGroup = cursor.getString(cursor.getColumnIndex(STUDENT_BLOODGROUP ));
        String noK = cursor.getString(cursor.getColumnIndex(STUDENT_NOK ));
        String noKAddr = cursor.getString(cursor.getColumnIndex(STUDENT_NOKADDR ));
        String noKPhoneNumber = cursor.getString(cursor.getColumnIndex(STUDENT_NOKPHONE));
        String state = cursor.getString(cursor.getColumnIndex(STUDENT_STATE));
        String lGA = cursor.getString(cursor.getColumnIndex(STUDENT_LGA ));
        String homeTown = cursor.getString(cursor.getColumnIndex(STUDENT_HOMETOWN));
        String healthCardNo = cursor.getString(cursor.getColumnIndex(STUDENT_HEALTHNO));
        String doB = cursor.getString(cursor.getColumnIndex(STUDENT_DOB ));
        String expiryDate = cursor.getString(cursor.getColumnIndex(STUDENT_EXPDATE ));
        String gender = cursor.getString(cursor.getColumnIndex(STUDENT_GENDER ));
        long niN = cursor.getLong(cursor.getColumnIndex(STUDENT_NIN ));
        String medicalCardNo = cursor.getString(cursor.getColumnIndex(STUDENT_MEDICALNO));
        String fp = cursor.getString(cursor.getColumnIndex(STUDENT_THUMBPRINT));
//        return new Student(id, name, regNum, phone, email);

        return new Student(id, photo, name, registration, phone, email, department, school, program, category, session, bloodGroup, noK, noKAddr, noKPhoneNumber, state, lGA, homeTown, healthCardNo, doB, expiryDate, gender, niN, medicalCardNo, fp);
    }
}