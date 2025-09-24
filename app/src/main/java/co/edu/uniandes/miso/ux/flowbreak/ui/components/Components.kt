package co.edu.uniandes.miso.ux.flowbreak.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.edu.uniandes.miso.ux.flowbreak.R
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary0
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary100
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary20
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary30
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary40
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary50
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary85
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary90
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Secondary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Tertiary70
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Tertiary80
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Tertiary85
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Tertiary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FlowBreakMobileTheme

@Composable
fun LoginButton(
    @DrawableRes icon: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {}
) {
    ElevatedButton(
        modifier = modifier
            .width(197.dp)
            .height(96.dp),
        onClick = onLoginClick,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(24.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 8.dp
        )

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = modifier
                    .size(32.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                stringResource(text),
                style = MaterialTheme.typography.headlineSmall,
                color = FB_Light_Primary100,
            )
        }
    }

}


@Composable
fun LoginLogo(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = Modifier
                .height(172.dp)
                .width(160.dp)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 0.dp, bottom = 8.dp),
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary
        )
    }

}

@Composable
fun SecondaryIndicator(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color)
                .align(Alignment.BottomCenter)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTab(
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    SecondaryTabRow(
        selectedTabIndex = 0,
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth(),
        containerColor = FB_Light_Tertiary95,
        indicator = {
            SecondaryIndicator(
                MaterialTheme.colorScheme.secondary,
                Modifier.tabIndicatorOffset(0)
            )
        }
    ) {
        Tab(
            selected = true,
            onClick = {},
            text = {
                Text(
                    text = stringResource(text),
                    style = MaterialTheme.typography.titleSmall
                )
            }
        )
    }
}


@Composable
fun ListItemAlarm(
    @StringRes overline: Int,
    @StringRes headline: Int,
    @StringRes supportingText: Int,
    color: Color,
    modifier: Modifier = Modifier,
    onEdit: () -> Unit = {},
    onDelete: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(80.dp)
            .background(color)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .width(236.dp)
                .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
        ) {
            Text(
                text = stringResource(overline),
                textAlign = TextAlign.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(headline),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = stringResource(supportingText),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .width(124.dp)
        ) {
            Row(
                modifier = modifier
                    .padding(start = 13.dp, end = 13.dp)
            ) {
                FilledIconButton(
                    onClick = onEdit,
                    shape = RoundedCornerShape(50),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ),
                    modifier = modifier
                        .width(40.dp)
                        .height(32.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_edit),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = modifier
                            .size(15.dp)
                    )
                }
                Spacer(modifier = Modifier.width(18.dp))
                FilledIconButton(
                    onClick = onDelete,
                    shape = RoundedCornerShape(50),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    ),
                    modifier = modifier
                        .width(40.dp)
                        .height(32.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_delete),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = modifier
                            .size(15.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AddAlarmButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 3.dp
        )
    ) {
        Icon(
            Icons.Default.Add,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun MainToolBar(
    modifier: Modifier = Modifier,
    onAlarmClick: () -> Unit = {},
    onMonitoringClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .background(
                color = MaterialTheme.colorScheme.primary, // Blue fill
                shape = RoundedCornerShape(50)
            )
            .border(
                BorderStroke(5.dp, MaterialTheme.colorScheme.primary),
                RoundedCornerShape(50)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .width(140.dp)
                .height(64.dp)
        ) {
            IconButton(
                onClick = onAlarmClick,
                modifier = modifier
                    .size(60.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_alarm),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = modifier
                        .size(21.dp)
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = {},
                modifier = modifier
                    .size(60.dp),
                enabled = true
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_monitoring),
                    contentDescription = null,
                    modifier = modifier
                        .size(21.dp),
                    tint = Color.Gray
                )
            }
        }
    }

}


@Composable
fun TextFieldAlarm(
    @StringRes name: Int,
    @StringRes placeholder: Int,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = stringResource(placeholder),
        textStyle = MaterialTheme.typography.bodyLarge,
        onValueChange = { },
        label = {
            Text(
                text = stringResource(name),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = modifier
                    .background(FB_Light_Secondary95)
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { },
                modifier = modifier
                    .padding(4.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_cancel),
                    contentDescription = "Clear text",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = modifier
                        .size(24.dp)
                )
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedBorderColor = FB_Light_Primary20,
            unfocusedBorderColor = FB_Light_Primary20
        ),
        modifier = modifier
            .height(64.dp)
            .width(210.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerAlarm(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier
                    .background(
                        color = FB_Light_Primary90,
                        shape = RoundedCornerShape(20)
                    )
                    .width(70.dp)
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.alarm_creation_text_hour),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Text(
                text = stringResource(R.string.alarm_creation_text_separator),
                style = MaterialTheme.typography.headlineMedium,
                modifier = modifier
                    .padding(start = 8.dp, end = 8.dp)
            )
            Box(
                modifier
                    .background(
                        color = FB_Light_Primary90,
                        shape = RoundedCornerShape(20)
                    )
                    .width(70.dp)
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.alarm_creation_text_minute),
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun DayCheckBoxAlarm(
    @StringRes day: Int,
    modifier: Modifier = Modifier,
    initialChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    var checked by remember { mutableStateOf(initialChecked) }
    
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            modifier = modifier
                .padding(bottom = 2.dp),
            text = stringResource(day),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { newValue ->
                checked = newValue
                onCheckedChange(newValue)
            },
            modifier = modifier
                .padding(top = 16.dp)
        )
    }
}

@Composable
fun TypeAlarmButton(
    @StringRes text: Int,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconToggleButton(
            checked = false,
            onCheckedChange = { onClick() },
            modifier = modifier
                .border(
                    BorderStroke(2.dp, FB_Light_Primary85),
                    shape = RoundedCornerShape(24.dp)
                )
                .size(96.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = modifier
                    .size(32.dp),
                tint = FB_Light_Primary40
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.titleSmall,
            color = FB_Light_Primary40,
            modifier = modifier
        )
    }

}

@Composable
fun AlarmCreationButtons(
    widthTonalButton: Dp,
    heightTonalButton: Dp,
    widthFilledButton: Dp,
    heightFilledButton: Dp,
    space: Dp,
    @StringRes textFilledButton: Int,
    @StringRes textTonalButton: Int,
    modifier: Modifier = Modifier,
    onFilledButtonClick: () -> Unit = {},
    onTonalButtonClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        FilledTonalButton(
            modifier = modifier
                .width(widthTonalButton)
                .height(heightTonalButton),
            onClick = onFilledButtonClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = FB_Light_Primary100,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        ) {
            Text(
                text = stringResource(textFilledButton),
                style = MaterialTheme.typography.titleMedium,
                color = FB_Light_Primary0
            )
        }
        Spacer(modifier = Modifier.width(space))
        Button(
            modifier = modifier
                .width(widthFilledButton)
                .height(heightFilledButton),
            shape = RoundedCornerShape(16.dp),
            onClick = onTonalButtonClick,
        ) {
            Text(
                text = stringResource(textTonalButton),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun AlertDialogDeleteAlarm(
    @StringRes dialogTitle: Int,
    @StringRes dialogText: Int,
    @StringRes deleteText: Int,
    @StringRes cancelText: Int,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    onConfirmDelete: () -> Unit = {},
    onCancel: () -> Unit = {}
) {
    AlertDialog(
        containerColor = FB_Light_Primary30,
        icon = {
            Icon(
                painter = painterResource(R.drawable.icon_warning),
                contentDescription = null,
                tint = FB_Light_Tertiary70,
                modifier = modifier
                    .width(22.dp)
                    .height(19.dp)
            )
        },
        title = {
            Text(
                text = stringResource(dialogTitle),
                color = FB_Light_Tertiary80
            )
        },
        text = {
            Text(
                text = stringResource(dialogText),
                color = FB_Light_Tertiary85
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onCancel,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = FB_Light_Primary50
                )
            ) {
                Text(
                    text = stringResource(cancelText),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = onConfirmDelete,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                )
            ) {
                Text(
                    text = stringResource(deleteText),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginButtonPreview() {
    FlowBreakMobileTheme {
        LoginButton(
            text = R.string.login_microsoft,
            icon = R.drawable.icon_microsoft
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LoginLogoPreview() {
    FlowBreakMobileTheme {
        LoginLogo(
            text = R.string.app_name,
            drawable = R.drawable.logo
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainTabPreview() {
    FlowBreakMobileTheme {
        MainTab(
            text = R.string.home_tab
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemAlarmPreview() {
    FlowBreakMobileTheme {
        ListItemAlarm(
            overline = R.string.alarm_list_item_1_overline,
            headline = R.string.alarm_list_item_1_headline,
            supportingText = R.string.alarm_list_item_1_supportingText,
            color = FB_Light_Secondary95
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddAlarmButtonPreview() {
    FlowBreakMobileTheme {
        AddAlarmButton()
    }
}

@Preview(showBackground = true)
@Composable
fun MainToolBarPreview() {
    FlowBreakMobileTheme {
        MainToolBar()
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldAlarmPreview() {
    FlowBreakMobileTheme {
        TextFieldAlarm(
            name = R.string.alarm_creation_text_field_name,
            placeholder = R.string.alarm_creation_text_field_placeholder
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TimePickerAlarmPreview() {
    FlowBreakMobileTheme {
        TimePickerAlarm(
            text = R.string.alarm_creation_text_start_time_label
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DayCheckBoxAlarmPreview() {
    FlowBreakMobileTheme {
        DayCheckBoxAlarm(
            day = R.string.alarm_creation_text_monday
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TypeAlarmButtonPreview() {
    FlowBreakMobileTheme {
        TypeAlarmButton(
            text = R.string.alarm_creation_type_challenge,
            icon = R.drawable.icon_alarm
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlarmCreationButtonsPreview() {
    FlowBreakMobileTheme {
        AlarmCreationButtons(
            widthTonalButton = 115.dp,
            heightTonalButton = 56.dp,
            widthFilledButton = 111.dp,
            heightFilledButton = 56.dp,
            textFilledButton = R.string.alarm_creation_cancel,
            textTonalButton = R.string.alarm_creation_save,
            space = 30.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlertDialogDeleteAlarmPreview() {
    FlowBreakMobileTheme {
        AlertDialogDeleteAlarm(
            dialogTitle = R.string.alarm_deletion_title,
            dialogText = R.string.alarm_deletion_text,
            deleteText = R.string.alarm_deletion_delete,
            cancelText = R.string.alarm_deletion_cancel,
        )
    }
}