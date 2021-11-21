import math as math

#définition d'une fonction qui prend en argument une string composé de 2 espaces 
#et 3 mots
#renvoit les trois mots séparés sans espaces
def separtion(str):
    long = len(str)
    i = 0 #i correspond au caractère en cours de traitement
    deb_temp = 0 #deb_temp correspond à l'indice de début du mot actuel
    mot_actuel = 0 #correspond à l'indice du mot actuellement cherché dans mots
    mots = ["", "", ""]
    while i != long:
        if str[i] == " ":
            mots[mot_actuel] = str[deb_temp: (i)]
            deb_temp = i +1
            mot_actuel += 1
        i += 1
    mots[mot_actuel] = str[deb_temp:long - 1] 
    return mots

#ouverture du fichier texte en mode lecture
fichier = open("graphe.txt", "r")

#récupération du nombre de sommet dans le fichier texte
nbr_sommet_str = fichier.readline()
nbr_sommet_int = int(nbr_sommet_str)

#récupération du nombre de liaisons dans le fichier texte
nbr_liaisons_str = fichier.readline()
nbr_liaisons_int = int(nbr_liaisons_str)

#définition de la matrice d'adjacence avec les valeur par défaut à inf
matrice_adj =  []
for _ in range(nbr_sommet_int):
    matrice_adj.append([math.inf] * nbr_sommet_int)

#mise à jour des valeurs de la matrice d'après les liaisons données dans le fichier text
for _ in range(nbr_liaisons_int):
    line_str = fichier.readline()
    tab_val = separtion(line_str)
    matrice_adj[int(tab_val[0])][int(tab_val[1])] = int(tab_val[2])

#fermeture du fichier texte
fichier.close()

print(matrice_adj)
