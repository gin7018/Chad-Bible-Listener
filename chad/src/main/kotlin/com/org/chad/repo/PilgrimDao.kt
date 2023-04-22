package com.org.chad.repo

import com.org.chad.model.PilgrimMapper
import com.org.chad.model.Pilgrim
import org.jdbi.v3.sqlobject.config.RegisterRowMapper
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.*

@UseClasspathSqlLocator
@RegisterRowMapper(PilgrimMapper::class)
interface PilgrimDao {

    @SqlQuery
    fun getPilgrim(pilgrimId: UUID): Pilgrim?

    @SqlUpdate
    fun register(pilgrimId: UUID, name: String, username: String, password: String)

    @SqlQuery
    fun login(username: String, password: String): Pilgrim?
}