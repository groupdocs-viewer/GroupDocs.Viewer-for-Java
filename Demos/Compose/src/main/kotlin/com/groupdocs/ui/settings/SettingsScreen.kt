package com.groupdocs.ui.settings


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.groupdocs.ui.common.Screen
import com.groupdocs.ui.settings.component.OptionsScreen
import com.groupdocs.ui.theme.spaces

@Composable
fun SettingsScreen(screen: MutableState<Screen>) {
    val viewModel = remember { SettingsViewModel(screen) }
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondaryVariant),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .padding(start = MaterialTheme.spaces.small),
            style = MaterialTheme.typography.h4,
            text = "Settings",
            color = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.medium))

        if (state.errorMessage == null) {
            OptionsScreen(modifier = Modifier, viewModel)
        } else {
            Text(
                modifier = Modifier
                    .padding(MaterialTheme.spaces.small),
                text = state.errorMessage,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.error
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spaces.medium))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (state.errorMessage == null) {
                Button(
                    modifier = Modifier
                        .width(180.dp)
                        .padding(MaterialTheme.spaces.small),
                    onClick = viewModel::saveSettings
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = MaterialTheme.spaces.medium),
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontWeight = FontWeight.W600,
                        ),
                        text = "Save".uppercase(),
                        color = MaterialTheme.colors.onBackground
                    )
                }
            }
            Button(
                modifier = Modifier
                    .width(180.dp)
                    .padding(MaterialTheme.spaces.small),
                onClick = {
                    screen.value = Screen.Home
                }
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spaces.medium),
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.W600,
                    ),
                    text = "Cancel".uppercase(),
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

