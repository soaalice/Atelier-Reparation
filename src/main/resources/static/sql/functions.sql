CREATE OR REPLACE FUNCTION etat_stock_filtre(date_debut DATE, date_fin DATE)
RETURNS TABLE (
    composant_id INT,
    composant_name VARCHAR,
    type_composant_id INT,
    type_composant_name VARCHAR,
    stock INT
) AS $$
BEGIN
    RETURN QUERY
    SELECT
        c.id AS composant_id,
        c.name AS composant_name,
        tc.id AS type_composant_id,
        tc.name AS type_composant_name,
        COALESCE(SUM(ms.entree) - SUM(ms.sortie), 0) AS stock
    FROM
        composant c
    JOIN
        type_composant tc ON tc.id = c.type_composant_id
    LEFT JOIN
        mvt_stock ms ON c.id = ms.composant_id AND ms.date_mvt BETWEEN date_debut AND date_fin
    GROUP BY
        c.id, tc.id;
END;
$$ LANGUAGE plpgsql;
