<br/>
<p align="center">


<h3 align="center">Test-Driven Development (TDD), Clean Architecture, multi-module support, Kotlin Flow, Jetpack Compose for UI, and the presence of unit tests.</h3>

 <a href="https://github.com/sachin052/flow-compose-clean-architecture/assets/42666335/4f92900e-a5e8-4ee0-9fa1-7d431706f43a">View Demo</a>


## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)
* [Authors](#authors)

## About The Project

An Android application that embraces modern development practices to deliver a robust and feature-rich user experience. This project is a testament to the integration of Test-Driven Development (TDD), Clean Architecture, and cutting-edge technologies within the Android ecosystem.


## Built With

1. Kotlin: The project is developed using Kotlin, a modern and expressive programming language that enhances developer productivity and readability.

2. Test-Driven Development (TDD): Embracing TDD principles, our project incorporates a suite of unit tests to ensure code reliability and facilitate continuous integration.

3. Clean Architecture: The architecture of the project adheres to clean architecture principles, promoting separation of concerns and maintainability.

4. Jetpack Compose: The UI is built using Jetpack Compose, a modern Android UI toolkit that simplifies UI development with a declarative syntax, enabling the creation of interactive and dynamic user interfaces.

5. Kotlin Flow: Leveraging Kotlin Flow for reactive programming, our application manages asynchronous tasks in a concise and efficient manner.

6. Multi-Module Support: The project is organized into distinct modules, including a core module for constants, helpers, routes, and use cases, and a feature module for authentication and posts. This modular structure enhances scalability and code organization.

7. buildSrc for Dependency Management: Dependency management across different modules is streamlined through the use of the buildSrc module, providing a centralized and consistent approach to handling dependencies.

## Getting Started

1. Clone the repo
 git clone https://github.com/sachin052/flow-compose-clean-architecture.git

## Usage

Before delving into the details of the project, let's introduce a key component - the `ViewStatus` class. Additionally, the project includes a `test` folder housing test cases, ensuring the reliability of the implemented functionalities.

## Key Concepts

### 1. CoreViewModel Class

The `CoreViewModel` class is central to the project, designed to execute API calls using generic methods. This helps eliminate the manual handling of common states like Loading, Success, or Failure, ensuring a consistent approach to managing API calls throughout the application.

```kotlin
   fun <T> executeApi(call: suspend () -> Flow<Either<Failure, T>>): Flow<Either<Failure, T>> {
        return flow {
            mutableUIState.value=ViewStatus.Loading
            call.invoke().collect { value ->

                when (value) {
                    is Either.Left -> {
                        mutableUIState.value=ViewStatus.Error("Something went wrong", action = {
                            executeApi(call)
                        })
                        emit(value = value)
                    }
                    is Either.Right -> {
                        mutableUIState.value=ViewStatus.Success
                        emit(value = value)
                    }
                }
            }

        }
    }
```

### 2. safeFlowBuilder

The `safeFlowBuilder` is a generic method implemented for making API calls with built-in error handling. This method simplifies the process of executing asynchronous operations in a safe and standardized manner.

```kotlin
fun <T> safeFlowBuilder(call: suspend () -> Response<T>): Flow<Either<Failure, T>> {
    return flow {
        // invoking suspend
        val response = call.invoke()
        if (response.isSuccessful) {
            emit(Either.Right(response.body() ?: return@flow))
        } else {
            emit(left(Failure.ServerFailure(response.code(), response.errorBody().toString())))
        }

    }.catch { e ->
        emit(Either.Left(Failure.ServerFailure(10, e.localizedMessage)))
    }
}
```

### 3. ViewStatus Class

The `ViewStatus` class represents the different states that the UI can be in. It includes states such as Initial, Loading, Success, and Error, with the ability to provide error messages, button text for retry actions, and custom action callbacks.


```kotlin
sealed class ViewStatus {
    object Inital : ViewStatus()
    object Loading : ViewStatus()

    object Success : ViewStatus()

    class Error(
        val message: String,
        @StringRes val buttonText: Int = R.string.retry,
        val action: (() -> Unit)? = null
    ) : ViewStatus()
}
```

### 4. Test Folder

The `test` folder contains unit tests to validate the functionality of key components. Specifically, test cases for `LoginViewModel` and `PostViewModel` are provided to ensure the reliability of authentication and posts-related functionalities.

## Core Module

The Core Module houses fundamental components crucial to the entire project:

- **Constants:** Stores constant values used throughout the project.
- **Helpers:** Includes utility functions and helper classes.
- **Routes:** Manages navigation routes within the application.
- **Usecase:** Defines use cases encapsulating the application's business logic.
- **Helper:** Additional helper functions and utilities.

## Feature Module

The Feature Module is divided into two distinct features: Authentication and Posts.

### Authentication Feature

This feature manages user authentication, encompassing components such as login, logout, and user profile management.

### Posts Feature

The Posts Feature handles the management of posts.

## buildSrc

The `buildSrc` folder serves as a centralized location for managing dependencies across different modules, contributing to a more organized and maintainable codebase.

## Example Usage

Example Usage
To demonstrate the usage of the project, let's consider fetching and displaying posts in the UI:

```kotlin
Copy code
// In PostScreenViewModel
class PostScreenViewModel(
    private val getAllPostsUseCase: GetAllPostsUseCase
) : CoreViewModel() {

   // Collecting allItems flow to display a list of items
     val allItems = executeApi { getAllPostsUseCases.invoke() }.map { value ->  when(value){
        is Either.Left -> emptyList()
        is Either.Right -> value.r
    } }
}
```
This example showcases how the CoreViewModel class, safeFlowBuilder, and GetAllPostsUseCase work together to handle the API call and manage the UI states seamlessly.


## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.
* If you have suggestions for adding or removing projects, feel free to [open an issue](https://github.com/sachin033/low-compose-clean-architecture//issues/new) to discuss it, or directly create a pull request after you edit the *README.md* file with necessary changes.
* Please make sure you check your spelling and grammar.
* Create individual PR for each suggestion.
* Please also read through the [Code Of Conduct](https://github.com/sachin033/low-compose-clean-architecture//blob/main/CODE_OF_CONDUCT.md) before posting your first idea as well.

### Creating A Pull Request

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See [LICENSE](https://github.com/sachin033/low-compose-clean-architecture//blob/main/LICENSE.md) for more information.

My Website :  <a href="https://moonphasesoulmate.com/">Demo Website</a>

## Authors

* **Sachin Kumar** - *Senior Software Engineer* - [Sachin Kumar](https://github.com/sachin052 ) - **

