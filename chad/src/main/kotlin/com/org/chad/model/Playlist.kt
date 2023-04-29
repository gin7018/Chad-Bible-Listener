package com.org.chad.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import org.json.JSONObject
import java.sql.ResultSet
import java.util.*

class Playlist (
    @JsonProperty("playlist_uuid") val playlistId: UUID,
    @JsonProperty("name") val name: String,
    @JsonProperty("owner") val owner: String,
    @JsonProperty("chapters") val chapters: List<String>
    )

class PlaylistMapper(): RowMapper<Playlist> {
    override fun map(rs: ResultSet?, ctx: StatementContext?): Playlist {
        val chs = JSONObject(JSONObject(rs?.getObject("chapters_in_playlist"))
            .getString("value")).getJSONArray("chapters")
        val chapters = chs.map { c -> c.toString() }.toList()

        return Playlist(
            UUID.fromString(rs?.getString("playlist_uuid")),
            rs?.getString("playlist_name")?: "",
            rs?.getString("playlist_owner")?: "",
            chapters)
    }

}