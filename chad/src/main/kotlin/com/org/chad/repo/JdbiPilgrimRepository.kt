package com.org.chad.repo

import com.org.chad.model.Pilgrim
import org.springframework.stereotype.Component
import java.util.*

@Component
class JdbiPilgrimRepository (
    private val dao: PilgrimDao
        ): PilgrimRepository {

    override fun register(name: String, username: String, password: String): Pilgrim? {
        val id = UUID.randomUUID()
        dao.register(id, name, username, password)
        return pilgrim(id)
    }

    override fun login(username: String, password: String): Pilgrim? {
        return dao.login(username, password)
    }

    private fun pilgrim(pilgrimId: UUID): Pilgrim? =
        dao.getPilgrim(pilgrimId)
}