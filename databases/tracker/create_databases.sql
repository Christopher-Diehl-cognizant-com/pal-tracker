/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  780449
 * Created: Mar 15, 2020
 */

DROP DATABASE IF EXISTS tracker_dev;
DROP DATABASE IF EXISTS tracker_test;

CREATE DATABASE tracker_dev;
CREATE DATABASE tracker_test;

CREATE USER IF NOT EXISTS 'tracker'@'%'
  IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON tracker_dev.* TO 'tracker' @'%';
GRANT ALL PRIVILEGES ON tracker_test.* TO 'tracker' @'%';
