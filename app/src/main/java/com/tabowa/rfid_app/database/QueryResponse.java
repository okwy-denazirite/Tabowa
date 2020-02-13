package com.tabowa.rfid_app.database;

public interface QueryResponse<T> {
    void onSuccess(T data);
    void onFailure(String message);
}