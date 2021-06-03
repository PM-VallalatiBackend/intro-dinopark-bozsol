## Dinópark

Hozz létre egy alkalmazást, ami segít nyilvántartani a dinóparkunkban látható állatokat, a parkba érkező látogatókat, illetve a park értékelését.
Az eltárolt adatokat elegendő memóriában menteni, első lépésben még nem szükséges adatbázist is használni.
Az alkalmazással REST API-n keresztül lehessen kommunikálni.

### Dinók

Minden dínónak van neve, fajtája, illetve eltároljuk róluk, hogy növényevők vagy ragadozók (a mindenevő, dögevő és hasonló kategóriákkal az egyszerűség kedvéért nem kell most foglalkozni).

A dínókat el lehet menteni, lehet listázni az összeset, illetve a táplálkozási szokásaik alapján is.
Mentéskor az alkalmazás térjen vissza az elmentett dínó adataival, jelezve, hogy sikeres volt a mentés.

### Látogatók

Minden látogatónak van neve, és tudja, hogy a növényevőket vagy a ragadozókat kedveli inkább.
A preferenciája alapján minden látogató értékeli a parkot az alábbiak szerint:
- ha nincs legalább 3 dinó a parkban, akkor gátlástalanul lepontozza a parkot, és 1-es értékelést ad
- ha van legalább 3 dinó a parkban, akkor a preferenciájának megfelelő dínókat 5 pontra értékeli, a nem megfelelőeket 2-re, és veszi ezek átlagát (lefelé kerekítve)

A látogatókat el lehet menteni, illetve lehet listázni az összes eddigi látogatót. Mindkét esetben adja vissza az alkalmazás a látogatók nevét és a hozzájuk tartozó értékelést.

### Átlagos értékelés

Az alkalmazástól el lehet kérni a park átlagos értékelését, ami a látogatók értékelései alapján kerül kiszámításra.
Ha még nem volt látogató a parkban, akkor 0-ás értékelést kapunk vissza.

### Opcionális feladat

Szeretnénk az adatokat adatbázisban is eltárolni. Módosítsd ennek megfelelően az alkalmazást (használj Spring JdbcTemplate-et)!
Az alkalmazás tervezésekor készülj fel erre a módosításra, hogy a lehető legkönnyebben tudd implementálni!
