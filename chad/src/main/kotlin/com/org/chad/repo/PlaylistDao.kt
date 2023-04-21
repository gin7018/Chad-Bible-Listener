package com.org.chad.repo

import com.org.chad.model.Playlist
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.*

interface PlaylistDao {

    @SqlUpdate
    @UseClasspathSqlLocator
    fun createPlaylist(playlistId: UUID, username: String, playlistName: String): Playlist?

    @SqlUpdate
    @UseClasspathSqlLocator
    fun editPlaylist(playlistName: String, chapters: String, owner: String, playlistId: UUID): Playlist

    @SqlUpdate
    @UseClasspathSqlLocator
    fun deletePlaylist(playlistId: UUID)

    @SqlQuery
    @UseClasspathSqlLocator
    fun search(query: String): List<Playlist>

    @SqlUpdate
    @UseClasspathSqlLocator
    fun addChapter(playlistId: UUID, chapterId: Int): Playlist

    @SqlUpdate
    @UseClasspathSqlLocator
    fun removeChapter(playlistId: UUID, chapterId: Int): Playlist

    @SqlQuery
    @UseClasspathSqlLocator
    fun getPlaylist(username: String, playlistId: UUID): Playlist?

    @SqlQuery
    @UseClasspathSqlLocator
    fun getAllPlaylists(username: String): List<Playlist>
}