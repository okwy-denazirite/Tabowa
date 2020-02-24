package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Admin;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class AdminQueryImplementation implements QueryContract.AdminQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createAdmin(Admin admin, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForAdmin(admin);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_ADMIN, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                admin.setId((int) id);
            }
            else
                response.onFailure("Failed to create admin. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readAdmin(int adminId, QueryResponse<Admin> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readAdmin", "readAdmin doing it!");
            cursor = sqLiteDatabase.query(TABLE_ADMIN, null,
                    ADMIN_ID + " =? ", new String[]{String.valueOf(adminId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Admin admin = getAdminFromCursor(cursor);
                response.onSuccess(admin);
            }
            else
                response.onFailure("Admin not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllAdmin(QueryResponse<List<Admin>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Admin> adminList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllAdmin", "readAllAdmin doing it!");
            cursor = sqLiteDatabase.query(TABLE_ADMIN, null, null, null, null, null, null);
            Log.d("readAllAdmin", "readAllAdmin doing it!-1");
            Log.d("readAllAdmin", cursor.getColumnNames()[0]);
            Log.d("readAllAdmin", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Admin admin = getAdminFromCursor(cursor);
//                    Log.d("readAllAdmin", "readAllAdmin doing it!-2");
//                    Log.d("readAllAdmin", admin.getEmail());
                    adminList.add(admin);
                } while (cursor.moveToNext());

                response.onSuccess(adminList);
            } else
                response.onFailure("There are no admin in database");

        } catch (Exception e){
            Log.d("readAllAdmin", "readAllAdmin doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllAdmin", "readAllAdmin doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateAdmin(Admin admin, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForAdmin(admin);

        try {
            long rowCount = sqLiteDatabase.update(TABLE_ADMIN, contentValues,
                    ADMIN_ID + " =? ", new String[]{String.valueOf(admin.getId())});
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
    public void deleteAdmin(int adminId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE_ADMIN, ADMIN_ID + " =? ",
                    new String[]{String.valueOf(adminId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete admin. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForAdmin(Admin admin){
        ContentValues contentValues = new ContentValues();

//        contentValues.put(ADMIN_NAME, admin.getName());
//        contentValues.put(ADMIN_REGISTRATION_NUM, admin.getRegistrationNumber());
//        contentValues.put(ADMIN_PHONE, admin.getPhone());
//        contentValues.put(ADMIN_EMAIL, admin.getEmail());

        

        contentValues.put(ADMIN_REGISTRATION_NUMBER, admin.getRegNo());
        contentValues.put(ADMIN_SESSION, admin.getSession());
        contentValues.put(ADMIN_PROGRAM, admin.getProgram());
        contentValues.put(ADMIN_CATEGORY, admin.getCategory());
        contentValues.put(ADMIN_SESSION, admin.getSession());
        contentValues.put(ADMIN_DATE_OF_PAYMENT, admin.getDatePayment());
        contentValues.put(ADMIN_MODE_OF_PAYMENT, admin.getModeOfPayment());
        contentValues.put(ADMIN_AMOUNT_PAID, admin.getAmountPaid());
        contentValues.put(ADMIN_PURPOSE_OF_PAYMENT, admin.getPurposePayment());
        return contentValues;
    }

    private Admin getAdminFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(ADMIN_ID));
//        String name = cursor.getString(cursor.getColumnIndex(ADMIN_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(ADMIN_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(ADMIN_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(ADMIN_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllAdmin", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllAdmin", s);
        }
        Log.d("readAllAdmin", "Done!" );
        Log.d("readAllAdmin", "ID-a:" );
        Log.d("readAllAdmin",Integer.toString(cursor.getColumnIndex(ADMIN_ID)));
        Log.d("readAllAdmin", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(ADMIN_ID));
        Log.d("readAllAdmin", Integer.toString(id) );

        Log.d("readAllAdmin", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(ADMIN_ID));
        Log.d("readAllAdmin", Integer.toString(id3) );


        String registrationNum = cursor.getString(cursor.getColumnIndex(ADMIN_REGISTRATION_NUMBER));
        String program = cursor.getString(cursor.getColumnIndex(ADMIN_PROGRAM));
        String category = cursor.getString(cursor.getColumnIndex(ADMIN_CATEGORY));
        String session = cursor.getString(cursor.getColumnIndex(ADMIN_SESSION ));
        String datePayment = cursor.getString(cursor.getColumnIndex(ADMIN_DATE_OF_PAYMENT ));
        String modeOfPayment = cursor.getString(cursor.getColumnIndex(ADMIN_MODE_OF_PAYMENT ));
        String amountPaid = cursor.getString(cursor.getColumnIndex(ADMIN_AMOUNT_PAID ));
        String purposePayment = cursor.getString(cursor.getColumnIndex(ADMIN_PURPOSE_OF_PAYMENT ));

        return new Admin(id, registrationNum, program, category, session, datePayment, modeOfPayment, amountPaid, purposePayment );
    }
}