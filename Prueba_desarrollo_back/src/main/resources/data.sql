
INSERT INTO `raza` (`idraza`, `nombre`) VALUES ('123', 'labrador'),
                                               ('145', 'angolo'),
                                               ('189', 'Afgano'),
                                               ('983', 'persa'),
                                                ('984','pitbull'),
                                                ('567','Guacamaya Bandera');



INSERT INTO `especie` (`idespecie`, `nombre`, `fk_raza`) VALUES ('1', 'perro', '123'),
                                                                 ('2', 'gato', '983'),
                                                                 ('5', 'Guacamaya', '567');




INSERT INTO `amo` (`idamo`, `tipoid`, `nombre`, `telefono`, `ciudad`, `direccion`) VALUES ('12344', 'cc', 'dario', '1284151', 'Monteria', 'calla x #45'),
                                                                                          ('23445', 'cc', 'maria', '3456778', 'Barranquilla', ' calle g #67');



INSERT INTO `paciente` (`idpaciente`, `nombre`, `fechaNapaciente`, `fechaRegistro`, `fk_especie`, `fk_amo`) VALUES ('1', 'firulais', '2023-01-20', '2023-01-25', '1', '12344'),
                                                                                                                    ('2', 'manbru', '2018-02-15', '2023-01-28', '2', '23445'),
                                                                                                                    ('3', 'tobi', '2015-10-24', '2023-02-01', '1', '23445');





