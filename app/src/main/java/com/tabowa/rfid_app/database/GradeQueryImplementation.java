package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Grade;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class GradeQueryImplementation implements QueryContract.GradeQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createGrade(Grade grade, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForGrade(grade);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_GRADE, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                grade.setId((int) id);
            }
            else
                response.onFailure("Failed to create grade. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readGrade(int gradeId, QueryResponse<Grade> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readGrade", "readGrade doing it!");
            cursor = sqLiteDatabase.query(TABLE_GRADE, null,
                    GRADE_ID + " =? ", new String[]{String.valueOf(gradeId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Grade grade = getGradeFromCursor(cursor);
                response.onSuccess(grade);
            }
            else
                response.onFailure("Grade not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllGrade(QueryResponse<List<Grade>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Grade> gradeList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllGrade", "readAllGrade doing it!");
            cursor = sqLiteDatabase.query(TABLE_GRADE, null, null, null, null, null, null);
            Log.d("readAllGrade", "readAllGrade doing it!-1");
            Log.d("readAllGrade", cursor.getColumnNames()[0]);
            Log.d("readAllGrade", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Grade grade = getGradeFromCursor(cursor);
//                    Log.d("readAllGrade", "readAllGrade doing it!-2");
//                    Log.d("readAllGrade", grade.getEmail());
                    gradeList.add(grade);
                } while (cursor.moveToNext());

                response.onSuccess(gradeList);
            } else
                response.onFailure("There are no grade in database");

        } catch (Exception e){
            Log.d("readAllGrade", "readAllGrade doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllGrade", "readAllGrade doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateGrade(Grade grade, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForGrade(grade);

        try {
            long rowCount = sqLiteDatabase.update(TABLE_GRADE, contentValues,
                    GRADE_ID + " =? ", new String[]{String.valueOf(grade.getId())});
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
    public void deleteGrade(int gradeId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE_GRADE, GRADE_ID + " =? ",
                    new String[]{String.valueOf(gradeId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete grade. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForGrade(Grade grade){
        ContentValues contentValues = new ContentValues();

//        contentValues.put(GRADE_NAME, grade.getName());
//        contentValues.put(GRADE_REGISTRATION_NUM, grade.getRegistrationNumber());
//        contentValues.put(GRADE_PHONE, grade.getPhone());
//        contentValues.put(GRADE_EMAIL, grade.getEmail());



        contentValues.put(GRADE_REGISTRATION_NUMBER, grade.getGradeRegno());
        contentValues.put(GRADE_SESSION, grade.getSession());
        contentValues.put(GRADE_PROGRAM, grade.getProgram());
        contentValues.put(GRADE_CATEGORY, grade.getCategory());
        contentValues.put(GRADE_SESSION, grade.getSession());
        contentValues.put(GRADE_SEMESTER, grade.getSemester());
        contentValues.put(GRADE_COURSE_TITLE, grade.getCousrseTitle());
        contentValues.put(GRADE_COURSE_CODE, grade.getCourseCode());
        contentValues.put(GRADE_UNITS, grade.getUnits());
        contentValues.put(GRADE_CLASS_ATTENDANCE, grade.getClass_attendance());
        contentValues.put(GRADE_CA_SCORE, grade.getClass_attendance());
        contentValues.put(GRADE_EXAMINATION, grade.getExamination());
        contentValues.put(GRADE_TOTAL, grade.getTotal());
        contentValues.put(GRADE_GRADE, grade.getGrade());
        return contentValues;
    }

    private Grade getGradeFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(GRADE_ID));
//        String name = cursor.getString(cursor.getColumnIndex(GRADE_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(GRADE_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(GRADE_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(GRADE_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllGrade", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllGrade", s);
        }
        Log.d("readAllGrade", "Done!" );
        Log.d("readAllGrade", "ID-a:" );
        Log.d("readAllGrade",Integer.toString(cursor.getColumnIndex(GRADE_ID)));
        Log.d("readAllGrade", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(GRADE_ID));
        Log.d("readAllGrade", Integer.toString(id) );

        Log.d("readAllGrade", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(GRADE_ID));
        Log.d("readAllGrade", Integer.toString(id3) );


        String registrationNum = cursor.getString(cursor.getColumnIndex(GRADE_REGISTRATION_NUMBER));
        String program = cursor.getString(cursor.getColumnIndex(GRADE_PROGRAM));
        String category = cursor.getString(cursor.getColumnIndex(GRADE_CATEGORY));
        String session = cursor.getString(cursor.getColumnIndex(GRADE_SESSION ));
        String semester = cursor.getString(cursor.getColumnIndex(GRADE_SEMESTER ));
        String gradeTitle = cursor.getString(cursor.getColumnIndex(GRADE_COURSE_TITLE  ));
        String gradeCode = cursor.getString(cursor.getColumnIndex(GRADE_COURSE_CODE));
        String gradeUnits = cursor.getString(cursor.getColumnIndex(GRADE_UNITS));
        String gradeAttendance = cursor.getString(cursor.getColumnIndex(GRADE_CLASS_ATTENDANCE));
        String gradeScore = cursor.getString(cursor.getColumnIndex(GRADE_CA_SCORE));
        String gradeExamination = cursor.getString(cursor.getColumnIndex(GRADE_EXAMINATION));
        String gradeTotal = cursor.getString(cursor.getColumnIndex(GRADE_TOTAL));
        String gradeGrade = cursor.getString(cursor.getColumnIndex(GRADE_GRADE));

        return new Grade(id, registrationNum, program, category, session, semester, gradeTitle, gradeCode, gradeUnits, gradeAttendance, gradeScore, gradeExamination, gradeTotal, gradeGrade);
    }
}