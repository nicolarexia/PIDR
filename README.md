# PIDR

Projet interdisciplinaire de recherche de Maxime Louis et Nicolas Warnet.


La procédure d'installation de l'environnement webPLM appliquée à notre projet de recherche est détaillée dans ce paragraphe.

- D'abord, extraire l'archive .zip sur la machine censée faire office de serveur. Le framework scala "Play" doit être préalablement installé.

- Dans un terminal, exécuter la commande suivante : "./activator start".
Cette commande a pour effet de déployer la partie serveur de l'application et de la rendre accessible sur un port particulier (ici le port 9000)

- S'assurer de la présence d'une instance de mongodb sur le serveur. Si ce n'est pas le cas, l'installer, et démarrer le service associé à l'aide de la commande "service mongodb start"

- L'application est utilisable ! Pour décrire une scène, remplir le champ situé en bas à droite de la page et cliquer sur "link code to description"

- Pour récupérer les données des utilisateurs via l'interface MongoDB, lancer le shell mongo à l'aide de la commande "mongo" puis sélectionner la base de données "dbPLMDescription" à l'aide de la commande "use dbPLMDescription". Les données recherchées se trouvent alors dans la collection "codeToDescription", affichables à l'aide de la commande "db.codeToDescription.find().
