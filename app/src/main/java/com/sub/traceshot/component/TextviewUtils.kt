package com.sub.traceshot.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextOverflow

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