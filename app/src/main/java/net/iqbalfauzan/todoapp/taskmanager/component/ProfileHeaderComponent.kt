package net.iqbalfauzan.todoapp.taskmanager.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iqbalfauzan.todoapp.R
import net.iqbalfauzan.todoapp.ui.theme.Orange

/**
 * Created by IqbalMF on 2024.
 * Package net.iqbalfauzan.todoapp.taskmanager.component
 */
@Preview
@Composable
fun ProfileHeaderComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = android.R.mipmap.sym_def_app_icon),
            "Profile Picture",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
        BadgedBox(
            badge = {
                Badge(
                    backgroundColor = Orange,
                    contentColor = Color.White,
                    modifier = Modifier.offset(y = 7.dp, x = (-6).dp)
                )
            },
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications")

        }
    }
}