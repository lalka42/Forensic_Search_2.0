package ru.sut.forensicsearch20

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val COLUMN_INFO: String? = null
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MyDatabase.db"

        private const val TABLE_NAME = "forensic_table"
        private const val COL_ID = "id"
        private const val COL_NAME = "program_name"
        private const val COL_INFO = "information"
        private const val COL_TG = "target_OS"
        private const val COL_BG = "base_OS"
        private const val COL_PRICE = "price"

        private const val COL_S_AREA = "search_area"
        private const val COL_TG_S = "target_OS_support"
        private const val COL_BG_S = "base_OS_support"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableStatement = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_INFO TEXT, $COL_NAME TEXT, $COL_TG TEXT, $COL_BG TEXT, $COL_PRICE TEXT, $COL_S_AREA TEXT, $COL_BG_S INTEGER, $COL_TG_S INTEGER)"
        println(createTableStatement)
        db.execSQL(createTableStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addInformation(info: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL_INFO, info)
        }
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getInformation(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}