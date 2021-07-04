package com.iamageo.kt_shopping_list.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class ProductDatabase(context: Context) : ManagedSQLiteOpenHelper(ctx = context, name = "list_products_db", version = 1) {

    companion object {
        private var instance: ProductDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context) : ProductDatabase {
            if(instance == null) {
                instance = ProductDatabase(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //TODO: create table
        if (db != null) {
            db.createTable("products", true,
                    "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                    "name" to TEXT,
                    "qtd" to INTEGER,
                    "value" to REAL,
                    "photo" to BLOB
            )
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //TODO: upgrade database
    }

}

    //access property
    val Context.database: ProductDatabase
    get() = ProductDatabase.getInstance(applicationContext)
