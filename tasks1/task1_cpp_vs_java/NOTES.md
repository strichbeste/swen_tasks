# task 1 – vergleich c++ vs java

## wichtigste unterschiede

| aspekt | c++ | java |
|--------|-----|------|
| speicher | manuell (new/delete) | garbage collector |
| vererbung | mehrfachvererbung | nur einfach (interfaces fuer mehrfach) |
| virtuelle methoden | explizit `virtual` | standardmaessig virtuell |
| override | optional `override` | `@Override` annotation |
| kompilierung | direkter maschinencode | bytecode -> jvm |
| plattform | plattformabhaengig | plattformunabhaengig (jvm) |
| object slicing | moeglich | nicht moeglich |
| nullpointer | undefined behavior | nullpointerexception (gecatcht) |

## was beim debug anders ist
- java: exceptions haben stack trace, c++ hat undefined behavior
- java: kein segfault, stattdessen arrayindexoutofboundsexception etc.
- java: jvm gibt klare fehlermeldungen, c++ crasht oft ohne hinweis
