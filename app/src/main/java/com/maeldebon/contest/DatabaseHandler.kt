package com.maeldebon.contest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "MyDB"
const val TABLE_NAME = "Users"
const val COL_NAME = "name"
const val COL_FLAG = "flag"
const val COL_CAPITALE = "capitale"
const val COL_CONTINENT = "continent"
const val COL_DATE = "date"
const val COL_ID = "id"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME VARCHAR(256), $COL_FLAG VARCHAR(256), $COL_CAPITALE VARCHAR(256), $COL_CONTINENT VARCHAR(256), $COL_DATE VARCHAR(256));"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(country: Country) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, country.name)
        cv.put(COL_FLAG, country.flag)
        cv.put(COL_CAPITALE, country.capitale)
        cv.put(COL_CONTINENT, country.continent)
        cv.put(COL_DATE, country.date)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == (-1).toLong()) {
            Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Réussi", Toast.LENGTH_SHORT).show()
        }
    }

    fun readData() : MutableList<Country> {
        var list : MutableList<Country> = ArrayList()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()) {
            do {
                var country = Country()
                country.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                country.name = result.getString(result.getColumnIndex(COL_NAME))
                country.flag = result.getString(result.getColumnIndex(COL_FLAG))
                country.capitale = result.getString(result.getColumnIndex(COL_CAPITALE))
                country.continent = result.getString(result.getColumnIndex(COL_CONTINENT))
                country.date = result.getString(result.getColumnIndex(COL_DATE))
                list.add(country)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
}