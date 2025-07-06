## Testfall 001 Create Contact v1.0

Änderungsdatum: 13.01.2025 <br>
Ersteller: Leandro Aepli <br>

Ausführungsdatum: 10.01.2025 <br>
Ausführende: Leandro Aepli <br>

### Beschreibung
Beschreibt wie ein Kontakt erstellt wird.

### Voraussetzungen
* Applikation wurde gestartet.

### Testdaten
Vorname: `Max` <br>
Nachname: `Mustermann` <br>
Datum: `10.01.2025` <br>
Image: `assets/MaxMustermann.png`

### Ausführungsschritte
1. "Create" Button drücken
2. "Edit" Button drücken
3. Vorname und Nachname Felder ausfüllen
4. Auf "..." Button im "Datum" Feld drücken
5. Datum auswählen
6. "Select Image" Button drücken
7. Bild im Dialog auswählen
8. "Speichern" Button drücken

### Erwartetes Ergebnis
Die View updated sich und zeigt den neuen Kontakt an.
Der neue Kontakt soll die Daten anzeigen die angegeben wurden.
Dem User wird der "Base Info" Tab angezeigt.

### Tatsächliches Ergebnis
Die View updated sich und zeigt den neuen Kontakt an.
Der neue Kontakt zeigt die Daten an, die angegeben wurden.
Dem User wird der "Base Info" Tab angezeigt.

### Beurteilung
1. "Create" Button wurde gedrückt
2. "Edit" Button wurde gedrückt
3. Vorname und Nachname Felder wurden ausgefüllt
4. Auf "..." Button im Datum drücken
5. Datum ausgewählt
6. "Select Image" Button gedrückt
7. Bild im Dialog ausgewählt
8. "Speichern" Button gedrückt

### Gesamtbeurteilung
Alles verhaltet sich wie erwartet. <br>
Ergebnis: **BESTANDEN**

### Nachbedingungen
Der User kann nun neue tabs oder mehr Kontakte hinzufügen.
Ausserdem kann er sich andere Kontakte anschauen oder sie mit der Suche Filtern.
Der User kann die erstellten Daten bearbeiten.
