# EmojiToTranslate — Offline Android Emoji Translator

An offline Android application that converts supported hand, action and emergency emojis into simple English words or phrases using a rule-based dictionary.

[![Android](https://img.shields.io/badge/Android-API%2026%2B-3DDC84?logo=android&logoColor=white)](https://developer.android.com/)
[![Java](https://img.shields.io/badge/Java-11-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Gradle](https://img.shields.io/badge/Gradle-Kotlin%20DSL-02303A?logo=gradle&logoColor=white)](https://gradle.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## Overview

EmojiToTranslate is a native Android application that demonstrates rule-based symbol translation.

Users enter one or more supported emojis, tap **Translate**, and receive an English meaning. The application checks recognized two-emoji combinations before translating individual emojis.

All translation happens locally. The application does not require an internet connection, cloud service, external API or machine-learning model.

## Features

- Offline emoji translation
- Single-emoji meanings
- Two-emoji phrase recognition
- Priority matching for supported emoji combinations
- Unknown-emoji indicator
- Translate and clear controls
- Empty-input validation
- Scrollable single-screen interface
- No application permissions required
- No advertising or tracking code
- Works without an account

## Supported Single Emojis

| Emoji | Output |
|---|---|
| 👍 | good |
| 👎 | bad |
| 🙏 | please |
| ✋ | stop |
| 🤟 | I love you |
| 👉 | you |
| 👈 | me |
| 👆 | listen |
| 👇 | look |
| 👏 | clap |
| 🤝 | friend |
| 🧍 | person |
| 🏃 | run |
| 🚶 | walk |
| 🏥 | hospital |
| 📞 | call |
| 🆘 | help |

## Supported Combinations

The translator checks two-emoji combinations before individual mappings.

| Combination | Output |
|---|---|
| 👍👍 | very good |
| 👎👎 | very bad |
| 🙏👉 | please you |
| 👉👈 | you and me |
| 👉🏥 | go to hospital |
| 🆘📞 | call for help |
| ✋👉 | stop you |
| 👆🙏 | please listen |
| 🏃🏥 | run to hospital |
| 🤝🙂 | friends |

If an emoji is not recognized, the application displays:

```text
[?]
```

## How Translation Works

The application uses two Java `HashMap` dictionaries:

- `singleMap` stores individual emoji meanings.
- `comboMap` stores recognized two-emoji phrases.

For each input:

1. The text is split into Unicode code points.
2. The translator checks whether the current emoji and the next emoji form a recognized combination.
3. When a combination is found, its phrase is added to the result and both emojis are consumed.
4. Otherwise, the individual emoji meaning is used.
5. Unsupported emojis are represented by `[?]`.

Example:

```text
Input:  🆘📞
Output: call for help
```

Another example:

```text
Input:  👍👍
Output: very good
```

## Tech Stack

- Java 11
- Android SDK
- AndroidX AppCompat
- Material Components
- CardView
- ConstraintLayout dependency
- XML layouts
- Gradle Kotlin DSL

## Android Configuration

| Setting | Value |
|---|---:|
| Minimum SDK | API 26 — Android 8.0 |
| Target SDK | API 36 |
| Compile SDK | API 36 |
| Version | 1.0 |
| Application ID | `com.example.EmojiToTranslate` |

## Project Structure

```text
EmojiToTranslate/
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/EmojiToTranslate/
│       │   ├── MainActivity.java
│       │   └── EmojiTranslator.java
│       └── res/
│           ├── layout/activity_main.xml
│           └── values/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── LICENSE
└── README.md
```

## Requirements

- Android Studio
- Android SDK 36
- JDK 11 or a compatible Android Studio embedded JDK
- Android device or emulator running Android 8.0 or newer

## Installation

Clone the repository:

```bash
git clone https://github.com/Ankit-ku-panda/EmojiToTranslate.git
cd EmojiToTranslate
```

Open the project in Android Studio:

1. Select **Open**.
2. Choose the cloned `EmojiToTranslate` directory.
3. Wait for Gradle synchronization to complete.
4. Install any SDK components requested by Android Studio.
5. Select an emulator or connected Android device.
6. Click **Run**.

## Build from the Command Line

### Windows

```powershell
.\gradlew.bat assembleDebug
```

### Linux or macOS

```bash
chmod +x gradlew
./gradlew assembleDebug
```

The debug APK will be generated at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Install the Debug APK

With Android Debug Bridge configured and a device connected:

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Run Tests

### Windows

```powershell
.\gradlew.bat test
```

### Linux or macOS

```bash
./gradlew test
```

Run connected-device tests with:

```bash
./gradlew connectedAndroidTest
```

## Usage

1. Open the application.
2. Enter one or more supported emojis.
3. Tap **Translate**.
4. Read the result displayed below the buttons.
5. Tap **Clear** to reset the input and result.

## Add a New Single Mapping

Open:

```text
app/src/main/java/com/example/EmojiToTranslate/EmojiTranslator.java
```

Add a mapping inside the constructor:

```java
singleMap.put("😊", "happy");
```

## Add a New Combination

Add a two-emoji mapping to `comboMap`:

```java
comboMap.put("👋🙂", "hello friend");
```

Add more-specific combinations before introducing logic that could overlap with them.

## Privacy

EmojiToTranslate:

- Does not request internet access
- Does not collect user information
- Does not create an account
- Does not transmit entered emojis
- Does not contain analytics or advertising code

Input is processed locally while the application is running.

## Important Clarification

This application uses developer-defined meanings for emoji symbols. It does not recognize physical hand gestures, process camera input, or translate formal American Sign Language grammar.

Emoji gestures and ASL signs are not equivalent in every context. The app should therefore be presented as:

- An educational rule-based translator
- A simplified communication aid
- An Android development demonstration

It should not be treated as a professional ASL interpretation service.

## Current Limitations

- Only predefined emojis and two-emoji combinations are supported.
- Output is limited to English.
- Translation is dictionary-based and does not understand conversation context.
- The code-point splitter does not fully combine every Unicode emoji sequence.
- Variation selectors, skin-tone modifiers and zero-width-joiner sequences may produce `[?]`.
- The app does not provide speech output.
- The app does not translate typed English into emojis.
- The app does not use a camera or recognize real hand gestures.

## Future Improvements

- Support Unicode grapheme clusters correctly
- Add skin-tone and variation-selector handling
- Move mappings into a JSON or resource file
- Add multilingual translations
- Add search and autocomplete
- Add translation history
- Add copy and share buttons
- Add accessibility descriptions
- Add unit tests for all supported mappings
- Add optional text-to-speech
- Allow bidirectional text-to-emoji translation

## Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a branch:

   ```bash
   git checkout -b feature/your-feature
   ```

3. Commit your changes:

   ```bash
   git commit -m "Add your feature"
   ```

4. Push the branch:

   ```bash
   git push origin feature/your-feature
   ```

5. Open a pull request.

For bugs and suggestions, use the repository’s [Issues page](https://github.com/Ankit-ku-panda/EmojiToTranslate/issues).

## Author

**Ankit Kumar Panda**

- GitHub: [Ankit-ku-panda](https://github.com/Ankit-ku-panda)
- Repository: [EmojiToTranslate](https://github.com/Ankit-ku-panda/EmojiToTranslate)

## License

This project is distributed under the [MIT License](LICENSE).

---

If this project helped you, consider giving the repository a star.
