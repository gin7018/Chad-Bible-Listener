package com.org.chad.repo

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.S3ObjectId
import com.org.chad.model.Chapter
import org.springframework.stereotype.Component

@Component
class ChapterRepository(
    private val s3Client: AmazonS3
): ChapterDao {
    private val BUCKET_NAME = "audio-bible-files"

    override fun fetchChapterFile(bookName: String, chapterNumber: Int): Chapter? {
        val result = s3Client.getObject(
            GetObjectRequest (
                S3ObjectId (BUCKET_NAME, "$bookName/$chapterNumber.mp3")
            )
        )
        return Chapter(
            chapterNumber = chapterNumber,
            bookName = bookName,
            file = result.objectContent.readAllBytes()
        )
    }
}