package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Attendance;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class AttendanceQueryImplementation implements QueryContract.AttendanceQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createAttendance(Attendance attendance, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForAttendance(attendance);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_ATTENDANCE, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                attendance.setId((int) id);
            }
            else
                response.onFailure("Failed to create attendance. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readAttendance(int attendanceId, QueryResponse<Attendance> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readAttendance", "readAttendance doing it!");
            cursor = sqLiteDatabase.query(TABLE_ATTENDANCE, null,
                    ATTENDANCE_ID + " =? ", new String[]{String.valueOf(attendanceId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Attendance attendance = getAttendanceFromCursor(cursor);
                response.onSuccess(attendance);
            }
            else
                response.onFailure("Attendance not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllAttendance(QueryResponse<List<Attendance>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Attendance> attendanceList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllAttendance", "readAllAttendance doing it!");
            cursor = sqLiteDatabase.query(TABLE_ATTENDANCE, null, null, null, null, null, null);
            Log.d("readAllAttendance", "readAllAttendance doing it!-1");
            Log.d("readAllAttendance", cursor.getColumnNames()[0]);
            Log.d("readAllAttendance", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Attendance attendance = getAttendanceFromCursor(cursor);
//                    Log.d("readAllAttendance", "readAllAttendance doing it!-2");
//                    Log.d("readAllAttendance", attendance.getEmail());
                    attendanceList.add(attendance);
                } while (cursor.moveToNext());

                response.onSuccess(attendanceList);
            } else
                response.onFailure("There are no attendance in database");

        } catch (Exception e){
            Log.d("readAllAttendance", "readAllAttendance doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllAttendance", "readAllAttendance doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateAttendance(Attendance attendance, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForAttendance(attendance);

        try {
            long rowCount = sqLiteDatabase.update(TABLE_ATTENDANCE, contentValues,
                    ATTENDANCE_ID + " =? ", new String[]{String.valueOf(attendance.getId())});
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
    public void deleteAttendance(int attendanceId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE_ATTENDANCE, ATTENDANCE_ID + " =? ",
                    new String[]{String.valueOf(attendanceId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete attendance. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForAttendance(Attendance attendance){
        ContentValues contentValues = new ContentValues();

//        contentValues.put(ATTENDANCE_NAME, attendance.getName());
//        contentValues.put(ATTENDANCE_REGISTRATION_NUM, attendance.getRegistrationNumber());
//        contentValues.put(ATTENDANCE_PHONE, attendance.getPhone());
//        contentValues.put(ATTENDANCE_EMAIL, attendance.getEmail());



        contentValues.put(ATTENDANCE_REGISTRATION_NUMBER, attendance.getRegistrationNumber());
        contentValues.put(ATTENDANCE_SESSION, attendance.getSession());
        contentValues.put(ATTENDANCE_PROGRAM, attendance.getProgram());
        contentValues.put(ATTENDANCE_CATEGORY, attendance.getCtergory());
        contentValues.put(ATTENDANCE_SESSION, attendance.getSession());
        contentValues.put(ATTENDANCE_SEMESTER, attendance.getSemester());
        contentValues.put(ATTENDANCE_COURSE_TITLE, attendance.getCourseTitle());
        contentValues.put(ATTENDANCE_COURSE_CODE, attendance.getCourseCode());
        contentValues.put(ATTENDANCE_ATTENDANCE, attendance.getAttendace());
        contentValues.put(ATTENDANCE_DATE_OF_ATTENDANCE, attendance.getDateAttendance());
        return contentValues;
    }

    private Attendance getAttendanceFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(ATTENDANCE_ID));
//        String name = cursor.getString(cursor.getColumnIndex(ATTENDANCE_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(ATTENDANCE_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(ATTENDANCE_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(ATTENDANCE_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllAttendance", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllAttendance", s);
        }
        Log.d("readAllAttendance", "Done!" );
        Log.d("readAllAttendance", "ID-a:" );
        Log.d("readAllAttendance",Integer.toString(cursor.getColumnIndex(ATTENDANCE_ID)));
        Log.d("readAllAttendance", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(ATTENDANCE_ID));
        Log.d("readAllAttendance", Integer.toString(id) );

        Log.d("readAllAttendance", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(ATTENDANCE_ID));
        Log.d("readAllAttendance", Integer.toString(id3) );


        String registrationNum = cursor.getString(cursor.getColumnIndex(ATTENDANCE_REGISTRATION_NUMBER));
        String program = cursor.getString(cursor.getColumnIndex(ATTENDANCE_PROGRAM));
        String category = cursor.getString(cursor.getColumnIndex(ATTENDANCE_CATEGORY));
        String session = cursor.getString(cursor.getColumnIndex(ATTENDANCE_SESSION ));
        String semester = cursor.getString(cursor.getColumnIndex(ATTENDANCE_SEMESTER ));
        String courseTitle = cursor.getString(cursor.getColumnIndex(ATTENDANCE_COURSE_TITLE  ));
        String courseCode = cursor.getString(cursor.getColumnIndex(ATTENDANCE_COURSE_CODE));
        String attendace = cursor.getString(cursor.getColumnIndex(ATTENDANCE_ATTENDANCE));
        String dateAttendance = cursor.getString(cursor.getColumnIndex(ATTENDANCE_DATE_OF_ATTENDANCE));

        return new Attendance(id, registrationNum, program, category, session, semester, courseTitle, courseCode, attendace, dateAttendance);
    }
}