package com.org.chad.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Chapter (
    @JsonProperty("bookName") val bookName: String,
    @JsonProperty("chapterNumber") val chapterNumber: Int,
    @JsonProperty("file") val file: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Chapter

        if (bookName != other.bookName) return false
        if (chapterNumber != other.chapterNumber) return false
        return file.contentEquals(other.file)
    }

    override fun hashCode(): Int {
        var result = bookName.hashCode()
        result = 31 * result + chapterNumber
        result = 31 * result + file.contentHashCode()
        return result
    }
}