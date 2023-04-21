SELECT (playlist_uuid, playlist_owner, chapters_in_playlist, playlist_name)
FROM chad.playlists
WHERE playlist_owner = (SELECT pilgrim_uuid
                        FROM chad.pilgrims
                        WHERE username = :owner)
  AND playlist_uuid = :playlistId;