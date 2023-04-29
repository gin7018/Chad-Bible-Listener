DELETE FROM chad.playlists
WHERE playlist_uuid = :playlistId
  AND playlist_owner = (SELECT pilgrim_uuid
                        FROM chad.pilgrims
                        WHERE username = :owner);