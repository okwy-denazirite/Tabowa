package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Course;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class CourseQueryImplementation implements QueryContract.CourseQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createCourse(Course course, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForCourse(course);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_COURSE, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                course.setId((int) id);
            }
            else
                response.onFailure("Failed to create course. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readCourse(int courseId, QueryResponse<Course> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readCourse", "readCourse doing it!");
            cursor = sqLiteDatabase.query(TABLE_COURSE, null,
                    COURSE_ID + " =? ", new String[]{String.valueOf(courseId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Course course = getCourseFromCursor(cursor);
                response.onSuccess(course);
            }
            else
                response.onFailure("Course not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllCourse(QueryResponse<List<Course>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Course> courseList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllCourse", "readAllCourse doing it!");
            cursor = sqLiteDatabase.query(TABLE_COURSE, null, null, null, null, null, null);
            Log.d("readAllCourse", "readAllCourse doing it!-1");
            Log.d("readAllCourse", cursor.getColumnNames()[0]);
            Log.d("readAllCourse", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Course course = getCourseFromCursor(cursor);
//                    Log.d("readAllCourse", "readAllCourse doing it!-2");
//                    Log.d("readAllCourse", course.getEmail());
                    courseList.add(course);
                } while (cursor.moveToNext());

                response.onSuccess(courseList);
            } else
                response.onFailure("There are no course in database");

        } catch (Exception e){
            Log.d("readAllCourse", "readAllCourse doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllCourse", "readAllCourse doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateCourse(Course course, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForCourse(course);

        try {
            long rowCount = sqLiteDatabase.update(TABLE_COURSE, contentValues,
                    COURSE_ID + " =? ", new String[]{String.valueOf(course.getId())});
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
    public void deleteCourse(int courseId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE_COURSE, COURSE_ID + " =? ",
                    new String[]{String.valueOf(courseId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete course. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForCourse(Course course){
        ContentValues contentValues = new ContentValues();

//        contentValues.put(COURSE_NAME, course.getName());
//        contentValues.put(COURSE_REGISTRATION_NUM, course.getRegistrationNumber());
//        contentValues.put(COURSE_PHONE, course.getPhone());
//        contentValues.put(COURSE_EMAIL, course.getEmail());



        contentValues.put(COURSE_REGISTRATION_NUMBER, course.getRegNo());
        contentValues.put(COURSE_SESSION, course.getSession());
        contentValues.put(COURSE_PROGRAM, course.getProgram());
        contentValues.put(COURSE_CATEGORY, course.getCategory());
        contentValues.put(COURSE_SESSION, course.getSession());
        contentValues.put(COURSE_SEMESTER, course.getSemester());
        contentValues.put(COURSE_TITLE, course.getCourseTitle());
        contentValues.put(COURSE_CODE, course.getCourseCode());
        contentValues.put(COURSE_UNITS, course.getUnits());
        return contentValues;
    }

    private Course getCourseFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(COURSE_ID));
//        String name = cursor.getString(cursor.getColumnIndex(COURSE_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(COURSE_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(COURSE_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(COURSE_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllCourse", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllCourse", s);
        }
        Log.d("readAllCourse", "Done!" );
        Log.d("readAllCourse", "ID-a:" );
        Log.d("readAllCourse",Integer.toString(cursor.getColumnIndex(COURSE_ID)));
        Log.d("readAllCourse", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(COURSE_ID));
        Log.d("readAllCourse", Integer.toString(id) );

        Log.d("readAllCourse", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(COURSE_ID));
        Log.d("readAllCourse", Integer.toString(id3) );


        String registrationNum = cursor.getString(cursor.getColumnIndex(COURSE_REGISTRATION_NUMBER));
        String program = cursor.getString(cursor.getColumnIndex(COURSE_PROGRAM));
        String category = cursor.getString(cursor.getColumnIndex(COURSE_CATEGORY));
        String session = cursor.getString(cursor.getColumnIndex(COURSE_SESSION ));
        String semester = cursor.getString(cursor.getColumnIndex(COURSE_SEMESTER ));
        String courseTitle = cursor.getString(cursor.getColumnIndex(COURSE_TITLE  ));
        String courseCode = cursor.getString(cursor.getColumnIndex(COURSE_CODE));
        String units = cursor.getString(cursor.getColumnIndex(COURSE_UNITS));

        return new Course(id, registrationNum, program, category, session, semester, courseTitle, courseCode, units);
    }
}