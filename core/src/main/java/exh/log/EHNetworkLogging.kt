package exh.log

import com.elvishew.xlog.XLog
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun OkHttpClient.Builder.maybeInjectEHLogger(): OkHttpClient.Builder {
    return this
}
