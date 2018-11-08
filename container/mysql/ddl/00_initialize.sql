/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# For Mybatis module.
create TABLE IF NOT EXISTS `greeting` (
  `greeting_id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `message`     VARCHAR(200) NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `notice` (
  `id`         INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `category`   TINYINT      NOT NULL,
  `booking`    BOOLEAN      NOT NULL
  COMMENT '#0 OFF, #1 ON',
  `start_time` TIMESTAMP    NULL                 DEFAULT NULL,
  `end_time`   TIMESTAMP    NULL                 DEFAULT NULL,
  `public`     BOOLEAN      NOT NULL,
  `post_type`  TINYINT      NOT NULL,
  `created_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by` VARCHAR(50)  NOT NULL,
  `updated_by` VARCHAR(50)  NOT NULL,
  `is_valid`   BOOLEAN      NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `notice_i18n` (
  `id`          INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `notice_id`   INT UNSIGNED NOT NULL,
  `locale`      VARCHAR(10)  NOT NULL,
  `title`       VARCHAR(200) NOT NULL,
  `description` longtext     NOT NULL,
  UNIQUE KEY `notice_i18n_notice_id_locale_pk` (`notice_id`, `locale`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `notice_email` (
  `id`          INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `notice_id`   INT UNSIGNED NOT NULL,
  `status`      TINYINT      NOT NULL,
  `template_id` INT UNSIGNED NOT NULL,
  `group_id`    VARCHAR(200)                      DEFAULT NULL,
  `address`     VARBINARY(512)                    DEFAULT NULL,
  UNIQUE KEY `notice_email_notice_id_uindex` (`notice_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `notice_page_views` (
  `notice_id`  INT UNSIGNED NOT NULL,
  `page_views` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`notice_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `forum` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(200) NOT NULL,
  `description` LONGTEXT     NOT NULL,
  `category`    TINYINT      NOT NULL
  COMMENT '#1 POIN General, #2 POIN Board, #3 Growthy General, #4 Growthy Analytics',
  `permission`  BOOLEAN      NOT NULL
  COMMENT '#0 Private, #1 Public',
  `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by`  VARCHAR(50)  NOT NULL,
  `updated_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `updated_by`  VARCHAR(50)  NOT NULL,
  `is_valid`    BOOLEAN      NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX index_is_valid(`is_valid`, `permission`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `forum_comment` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `forum_id`    INT UNSIGNED NOT NULL,
  `comment`     LONGTEXT     NOT NULL,
  `visible`     BOOLEAN      NOT NULL DEFAULT 1
  COMMENT '#0 Hidden, #1 Visible',
  `hide_reason` TINYINT               DEFAULT NULL
  COMMENT '#1 Contains inappropriate content, #2 Contains offensive content, #3 Spam, #4 Personal solicitation, #0 Other',
  `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by`  VARCHAR(50)  NOT NULL,
  `updated_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `updated_by`  VARCHAR(50)  NOT NULL,
  `is_valid`    BOOLEAN      NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX index_is_valid(`is_valid`, `visible`, `forum_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `forum_comment_reply` (
  `id`               INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `forum_comment_id` INT UNSIGNED NOT NULL,
  `comment`          LONGTEXT     NOT NULL,
  `visible`          BOOLEAN      NOT NULL DEFAULT 1
  COMMENT '#0 Hidden, #1 Visible',
  `hide_reason`      TINYINT               DEFAULT NULL
  COMMENT '#1 Contains inappropriate content, #2 Contains offensive content, #3 Spam, #4 Personal solicitation, #0 Other',
  `created_at`       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by`       VARCHAR(50)  NOT NULL,
  `updated_at`       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `updated_by`       VARCHAR(50)  NOT NULL,
  `is_valid`         BOOLEAN      NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX index_is_valid(`is_valid`, `visible`, `forum_comment_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `forum_comment_like` (
  `id`               INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `forum_comment_id` INT UNSIGNED NOT NULL,
  `created_by`       VARCHAR(50)  NOT NULL,
  PRIMARY KEY (`id`),
  INDEX index_forum_comment_id(`forum_comment_id`, `created_by`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `forum_draft` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(200)          DEFAULT NULL,
  `description` LONGTEXT              DEFAULT NULL,
  `category`    TINYINT               DEFAULT NULL
  COMMENT '#1 POIN General, #2 POIN Board, #3 Growthy General, #4 Growthy Analytics',
  `permission`  BOOLEAN               DEFAULT NULL
  COMMENT '#0 Private, #1 Public',
  `created_by`  VARCHAR(50)  NOT NULL,
  PRIMARY KEY (`id`),
  INDEX index_created_by(`created_by`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `faq` (
  `id`         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `category`   TINYINT      NOT NULL
  COMMENT '#1 POIN General, #2 POIN Board, #3 Growthy General, #4 Growthy Analytics',
  `permission` BOOLEAN      NOT NULL
  COMMENT '#0 Private, #1 Public',
  `created_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(50)  NOT NULL,
  `updated_at` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(50)  NOT NULL,
  `is_valid`   BOOLEAN      NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX index_is_valid(`is_valid`, `permission`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `faq_i18n` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `faq_id`      INT UNSIGNED NOT NULL,
  `locale`      VARCHAR(10)  NOT NULL,
  `title`       VARCHAR(200) NOT NULL,
  `description` LONGTEXT     NOT NULL,
  PRIMARY KEY (`id`),
  INDEX index_faq_id(`faq_id`, `locale`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `faq_page_views` (
  `faq_id`     INT UNSIGNED NOT NULL,
  `page_views` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`faq_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `faq_draft` (
  `id`         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `category`   TINYINT               DEFAULT NULL
  COMMENT '#1 POIN General, #2 POIN Board, #3 Growthy General, #4 Growthy Analytics',
  `permission` BOOLEAN               DEFAULT NULL
  COMMENT '#0 Private, #1 Public',
  `created_by` VARCHAR(50)  NOT NULL,
  PRIMARY KEY (`id`),
  INDEX index_created_by(`created_by`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `faq_i18n_draft` (
  `id`           INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `faq_draft_id` INT UNSIGNED NOT NULL,
  `locale`       VARCHAR(10)  NOT NULL,
  `title`        VARCHAR(200)          DEFAULT NULL,
  `description`  LONGTEXT              DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX index_faq_draft_id(`faq_draft_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project` (
  `project_id`      VARCHAR(64)    NOT NULL PRIMARY KEY,
  `api_key`         VARCHAR(100)   NOT NULL,
  `sdk_version`     VARCHAR(50)    NOT NULL,
  `status`          TINYINT        NOT NULL,
  `organization_id` INT UNSIGNED   NOT NULL,
  `name`            VARCHAR(100)   NOT NULL,
  `type`            TINYINT        NOT NULL
  COMMENT 'MOBILE_APP, INSTANT_APP',
  `description`     VARCHAR(500)            DEFAULT NULL,
  `channel_id`      INT UNSIGNED            DEFAULT NULL,
  `is_valid`        BOOLEAN        NOT NULL,
  `company`         INT UNSIGNED   NOT NULL,
  `email`           VARBINARY(256) NOT NULL,
  `created_at`      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at`      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by`      VARCHAR(100)   NOT NULL,
  `updated_by`      VARCHAR(100)   NOT NULL,
  KEY `status` (`status`, `organization_id`, `created_by`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_genre` (
  `id`         INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_id` VARCHAR(64)  NOT NULL             DEFAULT '',
  `genre_id`   TINYINT      NOT NULL,
  UNIQUE KEY `uk` (`project_id`, `genre_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_ip_whitelists` (
  `id`          INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_id`  VARCHAR(64)  NOT NULL             DEFAULT '',
  `ip_address`  VARCHAR(50)  NOT NULL,
  `subnet_mask` VARCHAR(2)   NOT NULL,
  `expired_at`  TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `is_valid`    BOOLEAN      NOT NULL,
  `created_at`  TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at`  TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by`  VARCHAR(100) NOT NULL,
  `updated_by`  VARCHAR(100) NOT NULL,
  UNIQUE KEY `uk` (`project_id`, `ip_address`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_partner` (
  `id`             INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_id`     VARCHAR(64)  NOT NULL             DEFAULT '',
  `partner_id`     INT UNSIGNED NOT NULL,
  `publisher_id`   INT UNSIGNED NOT NULL,
  `generated_user` VARCHAR(64)  NOT NULL             DEFAULT '',
  `created_at`     TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at`     TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `project_partner_id` (`project_id`, `partner_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_role_permission` (
  `id`              INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_id`      VARCHAR(64)  NOT NULL             DEFAULT '',
  `organization_id` INT UNSIGNED NOT NULL,
  `role`            TINYINT      NOT NULL,
  `expired`         BOOLEAN      NOT NULL,
  `expired_at`      TIMESTAMP    NULL                 DEFAULT CURRENT_TIMESTAMP,
  `is_valid`        BOOLEAN      NOT NULL,
  `created_at`      TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at`      TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by`      VARCHAR(100) NOT NULL,
  `updated_by`      VARCHAR(100) NOT NULL,
  UNIQUE KEY `uk` (`project_id`, `organization_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_service_account` (
  `id`                    INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_id`            VARCHAR(64)  NOT NULL             DEFAULT '',
  `service_account_name`  VARCHAR(200) NOT NULL,
  `service_account_email` VARCHAR(200) NOT NULL,
  `role`                  TINYINT      NOT NULL,
  `expired_at`            TIMESTAMP    NULL                 DEFAULT CURRENT_TIMESTAMP,
  `is_valid`              BOOLEAN      NOT NULL,
  `created_at`            TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at`            TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by`            VARCHAR(100) NOT NULL,
  `updated_by`            VARCHAR(100) NOT NULL,
  UNIQUE KEY `uk` (`project_id`, `service_account_name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_service_account_key` (
  `id`         INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `account_id` INT UNSIGNED NOT NULL,
  `key_id`     VARCHAR(100) NOT NULL,
  `is_valid`   BOOLEAN      NOT NULL,
  `created_by` VARCHAR(100) NOT NULL,
  `created_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(100) NOT NULL,
  `updated_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `uk` (`key_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_services` (
  `id`         INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `type`       TINYINT      NOT NULL,
  `sub_type`   VARCHAR(20)  NOT NULL,
  `is_valid`   BOOLEAN      NOT NULL,
  `created_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by` VARCHAR(100) NOT NULL,
  `updated_by` VARCHAR(100) NOT NULL,
  UNIQUE KEY `uk` (`type`, `sub_type`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_services_i18n` (
  `id`          INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `service_id`  INT UNSIGNED NOT NULL,
  `locale`      VARCHAR(2)   NOT NULL,
  `title`       VARCHAR(2)   NOT NULL,
  `description` VARCHAR(2)   NOT NULL,
  `is_valid`    BOOLEAN      NOT NULL,
  `created_at`  TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at`  TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by`  VARCHAR(100) NOT NULL,
  `updated_by`  VARCHAR(100) NOT NULL,
  UNIQUE KEY `uk` (`service_id`, `locale`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_services_setting` (
  `id`              INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_id`      VARCHAR(64)  NOT NULL             DEFAULT '',
  `used_service_id` INT UNSIGNED NOT NULL,
  `is_valid`        BOOLEAN      NOT NULL,
  `created_at`      TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_at`      TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by`      VARCHAR(100) NOT NULL,
  `updated_by`      VARCHAR(100) NOT NULL,
  UNIQUE KEY `uk` (`project_id`, `used_service_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_game_client_info` (
  `project_id`      VARCHAR(64)  NOT NULL PRIMARY KEY,
  `google_play_url` VARCHAR(1000)         DEFAULT NULL,
  `android_scheme`  VARCHAR(100)          DEFAULT NULL,
  `app_store_url`   VARCHAR(1000)         DEFAULT NULL,
  `ios_scheme`      VARCHAR(100)          DEFAULT NULL,
  `redirect_url`    VARCHAR(1000)         DEFAULT NULL,
  `quick_game_url`  VARCHAR(1000)         DEFAULT NULL,
  `service_url`     VARCHAR(1000)         DEFAULT NULL,
  `reserve1_url`    VARCHAR(1000)         DEFAULT NULL,
  `reserve2_url`    VARCHAR(1000)         DEFAULT NULL,
  `is_valid`        BOOLEAN      NOT NULL,
  `created_at`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `created_by`      VARCHAR(100) NOT NULL,
  `updated_by`      VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `project_thumbnails` (
  `id`         INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_id` VARCHAR(64)  NOT NULL             DEFAULT '',
  `type`       VARCHAR(30)  NOT NULL,
  `url`        VARCHAR(500) NOT NULL,
  `resolution` VARCHAR(20)  NOT NULL,
  UNIQUE KEY `uk` (`project_id`, `type`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `account` (
  `id`          VARCHAR(50)  NOT NULL PRIMARY KEY,
  `name`        VARCHAR(100) NOT NULL,
  `email`       VARBINARY(300),
  `line_uid`    VARCHAR(50)  NULL,
  `description` VARCHAR(512) NULL,
  `picture`     VARCHAR(255) NULL,
  `is_valid`    BOOLEAN      NOT NULL DEFAULT 1,
  `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type`        TINYINT               DEFAULT '0'
  COMMENT '0: individual 1: company',
  UNIQUE KEY `email_uk` (`email`),
  UNIQUE KEY `line_uid_uk` (`line_uid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `organization` (
  `id`          INT unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`        VARCHAR(20)  NOT NULL,
  `description` VARCHAR(512) NULL,
  `created_by`  VARCHAR(50)  NULL,
  `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by`  VARCHAR(50)  NULL,
  `updated_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `type`        TINYINT               DEFAULT '0'
  COMMENT '0: default 1: custom'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `organization_user_assign` (
  `organization_id` INT unsigned NOT NULL,
  `uid`             VARCHAR(50)  NOT NULL,
  `type`            TINYINT               DEFAULT '0'
  COMMENT '#0 Member, #1 Owner',
  `created_by`      VARCHAR(50)  NOT NULL,
  `created_at`      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`organization_id`, `uid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `invitation_account` (
  `id`              INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `token`           VARCHAR(40)  NOT NULL,
  `email`           VARBINARY(300)                    DEFAULT NULL,
  `organization_id` INT unsigned NOT NULL,
  `expiry_at`       TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `status`          TINYINT      NOT NULL             DEFAULT '0',
  `uid`             VARCHAR(50)  NULL                 DEFAULT NULL,
  `created_by`      VARCHAR(50)                       DEFAULT NULL,
  `created_at`      TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `updated_by`      VARCHAR(50)                       DEFAULT NULL,
  `updated_at`      TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `uk_token` (`token`),
  UNIQUE KEY `uk_email_organization_id` (`email`, `organization_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `liff_info` (
  `id`       INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  project_id VARCHAR(64)  NOT NULL,
  `type`     TINYINT      NOT NULL
  COMMENT '1:serverurl,2:reserve1url,3:reserve2url',
  liff_id    VARCHAR(64)  NOT NULL,
  UNIQUE KEY `uk` (`project_id`, `type`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company` (
  `id`             INT UNSIGNED   NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(100)   NOT NULL,
  `type`           TINYINT        NOT NULL
  COMMENT '#1 Public Institution, #2 Corporation, #3 Individual Business, #0 Others',
  `contact_name`   VARCHAR(100)   NOT NULL,
  `contact_email`  VARBINARY(128) NOT NULL,
  `contact_region` VARBINARY(128) NOT NULL,
  `contact_tel`    VARBINARY(128) NOT NULL,
  `contact_fax`    VARBINARY(128) NOT NULL,
  `website_url`    VARCHAR(200)            DEFAULT NULL,
  `created_at`     TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by`     VARCHAR(50)    NOT NULL,
  `updated_at`     TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  `updated_by`     VARCHAR(50)    NOT NULL,
  PRIMARY KEY (`id`),
  INDEX index_name(`name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company_file` (
  `id`         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id` INT UNSIGNED NOT NULL,
  `file_name`  VARCHAR(100) NOT NULL,
  `file_key`   VARCHAR(100) NOT NULL,
  `file_size`  INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX index_company_id(`company_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company_administrator` (
  `id`         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id` INT UNSIGNED NOT NULL,
  `user_id`    VARCHAR(50)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX index_company_id(`company_id`, `user_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company_administrator_invite` (
  `id`                INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id`        INT UNSIGNED NOT NULL,
  `invite_user_id`    VARCHAR(50)  NOT NULL,
  `invite_user_name`  VARCHAR(50)  NOT NULL,
  `invitee_user_id`   VARCHAR(50)  NOT NULL,
  `invitee_user_name` VARCHAR(50)  NOT NULL,
  `token`             VARCHAR(50)  NOT NULL,
  `status`            TINYINT      NOT NULL
  COMMENT '#0 Discard #1 Unconfirmed, #2 Joined, #3 Rejected',
  `created_at`        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX index_token(`token`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company_register_provider` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id`  INT UNSIGNED NOT NULL,
  `provider_id` INT UNSIGNED NOT NULL,
  `created_by`  VARCHAR(50)  NOT NULL,
  `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX index_company_id(`company_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company_channel_provider` (
  `id`          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id`  INT UNSIGNED NOT NULL,
  `provider_id` INT UNSIGNED NOT NULL,
  `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX index_company_id(`company_id`, `provider_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

ALTER TABLE `project_game_client_info`
  DROP `redirect_url`,
  DROP `quick_game_url`,
  DROP `service_url`,
  DROP `reserve1_url`,
  DROP `reserve2_url`,
  ADD `android_package_signature` TEXT DEFAULT NULL
  AFTER `android_scheme`,
  ADD `android_package_name` VARCHAR(100) DEFAULT NULL
  AFTER `android_package_signature`,
  ADD `ios_bundle_id` TEXT DEFAULT NULL
  AFTER `ios_scheme`;

CREATE TABLE IF NOT EXISTS `account_email_verify` (
  `id`         INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `uid`        VARCHAR(50)  NOT NULL,
  `email`      VARBINARY(300),
  `token`      VARCHAR(40)  NOT NULL,
  `expired_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(50)  NULL,
  `created_at` TIMESTAMP    NOT NULL             DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `token_uk` (`token`),
  UNIQUE KEY `uid_uk` (`uid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `permission` (
  `id`         INT UNSIGNED     NOT NULL AUTO_INCREMENT,
  `permission` VARCHAR(100)     NOT NULL,
  `role`       TINYINT UNSIGNED NOT NULL,
  `created_by` VARCHAR(50)      NOT NULL,
  `created_at` TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(50)      NOT NULL,
  `updated_at` TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_uk` (`permission`, `role`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `permission_i18n` (
  `permission_id` INT UNSIGNED NOT NULL,
  `locale`        VARCHAR(10)  NOT NULL,
  `description`   TINYTEXT     NOT NULL,
  PRIMARY KEY (`permission_id`, `locale`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
