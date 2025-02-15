package com.lctproduction.monagement.datasources

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

import com.lctproduction.monagement.config.DatabaseHelper

class UserDataSource(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    fun addUser(user: User): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, user.name)
            put(DatabaseHelper.COLUMN_PHONE, user.phone)
            put(DatabaseHelper.COLUMN_PASSWORD, user.password)
        }
        return db.insert(DatabaseHelper.TABLE_USERS, null, values)
    }

    fun getUser(phone: String): User {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            DatabaseHelper.TABLE_USERS,
            arrayOf(DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_PHONE, DatabaseHelper.COLUMN_PASSWORD),
            "${DatabaseHelper.COLUMN_PHONE} = ?",
            arrayOf(phone),
            null, null, null
        )
        cursor.moveToFirst()
        val user = User(
            cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)),
            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME)),
            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PHONE)),
            cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PASSWORD))
        )
        cursor.close()
        db.close()
        return user
    }

    fun validateUser(phone: String, password: String): Boolean {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            DatabaseHelper.TABLE_USERS, arrayOf(DatabaseHelper.COLUMN_ID),
            "${DatabaseHelper.COLUMN_PHONE}=? AND ${DatabaseHelper.COLUMN_PASSWORD}=?", arrayOf(phone, password), null, null, null, null
        )
        val isValid = cursor.moveToFirst()
        cursor.close()
        return isValid
    }
}
