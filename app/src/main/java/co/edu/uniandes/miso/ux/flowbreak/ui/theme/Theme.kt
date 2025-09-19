package co.edu.uniandes.miso.ux.flowbreak.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = fb_theme_light_primary,
    onPrimary = fb_theme_light_onPrimary,
    primaryContainer = fb_theme_light_primaryContainer,
    onPrimaryContainer = fb_theme_light_onPrimaryContainer,
    secondary = fb_theme_light_secondary,
    onSecondary = fb_theme_light_onSecondary,
    secondaryContainer = fb_theme_light_secondaryContainer,
    onSecondaryContainer = fb_theme_light_onSecondaryContainer,
    tertiary = fb_theme_light_tertiary,
    onTertiary = fb_theme_light_onTertiary,
    tertiaryContainer = fb_theme_light_tertiaryContainer,
    onTertiaryContainer = fb_theme_light_onTertiaryContainer

)

@Composable
fun FlowBreakMobileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
            LightColorScheme // TODO: Dark theme not supported yet
        } else {
            LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}