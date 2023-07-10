INSERT INTO clients (id, city, code_zip, department, floor, number, street, email, landline_phone, cellphone, last_name, name)
VALUES (1, "Los Angeles", "CodeZip123", "Dept A1", "Floor 0", "234", "Siempre Viva", "homero@gmail.com", "1125465852", "1546345", "Simpson", "Homero");

INSERT INTO clients (id, city, code_zip, department, floor, number, street, email, landline_phone, cellphone, last_name, name)
VALUES (2, "Los Angeles", "CodeZip123", "Dept A1", "Floor 0", "234", "Siempre Viva", "marge@gmail.com", "1125465852", "1986345", "Simpson", "Marge");

INSERT INTO vehicles (id, brand, color, model, patent, year)
VALUES (1, "Peugeot", "Gray", "208", "AB123CD", 2015);

INSERT INTO vehicles (id, brand, color, model, patent, year)
VALUES (2, "Citroen", "Black", "C4", "AC753CD", 2018);

INSERT INTO rel_clients_vehicles (client_id, vehicle_id) VALUES (1, 1);