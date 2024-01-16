package net.iqbalfauzan.todoapp.taskmanager.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.iqbalfauzan.todoapp.R
import net.iqbalfauzan.todoapp.taskmanager.data.TaskToDo
import net.iqbalfauzan.todoapp.ui.theme.LightBlue
import net.iqbalfauzan.todoapp.ui.theme.LightGreen
import net.iqbalfauzan.todoapp.ui.theme.LightPurple

/**
 * Created by IqbalMF on 2024.
 * Package net.iqbalfauzan.todoapp.taskmanager.component
 */
@Composable
fun TaskComponent(task: TaskToDo) {
    val taskColor = listOf(LightPurple, LightBlue, LightGreen).random()
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "${task.startTime}\nAM",
            fontFamily = FontFamily(Font(R.font.nunito_bold)),
            textAlign = TextAlign.Center
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .border(
                        border = BorderStroke(3.dp, Color.Black),
                        shape = CircleShape
                    )
            )
            Divider(modifier = Modifier.width(6.dp), color = Color.Black)

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            taskColor
                        )
                        .weight(0.9f)
                ) {
                    Text(
                        modifier = Modifier.padding(top = 12.dp, start = 12.dp),
                        text = task.title,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                    if (task.body != null) {
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = task.body,
                            color = Color.Gray,
                            fontFamily = FontFamily(Font(R.font.nunito_bold))
                        )
                    }

                    Text(
                        modifier = Modifier.padding(bottom = 12.dp, start = 12.dp),
                        text = "${task.startTime} - ${task.endTime}",
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                    )
                }

                Divider(
                    modifier = Modifier
                        .width(6.dp)
                        .weight(0.1f), color = Color.Black
                )
            }
        }
    }
}