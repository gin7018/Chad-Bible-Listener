SELECT pilgrim_uuid,
        name,
        username,
        password
FROM chad.pilgrims
WHERE pilgrim_uuid = :pilgrimId;