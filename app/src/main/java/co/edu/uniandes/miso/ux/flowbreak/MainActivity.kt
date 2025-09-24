package co.edu.uniandes.miso.ux.flowbreak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary70
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Secondary50
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Secondary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FlowBreakMobileTheme

// Define the different screens in the app
enum class Screen {
    LOGIN,
    HOME,
    CREATE_ALARM,
    RECORD_VOICE,
    TIME_PICKER,
    DELETE_ALARM,
    LOADING
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowBreakMobileTheme {
                AppNavigation()
            }
        }
    }
}

// Main navigation composable that handles screen switching
@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(Screen.LOGIN) }
    
    when (currentScreen) {
        Screen.LOGIN -> LoginDisplay(
            onLoginSuccess = { currentScreen = Screen.LOADING }
        )
        Screen.HOME -> HomeDisplay(
            onAddAlarm = { currentScreen = Screen.CREATE_ALARM },
            onDeleteAlarm = { currentScreen = Screen.DELETE_ALARM }
        )
        Screen.CREATE_ALARM -> CreateAlarmScreen(
            onBack = { currentScreen = Screen.HOME },
            onSave = { currentScreen = Screen.HOME },
            onTimePicker = { currentScreen = Screen.TIME_PICKER },
            onRecordVoice = { currentScreen = Screen.RECORD_VOICE }
        )
        Screen.RECORD_VOICE -> RecordVoiceDisplay(
            onBack = { currentScreen = Screen.CREATE_ALARM },
            onConfirm = { currentScreen = Screen.CREATE_ALARM }
        )
        Screen.TIME_PICKER -> TimePickerCreateAlarmDisplay(
            onBack = { currentScreen = Screen.CREATE_ALARM }
        )
        Screen.DELETE_ALARM -> DeleteAlarmDisplay(
            onBack = { currentScreen = Screen.HOME },
            onConfirmDelete = { currentScreen = Screen.HOME }
        )
        Screen.LOADING -> {
            LoadingDisplay()
            LaunchedEffect(Unit) {
                delay(800) // Wait for 800ms (same as animation duration)
                currentScreen = Screen.HOME
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
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {}
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
                        icon = R.drawable.icon_google,
                        onLoginClick = onLoginSuccess
                    )
                    Spacer(modifier = Modifier.height(57.dp))
                    LoginButton(
                        text = R.string.login_microsoft,
                        icon = R.drawable.icon_microsoft,
                        onLoginClick = onLoginSuccess
                    )
                }
            }

        }
    }
}


@Composable
fun HomeDisplay(
    onAddAlarm: () -> Unit = {},
    onDeleteAlarm: () -> Unit = {}
) {
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
                    AddAlarmButton(onClick = onAddAlarm)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    MainToolBar(
                        onAlarmClick = { /* Already on home, do nothing */ }
                    )
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
                    onEdit = onAddAlarm,
                    onDelete = onDeleteAlarm
                )
                Spacer(modifier = Modifier.height(43.dp))
                ListItemAlarm(
                    overline = R.string.alarm_list_item_2_overline,
                    headline = R.string.alarm_list_item_2_headline,
                    supportingText = R.string.alarm_list_item_2_supportingText,
                    color = FB_Light_Primary95,
                    onEdit = onAddAlarm,
                    onDelete = onDeleteAlarm
                )
            }
        }
    }
}

@Composable
fun CreateAlarmScreen(
    onBack: () -> Unit = {},
    onSave: () -> Unit = {},
    onTimePicker: () -> Unit = {},
    onRecordVoice: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            MainTab(
                text = R.string.creation_tab,
                modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
            )
        },
        floatingActionButton = {
            MainToolBar(
                onAlarmClick = onBack
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
                    text = R.string.alarm_creation_text_start_time_label,
                    onClick = onTimePicker
                )
                Spacer(modifier = Modifier.height(21.dp))
                TimePickerAlarm(
                    text = R.string.alarm_creation_text_end_time_label,
                    onClick = onTimePicker
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
                        initialChecked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_tuesday,
                        initialChecked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_wednesday,
                        initialChecked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_thursday,
                        initialChecked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_friday,
                        initialChecked = true
                    )
                    DayCheckBoxAlarm(
                        day = R.string.alarm_creation_text_saturday,
                        initialChecked = true
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
                        icon = R.drawable.icon_notifications,
                        onClick = onRecordVoice
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
                    space = 30.dp,
                    onFilledButtonClick = onBack,
                    onTonalButtonClick = onSave
                )
                Spacer(modifier = Modifier.height(90.dp))
            }
        }
    }
}


@Composable
fun RecordVoiceDisplay(
    onBack: () -> Unit = {},
    onConfirm: () -> Unit = {}
) {
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
                    space = 47.5.dp,
                    onFilledButtonClick = onBack,
                    onTonalButtonClick = onConfirm
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerCreateAlarmDisplay(
    onBack: () -> Unit = {}
) {
    val timePickerState = rememberTimePickerState(
        initialHour = 0,
        initialMinute = 0,
        is24Hour = true,
    )
    Box() {
        CreateAlarmScreen()
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(color = FB_Light_Primary10.copy(alpha = .7f))
                .clickable { onBack() }
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            TimePicker(
                state = timePickerState,
                colors = TimePickerDefaults.colors(
                    clockDialColor = FB_Light_Primary70,
                    selectorColor = FB_Light_Secondary50,
                    clockDialSelectedContentColor = Color.White,
                    clockDialUnselectedContentColor = MaterialTheme.colorScheme.onSurface,
                    timeSelectorSelectedContainerColor = Color.Transparent,
                    timeSelectorUnselectedContainerColor = Color.Transparent,
                    timeSelectorSelectedContentColor = Color.Transparent,
                    timeSelectorUnselectedContentColor = Color.Transparent,
                    periodSelectorSelectedContentColor = Color.Transparent,
                    periodSelectorSelectedContainerColor = Color.Transparent,
                    periodSelectorUnselectedContainerColor = Color.Transparent,
                    periodSelectorUnselectedContentColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun DeleteAlarmDisplay(
    onBack: () -> Unit = {},
    onConfirmDelete: () -> Unit = {}
) {
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
            onDismiss = onBack,
            onConfirmDelete = onConfirmDelete,
            onCancel = onBack
        )
    }
}

@Composable
fun LoadingDisplay(
    modifier: Modifier = Modifier
) {
    // Create infinite transition for rotation animation
    val infiniteTransition = rememberInfiniteTransition(label = "rotation")
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )

    Scaffold() { padding ->
        Background(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(172.dp)
                        .width(160.dp)
                        .graphicsLayer {
                            rotationZ = rotationAngle
                        }
                )
                Text(
                    text = stringResource(R.string.loading_text),
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = FB_Light_Primary40
                )
            }
        }
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

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun TimePickerCreateAlarmDisplayPreview() {
    FlowBreakMobileTheme {
        TimePickerCreateAlarmDisplay()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun LoadingDisplayPreview() {
    FlowBreakMobileTheme {
        LoadingDisplay()
    }
}