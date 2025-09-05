ALTER TABLE usuario
    ADD COLUMN firebase_uid VARCHAR(255),
    ADD COLUMN foto_perfil_url VARCHAR(255),
    ADD COLUMN data_cadastro DATE,
    ADD COLUMN ultimo_login TIMESTAMP,
    ADD COLUMN role VARCHAR(50),
    ADD COLUMN ativo BOOLEAN DEFAULT TRUE;