package com.sub.traceshot.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * @Description TODO
 * @systemUser bill.liu
 * @Author
 * @Date 09-12-2025 週五 上午 11:58
 */
@Composable
fun TruncatedTextView(
    title: String,
    maxLines: Int = 2,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleSmall,
    fontWeight: FontWeight = W500
) {
    Text(
        text = title,
        style = style,
        fontWeight = fontWeight,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier,
        maxLines = maxLines, // 限制為單行
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
fun SubTitleTextView(modifier: Modifier, title: String, imageVector: ImageVector? = null) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 8.dp, 0.dp, 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.W600)
        imageVector?.let {
            Icon(
                imageVector = it,
                modifier = Modifier.size(24.dp),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.inversePrimary)
        }

    }
}