package com.groupdocs.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.groupdocs.ui.theme.spaces

@Composable
fun FileScreen(modifier: Modifier = Modifier, title: String, documentName: String? = null, errorMessage: String? = null, onAdd: () -> Unit){
    Box(
        modifier = modifier
            .padding(MaterialTheme.spaces.medium)
            .size(350.dp, 200.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colors.secondary)
            .clickable { onAdd() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(85.dp, 65.dp),
                painter = painterResource("upload.png"), contentDescription = "Upload"
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spaces.small))
            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.W600
                ),
                text = title,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(MaterialTheme.spaces.small))
            if (errorMessage != null) {
                Text(
                    modifier = Modifier,
                    style = MaterialTheme.typography.h6,
                    text = errorMessage,
                    color = MaterialTheme.colors.error
                )
            } else {
                Text(
                    modifier = Modifier,
                    maxLines = 1,
                    style = MaterialTheme.typography.h6,
//                text = "Please drop or upload your file",
                    text = documentName ?: "Please upload your file",
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}