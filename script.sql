create database cities;
drop table if exists city;
create table city (id bigint not null auto_increment,
                    description varchar(255), name varchar(255),
                    sub_name varchar(255),
                    primary key (id));

insert into city values
    (1, 'В Москве нужно посетить Красную площадь', 'Moscow', 'Москва'),
    (2, 'Тут стоит посетить национальную библеотеку', 'Minsk', 'Минск'),
    (3, 'Тут в летний период хорошо бы посетить Славянский базар', 'Vitebsk', 'Витебск'),
    (4, 'Тут стоит посетить Исаакиевский собор, разводные мосты и вообще центр города', 'Saint-Petersburg', 'Санкт-Петербург'),
    (5, 'Тут стоит посетить Эйфелеву башню', 'Paris', 'Париж'),
    (6, 'Тут надо посетить Брестскую крепость', 'Brest', 'Брест'),
    (7, 'Это Италия, тут все красиво. Но в данной ситуации, я бы посоветовал воздержатся...', 'Milan', 'Милан'),
    (8, 'Советую посмотреть на БигБэн', 'London', 'Лондон'),
    (9, 'Тут проводят Октоберфест', 'Munich', 'Мюнхен');