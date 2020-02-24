package com.tabowa.rfid_app.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

import com.tabowa.rfid_app.model.Election;

import java.util.ArrayList;
import java.util.List;

import static com.tabowa.rfid_app.util.Constants.*;


public class ElectionQueryImplementation implements QueryContract.ElectionQuery {

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    @Override
    public void createElection(Election election, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForElection(election);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_ELECTION, null, contentValues);
            if(id>0) {
                response.onSuccess(true);
                election.setId((int) id);
            }
            else
                response.onFailure("Failed to create election. Unknown Reason!");
        } catch (SQLiteException e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    @Override
    public void readElection(int electionId, QueryResponse<Election> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = null;
        try {
            Log.d("readElection", "readElection doing it!");
            cursor = sqLiteDatabase.query(TABLE_ELECTION, null,
                    ELECTION_ID + " =? ", new String[]{String.valueOf(electionId)},
                    null, null, null);

            if(cursor!=null && cursor.moveToFirst()) {
                Election election = getElectionFromCursor(cursor);
                response.onSuccess(election);
            }
            else
                response.onFailure("Election not found with this ID in database");

        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void readAllElection(QueryResponse<List<Election>> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        List<Election> electionList = new ArrayList<>();

        Cursor cursor = null;
        try {
            Log.d("readAllElection", "readAllElection doing it!");
            cursor = sqLiteDatabase.query(TABLE_ELECTION, null, null, null, null, null, null);
            Log.d("readAllElection", "readAllElection doing it!-1");
            Log.d("readAllElection", cursor.getColumnNames()[0]);
            Log.d("readAllElection", Boolean.toString(cursor.moveToFirst()));
            if(cursor!=null && cursor.moveToFirst()){
                do {

                    Election election = getElectionFromCursor(cursor);
//                    Log.d("readAllElection", "readAllElection doing it!-2");
//                    Log.d("readAllElection", election.getEmail());
                    electionList.add(election);
                } while (cursor.moveToNext());

                response.onSuccess(electionList);
            } else
                response.onFailure("There are no election in database");

        } catch (Exception e){
            Log.d("readAllElection", "readAllElection doing it!-3");
            response.onFailure(e.getMessage());
        } finally {
            Log.d("readAllElection", "readAllElection doing it!-4");
            sqLiteDatabase.close();
            if(cursor!=null)
                cursor.close();
        }
    }

    @Override
    public void updateElection(Election election, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = getContentValuesForElection(election);

        try {
            long rowCount = sqLiteDatabase.update(TABLE_ELECTION, contentValues,
                    ELECTION_ID + " =? ", new String[]{String.valueOf(election.getId())});
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
    public void deleteElection(int electionId, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        try {
            long rowCount = sqLiteDatabase.delete(TABLE_ELECTION, ELECTION_ID + " =? ",
                    new String[]{String.valueOf(electionId)});

            if(rowCount>0)
                response.onSuccess(true);
            else
                response.onFailure("Failed to delete election. Unknown reason");
        } catch (Exception e){
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }

    private ContentValues getContentValuesForElection(Election election){
        ContentValues contentValues = new ContentValues();

//        contentValues.put(ELECTION_NAME, election.getName());
//        contentValues.put(ELECTION_REGISTRATION_NUM, election.getRegistrationNumber());
//        contentValues.put(ELECTION_PHONE, election.getPhone());
//        contentValues.put(ELECTION_EMAIL, election.getEmail());



        contentValues.put(ELECTION_REGISTRATION_NUMBER, election.getRegistrationNumber());
        contentValues.put(ELECTION_CONTESTANT_NAME, election.getContestantName());
        contentValues.put(ELECTION_POSITION_CONTESTANT_VIED_FOR, election.getPosition());
        contentValues.put(ELECTION_DATE_OF_ELECTION, election.getElectionDate());
        contentValues.put(ELECTION_CLEARANCE_STATUS, election.getClearanceStatus());
        contentValues.put(ELECTION_VOTING_STATUS, election.getVotingStatus());
        return contentValues;
    }

    private Election getElectionFromCursor(Cursor cursor){
//        int id = cursor.getInt(cursor.getColumnIndex(ELECTION_ID));
//        String name = cursor.getString(cursor.getColumnIndex(ELECTION_NAME));
//        int regNum = cursor.getInt(cursor.getColumnIndex(ELECTION_REGISTRATION_NUM));
//        String phone = cursor.getString(cursor.getColumnIndex(ELECTION_PHONE));
//        String email = cursor.getString(cursor.getColumnIndex(ELECTION_EMAIL));
        String getCNames[] = cursor.getColumnNames();
        Log.d("readAllElection", "Getting Column names:" );
        for (String s : getCNames)
        {
            Log.d("readAllElection", s);
        }
        Log.d("readAllElection", "Done!" );
        Log.d("readAllElection", "ID-a:" );
        Log.d("readAllElection",Integer.toString(cursor.getColumnIndex(ELECTION_ID)));
        Log.d("readAllElection", "ID-b:" );
        int id = cursor.getInt(cursor.getColumnIndex(ELECTION_ID));
        Log.d("readAllElection", Integer.toString(id) );

        Log.d("readAllElection", "ID-c:" );
        int id3 = cursor.getInt(cursor.getColumnIndex(ELECTION_ID));
        Log.d("readAllElection", Integer.toString(id3) );


        String registrationNumber = cursor.getString(cursor.getColumnIndex(ELECTION_REGISTRATION_NUMBER));
        String contestantName = cursor.getString(cursor.getColumnIndex(ELECTION_CONTESTANT_NAME));
        String position = cursor.getString(cursor.getColumnIndex(ELECTION_POSITION_CONTESTANT_VIED_FOR));
        String electionDate = cursor.getString(cursor.getColumnIndex(ELECTION_DATE_OF_ELECTION ));
        String clearanceStatus = cursor.getString(cursor.getColumnIndex(ELECTION_CLEARANCE_STATUS ));
        String votingStatus = cursor.getString(cursor.getColumnIndex(ELECTION_VOTING_STATUS));


        return new Election(id, registrationNumber, contestantName, position, electionDate, clearanceStatus, votingStatus);
    }
}