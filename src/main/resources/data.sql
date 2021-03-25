insert into ctc_user(username, enabled, password) values ('root', true, '$2b$10$lmmeeEPI0NIblGfNjBZTae60XQVO/IsTLpflTygTjPjel82OQ1Ucm'); --password: Root12345
insert into ctc_user(username, enabled, password) values ('test', true, '$2b$10$AJLBq3XGzo1Y4AW4nIZ8.exrdGg3UJ68X/MosQCHdSdIWUTx4B7CK'); --password: Test
insert into ctc_user_role(role, username) values ('ROLE_ROOT', 'root');
insert into ctc_user_role(role, username) values ('ROLE_USER', 'test');