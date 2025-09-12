package com.sub.traceshot.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sub.traceshot.R
import com.sub.traceshot.component.TruncatedTextView
import com.sub.traceshot.data.model.Photo
import com.sub.traceshot.theme.TraceShotTheme

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

        Text(
            text = "GALLERY",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Albums(Modifier)
        Spacer(modifier = Modifier.height(8.dp))
        Photos(Modifier)
    }
}

@Composable
private fun Albums(modifier: Modifier) {
    val photos = listOf(
        Photo("governors ball music festival", "", 100),
        Photo("oliver tree, tai verdes, upsahl", "", 101),
        Photo("hard summer music festival", "", 102),
        Photo("wonderbus music & arts festival 2023", "", 103),
        Photo("governors ball music festival", "", 104),
        Photo("governors ball music festival", "", 105),
    )
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "ALBUMS", style = MaterialTheme.typography.titleMedium)
        Icon(
            imageVector = Icons.Filled.Edit,
            modifier = Modifier.size(24.dp),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.surface)
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(photos) { photo ->
            AlbumItem(Modifier, photo)
        }
    }
}

@Composable
private fun AlbumItem(modifier: Modifier, photo: Photo) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(2.5f),
        shape = RoundedCornerShape(12.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = photo.title,

                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.width(4.dp))
                Column(modifier = Modifier.padding(4.dp)) {
                    TruncatedTextView(photo.title)
                    Text(
                        "${photo.count}",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurface)

                }
            }

        }
    }
}

@Composable
private fun Photos(modifier: Modifier){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "ALBUMS", style = MaterialTheme.typography.titleMedium)
        Icon(
            imageVector = Icons.Filled.Edit,
            modifier = Modifier.size(24.dp),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.surface)
    }
}

@Composable
private fun AlbumItem(modifier: Modifier){

}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun MainScreenPreview() {
    TraceShotTheme {
        MainScreen(Modifier)
    }
}