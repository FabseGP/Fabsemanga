package eu.kanade.tachiyomi.network

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.dnsoverhttps.DnsOverHttps
import java.net.InetAddress

const val PREF_DOH_ADGUARD = 1
const val PREF_DOH_LIBREDNS = 2
const val PREF_DOH_MULLVAD = 3
const val PREF_DOH_QUAD9 = 4

// AdGuard "Default" DNS works too but for the sake of making sure no site is blacklisted,
// we use "Unfiltered"
fun OkHttpClient.Builder.dohAdGuard() = dns(
    DnsOverHttps.Builder().client(build())
        .url("https://dns-unfiltered.adguard.com/dns-query".toHttpUrl())
        .bootstrapDnsHosts(
            InetAddress.getByName("94.140.14.140"),
            InetAddress.getByName("94.140.14.141"),
            InetAddress.getByName("2a10:50c0::1:ff"),
            InetAddress.getByName("2a10:50c0::2:ff"),
        )
        .build(),
)

/**
 * Source: https://libredns.gr/
 */
fun OkHttpClient.Builder.dohLibreDNS() = dns(
    DnsOverHttps.Builder().client(build())
        .url("https://doh.libredns.gr/dns-query".toHttpUrl())
        .bootstrapDnsHosts(
            InetAddress.getByName("116.202.176.26"),
            InetAddress.getByName("2a01:4f8:1c0c:8274::1"),
        )
        .build(),
)

/*
 * Mullvad DoH
 * without ad blocking option
 * Source: https://mullvad.net/en/help/dns-over-https-and-dns-over-tls
 */
fun OkHttpClient.Builder.dohMullvad() = dns(
    DnsOverHttps.Builder().client(build())
        .url(" https://dns.mullvad.net/dns-query".toHttpUrl())
        .bootstrapDnsHosts(
            InetAddress.getByName("194.242.2.2"),
            InetAddress.getByName("2a07:e340::2"),
        )
        .build(),
)

fun OkHttpClient.Builder.dohQuad9() = dns(
    DnsOverHttps.Builder().client(build())
        .url("https://dns.quad9.net/dns-query".toHttpUrl())
        .bootstrapDnsHosts(
            InetAddress.getByName("9.9.9.9"),
            InetAddress.getByName("149.112.112.112"),
            InetAddress.getByName("2620:fe::fe"),
            InetAddress.getByName("2620:fe::9"),
        )
        .build(),
)
