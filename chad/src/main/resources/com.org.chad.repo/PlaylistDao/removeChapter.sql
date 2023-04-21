UPDATE chad.playlists
SET chapters_in_playlist = chapters_in_playlist - :chapterId
WHERE playlist_uuid = :playlistId;