
CREATE TABLE Departamento (
                departamento_id INT AUTO_INCREMENT NOT NULL,
                nome VARCHAR(45) NOT NULL,
                email VARCHAR(45) DEFAULT null,
                telefone VARCHAR(45) DEFAULT null,
                numeroResidencia INT DEFAULT null,
                PRIMARY KEY (departamento_id)
);


CREATE TABLE Tramitacao (
                id INT AUTO_INCREMENT NOT NULL,
                descricao VARCHAR(45) NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE TipoSolicitante (
                tipo_solicitante_id INT AUTO_INCREMENT NOT NULL,
                descricao VARCHAR(45) NOT NULL,
                PRIMARY KEY (tipo_solicitante_id)
);


CREATE TABLE TipoOcorrencia (
                tipo_ocorrencia_id INT AUTO_INCREMENT NOT NULL,
                descricao VARCHAR(45) NOT NULL,
                PRIMARY KEY (tipo_ocorrencia_id)
);


CREATE TABLE Perfil (
                perfil_id INT AUTO_INCREMENT NOT NULL,
                descricao VARCHAR(45) NOT NULL,
                PRIMARY KEY (perfil_id)
);


CREATE TABLE OrigemOcorrencia (
                origem_ocorrencia_id INT AUTO_INCREMENT NOT NULL,
                descricao VARCHAR(45) NOT NULL,
                PRIMARY KEY (origem_ocorrencia_id)
);


CREATE TABLE Solicitante (
                solicitante_id INT AUTO_INCREMENT NOT NULL,
                tipo_solicitante_id INT NOT NULL,
                email VARCHAR(60),
                nome VARCHAR(60) NOT NULL,
                numero_residencia INT NOT NULL,
                PRIMARY KEY (solicitante_id, tipo_solicitante_id)
);


CREATE TABLE Funcionario (
                funcionario_id INT AUTO_INCREMENT NOT NULL,
                Perfil_id INT NOT NULL,
                email VARCHAR(60) NOT NULL,
                nome VARCHAR(60) NOT NULL,
                senha VARCHAR(90) NOT NULL,
                PRIMARY KEY (funcionario_id, Perfil_id)
);


CREATE TABLE Endereco (
                endereco_id INT NOT NULL,
                bairro VARCHAR(60) NOT NULL,
                nome VARCHAR(60) NOT NULL,
                cep VARCHAR(15) NOT NULL,
                regiao VARCHAR(45) NOT NULL,
                PRIMARY KEY (endereco_id)
);


CREATE TABLE Ocorrencia (
                ocorrencia_id INT NOT NULL,
                endereco_id INT NOT NULL,
                funcionario_id INT NOT NULL,
                solicitante_id INT NOT NULL,
                tipo_ocorrencia_id INT NOT NULL,
                origem_ocorrencia_id INT NOT NULL,
                data_abertura DATE NOT NULL,
                data_atendimento DATE DEFAULT null,
                data_conclusao DATE DEFAULT null,
                status VARCHAR(45) DEFAULT null,
                tipoOcorrencia VARCHAR(45) NOT NULL,
                historicoInicial VARCHAR(300) DEFAULT null,
                origemOcorrencia INT NOT NULL,
                numeroLocal INT DEFAULT null,
                PRIMARY KEY (ocorrencia_id, endereco_id, funcionario_id, solicitante_id, tipo_ocorrencia_id, origem_ocorrencia_id)
);


CREATE TABLE Relatorio (
                relatorio_id INT NOT NULL,
                funcionario_id INT NOT NULL,
                ocorrencia_id INT NOT NULL,
                endereco_id INT NOT NULL,
                Tramitacao_id INT NOT NULL,
                numero_local INT NOT NULL,
                observacao VARCHAR(1200),
                vistoria VARCHAR(1200) NOT NULL,
                PRIMARY KEY (relatorio_id, funcionario_id, ocorrencia_id, endereco_id, Tramitacao_id)
);


ALTER TABLE Relatorio ADD CONSTRAINT tramitacao_relatorio_fk
FOREIGN KEY (Tramitacao_id)
REFERENCES Tramitacao (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Solicitante ADD CONSTRAINT tiposolicitante_solicitante_fk
FOREIGN KEY (tipo_solicitante_id)
REFERENCES TipoSolicitante (tipo_solicitante_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Ocorrencia ADD CONSTRAINT tipoocorrencia_ocorrencia_fk
FOREIGN KEY (tipo_ocorrencia_id)
REFERENCES TipoOcorrencia (tipo_ocorrencia_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Funcionario ADD CONSTRAINT perfil_funcionario_fk
FOREIGN KEY (Perfil_id)
REFERENCES Perfil (perfil_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Ocorrencia ADD CONSTRAINT origemocorrencia_ocorrencia_fk
FOREIGN KEY (origem_ocorrencia_id)
REFERENCES OrigemOcorrencia (origem_ocorrencia_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Ocorrencia ADD CONSTRAINT solicitante_ocorrencia_fk
FOREIGN KEY (solicitante_id)
REFERENCES Solicitante (solicitante_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Ocorrencia ADD CONSTRAINT funcionario_ocorrencia_fk
FOREIGN KEY (funcionario_id)
REFERENCES Funcionario (funcionario_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Relatorio ADD CONSTRAINT funcionario_relatorio_fk
FOREIGN KEY (funcionario_id)
REFERENCES Funcionario (funcionario_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Ocorrencia ADD CONSTRAINT endereco_ocorrencia_fk
FOREIGN KEY (endereco_id)
REFERENCES Endereco (endereco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Relatorio ADD CONSTRAINT endereco_relatorio_fk
FOREIGN KEY (endereco_id)
REFERENCES Endereco (endereco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Relatorio ADD CONSTRAINT ocorrencia_relatorio_fk
FOREIGN KEY (ocorrencia_id, endereco_id)
REFERENCES Ocorrencia (ocorrencia_id, endereco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
