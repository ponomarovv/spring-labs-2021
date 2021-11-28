CREATE TABLE IF NOT EXISTS public.sports (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT sports_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.teams (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT teams_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.games (
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    date date NOT NULL,
    sport_id integer NOT NULL,
    first_team_id integer NOT NULL,
    second_team_id integer NOT NULL,
    first_team_score integer NOT NULL,
    second_team_score integer NOT NULL,
    CONSTRAINT games_pkey PRIMARY KEY (id),
    CONSTRAINT fk_games_first_team_id_to_teams
        FOREIGN KEY (first_team_id)
            REFERENCES public.teams (id) MATCH SIMPLE
                ON UPDATE NO ACTION
                ON DELETE NO ACTION,
    CONSTRAINT fk_games_second_team_id_to_teams
        FOREIGN KEY (second_team_id)
            REFERENCES public.teams (id) MATCH SIMPLE
                ON UPDATE NO ACTION
                ON DELETE NO ACTION,
    CONSTRAINT fk_games_to_sports
        FOREIGN KEY (sport_id)
            REFERENCES public.sports (id) MATCH SIMPLE
                ON UPDATE NO ACTION
                ON DELETE NO ACTION
);