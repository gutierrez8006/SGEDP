SELECT * FROM USUARIO;

SELECT * FROM PERFILES;

SELECT * FROM MENU;

SELECT * FROM MENUITEM;


SELECT MI.* FROM MENU M INNER JOIN MENUITEM MI
ON (M.CMENU_CODIGO =  MI.CMENU_CODIGO);
-- consulta menuitem por usuario ver 1
SELECT mi.* FROM USUARIO u INNER JOIN usuario_perfiles up
ON (u.iusuario_codigo = up.iusuario_codigo) INNER JOIN PERFILES p
ON (up.cperf_codigo = p.cperf_codigo) INNER JOIN perfiles_menu pm
ON (p.cperf_codigo = pm.cperf_codigo) INNER JOIN menu m
ON (pm.cmenu_codigo = m.cmenu_codigo) INNER JOIN menuitem mi
ON (m.cmenu_codigo = mi.cmenu_codigo)
WHERE u.iusuario_codigo = 1;

-- consulta menuitem por usuario ver 2
SELECT mi.* FROM MENU m INNER JOIN MENUITEM mi
ON (M.CMENU_CODIGO =  MI.CMENU_CODIGO) INNER JOIN perfiles_menu pm
ON (m.cmenu_codigo = pm.cmenu_codigo) INNER JOIN usuario_perfiles up
ON (pm.CPERF_CODIGO = up.CPERF_CODIGO)
WHERE up.IUSUARIO_CODIGO = '1';
