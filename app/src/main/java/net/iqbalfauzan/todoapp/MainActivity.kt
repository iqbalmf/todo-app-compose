package net.iqbalfauzan.todoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iqbalfauzan.todoapp.taskmanager.component.ProfileHeaderComponent
import net.iqbalfauzan.todoapp.taskmanager.component.TaskComponent
import net.iqbalfauzan.todoapp.taskmanager.component.WelcomeMessageComponent
import net.iqbalfauzan.todoapp.taskmanager.data.taskList
import net.iqbalfauzan.todoapp.ui.theme.Orange
import net.iqbalfauzan.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedScreen by remember {
                mutableIntStateOf(1)
            }
            val screens = listOf("Calendar", "Home", "Notifications")
            TodoAppTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            modifier = Modifier.height(90.dp),
                            backgroundColor = Color.White,
                            elevation = 0.dp
                        ) {
                            screens.forEachIndexed { index, _ ->
                                val icon: ImageVector = when (index) {
                                    0 -> Icons.Filled.DateRange
                                    1 -> Icons.Filled.Home
                                    2 -> Icons.Filled.Notifications
                                    else -> Icons.Filled.Home
                                }
                                BottomNavigationItem(
                                    selected = selectedScreen == index,
                                    onClick = { selectedScreen = index },
                                    icon = {
                                        Box(
                                            modifier = Modifier
                                                .size(80.dp)
                                                .clip(CircleShape)
                                                .background(if (selectedScreen == index) Color.Black else Color.White),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            Icon(
                                                imageVector = icon, contentDescription = "Screen",
                                                modifier = Modifier
                                                    .size(50.dp)
                                                    .padding(if (selectedScreen == index) 12.dp else 14.dp),
                                                tint = if (selectedScreen == index) Color.White else Color.Black
                                            )
                                        }
                                    },
                                )
                            }
                        }
                    },
                ) { paddingValues ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                paddingValues = PaddingValues(
                                    top = paddingValues.calculateTopPadding(),
                                    bottom = paddingValues.calculateBottomPadding(),
                                    start = 16.dp
                                ),
                            ),
                    ) {
                        item {
                            ProfileHeaderComponent()
                        }
                        item {
                            Spacer(modifier = Modifier.height(30.dp))
                            WelcomeMessageComponent()
                            Spacer(modifier = Modifier.height(30.dp))
                        }
                        items(taskList) { task ->
                            TaskComponent(task = task)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}