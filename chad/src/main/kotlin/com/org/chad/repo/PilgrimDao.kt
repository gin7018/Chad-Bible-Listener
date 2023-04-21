package com.org.chad.repo

import com.org.chad.model.Pilgrim
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.*

interface PilgrimDao {

    @SqlUpdate
    @UseClasspathSqlLocator
    fun register(pilgrimId: UUID, name: String, username: String, password: String): Pilgrim?

    @SqlQuery
    @UseClasspathSqlLocator
    fun login(username: String, password: String): Pilgrim?
}