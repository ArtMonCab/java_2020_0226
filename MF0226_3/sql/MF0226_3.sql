-- SQL listar últimos 5 cursos
SELECT  c.codigo, c.nombre, c.identificador, c.fInicio, c.fFin, c.nHoras, c.temario, c.activo, cl.nombre as cliente, c.precio, p.nombre as profesor
FROM curso c, profesor p, cliente cl
WHERE cl.codigo = c.cliente_codigo
AND  p.codigo = c.profesor_codigo
ORDER By c.fInicio DESC
LIMIT 5;

-- SQL listar últimos 5 usuarios creados
SELECT  nombre, apellidos, fnacimiento, direccion, poblacion, codigoPostal, telefono, email, dni FROM alumno
ORDER BY codigo DESC
LIMIT 5;

-- SQL detalle curso + número de reseñas
SELECT  c.nombre, c.identificador, c.nHoras as horas, p.nombre as profesor, (SELECT COUNT(*) FROM resenya
        WHERE curso_codigo = c.codigo) AS numero_resenyas
FROM curso c, profesor p
WHERE p.codigo = c.profesor_codigo
GROUP BY c.codigo;

-- SQL listado usuarios ordenado por número de reseñas
SELECT a.nombre, a.apellidos, a.telefono, a.email, (SELECT COUNT(*) FROM resenya
        WHERE alumno_codigo = a.codigo) AS numero_resenyas 
FROM alumno a
GROUP BY a.codigo
ORDER BY numero_resenyas DESC;

-- SQL Resumen de número de cursos de todos los años 
SELECT YEAR(fInicio) as anyo, count(*) as numero_cursos FROM curso
GROUP BY YEAR(fInicio);