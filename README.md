# basic-word-count

Ce projet amateur entre dans le cadre de "hadoop initiatif", ce premier volet a pour but de tester les différentes environnements de développement et de déployement hadoop.

Les classes sont copiées depuis le tutoriel d'apache :
https://hadoop.apache.org/docs/stable/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html

Environnement de développement :
jdk 1.8
git 1.3
maven 3.5
eclipse IDE for Java
hadoop 2.9

Environnement de déployement local :
apache hadoop 2.9 sur répertoires in et out locaux

Environnement de déployement avancé :
Docker
Image Cloudera ou MapR version standard (gratuites), ou installation mannuel des composants.

A venir / en cours :
Modification des algorithmes de comptage, et ajout de fonctionnalités basiques.
Augmentation du volume des jeux de tests : http://www.hadooplessons.info/2013/06/data-sets-for-practicing-hadoop.html
Tests des différentes composant notamment Hbase, Hive et Pig.
Remplacement du Map réduce par Spark (Java)
Test de remplacement de Map-Reduce par Spark (Java)
Test de performance.
