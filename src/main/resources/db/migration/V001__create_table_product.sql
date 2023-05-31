create table products (
    id uuid primary key,
    description varchar not null,
    height numeric not null,
    width numeric not null,
    "length" numeric not null,
    weight numeric not null,
    price numeric not null
);

insert into products (id, description, height, width, "length", weight, price) values
('4bd2b777-b279-44e0-beb5-4e10b25d88ab', 'Camera', 20.0, 15.0, 10.0, 1.0, 100.0),
('9f65c1f0-ea34-414f-af4f-4b54bb2e7cec', 'Guitarra', 100.0, 30.0, 10.0, 3.0, 300.0),
('e3ef4b07-d115-4263-9c48-0a41b8f1a454', 'Geladeira', 200.0, 100.0, 50.0, 40.0, 3500.0);
