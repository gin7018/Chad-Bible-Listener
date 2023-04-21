package com.org.chad.resource

import com.org.chad.model.Chapter
import com.org.chad.repo.ChapterDao
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chapter")
class ChapterResource (
    private val chapterDao: ChapterDao
    ){
    private val logger = KotlinLogging.logger {  }

    @GetMapping("/file/")
    fun GetChapterFile(@RequestParam bookName: String, @RequestParam chapterNumber: Int):
    ResponseEntity<Chapter> {
        logger.info("GET chapter/file/$bookName/$chapterNumber")
        val ch = chapterDao.fetchChapterFile(bookName, chapterNumber)
            ?: return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        return ResponseEntity(ch, HttpStatus.FOUND)
    }
}