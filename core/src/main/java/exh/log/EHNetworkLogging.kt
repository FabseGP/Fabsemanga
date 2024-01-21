package exh.log

import okhttp3.OkHttpClient

fun OkHttpClient.Builder.maybeInjectEHLogger(): OkHttpClient.Builder {
    return this
}
