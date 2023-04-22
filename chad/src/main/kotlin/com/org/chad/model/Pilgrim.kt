package com.org.chad.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet
import java.util.*

data class Pilgrim (
    @JsonProperty("pilgrim_uuid") val pilgrimId: UUID,
    @JsonProperty("name") val name: String,
    @JsonProperty("username") val username: String,
    @JsonProperty("password") val password: String
)

class PilgrimMapper(): RowMapper<Pilgrim> {
    override fun map(rs: ResultSet?, ctx: StatementContext?): Pilgrim {
        return Pilgrim(
            UUID.fromString(rs?.getString("pilgrim_uuid")),
            rs?.getString("name")?: "",
            rs?.getString("username")?: "",
            rs?.getString("password")?: "")
    }

}