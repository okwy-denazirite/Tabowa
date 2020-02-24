package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Security;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class SecurityQueryImplementation implements QueryContract.SecurityQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createSecurity(Security security, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForSecurity(security);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE__SECURITY, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                security.setId((int) id);
            }
            else
                response.onFailure("Failed to create security. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readSecurity(int securityId, QueryResponse<Security> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readSecurity", "readSecurity doing it!");
            cursor = sqLiteDatabase.query(TABLE__SECURITY, null,
                    SECURITY_ID + " =? ", new String[]{String.valueOf(securityId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Security security = getSecurityFromCursor(cursor);
                response.onSuccess(security);
            }
            else
                response.onFailure("Security not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllSecurity(QueryResponse<List<Security>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Security> securityList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllSecurity", "readAllSecurity doing it!");
            cursor = sqLiteDatabase.query(TABLE__SECURITY, null, null, null, null, null, null);
            Log.d("readAllSecurity", "readAllSecurity doing it!-1");
            Log.d("readAllSecurity", cursor.getColumnNames()[0]);
            Log.d("readAllSecurity", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Security security = getSecurityFromCursor(cursor);
//                    Log.d("readAllSecurity", "readAllSecurity doing it!-2");
//                    Log.d("readAllSecurity", security.getEmail());
                    securityList.add(security);
                } while (cursor.moveToNext());

                response.onSuccess(securityList);
            } else
                response.onFailure("There are no security in database");

        } catch (Exception e){
            Log.d("readAllSecurity", "readAllSecurity doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllSecurity", "readAllSecurity doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateSecurity(Security security, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForSecurity(security);

        try {
            long rowCount = sqLiteDatabase.update(TABLE__SECURITY, contentValues,
                    SECURITY_ID + " =? ", new String[]{String.valueOf(security.getId())});
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
    public void deleteSecurity(int securityId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE__SECURITY, SECURITY_ID + " =? ",
                    new String[]{String.valueOf(securityId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete security. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForSecurity(Security security){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SECURITY_ID, security.getId());
        contentValues.put(SECURITY_WANTED_STATUS, security.getWanted());
        contentValues.put(SECURITY_DATE_OF_BEING_WANTED, security.getWantedDate());
        contentValues.put(SECURITY_DATE_OF_BEING_ACQUITTED, security.getAcquitted());
        contentValues.put(SECURITY_DATE_OF_CLOSE_OF_INVESTIGATION, security.getClose_investigationDate());
        contentValues.put(SECURITY_NAME_OF_CRIME_CONVICTED_ON, security.getCrimeName());
        contentValues.put(SECURITY_NUMBER_OF_REGISTERED_OFFENCES, security.getNum_registerdOffences());
        contentValues.put(SECURITY_LIST_OF_CRIMES, security.getListOfCrimes());
        contentValues.put(SECURITY_DATE_OF_LAST_ARREST, security.getDateOfArrest());
        return contentValues;
    }

    private Security getSecurityFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(SECURITY_ID));
//        String name = cursor.getString(cursor.getColumnIndex(SECURITY_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(SECURITY_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(SECURITY_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(SECURITY_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllSecurity", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllSecurity", s);
        }
        Log.d("readAllSecurity", "Done!" );
        Log.d("readAllSecurity", "ID-a:" );
        Log.d("readAllSecurity",Integer.toString(cursor.getColumnIndex(SECURITY_ID)));
        Log.d("readAllSecurity", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(SECURITY_ID));
        Log.d("readAllSecurity", Integer.toString(id) );

        Log.d("readAllSecurity", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(SECURITY_ID));
        Log.d("readAllSecurity", Integer.toString(id3) );


        String wanted = cursor.getString(cursor.getColumnIndex(SECURITY_WANTED_STATUS));
        String wantedDate = cursor.getString(cursor.getColumnIndex(SECURITY_DATE_OF_BEING_WANTED));
        String acquitted = cursor.getString(cursor.getColumnIndex(SECURITY_DATE_OF_BEING_ACQUITTED));
        String close_investigationDate       = cursor.getString(cursor.getColumnIndex(SECURITY_DATE_OF_CLOSE_OF_INVESTIGATION));
        String crimeName      = cursor.getString(cursor.getColumnIndex(SECURITY_NAME_OF_CRIME_CONVICTED_ON));
        String num_registerdOffences    = cursor.getString(cursor.getColumnIndex(SECURITY_NUMBER_OF_REGISTERED_OFFENCES));
        String listOfCrimes   = cursor.getString(cursor.getColumnIndex(SECURITY_LIST_OF_CRIMES));
        String dateOfArrest   = cursor.getString(cursor.getColumnIndex(SECURITY_DATE_OF_LAST_ARREST));

        return new Security(id,wanted, wantedDate, acquitted, close_investigationDate,    crimeName, num_registerdOffences,    listOfCrimes,   dateOfArrest);
    }
}