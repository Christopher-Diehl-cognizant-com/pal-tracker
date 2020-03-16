/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  780449
 * Created: Mar 15, 2020
 */

CREATE TABLE time_entries (
  id         BIGINT NOT NULL AUTO_INCREMENT,
  project_id BIGINT,
  user_id    BIGINT,
  date       DATE,
  hours      INT,

  PRIMARY KEY (id)
)
  ENGINE = innodb
  DEFAULT CHARSET = UTF8MB4;