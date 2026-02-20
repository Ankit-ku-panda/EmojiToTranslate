package com.example.EmojiToTranslate;

import java.util.*;

public class EmojiTranslator {

    private Map<String, String> singleMap;
    private Map<String, String> comboMap;

    public EmojiTranslator() {

        // Single ASL meanings
        singleMap = new HashMap<>();

        singleMap.put("👍", "good");
        singleMap.put("👎", "bad");
        singleMap.put("🙏", "please");
        singleMap.put("✋", "stop");
        singleMap.put("🤟", "I love you");
        singleMap.put("👉", "you");
        singleMap.put("👈", "me");
        singleMap.put("👆", "listen");
        singleMap.put("👇", "look");
        singleMap.put("👏", "clap");
        singleMap.put("🤝", "friend");
        singleMap.put("🧍", "person");
        singleMap.put("🏃", "run");
        singleMap.put("🚶", "walk");
        singleMap.put("🏥", "hospital");
        singleMap.put("📞", "call");
        singleMap.put("🆘", "help");

        // COMBINATION meanings (this is the real ASL behavior)
        comboMap = new HashMap<>();

        comboMap.put("👍👍", "very good");
        comboMap.put("👎👎", "very bad");
        comboMap.put("🙏👉", "please you");
        comboMap.put("👉👈", "you and me");
        comboMap.put("👉🏥", "go to hospital");
        comboMap.put("🆘📞", "call for help");
        comboMap.put("✋👉", "stop you");
        comboMap.put("👆🙏", "please listen");
        comboMap.put("🏃🏥", "run to hospital");
        comboMap.put("🤝🙂", "friends");
    }

    public String translate(String input) {

        List<String> emojis = splitEmojis(input);

        if (emojis.size() == 0)
            return "No emoji detected";

        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < emojis.size(); i++) {

            // Check 2-emoji combination first
            if (i < emojis.size() - 1) {

                String pair = emojis.get(i) + emojis.get(i + 1);

                if (comboMap.containsKey(pair)) {
                    sentence.append(comboMap.get(pair)).append(" ");
                    i++; // skip next because already used
                    continue;
                }
            }

            // Single emoji meaning
            String e = emojis.get(i);

            if (singleMap.containsKey(e)) {
                sentence.append(singleMap.get(e)).append(" ");
            } else {
                sentence.append("[?] ");
            }
        }

        return sentence.toString().trim();
    }

    // Correct emoji splitter (VERY IMPORTANT)
    private List<String> splitEmojis(String text) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < text.length();) {

            int codePoint = text.codePointAt(i);
            int charCount = Character.charCount(codePoint);

            list.add(new String(Character.toChars(codePoint)));
            i += charCount;
        }

        return list;
    }
}