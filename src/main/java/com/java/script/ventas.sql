CREATE TABLE `prueba`.`administrador` (
                                          `chrAdmCodigo` CHAR(10) NOT NULL,
                                          `chrAdmLogin` CHAR(10) NOT NULL,
                                          `chrAdmPassword` CHAR(10) NOT NULL,
                                          `vchAdmNombres` VARCHAR(45) NOT NULL,
                                          `vchAdmApellidos` VARCHAR(45) NOT NULL,
                                          PRIMARY KEY (`chrAdmCodigo`),
                                          UNIQUE INDEX `chrAdmCodigo_UNIQUE` (`chrAdmCodigo` ASC) VISIBLE);


CREATE TABLE `ventas`.`cliente` (
                                     `idcli` INT NOT NULL AUTO_INCREMENT,
                                     `nombres` VARCHAR(45) NOT NULL,
                                     `totalCompras` DECIMAL NOT NULL,
                                     UNIQUE INDEX `idcli_UNIQUE` (`idcli` ASC) VISIBLE,
                                     PRIMARY KEY (`idcli`));

INSERT INTO `prueba`.`administrador`
(`chrAdmCodigo`,
 `chrAdmLogin`,
 `chrAdmPassword`,
 `vchAdmNombres`,
 `vchAdmApellidos`)
VALUES
    ('A0001',
     'admin',
     'admin',
     'Mario ',
     'Huaman Flores');

INSERT INTO `ventas`.`cliente`(`idcli`, `nombres`, `totalCompras`)VALUES(1,'Carlos Fernandez',100.0);
INSERT INTO `ventas`.`cliente`(`idcli`, `nombres`, `totalCompras`)VALUES(2,'Maria Carrascp',1000.0);
INSERT INTO `ventas`.`cliente`(`idcli`, `nombres`, `totalCompras`)VALUES(3,'Adrian Huaman',300.0);
INSERT INTO `ventas`.`cliente`(`idcli`, `nombres`, `totalCompras`)VALUES(4,'Pedro Fernandez',500.0);
INSERT INTO `ventas`.`cliente`(`idcli`, `nombres`, `totalCompras`)VALUES(5,'Diego Becerra',1100.0);


