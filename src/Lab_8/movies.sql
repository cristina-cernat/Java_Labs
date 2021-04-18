DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS relation;

create table movies (
	`id` int,
    `title` varchar(255),
    `release_date` DATE,
    `duration` TIME,
    `score` float
);


create table genres (
	`id` int,
    `name` varchar(255)
);


create table relation (
	`id_movie` int,
    `id_genre` int
);

insert into movies values (1, 'The Shawshank Redemption', '1994-10-14', '2:22', 9.3);
insert into movies values (2, 'The Godfather', '1972-03-24', '2:55', 9.2);
insert into movies values (3, 'Forrest Gump', '1994-07-06', '2:22', 8.8);

insert into genres values (1, 'Drama');
insert into genres values (2, 'Crime');
insert into genres values (3, 'Romance');

insert into relation values (1, 1);
insert into relation values (2, 1);
insert into relation values (2, 2);
insert into relation values (3, 1);
insert into relation values (3, 3);