## Testfall 002 Create Additional Info v1.0

Änderungsdatum: 10.01.2025 <br>
Ersteller: Leandro Aepli <br>

Ausführungsdatum: 10.01.2025 <br>
Ausführende: Leandro Aepli <br>

### Beschreibung
Beschreibt wie man zusätzliche Informationen zu einem bestehenden oder erstelltem Kontakt hinzufügen kann.

### Voraussetzungen
* Applikation wurde gestartet.

### Testdaten
Additional Private Info:
Private Phone: `081 122 34 12`
Private Email: `max.mustermann@example.com`
Street: `Grabenstrasse`
Housenumber: `15`
HousenumberAddon: `3. Stock`
ZipCode: `7000`
City: `Chur`

### Ausführungsschritte
1. Beliebigen Kontakt auswählen
2. Auf "Settings" Tab drücken
3. Auf "Private Info" drücken
4. Den neuen Tab anwählen
5. Auf "Edit" drücken
6. Daten eingeben
7. "Save" Button drücken
8. Den Tab erneut anwählen und abgespeicherte Daten überprüfen

### Erwartetes Ergebnis
Ein neuer Tab namens Private Info wird erstellt.
Der Tab enthält die angegebenen Testdaten.

### Tatsächliches Ergebnis
Ein neuer Tab namens Private Info wurde erstellt.
Der Tab enthält die angegebenen Testdaten.

### Beurteilung
1. Beliebiger Kontakt wurde ausgewählt
2. Der "Settings" Tab wurde gedrückt
3. Der "Private Info" Tab wurde gedrückt
4. Der neue Tab wurde angewählt
5. Der "Edit" Button wurde gedrückt
6. Daten wurden eingeben
7. "Save" wurde Button gedrückt
8. Der Tab wurde erneut angewählt und die abgespeicherten Daten überprüft

### Gesamtbeurteilung
Alles verhaltet sich wie erwartet. <br>
Ergebnis: **BESTANDEN**

### Nachbedingungen
Der User kann nun neue tabs oder mehr Kontakte hinzufügen.
Ausserdem kann er sich andere Kontakte anschauen oder sie mit der Suche Filtern.
Der User kann die erstellten Daten bearbeiten.