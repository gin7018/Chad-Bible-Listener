package com.org.chad.repo

import com.org.chad.model.Playlist
import java.util.*

interface PlaylistRepository {
    fun createPlaylist(username: String, playlistName: String): Playlist?

    fun editPlaylist(playlist: Playlist): Playlist?

    fun deletePlaylist(username: String, playlistId: UUID)

    fun search(query: String): List<Playlist>

    fun addChapter(username: String, playlistId: UUID, chapterId: Int): Playlist?

    fun removeChapter(username: String, playlistId: UUID, chapterId: Int): Playlist?

    fun getPlaylist(username: String, playlistId: UUID): Playlist?

    fun getAllPlaylists(username: String): List<Playlist>
}