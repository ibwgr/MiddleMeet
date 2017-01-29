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
Die Applikation lässt sich in der IDE über die MiddleMeet-Java-Klasse starten.<br />
Nach dem Start der Applikation erscheint der nachfolgende Startscreen:<br />
![alt tag](resources/startscreen.jpg)

Hier hat der Benutzer die Möglichkeit zwei Orte einzugeben.<br />
Die Angabe eines Landes ist optional. Sie soll dabei helfen, einen Ortsnamen eindeutig zu
identifizieren, falls dieser mehrfach existiert.<br />
Nach erfolgreicher Eingabe wird das Ergebnis mit den nachfolgenden Infos plus einem Kartenausschnitt angezeigt:

• Ortsname des Treffpunktes<br />
• Distanz bis zum Treffpunkt<br />
• Fahrzeit bis zum Treffpunkt<br />
![alt tag](resources/resultscreen.jpg)

Eine falsche Eingabe wird durch das GUI entsprechend dargestellt:<br />
![alt tag](resources/errorscreen.jpg)

**Unit Tests**<br />
Die Unit Tests laufen nicht automatisiert. Sie müssen in der IDE von Hand gestartet werden.<br />
z.B. in IntelliJ: Rechtsklick auf das Test-Verzeichnis und "Run all Tests" auswählen.

**Aufbau der Applikation**<br />
Die Applikation ist nach dem MVC-Paradigma aufgebaut. 
Über die MiddleMeet-Klasse wird die Applikation gestartet.<br />
![alt tag](resources/mvc.jpg)

Weiter verfügt die Applikation über die folgenden Hilfsklassen:<br />

• Geocoding: Holt von der Google Maps Geocoding API Koordinatendaten ab.<br />
• JSONParser: Liest ein JSON Objekt von einer URL ein.<br />
• Snapshoter: Nutzt die Gooogle Static Maps API um Kartensnapshots zu erstellen.<br />
• UmlauteParser: Ersetzt alle Umlaute in einem String.

**API Dokumentation**<br />
Die Dokumentation zur genutzten Google Maps API findet sich unter: https://developers.google.com/maps/documentation/<br />
Unter der Rubrik Web Service API finden sich sämtliche Beschreibungen zu den genutzten Diensten.

**Javadoc**<br />
Der Javadoc der ganzen Applikation findet sich im Projektverzeichnis unter doc.