CREATE TABLE IF NOT EXISTS `company_administrator_invite` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id` INT UNSIGNED NOT NULL,
  `invite_user_id` VARCHAR(50) NOT NULL,
  `invite_user_name` VARCHAR(50) NOT NULL,
  `invitee_user_id` VARCHAR(50) NOT NULL,
  `invitee_user_name` VARCHAR(50) NOT NULL,
  `token` VARCHAR(50) NOT NULL,
  `status` TINYINT NOT NULL COMMENT '#0 Discard #1 Unconfirmed, #2 Joined, #3 Rejected',
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX index_token(`token`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company_register_provider` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id` INT UNSIGNED NOT NULL,
  `provider_id` INT UNSIGNED NOT NULL,
  `created_by` VARCHAR(50) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX index_company_id(`company_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `company_channel_provider` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_id` INT UNSIGNED NOT NULL,
  `provider_id` INT UNSIGNED NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX index_company_id(`company_id`, `provider_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `account_email_verify` (
  `id` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `uid` VARCHAR(50) NOT NULL,
  `email` VARBINARY(300),
  `token` VARCHAR(40) NOT NULL,
  `expired_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(50) NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `token_uk` (`token`),
  UNIQUE KEY `uid_uk` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `project_game_client_info`
DROP `redirect_url`,
DROP `quick_game_url`,
DROP `service_url`,
DROP `reserve1_url`,
DROP `reserve2_url`,
ADD `android_package_signature` TEXT DEFAULT NULL AFTER `android_scheme`,
ADD `android_package_name` VARCHAR(100) DEFAULT NULL AFTER `android_package_signature`,
ADD `ios_bundle_id` TEXT DEFAULT NULL AFTER `ios_scheme`;

ALTER TABLE `company`
ADD `contact_region` VARBINARY(128) NOT NULL AFTER `contact_email`;