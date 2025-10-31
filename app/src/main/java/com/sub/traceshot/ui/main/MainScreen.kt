package com.sub.traceshot.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sub.traceshot.R
import com.sub.traceshot.component.*
import com.sub.traceshot.data.model.*
import com.sub.traceshot.theme.TraceShotTheme

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

        Text(
            text = "GALLERY",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W600,
            modifier = Modifier.fillMaxWidth())
        val albums = listOf(
            Album("governors ball music festival", "", 100),
            Album("governors ball music festival", "", 100),
            Album("oliver tree, tai verdes, upsahl", "", 101),
            Album("hard summer music festival", "", 102),
            Album("wonderbus music & arts festival 2023", "", 103),
            Album("governors ball music festival", "", 104),
            Album("governors ball music festival", "", 105),
            Album("governors ball music festival", "", 100),
            Album("governors ball music festival", "", 100),
            Album("oliver tree, tai verdes, upsahl", "", 101),
            Album("hard summer music festival", "", 102),
            Album("wonderbus music & arts festival 2023", "", 103),
            Album("governors ball music festival", "", 104),
            Album("governors ball music festival", "", 105),
            Album("governors ball music festival", "", 100),
            Album("governors ball music festival", "", 100),
            Album("oliver tree, tai verdes, upsahl", "", 101),
            Album("hard summer music festival", "", 102),
            Album("wonderbus music & arts festival 2023", "", 103),
            Album("governors ball music festival", "", 104),
            Album("governors ball music festival", "", 105),
        )
        val photos = listOf(
            Photo("governors ball music festival", ""),
            Photo("governors ball music festival", ""),
            Photo("oliver tree, tai verdes, upsahl", ""),
            Photo("hard summer music festival", ""),
            Photo("wonderbus music & arts festival 2023", ""),
            Photo("governors ball music festival", ""),
            Photo("governors ball music festival", ""),
            Photo("governors ball music festival", ""),
            Photo("governors ball music festival", ""),
            Photo("oliver tree, tai verdes, upsahl", ""),
            Photo("hard summer music festival", ""),
            Photo("wonderbus music & arts festival 2023", ""),
            Photo("governors ball music festival", ""),
            Photo("governors ball music festival", ""),
        )
        val multiGridItems = listOf(
            MultiGridItem(
                1,
                { item -> SubTitleTextView(Modifier, item.toString(), Icons.Filled.Edit) },
                "ALBUMS"
            ),
            MultiGridItem(
                2,
                { item -> AlbumItem(Modifier, item as Album) },
                albums
            ),
            MultiGridItem(
                1,
                { item -> SubTitleTextView(Modifier, item.toString()) },
                "PHOTOS"
            ),
            MultiGridItem(
                5,
                { item -> PhotoItem(Modifier, item as Photo) },
                photos
            ),
        )
        MultiLazyVerticalGrid(Modifier, multiGridItems)
    }
}



@Composable
private fun AlbumItem(modifier: Modifier, album: Album) {
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
                    contentDescription = album.title,

                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.width(4.dp))
                Column(modifier = Modifier.padding(4.dp)) {
                    TruncatedTextView(album.title)
                    Text(
                        "${album.count}",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurface)

                }
            }

        }
    }
}

@Composable
private fun PhotoItem(modifier: Modifier, photo: Photo) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(12.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = photo.title,

            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp))
        )
    }
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