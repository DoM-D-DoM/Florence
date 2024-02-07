# Applicazione Dockerizzata User Florence

## Descrizione
Questa applicazione Dockerizzata fornisce una serie di servizi REST per la gestione dei dati attraverso diverse operazioni, tra cui GET, ADD, UPDATE, DELETE
e caricamento di file CSV. L'applicazione è progettata per essere containerizzata usando Docker per una facile distribuzione e scalabilità.

## Indice
- [Installazione](#installazione)
- [Utilizzo](#utilizzo)
- [Endpoint API](#endpoint-api)
- [Variabili d'Ambiente](#variabili-dambiente)
- [Docker Compose](#docker-compose)
- [ENJOY!](#enjoy)

## Installazione
Per eseguire questa applicazione Dockerizzata, assicurati che Docker e Docker Compose siano installati sul tuo sistema. Segui i passaggi seguenti:

1. Clona il repository:
   ```bash
   git clone https://github.com/DoM-D-DoM/Florence.git
   ```

2. Entra nella directory dell'app:
   ```bash
   cd Florence
   ```

3. Esegui il comando Docker Compose per avviare l'applicazione:
   ```bash
   docker-compose up -d
   ```

## Utilizzo
L'applicazione è ora in esecuzione e pronta per essere utilizzata attraverso gli endpoint API forniti.

## Endpoint API
La seguente lista presenta gli endpoint API disponibili. Puoi sostituire questi placeholder con le tue chiamate REST originali.

- `GET (http://TUOINDIRIZZO/florence/user)`: Ottieni la lista degli user
- `POST http://TUOINDIRIZZO/florence/user`: Aggiungi user
- `PUT http://TUOINDIRIZZO/florence/user`: Aggiorna user
- `DELETE http://TUOINDIRIZZO/florence/user/{id}`: Elimina l'user tramite id
- `GET http://TUOINDIRIZZO/florence/user/search/{filtro}`: Ricerca user per filtro dove filtro è nome o cognome
- `GET http://TUOINDIRIZZO/florence/user/{id}`: Ricerca user per ID
- `POST http://TUOINDIRIZZO/florence/upload/addcsv`: Carica file CSV

## Variabili d'Ambiente
L'applicazione utilizza alcune variabili d'ambiente. Assicurati di configurarle nel tuo ambiente o di fornirle durante l'esecuzione del container Docker.

- `SPRING_DATASOURCE_URL`: URL del database

## Docker Compose
Puoi utilizzare il comando seguente per arrestare e rimuovere i container:

- Arresta e rimuovi i container:
  ```bash
  docker-compose down
  ```

## ENJOY!
