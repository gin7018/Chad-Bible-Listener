package com.org.chad.repo

import com.org.chad.model.Playlist
import com.org.chad.model.PlaylistMapper
import org.jdbi.v3.sqlobject.config.RegisterRowMapper
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.*

@UseClasspathSqlLocator
@RegisterRowMapper(PlaylistMapper::class)
interface PlaylistDao {

    @SqlUpdate
    fun createPlaylist(playlistId: UUID, username: String, playlistName: String)

    @SqlUpdate
    fun editPlaylist(playlistName: String, chapters: String, owner: String, playlistId: UUID)

    @SqlUpdate
    fun deletePlaylist(username: String, playlistId: UUID)

    @SqlQuery
    fun search(query: String): List<Playlist>

    @SqlUpdate
    fun addChapter(playlistId: UUID, chapterId: Int)

    @SqlUpdate
    fun removeChapter(playlistId: UUID, chapterId: Int)

    @SqlQuery
    fun getPlaylist(owner: String, playlistId: UUID): Playlist?

    @SqlQuery
    fun getAllPlaylists(username: String): List<Playlist>
}