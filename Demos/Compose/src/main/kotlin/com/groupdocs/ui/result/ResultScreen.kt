package com.groupdocs.ui.result


import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.groupdocs.ui.common.LocalResourceLoader
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.result.component.HeaderScreen
import com.groupdocs.ui.result.component.SubHeaderScreen
import com.groupdocs.ui.theme.GrayLight
import com.groupdocs.ui.theme.spaces

@ExperimentalComposeUiApi
@Composable
fun ResultScreen(screen: MutableState<Screen>) {
    val viewModel = remember { ResultViewModel(screen) }
    val state = viewModel.state.value

    DisposableEffect(true) {
        onDispose { viewModel.onDispose() }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderScreen(
            modifier = Modifier
                .height(50.dp),
            state = state
        ) {
            screen.value = Screen.Home
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.isInProgress || state.errorMessage != null) {
                if (state.isInProgress) {
                    CircularProgressIndicator()
                } else {
                    state.errorMessage?.let { message ->
                        Text(
                            modifier = Modifier
                                .padding(MaterialTheme.spaces.small),
                            text = message,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.error
                        )
                    }
                }
            } else if (state.infoMessage != null) {
                Text(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small),
                    text = state.infoMessage,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onPrimary
                )
            } else {
                SubHeaderScreen(
                    modifier = Modifier
                        .height(50.dp),
                    state = state,
                    onDownload = viewModel::onDownload
                )
                BodyScreen(
                    modifier = Modifier
                        .weight(1f),
                    state
                )
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun BodyScreen(modifier: Modifier, state: ResultState) {
    LazyColumn(
        modifier = modifier
    ) {
        items(state.pageList) { pagePath ->
            Image(
                modifier = Modifier
                    .padding(MaterialTheme.spaces.small)
                    .width(750.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(resourcePath = pagePath, loader = LocalResourceLoader()),
                contentDescription = "Result page"
            )
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun ResultScreenPreview() {
    ResultScreen(mutableStateOf(Screen.Result("source-file")))
}