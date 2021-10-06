
CREATE TABLE IF NOT EXISTS routes (
  id BIGINT NOT NULL,
  time TIME NOT NULL,
  PRIMARY KEY (id));
GO
  CREATE TABLE IF NOT EXISTS tracks (
  id BIGINT NOT NULL,
  type int NULL,
  routes_id BIGINT NOT NULL,
  INDEX fk_tracks_routes1_idx (routes_id ASC),
  CONSTRAINT fk_tracks_routes1
    FOREIGN KEY (routes_id)
    REFERENCES routes (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  PRIMARY KEY (id));
GO
CREATE TABLE IF NOT EXISTS stations (
  id BIGINT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
GO
CREATE TABLE IF NOT EXISTS routes_stations (
  stations_id BIGINT NOT NULL,
  routes_id BIGINT NOT NULL,
  sequence BIGINT NOT NULL,
  time TIME NOT NULL,
  INDEX stantions_fk_idx (stations_id ASC),
  INDEX routes_fk_idx (routes_id ASC),
  PRIMARY KEY (stations_id, routes_id),
  CONSTRAINT stantions_fk
    FOREIGN KEY (stations_id)
    REFERENCES stations (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT routes_fk
    FOREIGN KEY (routes_id)
    REFERENCES routes (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
