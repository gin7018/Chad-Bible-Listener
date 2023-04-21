package com.org.chad.module

import com.org.chad.repo.JdbiPlaylistRepository
import com.org.chad.repo.PilgrimDao
import com.org.chad.repo.PlaylistDao
import com.org.chad.repo.PlaylistRepository
import mu.KotlinLogging
import org.jdbi.v3.core.Jdbi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JdbiModule {
    private val LOG = KotlinLogging.logger {  }

    @Bean
    fun connection(): Jdbi {
        val dbName = System.getenv("RDS_DB_NAME")
        val userName = System.getenv("RDS_USERNAME")
        val password = System.getenv("RDS_PASSWORD")
        val hostname = System.getenv("RDS_HOSTNAME")
        val port = System.getenv("RDS_PORT")
        val jdbiUrl = "jdbc:postgresql://$hostname:$port/$dbName?user=$userName&password=$password"
        val con = Jdbi.create(jdbiUrl)
        LOG.info("Remote connection successful.")
        return con
    }

    @Bean
    fun pilgrimDao(jdbi: Jdbi): PilgrimDao =
        jdbi.onDemand(PilgrimDao::class.java)

    @Bean
    fun playlistDao(jdbi: Jdbi): PlaylistDao =
        jdbi.onDemand(PlaylistDao::class.java)

    @Bean
    fun playlistRepository(playlistDao: PlaylistDao): PlaylistRepository =
        JdbiPlaylistRepository(playlistDao)
}