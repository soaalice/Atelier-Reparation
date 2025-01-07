CREATE OR REPLACE VIEW etat_stock AS

SELECT
    c.id as composant_id,
    c.name as composant_name,
    tc.id as type_composant_id,
    tc.name as type_composant_name,
    COALESCE( COALESCE(SUM(ms.entree - ms.sortie), 0), 0) as stock
FROM
    composant c
JOIN
    type_composant tc
ON
    tc.id = c.type_composant_id
LEFT JOIN
    mvt_stock ms
ON 
    c.id = ms.composant_id  
GROUP BY 
    c.id, tc.id
;

SELECT
    c.id as composant_id,
    c.name as composant_name,
    tc.id as type_composant_id,
    tc.name as type_composant_name,
    COALESCE( COALESCE(SUM(ms.entree - ms.sortie), 0), 0) as stock
FROM
    composant c
JOIN
    type_composant tc
ON
    tc.id = c.type_composant_id
LEFT JOIN
    mvt_stock ms
ON 
    c.id = ms.composant_id  
AND 
    (ms.date_mvt <= '2100-01-01')
AND 
    (ms.date_mvt >= '1900-01-01')
GROUP BY 
    c.id, tc.id
;