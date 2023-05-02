--Pantailatik zerbait ikusi nahi badugu egin ahal izateko
SET VERIFY OFF;
SET SERVEROUTPUT ON;

--HASIERAKO EGOERA. Ezer egin baino lehen hurrengo sententziak idatzi behar dira.
--Bezeroen pasahitzak gordetzeko zutabea bezeroen taulan + emailak pasahitzaren barruan sartu
ALTER TABLE BEZERO ADD PASAHITZA VARCHAR2(50);

UPDATE BEZERO SET PASAHITZA = EMAILA;

--Egoera aldaketak auditatzeko taula sortu
CREATE TABLE EGOERA_ALDAKETAK(
    ESKARI_ID NUMBER(5,0),
    SALTZAILE_ID NUMBER(5,0),
    EGOERA_ZAHARRA NUMBER(1,0),
    EGOERA_BERRIA NUMBER(1,0),
    DATA DATE);
/

--RAM kategoria sortu kategorien taula
INSERT INTO KATEGORIA (ID, IZENA) VALUES (3, 'RAM');
/

--ESKARI taulan aldaketak egin duen azken saltzailea gordetzeko zutabea sortu eta foreign key-a ezarri
ALTER TABLE ESKARI ADD AZKEN_ALDAKETA NUMBER(4);
ALTER TABLE ESKARI ADD CONSTRAINT FK_AZKSAL FOREIGN KEY (AZKEN_ALDAKETA) REFERENCES SALTZAILE(ID) ON DELETE SET NULL;
/

--BEZERO eta SALTZAILEko logina egin ahal izateko gure datuak
INSERT INTO BEZERO (ID, IZENA, ABIZENA, HELBIDEA, EMAILA, PASAHITZA) VALUES (320, 'ASIER', 'FERNANDEZ', '48480, Arrigorriaga, Bizkaia, EH', 'afernandezi22@fpsanjorge.com', 'asier1234');
INSERT INTO BEZERO (ID, IZENA, ABIZENA, HELBIDEA, EMAILA, PASAHITZA) VALUES (321, 'IZASKUN', 'FERNANDEZ', '48480, Arrigorriaga, Bizkaia, EH', 'ifernandezi22@fpsanjorge.com', '8888');
INSERT INTO BEZERO (ID, IZENA, ABIZENA, HELBIDEA, EMAILA, PASAHITZA) VALUES (322, 'JON', 'CABALLERO', '48980, Santurtzi, Bizkaia, EH', 'jcaballerof22@fpsanjorge.com', '3333');
INSERT INTO LANGILE(ID, IZENA, ABIZENA, EMAILA, TELEFONOA, KONTRATAZIO_DATA, ID_NAGUSI) VALUES (108, 'Izaskun', 'Fernandez', 'ifernandezi22@fpsanjorge.com', '515.123.8182', SYSDATE, 1);
INSERT INTO LANGILE(ID, IZENA, ABIZENA, EMAILA, TELEFONOA, KONTRATAZIO_DATA, ID_NAGUSI) VALUES (109, 'Asier', 'Fernandez', 'afernandezi22@fpsanjorge.com', '515.123.8183', SYSDATE, 1);
INSERT INTO LANGILE(ID, IZENA, ABIZENA, EMAILA, TELEFONOA, KONTRATAZIO_DATA, ID_NAGUSI) VALUES (110, 'Jon', 'Fernandez', 'jcaballerof22@fpsanjorge.com', '515.123.8184', SYSDATE, 1);
INSERT INTO SALTZAILE(ID, ERABILTZAILEA, PASAHITZA) VALUES(108, 'ifernandezi22', '8888');
INSERT INTO SALTZAILE(ID, ERABILTZAILEA, PASAHITZA) VALUES(109, 'afernandezi22', 'asier1234');
INSERT INTO SALTZAILE(ID, ERABILTZAILEA, PASAHITZA) VALUES(110, 'jcaballerof22', '3333');
/

--1 PANTAILA. Bezeroen logina.
CREATE OR REPLACE FUNCTION BEZEROLOGIN(ERABILTZAILE BEZERO.EMAILA%TYPE, PASA BEZERO.PASAHITZA%TYPE) RETURN NUMBER AS
    PASS BEZERO.PASAHITZA%TYPE;
    ERAB BEZERO.EMAILA%TYPE;
BEGIN
    SELECT EMAILA, PASAHITZA INTO ERAB, PASS FROM BEZERO WHERE ERABILTZAILE = EMAILA;
    CASE
        WHEN ERAB IS NULL THEN RETURN 2; -- Ez badu erabiltzailea topatzen 2 bueltatuko du
        WHEN PASS = PASA THEN RETURN 1; -- Topatzen badu eta pasahitza ondo sartu badu 1 bueltatuko du
        ELSE RETURN 0; -- Beste egoera guztietan 0 bueltatuko du (pasahitza txarto dagoenean, adibidez)
    END CASE;
EXCEPTION
    WHEN NO_DATA_FOUND THEN RETURN 0; 
    WHEN OTHERS THEN RETURN 0;
END;
/

--3 PANTAILA. Produktuak erosi
--KOPURU GEHIEN DUEN BILTEGIA AUKERATU
CREATE OR REPLACE FUNCTION ERABAKIBILTEGIA(PRODUKTUIZENA PRODUKTU.IZENA%TYPE) RETURN NUMBER AS
	BILTEGIA NUMBER;
BEGIN
	SELECT I.ID_BILTEGI INTO BILTEGIA FROM PRODUKTU P, INBENTARIO I WHERE P.IZENA = PRODUKTUIZENA AND P.ID = I.ID_PRODUKTU group by P.ID, I.ID_BILTEGI ORDER BY MAX(I.KOPURUA) DESC FETCH FIRST 1 ROWS ONLY;    
	RETURN BILTEGIA;
END;
/
--KONTSULTA PRODUKTUEN BILAKETA EGITEKO FILTROEKIN
SELECT * FROM PRODUKTU WHERE SALNEURRIA > ? AND SALNEURRIA < ? AND ID ?(SELECT ID_PRODUKTU FROM INBENTARIO) AND ID_KATEGORIA = ? ORDER BY SALNEURRIA ASC FETCH FIRST ? ROWS ONLY;

--4 PANTAILA. Eskariak bilatu
SELECT ES.ID AS ESKARI_ID, ES.ID_BEZERO AS BEZEROA, EE.DESKRIBAPENA AS EGOERA, S.ERABILTZAILEA AS SALTZAILEA, ES.ESKAERA_DATA 
FROM SALTZAILE S, ESKARI_EGOERA EE, ESKARI ES 
WHERE ES.ID_EGOERA=EE.ID
AND ES.ID_SALTZAILE=S.ID
AND ES.ID_BEZERO = ?;
/

--5 PANTAILA. Bezeroen erregistroa
CREATE OR REPLACE PROCEDURE BEZEROERREGISTRO(IZEN BEZERO.IZENA%TYPE, ABIZEN BEZERO.ABIZENA%TYPE, HELBIDE BEZERO.HELBIDEA%TYPE, EMAIL BEZERO.EMAILA%TYPE, PASS BEZERO.PASAHITZA%TYPE) AS
    KODE BEZERO.ID%TYPE;
BEGIN
    SELECT ID INTO KODE FROM BEZERO WHERE EMAILA = EMAIL;
    IF KODE IS NOT NULL THEN
        RAISE_APPLICATION_ERROR(-20002, 'Email hori dagoeneko datu-basean dago');
    ELSIF EMAIL NOT LIKE('%@%') THEN
        RAISE_APPLICATION_ERROR(-20003, 'Ez duzu email bat idatzi');
    END IF;
    
    SELECT (MAX(ID)+1) INTO KODE FROM BEZERO;
    
    INSERT INTO BEZERO(ID, IZENA, ABIZENA, HELBIDEA, EMAILA, PASAHITZA) VALUES(KODE, IZEN, ABIZEN, HELBIDE, EMAIL, PASS);
END;
/

--6 PANTAILA. Saltzaileen logina
CREATE OR REPLACE FUNCTION SALTZAILELOGIN (ERABILTZAILE SALTZAILE.ERABILTZAILEA%TYPE, PASAHITZ SALTZAILE.PASAHITZA%TYPE) RETURN NUMBER AS
	PASS SALTZAILE.PASAHITZA%TYPE;
	ERAB SALTZAILE.ERABILTZAILEA%TYPE;
BEGIN
	SELECT ERABILTZAILEA, PASAHITZA INTO ERAB, PASS FROM SALTZAILE WHERE ERABILTZAILEA = ERABILTZAILE;
	CASE
        WHEN ERAB IS NULL THEN RETURN 2; -- Ez badu erabiltzailea topatzen 2 bueltatuko du
        WHEN PASS = PASAHITZ THEN RETURN 1; -- Topatzen badu eta pasahitza ondo sartu badu 1 bueltatuko du
        ELSE RETURN 0; -- Beste egoera guztietan 0 bueltatuko du (pasahitza txarto dagoenean, adibidez)
    END CASE;
EXCEPTION
	WHEN NO_DATA_FOUND THEN RETURN 0;
	WHEN OTHERS THEN RETURN 0;
END;
/

--9 PANTAILA. Bezeroak bilatu, aldatu eta ezabatu
--Bilatu datuak
SELECT *
FROM BEZERO
WHERE ID = ?;
/
--Aldatu
UPDATE BEZERO SET IZENA = ?, ABIZENA = ?, HELBIDEA = ?, EMAILA = ? WHERE ID = ?;
/
--Ezabatu
DELETE FROM BEZERO ID = ?;
/
--10 PANTAILA. Produktuen prezioa igotzeko
-- Produktu baten IDa parametro bezala eta stocka bueltatzen du
CREATE OR REPLACE PROCEDURE STOCK(KODE PRODUKTU.ID%TYPE, S OUT NUMBER) AS --S aldagaia bueltatuko duen prozedura da
BEGIN
    SELECT SUM(KOPURUA) INTO S FROM INBENTARIO WHERE ID_PRODUKTU = KODE;
    IF S IS NULL THEN -- Ez badu produktua aurkitzen stocka 0 dela esan behar diogu
        S := 0;
    END IF;
END;

--Prezioak igotzen dituen prozedura. Parametro asko hartzen ditu (zein preziotik aurrera eta bakoitzari igo nahi diogu portzentajea)
CREATE OR REPLACE PROCEDURE IGOPREZIOAK(CPUSTOCK INBENTARIO.KOPURUA%TYPE, VCSTOCK INBENTARIO.KOPURUA%TYPE, RAMSTOCK INBENTARIO.KOPURUA%TYPE, MBSTOCK INBENTARIO.KOPURUA%TYPE, STORAGESTOCK INBENTARIO.KOPURUA%TYPE, CPUIGO NUMBER, VCIGO NUMBER, RAMIGO NUMBER, MBIGO NUMBER, STORAGEIGO NUMBER) AS
    CURSOR CPRODUKTU IS SELECT * FROM PRODUKTU FOR UPDATE; --Produktu guztiak begiratzeko kurtsorea
    S NUMBER(4); --Stocka zehazteko kasu bakoitzean
BEGIN
    FOR PRODUKTU IN CPRODUKTU
    LOOP
        STOCK(PRODUKTU.ID,S);--Produktu bakoitza begiratzerakoan dagoen stocka gordetzen du
        CASE PRODUKTU.ID_KATEGORIA
            WHEN 1 THEN
                IF S > CPUSTOCK THEN
                    UPDATE PRODUKTU SET SALNEURRIA = SALNEURRIA + ((SALNEURRIA * CPUIGO)/100) WHERE CURRENT OF CPRODUKTU;
                END IF;
            WHEN 2 THEN
                IF S > VCSTOCK THEN
                    UPDATE PRODUKTU SET SALNEURRIA = SALNEURRIA + ((SALNEURRIA * VCIGO)/100) WHERE CURRENT OF CPRODUKTU;
                END IF;
            WHEN 3 THEN
                IF S > RAMSTOCK THEN
                    UPDATE PRODUKTU SET SALNEURRIA = SALNEURRIA + ((SALNEURRIA * RAMIGO)/100) WHERE CURRENT OF CPRODUKTU;
                END IF;
            WHEN 4 THEN
                IF S > MBSTOCK THEN
                    UPDATE PRODUKTU SET SALNEURRIA = SALNEURRIA + ((SALNEURRIA * MBIGO)/100) WHERE CURRENT OF CPRODUKTU;
                END IF;
            WHEN 5 THEN
                IF S > STORAGESTOCK THEN
                    UPDATE PRODUKTU SET SALNEURRIA = SALNEURRIA + ((SALNEURRIA * STORAGEIGO)/100) WHERE CURRENT OF CPRODUKTU;
                END IF;
        END CASE;
    END LOOP;
END;