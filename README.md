# How to integrate the Gemini API into your sample project?

This repository contains a simple Android application that demonstrates how to integrate and use the Google Gemini API. It serves as a quick-start guide for developers looking to add generative AI capabilities to their Android projects.

### Purpose of this repository

This repository was created as a companion sample project for my article on Medium.
**[Read the full article on Medium](https://medium.com/@your_username/your-article-slug)**

---

## Features📝

* **Gemini API Integration:** A basic implementation of the Gemini API for text generation.
* **Kotlin Coroutines:** Safe and simple handling of asynchronous network calls.
* **Jetpack Compose UI:** A minimal, modern UI to display the AI's response.
  
⚠️**Remember** this is a sample repository and you should implement best practices such as ViewModel, separation of concerns, securing api key, etc.

---

## Getting Started🚀 

Follow these steps to get the app running on your device or emulator.

### Prerequisites✅

* Android Studio
* A physical device or an Android Emulator
* A [Google Gemini API Key](https://ai.google.dev/)
* For a detailed explanation **[Read the full article on Medium](https://medium.com/@your_username/your-article-slug)**

### Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/Gemini-Android-Sample.git](https://github.com/your-username/Gemini-Android-Sample.git)
    ```

2.  **Add your API Key:**
    * **Recommended (Secure):** In your project's `local.properties` file, add your API key like this:
        ```properties
        gemini.api.key=YOUR_API_KEY
        gemini.model.name=gemini-pro
        ```
    * **Quick Test (Not Secure):** For a quick test, you can hardcode your API key in `MainActivity.kt`. **Note: This is a security risk and should not be used in production code.**

3.  **Run the app:**
    * Sync your Gradle project.
    * Run the app on a connected device or emulator from Android Studio.

The app will automatically make an API call and display the AI's response on the screen upon launch.

---
