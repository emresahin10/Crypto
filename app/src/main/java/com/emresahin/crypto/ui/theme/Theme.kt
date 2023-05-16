package com.emresahin.crypto.ui.theme


import android.app.Activity
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


@Immutable
data class CryptoColors(
    val primary: Color,
    val container: Color,
    val progress: Color,
    val success: Color,
    val error: Color,
    val info: Color,
    val textPrimary: Color,
    val textGrey: Color,
    val backgroundGrey: Color,
)

val LocalCryptoColors = staticCompositionLocalOf {
    CryptoColors(
        primary = Color.Unspecified,
        container = Color.Unspecified,
        progress = Color.Unspecified,
        success = Color.Unspecified,
        error = Color.Unspecified,
        info = Color.Unspecified,
        textPrimary = Color.Unspecified,
        textGrey = Color.Unspecified,
        backgroundGrey = Color.Unspecified
    )
}

val LightCryptoColors = CryptoColors(
    primary = blue,
    container = white,
    progress = orangePrimary,
    success = green,
    error = orangeSecondary,
    info = yellow,
    textPrimary = black,
    textGrey = grey,
    backgroundGrey = greyMid
)

val DarkCryptoColors = CryptoColors(
    primary = blue,
    container = white,
    progress = orangePrimary,
    success = green,
    error = orangeSecondary,
    info = yellow,
    textPrimary = black,
    textGrey = grey,
    backgroundGrey = greyMid
)

private val LightMaterialColorScheme = lightColorScheme(
    primary = blue,
    secondary = orangeSecondary,
    tertiary = yellow,
)

private val DarkMaterialColorScheme = darkColorScheme(
    primary = blue,
    secondary = orangeSecondary,
    tertiary = yellow
)


@Composable
fun CryptoTheme(
    isDarkThemeEnabled: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) = CryptoTheme(
    darkTheme = isDarkThemeEnabled,
    disableDynamicColor = true,
    content = content
)

@Composable
internal fun CryptoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    disableDynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val materialColorScheme = when {
        !disableDynamicColor && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            dynamicLightColorScheme(context)
        }

        darkTheme -> DarkMaterialColorScheme
        else -> LightMaterialColorScheme
    }

    val cryptoColorScheme = when {
        darkTheme -> DarkCryptoColors
        else -> LightCryptoColors
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = materialColorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(LocalCryptoColors provides cryptoColorScheme) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            shapes = Shapes,
            content = content
        )
    }
}

object CryptoTheme {
    val colors: CryptoColors
        @Composable
        get() = LocalCryptoColors.current
}


@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
private fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
