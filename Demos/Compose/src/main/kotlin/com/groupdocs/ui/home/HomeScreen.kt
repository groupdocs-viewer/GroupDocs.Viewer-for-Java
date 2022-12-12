package com.groupdocs.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.home.component.FileScreen
import com.groupdocs.ui.theme.spaces

@Composable
fun HomeScreen(screen: MutableState<Screen>) {
    val viewModel = remember { HomeViewModel(screen) }
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.h3.copy(
                fontWeight = FontWeight.W600
            ),
            text = "View Documents",
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.medium))
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.h5,
            text = "Desktop tool to view document. It supports Word, Excel, PowerPoint, Pdf, Images and lots of other formats.",
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.medium))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.h5,
                text = "Powered by ",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.clickable { viewModel.openGroupDocsSite() },
                style = MaterialTheme.typography.h5,
                text = "groupdocs.com",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.h5,
                text = ".",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.medium))
        FileScreen(
            title = "Document to view",
            documentName = state.sourceFileName,
            errorMessage = state.sourceError,
            onAdd = viewModel::onAddSource
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.medium))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.h6,
                text = "By viewing your files or using our service you agree with our ",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.clickable { viewModel.openTermsPage() },
                style = MaterialTheme.typography.h6,
                text = "Terms of Service",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.small))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.h6,
                text = "and ",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.clickable { viewModel.openPolicy() },
                style = MaterialTheme.typography.h6,
                text = " Privacy Policy",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
            Text(
                modifier = Modifier,
                style = MaterialTheme.typography.h6,
                text = ".",
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.large))

        Button(
            modifier = Modifier,
            onClick = viewModel::runConverting
        ) {
            Text(
                modifier = Modifier.padding(horizontal = MaterialTheme.spaces.medium),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.W600,
                ),
                text = "View now".uppercase(),
                color = MaterialTheme.colors.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = MaterialTheme.spaces.small)
                .weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterVertically)
                    .clickable {
                        screen.value = Screen.Settings
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = MaterialTheme.spaces.small),
                    style = MaterialTheme.typography.h6,
                    text = "Set license",
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
                Image(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .size(32.dp),
                    painter = painterResource("settings.png"),
                    contentDescription = "Settings"
                )
            }
        }
    }
}