package com.org.chad.repo

import com.org.chad.model.Playlist
import java.util.*

interface PlaylistRepository {
    fun createPlaylist(username: String, playlistName: String): Playlist?

    fun editPlaylist(playlist: Playlist): Playlist

    fun deletePlaylist(playlistId: UUID)

    fun search(query: String): List<Playlist>

    fun addChapter(playlistId: UUID, chapterId: Int): Playlist

    fun removeChapter(playlistId: UUID, chapterId: Int): Playlist

    fun getPlaylist(username: String, playlistId: UUID): Playlist?

    fun getAllPlaylists(username: String): List<Playlist>
}