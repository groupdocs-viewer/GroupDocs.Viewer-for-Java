package com.groupdocs.ui.settings.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.groupdocs.ui.settings.SettingsViewModel
import com.groupdocs.ui.theme.spaces

@Composable
fun OptionsScreen(modifier: Modifier = Modifier, viewModel: SettingsViewModel) {
    val state = viewModel.state.value

    Column(
        modifier = modifier
            .padding(horizontal = MaterialTheme.spaces.medium, vertical = MaterialTheme.spaces.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "License:",
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            TextField(
                modifier = Modifier
                    .width(350.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current,
                value = state.licensePath ?: "",
                onValueChange = {
                    viewModel.onLicenseChanged(it)
                },
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            Button(
                modifier = Modifier,
                onClick = viewModel::selectLicense
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spaces.medium),
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.W600,
                    ),
                    text = "...",
                    color = MaterialTheme.colors.onBackground
                )
            }
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            Button(
                modifier = Modifier,
                onClick = viewModel::resetLicense
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spaces.medium),
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.W600,
                    ),
                    text = "X",
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.extraLarge))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "A few of additional options, will work only for licensed version",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f)
            )
            Text(
                modifier = Modifier
                    .clickable { viewModel.openDocumentation() },
                style = MaterialTheme.typography.body1,
                text = "(much more Viewer options are described in documentation)",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f, blue = 0.8f),
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.small))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "Max page width:",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),

                )
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .clickable {
                            viewModel.onMaxWidthChanged(100)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spaces.small),
                        style = MaterialTheme.typography.h6,
                        text = "100",
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                    RadioButton(
                        selected = state.maxWidth == 100,
                        onClick = {
                            viewModel.onMaxWidthChanged(100)
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .clickable {
                            viewModel.onMaxWidthChanged(400)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spaces.small),
                        style = MaterialTheme.typography.h6,
                        text = "400",
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                    RadioButton(
                        selected = state.maxWidth == 400,
                        onClick = {
                            viewModel.onMaxWidthChanged(400)
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .clickable {
                            viewModel.onMaxWidthChanged(800)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spaces.small),
                        style = MaterialTheme.typography.h6,
                        text = "800",
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                    RadioButton(
                        selected = state.maxWidth == 800,
                        onClick = {
                            viewModel.onMaxWidthChanged(800)
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .clickable {
                            viewModel.onMaxWidthChanged(1200)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spaces.small),
                        style = MaterialTheme.typography.h6,
                        text = "1200",
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                    RadioButton(
                        selected = state.maxWidth == 1200,
                        onClick = {
                            viewModel.onMaxWidthChanged(1200)
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spaces.small)
                .clickable {
                    viewModel.onRenderCommentsChanged(!state.isRenderComments)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = state.isRenderComments,
                onCheckedChange = {
                    viewModel.onRenderCommentsChanged(it)
                }
            )
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "Render comments",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
            )
        }

    }
    Spacer(modifier = Modifier.height(MaterialTheme.spaces.large))
}