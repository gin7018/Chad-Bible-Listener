UPDATE chad.playlists
SET chapters_in_playlist = chapters_in_playlist || '[":chapterId"]'::JSONB
WHERE playlist_uuid = :playlistId;