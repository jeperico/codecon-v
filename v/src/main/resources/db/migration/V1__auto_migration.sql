create table batches (id uuid not null, created_at timestamp(6) not null, is_active boolean not null, updated_at timestamp(6) not null, event varchar(255), total integer not null, primary key (id));
create table reservations (id uuid not null, created_at timestamp(6) not null, is_active boolean not null, updated_at timestamp(6) not null, cpf varchar(11) not null, quantity integer not null, status varchar(255) not null, primary key (id));
alter table if exists reservations drop constraint if exists UKcp1uvbeiaglprt0sfrpughrig;
alter table if exists reservations add constraint UKcp1uvbeiaglprt0sfrpughrig unique (cpf);
