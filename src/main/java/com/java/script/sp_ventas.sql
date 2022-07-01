
CREATE PROCEDURE sp_ins_cliente(in idcli int(1),in nombres VARCHAR(50), in totalCompras decimal(3,2))
     insert into cliente values(idcli,nombres,totalCompras);

CREATE PROCEDURE sp_upd_cliente(in cod CHAR(3),in nom VARCHAR(50), in cre int(2))
     update curso set vchCurNombre=nom, intCurCreditos=cre where chrCurCodigo=cod;

CREATE PROCEDURE sp_del_cliente(in cod int(1))
     delete from cliente where idcli=cod;

CREATE PROCEDURE sp_findAll_cliente()
     select * from cliente;

CREATE PROCEDURE sp_find_cliente(in cod int(1))
     select * from cliente where idcli=cod;

CREATE PROCEDURE sp_login(in user CHAR(10),in pass CHAR(10))
     select * from administrador where chrAdmLogin=user and chrAdmPassword=pass;

