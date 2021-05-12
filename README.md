# CleanMarvelCharacters
List Marvel characters and show specific information of marvel character selected.

## Architecture
Use clean architecture layers in module, is not necessary, with packages is enough. App module can implement data domain and usecases modules but domain for example can not see anything of other modules. Data and usecases only use domain and not know nothing of the presentation layer.

### Modules
#### Domain
With the entity MarvelCharacter

#### Data
With the repository and data sources, local and remote.
Repository is tested with mockito
Repository call first to localDataSource and then if is empty call to the server and save the response.

#### UsesCases
With the cases that the presenter or viewModel need

#### App Module
App module use MVVM with databinding with liveData. MVVM is similar to MVP changing presenter by viewModel, having the advantage or disadvantage to be more coupled to android.
Real DataBinding when inflate layout, for load adapter and showing detail of marvelCharacter


## Test
Run all ( Unit and instrumentation) test  ./gradlew testAll

## Manage Errors with retrofit