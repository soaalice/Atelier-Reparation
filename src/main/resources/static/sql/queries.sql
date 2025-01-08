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

SELECT r.*, tc.* from reparation r
join reparation_details rd on r.id = rd.reparation_id
join composant c on rd.composant_id = c.id
join type_composant tc on c.type_composant_id = tc.id;

SELECT o.* from ordinateur o
where o.id not in ( SELECT ordinateur_id from  reparation );

