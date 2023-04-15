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
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM ${Constants.DATABASE_TABLE}")
    suspend fun deleteAllTask()

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' then 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM ${Constants.DATABASE_TABLE} ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' then 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>
}