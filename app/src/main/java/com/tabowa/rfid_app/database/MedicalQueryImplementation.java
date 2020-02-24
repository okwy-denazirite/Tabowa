package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Medical;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class MedicalQueryImplementation implements QueryContract.MedicalQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createMedical(Medical medical, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForMedical(medical);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_MEDICAL, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                medical.setId((int) id);
            }
            else
                response.onFailure("Failed to create medical. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readMedical(int medicalId, QueryResponse<Medical> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readMedical", "readMedical doing it!");
            cursor = sqLiteDatabase.query(TABLE_MEDICAL, null,
                    MEDICAL_ID + " =? ", new String[]{String.valueOf(medicalId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Medical medical = getMedicalFromCursor(cursor);
                response.onSuccess(medical);
            }
            else
                response.onFailure("Medical not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllMedical(QueryResponse<List<Medical>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Medical> medicalList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllMedical", "readAllMedical doing it!");
            cursor = sqLiteDatabase.query(TABLE_MEDICAL, null, null, null, null, null, null);
            Log.d("readAllMedical", "readAllMedical doing it!-1");
            Log.d("readAllMedical", cursor.getColumnNames()[0]);
            Log.d("readAllMedical", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Medical medical = getMedicalFromCursor(cursor);
//                    Log.d("readAllMedical", "readAllMedical doing it!-2");
//                    Log.d("readAllMedical", medical.getEmail());
                    medicalList.add(medical);
                } while (cursor.moveToNext());

                response.onSuccess(medicalList);
            } else
                response.onFailure("There are no medical in database");

        } catch (Exception e){
            Log.d("readAllMedical", "readAllMedical doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllMedical", "readAllMedical doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateMedical(Medical medical, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForMedical(medical);

        try {
            long rowCount = sqLiteDatabase.update(TABLE_MEDICAL, contentValues,
                    MEDICAL_ID + " =? ", new String[]{String.valueOf(medical.getId())});
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
    public void deleteMedical(int medicalId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE_MEDICAL, MEDICAL_ID + " =? ",
                    new String[]{String.valueOf(medicalId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete medical. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForMedical(Medical medical){
        ContentValues contentValues = new ContentValues();

//        contentValues.put(MEDICAL_NAME, medical.getName());
//        contentValues.put(MEDICAL_REGISTRATION_NUM, medical.getRegistrationNumber());
//        contentValues.put(MEDICAL_PHONE, medical.getPhone());
//        contentValues.put(MEDICAL_EMAIL, medical.getEmail());



        contentValues.put(MEDICAL_REGISTRATION_NUMBER, medical.getRegistrationNumber());
        contentValues.put(MEDICAL_NAME, medical.getName());
        contentValues.put(MEDICAL_MEDICAL_CARD_NUMBER, medical.getMedicalCardNumber());
        contentValues.put(MEDICAL_BLOOD_GROUP, medical.getMedicalCardNumber());
        contentValues.put(MEDICAL_BLOOD_GROUP, medical.getBloodGroup());
        contentValues.put(MEDICAL_CONDITIONS, medical.getCondition());
        contentValues.put(MEDICAL_ALLERGY, medical.getAllergy());
        contentValues.put(MEDICAL_HISTORY, medical.getMedicalHistory());
        contentValues.put(MEDICAL_ATTENDANT_DOCTOR, medical.getAttendantDoctor());
        contentValues.put(MEDICAL_TTENDANT_DOCTOR_PHONE, medical.getAttendantDoctorPhone());
        return contentValues;
    }

    private Medical getMedicalFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(MEDICAL_ID));
//        String name = cursor.getString(cursor.getColumnIndex(MEDICAL_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(MEDICAL_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(MEDICAL_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(MEDICAL_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllMedical", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllMedical", s);
        }
        Log.d("readAllMedical", "Done!" );
        Log.d("readAllMedical", "ID-a:" );
        Log.d("readAllMedical",Integer.toString(cursor.getColumnIndex(MEDICAL_ID)));
        Log.d("readAllMedical", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(MEDICAL_ID));
        Log.d("readAllMedical", Integer.toString(id) );

        Log.d("readAllMedical", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(MEDICAL_ID));
        Log.d("readAllMedical", Integer.toString(id3) );


        String registrationNumber = cursor.getString(cursor.getColumnIndex(MEDICAL_REGISTRATION_NUMBER));
        String name = cursor.getString(cursor.getColumnIndex(MEDICAL_NAME));
        String medicalCardNumber = cursor.getString(cursor.getColumnIndex(MEDICAL_MEDICAL_CARD_NUMBER));
        String bloodGroup = cursor.getString(cursor.getColumnIndex(MEDICAL_BLOOD_GROUP));
        String condition = cursor.getString(cursor.getColumnIndex(MEDICAL_CONDITIONS));
        String allergy = cursor.getString(cursor.getColumnIndex(MEDICAL_ALLERGY));
        String medicalHistory = cursor.getString(cursor.getColumnIndex(MEDICAL_HISTORY));
        String attendantDoctor = cursor.getString(cursor.getColumnIndex(MEDICAL_ATTENDANT_DOCTOR));
        String attendantDoctorPhone = cursor.getString(cursor.getColumnIndex(MEDICAL_TTENDANT_DOCTOR_PHONE));




        return new Medical(id, registrationNumber, name, medicalCardNumber, bloodGroup, condition, allergy, medicalHistory, attendantDoctor, attendantDoctorPhone);
    }
}