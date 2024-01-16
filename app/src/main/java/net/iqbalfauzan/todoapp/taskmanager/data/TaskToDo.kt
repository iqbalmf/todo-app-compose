package net.iqbalfauzan.todoapp.taskmanager.data

/**
 * Created by IqbalMF on 2024.
 * Package net.iqbalfauzan.todoapp.taskmanager.data
 */
data class TaskToDo(
    val id: Int,
    val title: String,
    val body: String? = null,
    val startTime: String,
    val endTime: String,
)

val taskList = listOf(
    TaskToDo(1, "Do Laundry", "Wash and fold clothes", "10:00", "11:00"),
    TaskToDo(2, "Do Laundry", "Wash and fold clothes", "11:00", "12:00"),
    TaskToDo(3, "Do Laundry", "Wash and fold clothes", "12:00", "13:00"),
    TaskToDo(4, "Do Laundry", "Wash and fold clothes", "13:00", "14:00"),
    TaskToDo(5, "Do Laundry", "Wash and fold clothes", "14:00", "15:00"),
    TaskToDo(6, "Do Laundry", "Wash and fold clothes", "15:00", "16:00"),
)
