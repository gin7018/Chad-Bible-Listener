package com.org.chad.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class Playlist (
    @JsonProperty("playlist_uuid") val playlistId: UUID,
    @JsonProperty("name") val name: String,
    @JsonProperty("owner") val owner: String,
    @JsonProperty("chapters") val chapters: List<Chapter>
    )