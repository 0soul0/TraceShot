package com.sub.traceshot.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sub.traceshot.data.model.MultiGridItem

/**
 * @Description TODO
 * @systemUser bill.liu
 * @Author
 * @Date 09-12-2025 週五 下午 05:45
 */


@Composable
fun MultiLazyVerticalGrid(modifier: Modifier, multiGridItems: List<MultiGridItem>) {
    val gridCells = 10
    LazyVerticalGrid(
        columns = GridCells.Fixed(gridCells),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        multiGridItems.forEach { data ->
            items(
                if (data.data is List<*>) data.data else listOf(data.data),
                span = { GridItemSpan(gridCells / data.columns) }
            ) { item ->
                data.layout(item)
            }
        }


    }
}

