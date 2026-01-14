# 🃏 JavaFX Card Dealer (Card Drawer)

A simple and interactive **JavaFX application** that simulates drawing random playing cards from a shuffled deck.  
Each card is displayed visually using images, with smooth fade-in animation and logic to ensure no duplicate cards are drawn.

---

## 📌 Project Overview

**Card Dealer (Card Drawer)** is a desktop application built using **Java and JavaFX**.  
The goal of this project is to demonstrate JavaFX UI development, image handling, animations, and basic game logic using Java collections.

The application allows users to draw cards one at a time from a standard 52-card deck until the deck is exhausted.

---

## ❓ Why JavaFX?

JavaFX was chosen because it provides:
- Built-in UI components for desktop applications
- Native support for images and animations
- A clean way to separate UI and application logic

This makes it ideal for building lightweight, interactive Java applications.

---

## ⚙️ How the Application Works

### Deck Initialization
- A standard 52-card deck is created using combinations of ranks and suits
- Cards are stored as image file names
- The deck is shuffled at startup to ensure randomness

### Card Drawing Logic
- One card is removed from the deck per draw
- A `Set` is used to track drawn cards and prevent duplicates
- When the deck is empty, the user is notified

### Image Display
- Card images are loaded dynamically from the resources folder
- Each drawn card is displayed using an `ImageView`
- A fade-in animation enhances the user experience

---

## 🖥️ User Interface

The UI is built using JavaFX components:
- `Stage` and `Scene` for the main window
- `ImageView` to display card images
- `Label` to show card names and messages
- `Button` to trigger card draws

The layout is simple, centered, and easy to use.

---

## ✨ Features

- Shuffled 52-card deck
- Random card drawing
- No duplicate cards
- Dynamic image loading
- Fade-in animation for card display
- User feedback when the deck is empty

---

## 📂 Project Structure

