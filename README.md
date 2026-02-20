# 🧩 EmojiToTranslate — Emoji → Text + ASL Meaning Android App

**EmojiToTranslate** is an Android application that converts emojis and emoji combinations into meaningful English words and phrases.
The app is designed as an **assistive communication tool** for users who communicate using emojis and basic sign representations.

It also interprets **hand gesture emojis as simplified ASL (American Sign Language) meanings**.

---

## 📱 Project Objective

Many users — especially children, early learners, and some speech-impaired users — communicate using emojis instead of text.
However, normal messaging apps cannot understand emoji intent.

This app:

* Reads emoji input
* Detects patterns
* Understands combinations
* Converts them into human-readable sentences

It works like a **basic Natural Language Understanding (NLU) system**, but instead of words → meaning, it uses **emojis → meaning**.

---

## ✨ Features

✔ Emoji to English translation
✔ Emoji combination understanding
✔ ASL hand emoji interpretation
✔ Offline (no internet required)
✔ Simple one-screen UI
✔ Fast processing (no API calls)

---

## 🧠 How It Works (Core Logic)

The application uses a **rule-based semantic mapping system**.

The `EmojiTranslator` class:

1. Reads each emoji character
2. Matches it inside a HashMap (emoji dictionary)
3. Detects multi-emoji patterns (combinations)
4. Replaces them with a meaningful sentence

Example:

```
🙂 = happy
🍕 = pizza
🙂🍕 = I want pizza
```

Instead of translating emoji individually, the app checks:

> “Is this a single emoji OR a meaningful sequence?”

If a sequence is found → higher priority translation is applied.

This is similar to:

* NLP tokenization
* Pattern matching
* Intent detection

---

## 🔗 Emoji Combination Intelligence

The app recognizes multiple emoji combinations:

| Emoji   | Meaning         |
| ------- | --------------- |
| ❤️🙏    | Thank you       |
| 😭💔    | Heartbroken     |
| 😡👊    | I am angry      |
| 🏃‍♂️💨 | I am running    |
| 🌙😴    | Good night      |
| ☀️😊    | Good morning    |
| 🍕🤤    | I want pizza    |
| 📚🧠    | Studying        |
| 🏫🎒    | Going to school |
| 🚗🏠    | Reached home    |

This simulates **human intention detection** rather than word replacement.

---

## 🤟 ASL Hand Emoji Meanings

The app interprets hand gesture emojis as simplified sign language meanings.

| Emoji | Interpreted Meaning |
| ----- | ------------------- |
| 👍    | Yes / Good          |
| 👎    | No                  |
| 👋    | Hello               |
| 🤝    | Agreement / Deal    |
| 🙏    | Please / Thank you  |
| ✌️    | Peace               |
| 🤙    | Call me             |
| 👌    | OK                  |
| ✋     | Stop                |
| 🤞    | Hope / Wish         |

This makes the app useful for:

* basic assistive communication
* educational demonstration
* children learning signs

---

## 🏗 Tech Stack

* Java (Android)
* Android Studio
* ConstraintLayout
* Material UI Components
* HashMap based NLP logic

No:

* APIs
* Cloud
* Internet
* ML models

The intelligence is **fully local and offline**.

---

## 📂 Project Structure

```
com.example.emojitotranslate
│
├── MainActivity.java
├── EmojiTranslator.java   ← Core logic
│
├── res/layout/
│   └── activity_main.xml
│
├── res/values/
│   ├── colors.xml
│   ├── strings.xml
│   └── themes.xml
```

---

## 🚀 Installation

1. Clone the repository

```
git clone https://github.com/Ankit-ku-panda/EmojiToTranslate.git
```

2. Open in **Android Studio**

3. Let Gradle sync

4. Run on:

* Android Emulator
* OR Physical device (recommended)

Minimum Android Version: **Android 8.0 (API 26)**

---

## 🧪 Example Usage

Input:

```
👋🙂
```

Output:

```
Hello, I am happy
```

Input:

```
🙏❤️
```

Output:

```
Thank you
```

Input:

```
🍕🤤
```

Output:

```
I want pizza
```

---

## 🎯 Why This Project is Important

This project demonstrates concepts of:

* Natural Language Processing (NLP)
* Pattern recognition
* Human-computer interaction
* Assistive technology
* Semantic mapping

Instead of processing **words**, it processes **symbols (emojis)** — which is a growing modern communication language.

---

## 🔮 Future Improvements

* Voice output (Text-to-Speech)
* Camera hand gesture recognition
* ML-based intent prediction
* Chat keyboard integration
* WhatsApp accessibility service
* Multi-language translation

---

## 👨‍💻 Author

**Ankit Kumar Panda**
B.Tech Student | Android Developer | Cybersecurity Learner

GitHub:
https://github.com/Ankit-ku-panda

---

## 📜 License

This project is for **educational and research purposes**.

You may modify and use it with credit.
