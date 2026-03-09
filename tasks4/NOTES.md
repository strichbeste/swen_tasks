# task 4 – datenbank mit docker

## setup
```bash
# container starten (schema wird automatisch ausgefuehrt)
docker-compose up -d

# verbindung testen
psql -h localhost -U postgres -d tasksdb

# container stoppen (daten bleiben im volume)
docker-compose down

# daten auch loeschen
docker-compose down -v
```

## containerisiert vs. lokal

| aspekt | docker | lokal installiert |
|--------|--------|-------------------|
| reproduzierbarkeit | immer gleiche version | abhaengig vom system |
| teamarbeit | alle nutzen selben stand | jeder konfiguriert selbst |
| debugging | logs per docker logs | direkt zugaenglich |
| isolation | kein konflikt mit anderen dbs | kann kollidieren |

## fehlerbehandlung demo
- container nicht gestartet -> `Connection refused` auf port 5432
- falsches passwort -> `FATAL: password authentication failed`
- falsche query -> `PSQLException: ERROR: column X does not exist`
