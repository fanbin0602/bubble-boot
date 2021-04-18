-- OAuth 客户端
create table oauth_client_details
(
    client_id               varchar(256)  not null
        primary key,
    resource_ids            varchar(256)  null,
    client_secret           varchar(256)  null,
    scope                   varchar(256)  null,
    authorized_grant_types  varchar(256)  null,
    web_server_redirect_uri varchar(256)  null,
    authorities             varchar(256)  null,
    access_token_validity   int           null,
    refresh_token_validity  int           null,
    additional_information  varchar(4096) null,
    autoapprove             varchar(256)  null
);

-- 测试客户端
INSERT INTO bubble.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('client', 'resource', '$2a$10$8GLMxLcd30wWGIpGDxcDTeO0GnteKX0OkpP447liLIhwuTOVNzJhS', 'admin', 'password,authorization_code,client_credentials,refresh_token,implicit', 'http://baidu.com/', 'ADMIN', 7200, null, null, 'false');