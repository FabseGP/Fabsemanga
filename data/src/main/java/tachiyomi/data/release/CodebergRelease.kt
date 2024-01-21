package tachiyomi.data.release

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import tachiyomi.domain.release.model.Release

/**
 * Contains information about the latest release from GitHub.
 */
@Serializable
data class CodebergRelease(
    @SerialName("tag_name") val version: String,
    @SerialName("body") val info: String,
    @SerialName("html_url") val releaseLink: String,
    @SerialName("assets") val assets: List<CodebergAssets>,
)

/**
 * Assets class containing download url.
 */
@Serializable
data class CodebergAssets(@SerialName("browser_download_url") val downloadLink: String)

val releaseMapper: (CodebergRelease) -> Release = {
    Release(
        it.version,
        it.info,
        it.releaseLink,
        it.assets.map(CodebergAssets::downloadLink),
    )
}
