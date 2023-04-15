package net.iqbalfauzan.todoapp.data.models

import androidx.compose.ui.graphics.Color
import net.iqbalfauzan.todoapp.ui.theme.HighPriorityColor
import net.iqbalfauzan.todoapp.ui.theme.LowPriorityColor
import net.iqbalfauzan.todoapp.ui.theme.MediumPriorityColor
import net.iqbalfauzan.todoapp.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}