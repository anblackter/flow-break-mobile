package co.edu.uniandes.miso.ux.flowbreak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.uniandes.miso.ux.flowbreak.ui.components.AddAlarmButton
import co.edu.uniandes.miso.ux.flowbreak.ui.components.AlarmCreationButtons
import co.edu.uniandes.miso.ux.flowbreak.ui.components.AlertDialogDeleteAlarm
import co.edu.uniandes.miso.ux.flowbreak.ui.components.DayCheckBoxAlarm
import co.edu.uniandes.miso.ux.flowbreak.ui.components.ListItemAlarm
import co.edu.uniandes.miso.ux.flowbreak.ui.components.LoginButton
import co.edu.uniandes.miso.ux.flowbreak.ui.components.LoginLogo
import co.edu.uniandes.miso.ux.flowbreak.ui.components.MainTab
import co.edu.uniandes.miso.ux.flowbreak.ui.components.MainToolBar
import co.edu.uniandes.miso.ux.flowbreak.ui.components.TextFieldAlarm
import co.edu.uniandes.miso.ux.flowbreak.ui.components.TimePickerAlarm
import co.edu.uniandes.miso.ux.flowbreak.ui.components.TypeAlarmButton
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary10
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary40
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary50
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Secondary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FlowBreakMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowBreakMobileTheme {
                    LoginDisplay()
            }
        }
    }
}

@Composable
fun Background(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        content()
    }
}

@Composable
fun LoginDisplay(
    modifier: Modifier = Modifier
) {
    FlowBreakMobileTheme {
        Scaffold() { padding ->
            Background(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(75.dp))
                    LoginLogo(
                        text = R.string.app_name,
                        drawable = R.drawable.logo
                    )
                    Spacer(modifier = Modifier.height(35.dp))
                    Text(
                        text = stringResource(R.string.login_text),
                        color = FB_Light_Primary40,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Spacer(modifier = Modifier.height(51.dp))
                    LoginButton(
                        text = R.string.login_google,
                        icon = R.drawable.icon_google
                    )
                    Spacer(modifier = Modifier.height(57.dp))
                    LoginButton(
                        text = R.string.login_microsoft,
                        icon = R.drawable.icon_microsoft
                    )
                }
            }

        }
    }
}


@Composable
fun HomeDisplay() {
    Scaffold(
        topBar = {
            MainTab(
                text = R.string.home_tab,
                modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
            )
        },
        floatingActionButton = {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    AddAlarmButton()
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    MainToolBar()
                }
            }
        }
    ) { padding ->
        Background(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(43.dp))
                ListItemAlarm(
                    overline = R.string.alarm_list_item_1_overline,
                    headline = R.string.alarm_list_item_1_headline,
                    supportingText = R.string.alarm_list_item_1_supportingText,
                    color = FB_Light_Secondary95,
                    )
                Spacer(modifier = Modifier.height(43.dp))
                ListItemAlarm(
                    overline = R.string.alarm_list_item_2_overline,
                    headline = R.string.alarm_list_item_2_headline,
                    supportingText = R.string.alarm_list_item_2_supportingText,
                    color = FB_Light_Primary95,
                )
            }
        }
    }
}

@Composable
fun CreateAlarmScreen() {
    Scaffold(
        topBar = {
            MainTab(
                text = R.string.creation_tab,
                modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
            )
        },
        floatingActionButton = {
            MainToolBar()
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        Background(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(47.dp))
                TextFieldAlarm(
                    name = R.string.alarm_creation_text_field_name,
                    placeholder = R.string.alarm_creation_text_field_placeholder
                )
                Spacer(modifier = Modifier.height(47.dp))
                Text(
                    text = stringResource(R.string.creation_time_pick_title),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(30.dp))
                TimePickerAlarm(
                    text = R.string.alarm_creation_text_start_time_label
                )
                Spacer(modifier = Modifier.height(21.dp))
                TimePickerAlarm(
                    text = R.string.alarm_creation_text_end_time_label
                )
                Spacer(modifier = Modifier.height(31.dp))
                Text(
                    text = stringResource(R.string.creation_date_pick_title),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 7.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_sunday
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_monday,
                        checked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_tuesday,
                        checked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_wednesday,
                        checked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_thursday,
                        checked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_friday,
                        checked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_saturday,
                        checked = true
                    )
                }
                Spacer(modifier = Modifier.height(26.dp))
                Text(
                    text = stringResource(R.string.creation_date_type_title),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TypeAlarmButton(
                        text = R.string.alarm_creation_type_challenge,
                        icon = R.drawable.icon_alarm
                    )
                    TypeAlarmButton(
                        text = R.string.alarm_creation_type_suggestion,
                        icon = R.drawable.icon_notifications
                    )
                }
                Spacer(modifier = Modifier.height(69.dp))
                AlarmCreationButtons(
                    widthTonalButton = 115.dp,
                    heightTonalButton = 56.dp,
                    widthFilledButton = 111.dp,
                    heightFilledButton = 56.dp,
                    textFilledButton = R.string.alarm_creation_cancel,
                    textTonalButton = R.string.alarm_creation_save,
                    space = 30.dp
                )
                Spacer(modifier = Modifier.height(90.dp))
            }
        }
    }
}


@Composable
fun RecordVoiceDisplay() {
    Scaffold(
        topBar = {
            MainTab(
                text = R.string.creation_tab,
                modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        Background(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .width(196.dp)
                            .padding(top = 14.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(R.string.recording_title),
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(69.dp))
                Image(
                    painter = painterResource(id = R.drawable.voice_recording),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(143.dp)
                )
                Spacer(modifier = Modifier.height(28.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .width(48.dp)
                        .height(56.dp)
                        .border(
                            BorderStroke(2.dp, FB_Light_Primary50),
                            shape = RoundedCornerShape(60.dp)
                        ),
                    enabled = true,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = FB_Light_Primary50
                    )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_mic),
                        contentDescription = null,
                        modifier = Modifier
                            .width(14.dp)
                            .height(19.dp),
                        tint = MaterialTheme.colorScheme.onPrimary

                    )
                }
                Spacer(modifier = Modifier.height(19.dp))
                Text(
                    text = stringResource(R.string.recording_text),
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(235.dp)
                )
                Spacer(modifier = Modifier.height(119.dp))
                AlarmCreationButtons(
                    widthTonalButton = 115.dp,
                    heightTonalButton = 56.dp,
                    widthFilledButton = 125.dp,
                    heightFilledButton = 56.dp,
                    textFilledButton = R.string.recording_cancel,
                    textTonalButton = R.string.recording_confirm,
                    space = 47.5.dp
                )
            }
        }
    }
}

@Composable
fun DeleteAlarmDisplay() {
    Box() {
        HomeDisplay()
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(color = FB_Light_Primary10.copy(alpha = .7f))
        )
        AlertDialogDeleteAlarm(
            dialogTitle = R.string.alarm_deletion_title,
            dialogText = R.string.alarm_deletion_text,
            deleteText = R.string.alarm_deletion_delete,
            cancelText = R.string.alarm_deletion_cancel,
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun LoginDisplayPreview() {
    FlowBreakMobileTheme {
        LoginDisplay()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun HomeDisplayPreview() {
    FlowBreakMobileTheme {
        HomeDisplay()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun CreateAlarmScreenPreview() {
    FlowBreakMobileTheme {
        CreateAlarmScreen()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun RecordVoiceDisplayPreview() {
    FlowBreakMobileTheme {
        RecordVoiceDisplay()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 749)
@Composable
fun DeleteAlarmDisplayPreview() {
    FlowBreakMobileTheme {
        DeleteAlarmDisplay()
    }
}