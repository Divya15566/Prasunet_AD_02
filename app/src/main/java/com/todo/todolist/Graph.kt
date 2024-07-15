package com.todo.todolist

import android.content.Context
import androidx.room.Room
import com.todo.todolist.data.ToDoDatabase
import com.todo.todolist.data.ToDoRepo


object Graph {
    lateinit var database: ToDoDatabase

    val ToDoRepo by lazy {
        ToDoRepo(todoDao = database.todoDAO())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, ToDoDatabase::class.java, "todolist.db").build()
    }
}