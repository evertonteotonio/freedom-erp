-- 1. CRIAR TIPO DE MOVIMENTO PARA INVENTÁRIO
   
-- PELO SISTEMA   DENTRO DO SISTEMA


-- 2. CRIAR OS CAMPOS

   ALTER TABLE EQMOVPROD ADD CODEMPTM INTEGER;
   ALTER TABLE EQMOVPROD ADD CODFILIALTM SMALLINT;
   ALTER TABLE EQMOVPROD ADD CODTIPOMOV INTEGER;
   ALTER TABLE EQMOVPROD ADD ESTOQMOVPROD CHAR(1);
   COMMIT WORK;

   ALTER TABLE EQINVPROD ADD CODEMPTM INTEGER;
   ALTER TABLE EQINVPROD ADD CODFILIALTM SMALLINT;
   ALTER TABLE EQINVPROD ADD CODTIPOMOV INTEGER;
   ALTER TABLE EQINVPROD ADD PRECOINVP NUMERIC(15,3);
   COMMIT WORK;

    
   
-- 3. ATUALIZAR

   UPDATE SGPREFERE1 SET ESTNEG='S', ESTLOTNEG='S';
   COMMIT WORK;

   DROP TRIGGER EQINVPRODTGBU;
   DROP TRIGGER EQINVPRODTGAU;
   COMMIT WORK;
   DROP TRIGGER EQMOVPRODTGBU;
   DROP TRIGGER EQMOVPRODTGAU;
   DROP TRIGGER EQMOVPRODAD;
   COMMIT WORK;

   UPDATE EQINVPROD SET PRECOINVP=CUSTOMPMINVP;
   COMMIT WORK;

   UPDATE EQINVPROD IV SET 
       IV.CODEMPTM = ( SELECT CODEMP FROM EQTIPOMOV WHERE ESTIPOMOV='I' AND TIPOMOV='IV' ),
       IV.CODFILIALTM = ( SELECT CODFILIAL FROM EQTIPOMOV WHERE ESTIPOMOV='I' AND TIPOMOV='IV' ),
       IV.CODTIPOMOV = ( SELECT CODTIPOMOV FROM EQTIPOMOV WHERE ESTIPOMOV='I' AND TIPOMOV='IV' ) ;
   COMMIT WORK;
   
   UPDATE EQMOVPROD SET ESTOQMOVPROD='S';
   COMMIT WORK;   

   DELETE FROM EQMOVPROD WHERE CODINVPROD IS NOT NULL AND CODEMPIV IS NULL ;
   COMMIT WORK;

   UPDATE EQMOVPROD MP SET 
      MP.CODEMPTM = ( SELECT CODEMPTM FROM VDVENDA V WHERE V.CODEMP=MP.CODEMPVD AND V.CODFILIAL=MP.CODFILIALVD AND V.TIPOVENDA=MP.TIPOVENDA AND V.CODVENDA=MP.CODVENDA ),
      MP.CODFILIALTM = ( SELECT CODFILIALTM FROM VDVENDA V WHERE V.CODEMP=MP.CODEMPVD AND V.CODFILIAL=MP.CODFILIALVD AND V.TIPOVENDA=MP.TIPOVENDA AND V.CODVENDA=MP.CODVENDA ),
      MP.CODTIPOMOV = ( SELECT CODTIPOMOV FROM VDVENDA V WHERE V.CODEMP=MP.CODEMPVD AND V.CODFILIAL=MP.CODFILIALVD AND V.TIPOVENDA=MP.TIPOVENDA AND V.CODVENDA=MP.CODVENDA )
   WHERE MP.CODVENDA IS NOT NULL;

   COMMIT WORK;

   UPDATE EQMOVPROD MP SET 
      MP.CODEMPTM = ( SELECT CODEMPTM FROM CPCOMPRA C WHERE C.CODEMP=MP.CODEMPCP AND C.CODFILIAL=MP.CODFILIALCP AND C.CODCOMPRA=MP.CODCOMPRA ),
      MP.CODFILIALTM = ( SELECT CODFILIALTM FROM CPCOMPRA C WHERE C.CODEMP=MP.CODEMPCP AND C.CODFILIAL=MP.CODFILIALCP AND C.CODCOMPRA=MP.CODCOMPRA ),
      MP.CODTIPOMOV = ( SELECT CODTIPOMOV FROM CPCOMPRA C WHERE C.CODEMP=MP.CODEMPCP AND C.CODFILIAL=MP.CODFILIALCP AND C.CODCOMPRA=MP.CODCOMPRA )
   WHERE MP.CODCOMPRA IS NOT NULL;

   COMMIT WORK;
   
   UPDATE EQMOVPROD MP SET 
      MP.CODEMPTM = ( SELECT CODEMPTM FROM EQINVPROD I WHERE I.CODEMP=MP.CODEMPIV AND I.CODFILIAL=MP.CODFILIALIV AND I.CODINVPROD=MP.CODINVPROD ),
      MP.CODFILIALTM = ( SELECT CODFILIALTM FROM EQINVPROD I WHERE I.CODEMP=MP.CODEMPIV AND I.CODFILIAL=MP.CODFILIALIV AND I.CODINVPROD=MP.CODINVPROD ),
      MP.CODTIPOMOV = ( SELECT CODTIPOMOV FROM EQINVPROD I WHERE I.CODEMP=MP.CODEMPIV AND I.CODFILIAL=MP.CODFILIALIV AND I.CODINVPROD=MP.CODINVPROD )
   WHERE MP.CODINVPROD IS NOT NULL;

   COMMIT WORK;

   UPDATE SGPREFERE1 SET ESTNEG='N', ESTLOTNEG='N';

   COMMIT WORK;


   
  
