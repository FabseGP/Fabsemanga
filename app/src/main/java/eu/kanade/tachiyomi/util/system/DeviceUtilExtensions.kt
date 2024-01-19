package eu.kanade.tachiyomi.util.system

import android.os.Build
import com.google.android.material.color.DynamicColors

val DeviceUtil.isDynamicColorAvailable by lazy {
    DynamicColors.isDynamicColorAvailable()
}
