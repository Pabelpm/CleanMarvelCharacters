# CleanMarvelCharacters
List Marvel characters and show specific information of marvel character selected.

## Architecture
Use clean architecture layers in module, is not necessary, with packages is enough. App module can implement data domain and usecases modules but domain for example can not see anything of other modules. Data and usecases only use domain and not know nothing of the presentation layer.

### Modules
#### Domain
With the entity MarvelCharacter

#### Data
With the repository and data sources, local and remote.

#### UsesCases
With the cases that the presenter or viewModel need