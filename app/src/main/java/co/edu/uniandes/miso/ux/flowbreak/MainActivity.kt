package co.edu.uniandes.miso.ux.flowbreak

import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary100
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary20
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary80
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Secondary40
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Secondary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Tertiary30
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Tertiary95
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FlowBreakMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowBreakMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Flow Break",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.displayLarge,
        color = FB_Light_Primary80,
        modifier = modifier.background(MaterialTheme.colorScheme.onErrorContainer)
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    FlowBreakMobileTheme {
//        Greeting("Flow Break")
//    }
//}

@Composable
fun LoginButton(
    @DrawableRes icon: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    ElevatedButton(
        modifier = modifier
            .width(197.dp)
            .height(96.dp),
        onClick = {},
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
        ){
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
    Column (
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
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(80.dp)
            .background(color)
    ){
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .width(236.dp)
                .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
        ){
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
        ){
            Row(
                modifier = modifier
                    .padding(start = 13.dp, end = 13.dp)
            ){
                FilledIconButton(
                    onClick = {},
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
                    onClick = {},
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
    modifier: Modifier = Modifier
){
    FloatingActionButton(
        onClick = {},
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
    modifier: Modifier = Modifier
){
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
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .width(140.dp)
                .height(64.dp)
        ){
            IconButton(
                onClick = {},
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
                enabled = false
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_monitoring),
                    contentDescription = null,
                    modifier = modifier
                        .size(21.dp)
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
        onValueChange = {  },
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
fun ListItemAlarmPreview(){
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
fun AddAlarmButtonPreview(){
    FlowBreakMobileTheme {
        AddAlarmButton()
    }
}

@Preview(showBackground = true)
@Composable
fun MainToolBarPreview(){
    FlowBreakMobileTheme {
        MainToolBar()
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldAlarmPreview(){
    FlowBreakMobileTheme {
        TextFieldAlarm(
            name = R.string.alarm_creation_text_field_name,
            placeholder = R.string.alarm_creation_text_field_placeholder
        )
    }
}

