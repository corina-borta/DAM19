-- Populare tabel Angajati
INSERT INTO ANGAJATI (SALARIU, EMAIL, NUME_ANGAJAT, ROL_ANGAJAT, TELEFON)
VALUES
  (3000, 'john.doe@example.com', 'John Doe', 'Bucatar', '0700123456'),
  (2500, 'jane.smith@example.com', 'Jane Smith', 'Ospatar', '0700987654'),
  (4000, 'emma.brown@example.com', 'Emma Brown', 'Manager', '0700765432');

-- Populare tabel Clienti
INSERT INTO CLIENTI (ACTIV, EMAIL, NUME_CLIENT, TELEFON)
VALUES
  (TRUE, 'client1@example.com', 'Client 1', '0712345678'),
  (TRUE, 'client2@example.com', 'Client 2', '0723456789'),
  (FALSE, 'client3@example.com', 'Client 3', '0734567890');

-- Populare tabel Meniu
INSERT INTO MENIU (NUME_MENIU)
VALUES
  ('Meniu Zilnic'),
  ('Meniu Vegetarian'),
  ('Meniu Special');

-- Populare tabel Comenzi
INSERT INTO COMENZI (STATUS, TOTAL_COMANDA, DATA_COMENZII, NUMAR_MASA, METODA_PLATA, STATUS_PLATA)
VALUES
  ('IN_ASTEPTARE', 100.50, CURRENT_TIMESTAMP, '5', 'CASH', 'NEPLATITA'),
  ('PROCESATA', 150.00, CURRENT_TIMESTAMP, '3', 'CARD', 'PLATITA'),
  ('LIVRATA', 200.75, CURRENT_TIMESTAMP, '2', 'ONLINE', 'PLATITA');

-- Populare tabel Rezervari
INSERT INTO REZERVARI (ID_ANGAJAT, ID_CLIENT, NUMAR_PERSOANE, DATA_REZERVARE, NUME_CLIENT, STATUS_REZERVARE, TIP_MASA)
VALUES
  (1, 1, 4, CURRENT_TIMESTAMP, 'Client 1', 'CONFIRMATA', 'INTERIOR'),
  (2, 2, 2, CURRENT_TIMESTAMP, 'Client 2', 'PENDING', 'EXTERIOR'),
  (3, 3, 6, CURRENT_TIMESTAMP, 'Client 3', 'ANULATA', 'VIP');
