package com.groupdocs.ui.result.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.groupdocs.ui.result.ResultState
import com.groupdocs.ui.theme.spaces

@Composable
fun HeaderScreen(modifier: Modifier = Modifier, state: ResultState, onClose: () -> Unit) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier

                .padding(MaterialTheme.spaces.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource("icon.png"), contentDescription = "icon")
            Text(
                text = "GroupDocs",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onSurface
            )
        }
        Text(
            modifier = Modifier
                .padding(MaterialTheme.spaces.small),
            text = state.sourceName,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface
        )
        Button(modifier = Modifier

            .padding(MaterialTheme.spaces.small),
            onClick = {
                onClose()
            }
        ) {
            Text(
                text = "Close Viewer",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}