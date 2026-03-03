package IOC_BE.SS17.BaiTap01_SS17;

CREATE TABLE movies (
        id SERIAL PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
director VARCHAR(255) NOT NULL,
release_year INT NOT NULL
);

CREATE OR REPLACE FUNCTION add_movie(
        p_title VARCHAR,
        p_director VARCHAR,
        p_release_year INT
) RETURNS VOID AS $$
BEGIN
INSERT INTO movies (title, director, release_year)
VALUES (p_title, p_director, p_release_year);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION list_movies(
) RETURNS SETOF movies AS $$
BEGIN
RETURN QUERY SELECT * FROM movies;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION update_movie(
        p_id INT,
        p_title VARCHAR,
        p_director VARCHAR,
        p_release_year INT
) RETURNS VOID AS $$
BEGIN
UPDATE movies
        SET title = p_title,
                director = p_director,
                release_year = p_release_year
WHERE id = p_id;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION delete_movie(
        p_id INT
) RETURNS VOID AS $$
BEGIN
DELETE FROM movies WHERE id = p_id;
END;
$$ LANGUAGE plpgsql;