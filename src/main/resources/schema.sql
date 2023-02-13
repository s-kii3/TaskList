CREATE TABLE IF NOT EXISTS task_item
(
   id VARCHAR(8) PRIMARY KEY,
   task VARCHAR(256),
   deadLine DATE,
   done BOOLEAN,
   created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);