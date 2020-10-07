create database if not exists projeto_ed;
use projeto_ed;
create table if not exists cliente
(
    cod_cliente integer      not null auto_increment,
    email       varchar(120) not null,
    tipo        varchar(20)  not null,
    primary key (cod_cliente)
);
create table if not exists telefone
(
    cod_cliente integer     not null auto_increment,
    telefone    varchar(15) not null,
    primary key (cod_cliente),
    foreign key (cod_cliente) references cliente (cod_cliente)
);
create table if not exists pessoa_fisica
(
    cod_cliente     integer,
    nome            varchar(120),
    cpf             varchar(11),
    data_nascimento date,
    foreign key (cod_cliente) references cliente (cod_cliente),
    primary key (cod_cliente)
);
create table if not exists pessoa_juridica
(
    cod_cliente  integer,
    cnpj         varchar(14),
    razao_social varchar(120),
    primary key (cod_cliente),
    foreign key (cod_cliente) references cliente (cod_cliente)
);
create table if not exists pedido
(
    cod_pedido  integer not null auto_increment,
    cod_cliente integer not null,
    date        date    not null,
    rua         varchar(30),
    numero      varchar(6),
    complemento varchar(30),
    cidade      varchar(30),
    estado      char(2),
    primary key (cod_pedido),
    foreign key (cod_cliente) references cliente (cod_cliente)
);
create table if not exists empresa
(
    cod_empresa  integer      not null auto_increment,
    razao_social varchar(120) not null,
    cnpj         varchar(14)  not null,
    rua          varchar(30),
    numero       varchar(6),
    bairro       varchar(30),
    complemento  varchar(30),
    cidade       varchar(30),
    estado       char(2),
    primary key (cod_empresa)
);
create table if not exists produto
(
    cod_produto    integer not null auto_increment,
    cod_empresa    integer not null,
    descricao      varchar(120),
    valor_unidade  float   not null,
    qtd_disponivel bigint,
    unidade        varchar(120),
    primary key (cod_produto),
    foreign key (cod_empresa) references empresa (cod_empresa)
);
create table if not exists itens_pedido
(
    cod_pedido  integer not null,
    cod_produto integer not null,
    cod_empresa integer not null,
    primary key (cod_pedido, cod_produto, cod_empresa),
    foreign key (cod_empresa) references empresa (cod_empresa),
    foreign key (cod_produto) references produto (cod_produto),
    foreign key (cod_pedido) references pedido (cod_pedido)
);

insert into empresa
values (null,
        'Casas Bahia',
        '192837465',
        'Vinte e Cinco',
        '150A',
        'Centro',
        null,
        'Sao Paulo',
        'SP');
insert into empresa
values (null,
        'Americanas',
        '1928367674',
        'Vinte e Tres',
        '276',
        'Centro',
        null,
        'Sao Paulo',
        'SP');
insert into empresa
values (null,
        'Mackenzie',
        '18293047856',
        'Consolacao',
        '530',
        'Higienopolis',
        null,
        'Sao Paulo',
        'SP');
insert into empresa
values (null,
        'Submarino',
        '123',
        'Vinte e Cinco',
        '200',
        'Lapa',
        null,
        'Sao Paulo',
        'SP');
insert into empresa
values (null,
        'Cromai',
        '133',
        'Hamburguesa',
        '1500',
        'Vila Lobos',
        null,
        'Sao Paulo',
        'SP');
insert into empresa
values (null,
        'Amazon',
        '1423',
        'EUA',
        '6',
        'Beverly Hills',
        null,
        'Los Angeles',
        'CA');