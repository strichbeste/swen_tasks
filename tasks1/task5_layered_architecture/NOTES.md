# task 5 – layered architecture

## schichten und ihre verantwortung

```
+------------------+
|      ui/         |  presentation layer: ein-/ausgabe, benutzerinteraktion
+------------------+
|    service/      |  business logic layer: fachlogik, regeln
+------------------+
|   repository/    |  data access layer: datenbankzugriff, persistence
+------------------+
|     model/       |  domain layer: datenklassen, entitaeten
+------------------+
```

## warum diese trennung?
- ui kann ausgetauscht werden (console -> web) ohne service zu aendern
- repository kann ausgetauscht werden (in-memory -> postgres) ohne service zu aendern
- jede schicht ist einzeln testbar
- aenderungen in einer schicht betreffen andere nicht
