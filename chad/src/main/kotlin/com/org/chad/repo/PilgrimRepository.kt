package com.org.chad.repo

import com.org.chad.model.Pilgrim

interface PilgrimRepository {
    fun register(name: String, username: String, password: String): Pilgrim?

    fun login(username: String, password: String): Pilgrim?
}