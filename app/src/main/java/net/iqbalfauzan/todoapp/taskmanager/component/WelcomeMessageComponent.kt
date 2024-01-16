package net.iqbalfauzan.todoapp.taskmanager.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iqbalfauzan.todoapp.R

/**
 * Created by IqbalMF on 2024.
 * Package net.iqbalfauzan.todoapp.taskmanager.component
 */
@Composable
@Preview
fun WelcomeMessageComponent() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Hi John!",
            fontFamily = FontFamily(Font(R.font.nunito_bold)),
            fontSize = 22.sp
        )

        Text(
            text = "8 tasks for today Monday",
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            fontSize = 18.sp,
            color = Color.LightGray
        )

    }
}