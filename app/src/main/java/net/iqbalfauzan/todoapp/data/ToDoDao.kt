package net.iqbalfauzan.todoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import net.iqbalfauzan.todoapp.data.models.ToDoTask
import net.iqbalfauzan.todoapp.utils.Constants

@Dao
interface ToDoDao {
    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} Order By id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(toDoTask: ToDoTask)

    @Update
    fun updateTask(toDoTask: ToDoTask)

    @Delete
    fun deleteTask(toDoTask: ToDoTask)

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

}