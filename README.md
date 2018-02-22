# word-count

Ce projet a pour but de tester les différentes environnements de développement et de déployement hadoop, et de découvrir les classes / composants de base de l'écosystème hadoop.


Environnement de développement actuel :
* jdk 1.8
* git 1.3
* maven 3.5
* eclipse IDE for Java
* hadoop 2.9

Environnement de déployement local :
* apache hadoop 2.9 sur répertoires in et out locaux

Environnement de déployement avancé :
* Docker
* Image Cloudera ou MapR édition standard (gratuites), ou installation mannuel des composants.
voir tuto : https://github.com/depysk/big-data/blob/master/hortonworks_sandbox.adoc

Ce projet d'initiation est séparé en plusieurs 3 parties, et a été conçu dans l'optique de maîtriser les bases de l'écosystème hadoop à la fin du développement.


## basic-word-count

Cette partie a pour but de tester les différentes environnements de développement et de déployement hadoop.

Elle comporte une seule classe très simple : **BasicWordCount.java** qui a été copié directement depuis les tutoriels d'apache : https://hadoop.apache.org/docs/stable/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html 

Pour l'installer, rien de plus simple : utiliser un logiciel git (sourceTree par exemple) pour tirer le projet, puis l'importer en tant que projet Maven dans eclipse, on peut alors commencer à le modifier !

Tests rapide en local : 
1. récupéré préalablement l'hadoop 2.0 depuis le site d'apache : http://hadoop.apache.org/releases.html , puis l'installer en local (dézipper et ajouter le bin dans le PATH).
2. Faire un maven install sur le projet dans eclipse, et un fichier word-count-0.0.1-SNAPSHOT.jar sera généré dans le dossier target.
3. Créer un dossier qui sera utiliser pour faire les tests, mettre le jar dans ce dossier.
Mettre ce fichier dans le dossier où hadoop 2.9 a été dézipé, et créer 1 répertoire "in", puis placer un fichier texte dans le dossier "in", par exemple ce README, et lancer la commande : **hadoop jar word-count-0.0.1-SNAPSHOT.jar fr.hadoop.initiatif.basicwordcount.BasicWordCount in out**
4. les résultats sont placés directement dans le dossier out :)


## advance-word-count

Cette partie est actuellement en cours, les tâches prévues pour cette classe :
* familariser les classes de base de la librairie hadoop en modifiant l'algorithme de comptage.
* ajouter des classes de tests.
* chercher s'il est possible de lancer la classe depuis Eclipse (plugin hadoop ou test unitaire / intégration), de façon à faciliter les tests et éventuellement pouvoir lancer en mode débuggage.
* augmenter le volume de données : http://www.hadooplessons.info/2013/06/data-sets-for-practicing-hadoop.html


## complexe-word-count

à venir :
* ajout et utilisation des différentes composant notamment Hbase, Hive et Pig.
* installer et utiliser Docker avec un environnement proche de la production.
* Test de performance.


## pour aller plus loin

* Créer un projet ayant pour but de résoudre un problème réel, en utilisant toutes les connaissances aquises précédamment.
* tests avec Spark.
