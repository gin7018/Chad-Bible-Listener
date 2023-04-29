INSERT INTO chad.playlists(
                           playlist_id,
                           playlist_uuid,
                           playlist_owner,
                           chapters_in_playlist,
                           playlist_name
                           )
VALUES (
        nextval('chad.playlists_playlist_id_seq'),
        :playlistId,
        (SELECT pilgrim_uuid FROM chad.pilgrims WHERE username = :username),
        '{"chapters": []}'::JSONB,
        :playlistName
       )
RETURNING *;
