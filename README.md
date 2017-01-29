# MiddleMeet

**Semesterarbeit NDK HF Grundlagen Software-Entwicklung**<br />
von Cla Tschenett und Patrick Stoffel

**Motivation**<br />
MiddleMeet ist ein Tool, um den optimalen Treffpunkt zwischen zwei Orten zu berechnen. Das Tool ermöglicht
dem User, zwei Orte einzugeben, um anhand von Google Maps Daten zu berechnen, welcher Ort sich genau
zwischen den beiden befindet. Der Anwender erhält als Resultat folgende Informationen zurück:

• Ortsname des Treffpunktes auf halber Strecke<br />
• Distanz bis zum Treffpunkt<br />
• Fahrzeit bis zum Treffpunkt<br />
• Grafische Übersicht der Situation in Google Maps Darstellung (Kartenausschnitt)

**How to use**<br />
Die Applikation läss sich in der IDE über die MiddleMeet-Java-Klasse starten.<br />
Nach dem Start der Applikation erscheint der nachfolgende Startscreen:<br />
![alt tag](resources/startscreen.jpg)

Hier hat der Benutzer die Möglichkeit zwei Orte einzugeben.<br />
Die Angabe eines Landes ist optional. Sie soll dabei helfen, einen Ortsnamen eindeutig zu
identifizieren, falls dieser mehrfach existiert.<br />
Nach erfolgreicher Eingabe wird das Ergebnis mit folgenden Infos angezeigt:

• Ortsname des Treffpunktes<br />
• Distanz bis zum Treffpunkt<br />
• Fahrzeit bis zum Treffpunkt<br />

Eine falsche Eingabe wird druch das GUI entsprechend dargestellt:<br />
![alt tag](resources/errorscreen.jpg)

**Unit Tests**<br />
Die laufen nicht automatisiert. Sie müssen in der IDE von Hand gestartet werden.<br />
z.B. in IntelliJ: Rechtsklick auf das Test-Verzeichnis und "Run all test" auswählen.

**Aufbau der Applikation**<br />
Die Applikation ist nach dem MVC-Paradigma aufgebaut. 
Über die die MiddleMeet-Klasse wird die Applikation gestartet.<br />
![alt tag](resources/mvc.jpg)

Weiter verfügt die Applikation über die folgenden Hilfsklassen:<br />

• Geocoding: Holt von der Google Maps Geocoding API Koordinatendaten ab<br />
• JSONParser: Liest ein JSON Objekt von einer URL ein<br />
• Snapshoter: Nutzt die Gooogle Static Maps API um Kartensnapshots zu erstellen<br />
• UmlauteParser: Ersetzt alle Umlaute in einem String

