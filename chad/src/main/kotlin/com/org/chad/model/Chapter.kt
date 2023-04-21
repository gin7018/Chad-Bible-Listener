package com.org.chad.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Chapter (
    @JsonProperty("bookName") val bookName: String,
    @JsonProperty("chapterNumber") val chapterNumber: Int,
    @JsonProperty("file") val file: ByteArray
)