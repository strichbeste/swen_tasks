# task 1 – single responsibility principle (srp)

## verletzung (bad/)
- `UserManager` hat 3 verantwortungen gleichzeitig:
  - datenbankzugriff
  - authentifizierungslogik
  - email-versand
- jede aenderung (db-schema, email-text, login-logik) betrifft dieselbe klasse
- nicht einzeln testbar

## loesung (good/)
- `UserRepository` – nur datenbankzugriff
- `EmailService` – nur email-versand  
- `AuthService` – nur auth-logik, delegiert an die anderen

## trade-offs
- mehr klassen (mehr dateien)
- aber: jede klasse einzeln testbar und austauschbar
- aenderungen haben kleineren scope
