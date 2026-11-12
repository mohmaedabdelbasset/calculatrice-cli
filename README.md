# Calculatrice CLI - TP DevOps

Projet universitaire de calculatrice Java en ligne de commande. Le projet
illustre un workflow Git/GitHub collaboratif avec deux comptes, des branches
de fonctionnalites, des Pull Requests, Maven, JUnit, Checkstyle, Git Hooks et
GitHub Actions.

## Architecture

La branche `main` contient la version integree:

- `Operation.java`: contrat commun des operations.
- `AddOperation.java`: addition.
- `SubtractOperation.java`: soustraction.
- `Main.java`: interface CLI.
- `pom.xml`: configuration Maven, JUnit 5 et Checkstyle.

Les contributions ont ete integrees par Pull Request:

1. PR #1: `feature/addition` vers `main`.
2. PR #2: `feature/subtraction` vers `main`, contribution du compte Collaborator.
3. PR #3: `feature/cli-main` vers `main`, ajout de l'interface CLI.

## Prerequis

- JDK 17 ou version compatible avec `maven.compiler.release`.
- Maven 3.9 ou version ulterieure.
- Git.

Sous Windows, Maven peut etre lance avec:

```powershell
& "C:\Program Files\NetBeans-25\netbeans\java\maven\bin\mvn.cmd" clean verify
```

## Installation

```powershell
git clone https://github.com/mohmaedabdelbasset/calculatrice-cli.git
Set-Location calculatrice-cli
git config core.hooksPath .githooks
```

La derniere commande active les Hooks versionnes du projet.

## Compilation et tests

```powershell
mvn clean verify
```

Cette commande compile le projet, execute les 8 tests JUnit et controle le
style. La validation locale finale a donne:

- 8 tests reussis.
- 0 violation Checkstyle.
- `BUILD SUCCESS`.

## Execution de la CLI

Apres la compilation:

```powershell
java -cp target\classes dz.univ.calculatrice.Main + 7 5
java -cp target\classes dz.univ.calculatrice.Main - 7 5
```

Resultats attendus:

```text
12.0
2.0
```

Format general:

```text
java -cp target\classes dz.univ.calculatrice.Main <+|-> <firstNumber> <secondNumber>
```

## Git Hooks

- `pre-commit` lance `mvn -B clean verify` avant chaque commit.
- `pre-push` lance la meme validation avant chaque push.

Si Maven, les tests ou Checkstyle echouent, l'operation est bloquee. Cette
protection a ete verifiee avec une source Java volontairement invalide: les
deux Hooks ont retourne le code 1 et ont affiche un message de blocage.

## Demonstration du Merge Conflict

Un conflit pedagogique a ete provoque dans des branches locales temporaires,
sans modifier `main`:

1. Deux branches ont modifie la meme ligne de `conflict-demo.txt`.
2. Le `git merge` a arrete l'operation avec un conflit.
3. Les marqueurs `<<<<<<<`, `=======` et `>>>>>>>` ont ete lus et compris.
4. Les deux modifications ont ete fusionnees, puis les marqueurs ont ete
   supprimes.
5. `git add`, `git commit` et `mvn clean verify` ont termine la resolution.
6. Les branches et le fichier de demonstration ont ensuite ete supprimes.

## CI GitHub Actions

Le workflow [.github/workflows/ci.yml](.github/workflows/ci.yml) est configure
pour verifier les Push sur `main` et `feature/**`, ainsi que les Pull Requests
vers `main`. Il utilise Java 17 et execute:

```text
mvn -B clean verify
```

La configuration est correcte, mais GitHub a refuse de demarrer les Jobs avec
le message indiquant que le compte est verrouille pour un probleme de
facturation. Les Runs ont donc echoue avant la premiere etape du Job. La CI
GitHub ne doit pas etre presentee comme reussie tant que ce verrou externe
n'est pas leve. La validation locale Maven reste reussie et ne remplace pas
un Run GitHub Actions.

## Questions frequentes pour la soutenance

- **Compte GitHub:** identite de l'utilisateur.
- **Repository:** espace distant qui contient le projet et son historique.
- **Branch:** ligne de developpement independante.
- **Commit:** version locale enregistree dans l'historique.
- **Push:** envoi des commits vers GitHub.
- **Pull Request:** demande de revue et d'integration d'une branch.
- **Merge:** integration de la Pull Request dans la branch cible.
- **Maven:** compilation, execution des tests et verification du projet Java.
- **JUnit:** framework utilise pour les tests unitaires.
- **Checkstyle:** controle automatique du style du code.
- **Git Hooks:** controles locaux executes avant commit et push.
- **GitHub Actions:** automatisation distante de la validation CI.
