## 数据库结构

#### 数据库概览

    mine    数据库
    |—— enterprise      企业
    |—— user            用户
    |—— role            角色
    |—— entity_role     实体—角色关系
    |—— permission      权限
    |—— role_permission 角色—权限关系
    |—— project         矿区工程
    |—— device          设备
    |—— material        物料
    |—— prjlog          工程日志
    |—— report          生产报告

#### 表结构概览
##### enterprise

    -- auto-generated definition
    CREATE TABLE enterprise
    (
      id        INT AUTO_INCREMENT
        PRIMARY KEY,
      email     VARCHAR(40) NOT NULL,
      password  VARCHAR(32) NOT NULL,
      pass_salt VARCHAR(6)  NOT NULL,
      fullname  VARCHAR(40) NOT NULL,
      USCI      VARCHAR(18) NULL,
      BSLIC     VARCHAR(15) NULL,
      CONSTRAINT enterprise_email_uindex
      UNIQUE (email),
      CONSTRAINT enterprise_fullname_uindex
      UNIQUE (fullname),
      CONSTRAINT enterprise_USCI_uindex
      UNIQUE (USCI),
      CONSTRAINT enterprise_BSLIC_uindex
      UNIQUE (BSLIC)
    )
      ENGINE = InnoDB;
    
##### user
    -- auto-generated definition
    CREATE TABLE user
    (
      id            INT AUTO_INCREMENT
        PRIMARY KEY,
      username      VARCHAR(40) NOT NULL,
      password      VARCHAR(32) NOT NULL,
      pass_salt     VARCHAR(6)  NOT NULL,
      email         VARCHAR(40) NOT NULL,
      enterprise_id INT         NOT NULL,
      CONSTRAINT user_username_uindex
      UNIQUE (username),
      CONSTRAINT user_email_uindex
      UNIQUE (email)
    )
      ENGINE = InnoDB;
    
##### role
    -- auto-generated definition
    CREATE TABLE role
    (
      id   INT NOT NULL
        PRIMARY KEY,
      name INT NOT NULL,
      CONSTRAINT role_name_uindex
      UNIQUE (name)
    )
      ENGINE = InnoDB;
    
##### entity_role
    -- auto-generated definition
    CREATE TABLE entity_role
    (
      entity_id INT NOT NULL,
      role_id   INT NOT NULL
    )
      ENGINE = InnoDB;
    
##### permission
    -- auto-generated definition
    CREATE TABLE permission
    (
      id   INT AUTO_INCREMENT
        PRIMARY KEY,
      name VARCHAR(40) NOT NULL,
      CONSTRAINT permission_name_uindex
      UNIQUE (name)
    )
      ENGINE = InnoDB;
    
##### role_permission
    -- auto-generated definition
    CREATE TABLE role_permission
    (
      role_id       INT NOT NULL,
      permission_id INT NOT NULL
    )
      ENGINE = InnoDB;
    
##### project
    -- auto-generated definition
    CREATE TABLE project
    (
      id            INT AUTO_INCREMENT
        PRIMARY KEY,
      name          VARCHAR(100) NOT NULL,
      location      TEXT         NOT NULL,
      enterprise_id INT          NOT NULL,
      drilled_holes MEDIUMTEXT   NOT NULL,
      tunnel        MEDIUMTEXT   NOT NULL,
      statistic     MEDIUMTEXT   NOT NULL,
      date          DATE         NOT NULL,
      CONSTRAINT project_prjname_uindex
      UNIQUE (name)
    )
      ENGINE = InnoDB;
    
##### device
    -- auto-generated definition
    CREATE TABLE device
    (
      id     INT AUTO_INCREMENT
        PRIMARY KEY,
      name   INT         NOT NULL,
      amount INT         NOT NULL,
      price  DOUBLE      NOT NULL,
      status VARCHAR(40) NOT NULL,
      CONSTRAINT device_dvc_name_uindex
      UNIQUE (name)
    )
      ENGINE = InnoDB;
    
##### material
    -- auto-generated definition
    CREATE TABLE material
    (
      id     INT AUTO_INCREMENT
        PRIMARY KEY,
      name   VARCHAR(40) NOT NULL,
      amount DOUBLE      NOT NULL,
      price  DOUBLE      NOT NULL,
      CONSTRAINT material_mt_name_uindex
      UNIQUE (name)
    )
      ENGINE = InnoDB;
    
##### prjlog
    -- auto-generated definition
    CREATE TABLE prjlog
    (
      id      INT AUTO_INCREMENT
        PRIMARY KEY,
      prj_id  INT         NOT NULL,
      dvc_id  INT         NOT NULL,
      status  VARCHAR(20) NOT NULL,
      time    TIMESTAMP   NOT NULL,
      content MEDIUMTEXT  NOT NULL
    )
      ENGINE = InnoDB;
    
##### report
    -- auto-generated definition
    CREATE TABLE report
    (
      id                    INT AUTO_INCREMENT
        PRIMARY KEY,
      prj_id                INT         NOT NULL,
      mining_amount         DOUBLE      NOT NULL,
      surrounding_rock_mass DOUBLE      NOT NULL,
      grade                 VARCHAR(30) NOT NULL,
      dilution              DOUBLE      NOT NULL,
      loss_rate             DOUBLE      NOT NULL,
      raw_ore               DOUBLE      NOT NULL,
      concentrate_quantity  DOUBLE      NOT NULL,
      sewage                DOUBLE      NOT NULL,
      content               MEDIUMTEXT  NOT NULL
    )
      ENGINE = InnoDB;
    
