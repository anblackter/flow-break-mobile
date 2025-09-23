package co.edu.uniandes.miso.ux.flowbreak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.uniandes.miso.ux.flowbreak.ui.components.LoginButton
import co.edu.uniandes.miso.ux.flowbreak.ui.components.LoginLogo
import co.edu.uniandes.miso.ux.flowbreak.ui.theme.FB_Light_Primary40
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

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun LoginDisplayPreview() {
    FlowBreakMobileTheme {
        LoginDisplay()
    }
}