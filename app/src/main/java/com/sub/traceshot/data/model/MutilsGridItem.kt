package com.sub.traceshot.data.model

import androidx.compose.runtime.Composable

/**
 * @Description TODO
 * @systemUser bill.liu
 * @Author
 * @Date 09-12-2025 週五 下午 04:36
 */
data class MultiGridItem(
    val columns: Int,
    val layout: @Composable (Any?) -> Unit,
    val data: Any,
)
