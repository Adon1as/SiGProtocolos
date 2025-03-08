CREATE SEQUENCE IF NOT EXISTS protocolo_numero_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE protocolo
(
    numero   BIGINT                      NOT NULL,
    criacao  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    natureza SMALLINT                    NOT NULL,
    CONSTRAINT pk_protocolo PRIMARY KEY (numero)
);