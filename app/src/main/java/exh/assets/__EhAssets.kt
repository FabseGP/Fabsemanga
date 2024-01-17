package exh.assets

import androidx.compose.ui.graphics.vector.ImageVector
import exh.assets.ehassets.AllAssets
import exh.assets.ehassets.Exh
import exh.assets.ehassets.MangadexLogo
import kotlin.collections.List as ____KtList

public object EhAssets

private var __AllAssets: ____KtList<ImageVector>? = null

public val EhAssets.AllAssets: ____KtList<ImageVector>
    get() {
        if (__AllAssets != null) {
            return __AllAssets!!
        }
        __AllAssets = Exh.AllAssets + listOf(MangadexLogo)
        return __AllAssets!!
    }
