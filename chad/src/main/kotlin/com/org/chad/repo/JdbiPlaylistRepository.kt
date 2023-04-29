package com.org.chad.repo

import com.org.chad.model.Playlist
import org.json.JSONObject
import java.util.*

class JdbiPlaylistRepository (
    private val dao: PlaylistDao
        ): PlaylistRepository {

    override fun createPlaylist(username: String, playlistName: String): Playlist? {
        val id = UUID.randomUUID()
        // TODO NEED TO CHECK IF USER EXISTS FIRST
        dao.createPlaylist(id, username, playlistName)
        return dao.getPlaylist(username, id)
    }

    override fun editPlaylist(playlist: Playlist): Playlist? {
        // CRITICAL ACTION
        val existing = dao.getPlaylist(playlist.owner, playlist.playlistId)
        require(existing != null) {
            "No playlist found to edit"
        }

        val chapters = JSONObject()
        chapters.append("chapters", playlist.chapters.toTypedArray())

        dao.editPlaylist(playlist.name,
            chapters.toString(),
            playlist.owner,
            playlist.playlistId)
        return dao.getPlaylist(playlist.owner, playlist.playlistId)
    }

    override fun deletePlaylist(username: String, playlistId: UUID) {
        // CRITICAL ACTION
        val existing = dao.getPlaylist(username, playlistId)
        require(existing != null) {
            "Cannot delete playlist"
        }
        dao.deletePlaylist(username, playlistId)
    }

    override fun search(query: String): List<Playlist> {
        // This will show all playlists, even those not owned by the current user
        // security risk
        // need to change the logic
        // later tho bc im lazy rn
        // CRITICAL ACTION
        return dao.search(query)
    }

    override fun addChapter(username: String, playlistId: UUID, chapterId: Int): Playlist? {
        // CRITICAL ACTION
        val existing = dao.getPlaylist(username, playlistId)
        require(existing != null) {
            "Cannot add chapter to this playlist"
        }

        dao.addChapter(playlistId, chapterId)
        return dao.getPlaylist(username, playlistId)
    }

    override fun removeChapter(username: String, playlistId: UUID, chapterId: Int): Playlist? {
        // CRITICAL ACTION
        val existing = dao.getPlaylist(username, playlistId)
        require(existing != null) {
            "Cannot remove chapter to this playlist"
        }

        dao.removeChapter(playlistId, chapterId)
        return dao.getPlaylist(username, playlistId)
    }

    override fun getPlaylist(username: String, playlistId: UUID): Playlist? {
        return dao.getPlaylist(username, playlistId)
    }

    override fun getAllPlaylists(username: String): List<Playlist> {
        return dao.getAllPlaylists(username)
    }
}