INSERT INTO chad.pilgrims(user_id, pilgrim_uuid, name, username, password)
VALUES (
        nextval('chad.pilgrims_user_id_seq'),
        :pilgrimId,
        :name,
        :username,
        :password
       )
RETURNING *;