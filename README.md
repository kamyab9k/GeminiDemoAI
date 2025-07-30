# How to integrate the Gemini API into your Android project?
<p align="center">
  <img width="1431" height="753" alt="Gemini_Medium_Cover" src="https://github.com/user-attachments/assets/0c75537b-7893-422d-88d4-335332be40e0" />
   <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/kamyab9k"><img alt="Profile" src="https://img.shields.io/badge/GitHub-Kamyab%20Khosravi-blue?style=flat&link=https%3A%2F%2Fgithub.com%2Fkamyab9k"/></a>
<a href="https://www.linkedin.com/in/kamyab-khosravi-5214551a4/"><img alt="LinkedIn" src="https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=linkedin&logoColor=white"/></a>
  <a href="https://medium.com/@kamyab9k"><img alt="Medium" src="https://img.shields.io/badge/Medium-12100E?logo=medium&logoColor=white"/></a></p>
  

This repository contains a simple Android application that demonstrates how to integrate and use the Google Gemini API. It serves as a quick-start guide for developers seeking to incorporate generative AI capabilities into their Android projects.

### Purpose of this repository?

This repository was created as a companion sample project for my article on Medium.<br>
**[Read the full article on Medium](https://medium.com/@kamyab9k/how-to-integrate-gemini-api-into-your-android-project-80fe8422a9d8)**

---

## Features📝

* **Gemini API Integration:** A basic implementation of the Gemini API for text generation.
* **Kotlin Coroutines:** Safe and simple handling of asynchronous network calls.
* **Jetpack Compose UI:** A minimal, modern UI to display the AI's response.
  
⚠️**Remember** this is a sample repository and you should implement best practices such as ViewModel, separation of concerns, securing api key, etc.

---

## Getting Started🚀 

Follow these steps to get the app running on your device or emulator.

### Prerequisites

* Android Studio
* A physical device or an Android Emulator
* A [Google Gemini API Key](https://ai.google.dev/)
* For a detailed explanation **[Read the full article on Medium](https://medium.com/@kamyab9k/how-to-integrate-gemini-api-into-your-android-project-80fe8422a9d8)**

### Setup

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/kamyab9k/GeminiDemoAI.git
    ```

2.  **Add your API Key:**
    * **Recommended (Secure):** In your project's `local.properties` file, add your API key like this:
        ```properties
        gemini.api.key=YOUR_API_KEY
        gemini.model.name=gemini-model
        ```
    * **Quick Test (Not Secure):** For a quick test, you can hardcode your API key in `MainActivity.kt`. **Note: This is a security risk and should not be used in production code.**

3.  **Run the app:**
    * Sync your Gradle project.
    * Run the app on a connected device or emulator from Android Studio.

The app will automatically make an API call and display the AI's response on the screen upon launch.<br>
The prompt can be changed from the Main Activity.

📍 **[Read the full article on Medium](https://medium.com/@kamyab9k/how-to-integrate-gemini-api-into-your-android-project-80fe8422a9d8)**
---
