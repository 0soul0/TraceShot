package com.sub.traceshot.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sub.traceshot.component.SubTitleTextView
import com.sub.traceshot.theme.TraceShotTheme

/**
 * @Description TODO
 * @systemUser bill.liu
 * @Author
 * @Date 09-09-2025 週二 下午 03:01
 */

@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        SubTitleTextView(Modifier, "Setting")
        AlbumItem(Modifier, "Transparency", Icons.Default.DateRange, content = {})
    }
}

@Composable
private fun AlbumItem(
    modifier: Modifier, title: String,
    imageVectorLeft: ImageVector? = null,
    imageVectorRight: ImageVector? = null,
    content: (@Composable () -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .border(0.5.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(6.dp)),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(4.dp, 8.dp, 4.dp, 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = modifier
                    .background(Color.Transparent),
                verticalAlignment = Alignment.CenterVertically
            ) {
                imageVectorLeft?.let {
                    Icon(
                        imageVector = it,
                        modifier = modifier.size(24.dp),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                Text(
                    title,
                    fontWeight = FontWeight.W400,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.surface,
                    modifier = modifier.padding(start = 4.dp) // 增加間距
                )
            }
            content?.let {
                Box(modifier = modifier.fillMaxWidth(), content = { it.invoke() })
            }
            imageVectorRight?.let {
                Icon(
                    imageVector = it,
                    modifier = Modifier.size(24.dp),
                    contentDescription = "",

                    tint = MaterialTheme.colorScheme.inversePrimary)
            }
        }

    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun MainScreenPreview() {
    TraceShotTheme {
        SettingScreen(Modifier)
    }
}