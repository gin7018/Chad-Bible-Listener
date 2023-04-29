UPDATE chad.playlists
SET playlist_name = :playlistName,
    chapters_in_playlist = :chapters::JSONB
WHERE playlist_owner = :owner
  AND playlist_uuid = :playlistId
RETURNING *;
