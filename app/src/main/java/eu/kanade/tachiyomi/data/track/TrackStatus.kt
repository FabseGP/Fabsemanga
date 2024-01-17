package eu.kanade.tachiyomi.data.track

import dev.icerock.moko.resources.StringResource
import eu.kanade.tachiyomi.data.track.anilist.Anilist
import eu.kanade.tachiyomi.data.track.kitsu.Kitsu
import eu.kanade.tachiyomi.data.track.komga.Komga
import eu.kanade.tachiyomi.data.track.myanimelist.MyAnimeList
import exh.md.utils.FollowStatus
import tachiyomi.i18n.MR
import tachiyomi.i18n.sy.SYMR

enum class TrackStatus(val int: Int, val res: StringResource) {
    READING(1, MR.strings.reading),
    REPEATING(2, MR.strings.repeating),
    PLAN_TO_READ(3, MR.strings.plan_to_read),
    PAUSED(4, MR.strings.on_hold),
    COMPLETED(5, MR.strings.completed),
    DROPPED(6, MR.strings.dropped),
    OTHER(7, SYMR.strings.not_tracked),
    ;

    companion object {
        fun parseTrackerStatus(trackerManager: TrackerManager, tracker: Long, statusLong: Long): TrackStatus? {
            val status = statusLong.toInt()
            return when (tracker) {
                trackerManager.mdList.id -> {
                    when (FollowStatus.fromInt(status)) {
                        FollowStatus.UNFOLLOWED -> null
                        FollowStatus.READING -> READING
                        FollowStatus.COMPLETED -> COMPLETED
                        FollowStatus.ON_HOLD -> PAUSED
                        FollowStatus.PLAN_TO_READ -> PLAN_TO_READ
                        FollowStatus.DROPPED -> DROPPED
                        FollowStatus.RE_READING -> REPEATING
                    }
                }
                trackerManager.myAnimeList.id -> {
                    when (status) {
                        MyAnimeList.READING -> READING
                        MyAnimeList.COMPLETED -> COMPLETED
                        MyAnimeList.ON_HOLD -> PAUSED
                        MyAnimeList.PLAN_TO_READ -> PLAN_TO_READ
                        MyAnimeList.DROPPED -> DROPPED
                        MyAnimeList.REREADING -> REPEATING
                        else -> null
                    }
                }
                trackerManager.aniList.id -> {
                    when (status) {
                        Anilist.READING -> READING
                        Anilist.COMPLETED -> COMPLETED
                        Anilist.ON_HOLD -> PAUSED
                        Anilist.PLAN_TO_READ -> PLAN_TO_READ
                        Anilist.DROPPED -> DROPPED
                        Anilist.REREADING -> REPEATING
                        else -> null
                    }
                }
                trackerManager.kitsu.id -> {
                    when (status) {
                        Kitsu.READING -> READING
                        Kitsu.COMPLETED -> COMPLETED
                        Kitsu.ON_HOLD -> PAUSED
                        Kitsu.PLAN_TO_READ -> PLAN_TO_READ
                        Kitsu.DROPPED -> DROPPED
                        else -> null
                    }
                }
                trackerManager.komga.id -> {
                    when (status) {
                        Komga.READING -> READING
                        Komga.COMPLETED -> COMPLETED
                        Komga.UNREAD -> null
                        else -> null
                    }
                }
                else -> null
            }
        }
    }
}
