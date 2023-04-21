package com.org.chad.repo

import com.org.chad.model.Chapter

interface ChapterDao {

    fun fetchChapterFile(bookName: String, chapterNumber: Int): Chapter?
}