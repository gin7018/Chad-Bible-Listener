package com.org.chad.repo

import com.org.chad.model.Playlist
import org.json.JSONObject
import java.util.*

class JdbiPlaylistRepository (
    private val dao: PlaylistDao
        ): PlaylistRepository {

    override fun createPlaylist(username: String, playlistName: String): Playlist? {
        val id = UUID.randomUUID()
        return dao.createPlaylist(id, username, playlistName)
    }

    override fun editPlaylist(playlist: Playlist): Playlist {
        val chapters = JSONObject()
        chapters.append("chapters", playlist.chapters.toTypedArray())

        return dao.editPlaylist(playlist.name,
            chapters.toString(),
            playlist.owner,
            playlist.playlistId)
    }

    override fun deletePlaylist(playlistId: UUID) {
        return dao.deletePlaylist(playlistId)
    }

    override fun search(query: String): List<Playlist> {
        return dao.search(query)
    }

    override fun addChapter(playlistId: UUID, chapterId: Int): Playlist {
        return dao.addChapter(playlistId, chapterId)
    }

    override fun removeChapter(playlistId: UUID, chapterId: Int): Playlist {
        return dao.removeChapter(playlistId, chapterId)
    }

    override fun getPlaylist(username: String, playlistId: UUID): Playlist? {
        return dao.getPlaylist(username, playlistId)
    }

    override fun getAllPlaylists(username: String): List<Playlist> {
        return dao.getAllPlaylists(username)
    }
}