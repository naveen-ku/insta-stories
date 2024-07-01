## Stage Project
This repository is an android application to show instagram like stories build using Kotlin.


## Tech Stack
- Language: Kotlin
- Database: Room Databases
- Backend: Firebase Functions (For Rest API)
- Testing: Expresso for UI & MockWebServer for API
- CI/CD: Github Actions

## Project Description
Develop a simplified version of the Instagram Stories feature. This application should allow users to view a series of "stories" short, temporary posts that disappear after a set period

## Video Demo

https://github.com/naveen-ku/insta-stories/assets/44813618/32f2fc77-2877-4ea0-a530-e38645f54fe7


## Task achieved

- [x] User story bar
- [x] Stories navigation & gestures
- [x] Caching
- [x] Test cases
- [x] CI/CD Pipeline

## Methodology

#### Architecture and design choices
- Followed MVVM architecture to separate the development of the graphical user interface from the development of the business logic or back-end logic.

#### Caching (Strategy for optimized performance and scalability)
- Used Glide disk cache strategy where images are stored on the device's storage. This means that even if the app is closed and reopened, images do not need to be downloaded again, saving bandwidth and improving loading times.
- Usesd okHttpClient cache to store responses that can be reused without sending a new request to the server. This cache is stored on the disk and can be configured with a maximum size.

#### Testing
- Test UI functionality
- Test API data fetch functionality

#### CI/CD Pipeline
- Check for lint errors and publish report as artifact that will analyze code for potential errors. Using linting maintained the code quality and consistency by identifying and fixing issues early in the development process.
- Added android emulator CI pipeline to test UI click operation  


### Running the project

- Download Android Studio
- Download Android SDK/NDK and build tools



