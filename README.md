# MiddleMeet

**Semesterarbeit NDK HF Grundlagen Software-Entwicklung**\
von Cla Tschenett und Patrick Stoffel

**Motivation**\
MiddleMeet ist ein Tool, um den optimalen Treffpunkt zwischen zwei Orten zu berechnen. Das Tool ermöglicht
dem User, zwei Orte einzugeben, um anhand von Google Maps Daten zu berechnen, welcher Ort sich genau
zwischen den beiden befindet. Der Anwender erhält als Resultat folgende Informationen zurück:

• Ortsname des Treffpunktes auf halber Strecke\
• Distanz bis zum Treffpunkt \
• Fahrzeit bis zum Treffpunkt \
• Grafische Übersicht der Situation in Google Maps Darstellung (Kartenausschnitt)

**How to use**\
Die Applikation läss sich in der IDE über die MiddleMeet-Java-Klasse starten.\
Nach dem Start der Applikation erscheint der nachfolgende Startscreen:\
![alt tag](resources/startscreen.jpg)

Hier hat der Benutzer die Möglichkeit zwei Orte einzugeben.\
Die Angabe eines Landes ist optional. Sie soll dabei helfen, einen Ortsnamen eindeutig zu
identifizieren, falls dieser mehrfach existiert.

Eine falsche Eingabe wird druch das GUI entsprechend dargestellt:\
![alt tag](resources/errorscreen.jpg)

**Unit Tests**\
Die laufen nicht automatisiert. Sie müssen in der IDE von Hand gestartet werden.\
z.B. in IntelliJ: Rechtsklick auf das Test-Verzeichnis und "Run all test" auswählen.