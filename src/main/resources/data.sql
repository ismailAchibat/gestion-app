insert into gare(id, nom, nombre_quais) values (0, 'Le Mans', 1);
insert into gare(id, nom, nombre_quais) values (1, 'Paris Montparnasse', 28);
insert into gare(id, nom, nombre_quais) values (2, 'Lille Flandres', 17);
insert into gare(id, nom, nombre_quais) values (3, 'Marseille Saint-Charles', 16);
insert into gare(id, nom, nombre_quais) values (4, 'Bordeaux Saint-Jean', 15);

insert into train(id, matricule) values (0, '1234');
insert into train(id, matricule) values (1, '5678');
insert into train(id, matricule) values (2, 'ABCD');
insert into train(id, matricule) values (3, 'EFGH');
insert into train(id, matricule) values (4, 'IJKL');

-- Insert Trajets
insert into trajet(id, gare_depart_id, gare_arrivee_id) values (0, 0, 1); -- Le Mans to Paris Montparnasse
insert into trajet(id, gare_depart_id, gare_arrivee_id) values (1, 1, 0); -- Paris Montparnasse to Le Mans
insert into trajet(id, gare_depart_id, gare_arrivee_id) values (2, 1, 2); -- Paris Montparnasse to Lille Flandres

-- Insert Horaires
insert into horaire(id, trajet_id, heure_depart, heure_arrivee, train_id) values (0, 0, '08:00:00', '09:00:00', 0);
insert into horaire(id, trajet_id, heure_depart, heure_arrivee, train_id) values (1, 0, '09:30:00', '10:30:00', 1);
insert into horaire(id, trajet_id, heure_depart, heure_arrivee, train_id) values (2, 1, '17:00:00', '18:00:00', 0);
insert into horaire(id, trajet_id, heure_depart, heure_arrivee, train_id) values (3, 2, '10:00:00', '11:00:00', 1);


insert into chemin_de_fer(id, gare_depart_id, gare_arrivee_id, distance, nb_voies)
values (10, 1, 2, 12.5, 1);

insert into chemin_de_fer(id, gare_depart_id, gare_arrivee_id, distance, nb_voies)
values (11, 1, 3, 42.0, 2);
