package com.org.chad.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Pilgrim (
    @JsonProperty("pilgrim_uuid") val pilgrimId: UUID,
    @JsonProperty("name") val name: String,
    @JsonProperty("username") val username: String,
    @JsonProperty("password") val password: String
)