package com.rakibcse99.profileviewapps.utils

fun join(vararg input: String?, delimiter: String = ", "): String {
    return input
        .filter { it.isNullOrEmpty().not() }
        .joinToString(delimiter) { it!! }
}
