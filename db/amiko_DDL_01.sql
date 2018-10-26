CREATE TABLE kosto (
	kosto_id serial PRIMARY KEY,
    price numeric NOT NULL,
	description varchar (50) NOT NULL,
	quantity integer NOT NULL,
	weight varchar (10) NOT NULL,
	date date
);

CREATE TABLE hashtag (
	hashtag_id serial PRIMARY KEY,
	hashtag varchar (50) NOT NULL UNIQUE
);

CREATE TABLE kosto_hashtag (
	kosto_hashtag_id serial PRIMARY KEY,
	kosto_id integer REFERENCES kosto (kosto_id),
	hashtag_id integer REFERENCES hashtag (hashtag_id)
);

