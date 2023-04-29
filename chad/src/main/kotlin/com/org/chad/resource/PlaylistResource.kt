package com.org.chad.resource

import com.org.chad.model.Playlist
import com.org.chad.repo.PlaylistRepository
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("playlist")
class PlaylistResource(
    private val playlistRepository: PlaylistRepository
) {
    private val LOG = KotlinLogging.logger {  }

    @PutMapping("/create/")
    fun createPlaylist(@RequestParam username: String, @RequestParam name: String): ResponseEntity<Playlist> {
        LOG.info("PUT playlist/create/ $name for $username")
        val ch = playlistRepository.createPlaylist(username, name) ?: return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        return ResponseEntity(ch, HttpStatus.CREATED)
    }

    @PostMapping("/edit/")
    fun updatePlaylist(@RequestBody playlist: Playlist): ResponseEntity<Playlist> {
        LOG.info("POST playlist/edit/ ${playlist.name}")
        val ch = playlistRepository.editPlaylist(playlist)
        return ResponseEntity(ch, HttpStatus.ACCEPTED)
    }

    @PostMapping("/delete/")
    fun deletePlaylist(@RequestParam username: String, @RequestParam playlistId: UUID): ResponseEntity<Boolean> {
        LOG.info("POST playlist/delete/ $playlistId for $username")
        playlistRepository.deletePlaylist(username, playlistId)
        return ResponseEntity(true, HttpStatus.ACCEPTED)
    }

    @PutMapping("/chapter/add/")
    fun addChapter(@RequestParam username: String, @RequestParam playlistId: UUID, @RequestParam chapterId: Int): ResponseEntity<Playlist> {
        LOG.info("PUT playlist/chapter/add/ $chapterId")
        val ch = playlistRepository.addChapter(username, playlistId, chapterId)
        return ResponseEntity(ch, HttpStatus.ACCEPTED)
    }

    @PutMapping("/chapter/remove/")
    fun removeChapter(@RequestParam username: String, @RequestParam playlistId: UUID, @RequestParam chapterId: Int): ResponseEntity<Playlist> {
        LOG.info("PUT playlist/chapter/remove/ $chapterId")
        val ch = playlistRepository.removeChapter(username, playlistId, chapterId)
        return ResponseEntity(ch, HttpStatus.ACCEPTED)
    }

    @GetMapping("/")
    fun getPlaylist(@RequestParam username: String, @RequestParam playlistId: UUID): ResponseEntity<Playlist> {
        LOG.info("GET playlist/ $playlistId")
        val ch = playlistRepository.getPlaylist(username, playlistId)?: return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        return ResponseEntity(ch, HttpStatus.FOUND)
    }

    @GetMapping("/all/")
    fun getAllPlaylists(@RequestParam username: String): ResponseEntity<List<Playlist>> {
        LOG.info("GET playlist/all/ $username")
        val ch = playlistRepository.getAllPlaylists(username)
        return ResponseEntity(ch, HttpStatus.FOUND)
    }

    @GetMapping("/search/")
    fun searchPlaylists(@RequestParam query: String): ResponseEntity<List<Playlist>> {
        LOG.info("GET playlist/search/ $query")
        val ch = playlistRepository.search(query)
        return ResponseEntity(ch, HttpStatus.FOUND)
    }
}