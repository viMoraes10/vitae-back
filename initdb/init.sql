DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'vagasback') THEN
        CREATE DATABASE vagasback;
    END IF;
END
$$;
