# Assignment 19: Expo React Native Counter Application

This directory contains a mobile **Counter Application** built using **React Native**, **TypeScript**, and **Expo**. It features interactive state updates, constraints preventing negative counts, dynamic light/dark theme toggling, and file-based routing with Expo Router.

## Table of Contents
- [Project Architecture](#project-architecture)
- [Key Features](#key-features)
- [Code Overview](#code-overview)
- [How to Run the Application](#how-to-run-the-application)

---

## Project Architecture

The application files are structured as follows within `counter/`:
```text
counter/
├── src/
│   └── app/
│       ├── _layout.tsx       # Expo Router Stack layout
│       ├── Counter.tsx       # Root view component
│       └── CounterScreen.tsx # Core UI component & state logic
├── package.json              # Project dependencies and scripts
└── tsconfig.json             # TypeScript configuration
```

- **`_layout.tsx`**: Defines the root layout with a standard stack navigator via `expo-router`.
- **`Counter.tsx`**: Serves as the main index route, rendering the `CounterScreen` component.
- **`CounterScreen.tsx`**: Houses the main count and theme state logic, stylesheets, and UI elements.

---

## Key Features

1. **Reactive Counter**:
   - **Increment**: Increases count by 1.
   - **Decrement**: Decreases count by 1 (clamped at a minimum of `0` to prevent negative numbers).
   - **Reset**: Resets count back to `0`.
2. **Dynamic Light & Dark Theme Toggling**:
   - Updates the component styling dynamically by swapping background colors, secondary background colors, button backgrounds, and text colors based on the `isDarkMode` state.
3. **Responsive Stylesheet**:
   - Implements native layout styling using React Native's `StyleSheet`.

---

## Code Overview

### State Management
The state is managed locally in `CounterScreen.tsx` using React's `useState` hook:
```typescript
const [count, setCount] = useState<number>(0);
const [isDarkMode, setIsDarkMode] = useState<boolean>(false);
```

### State Modification Handlers
* **Increment**: `setCount((c) => c + 1)`
* **Decrement**: `setCount((c) => (c > 0 ? c - 1 : c))` *(avoids negative counts)*
* **Reset**: `setCount(0)`
* **Theme Toggle**: `setIsDarkMode((d) => !d)`

### Styling and Theme Adaptability
Color values are dynamically computed in render time depending on `isDarkMode`:
```typescript
const backgroundColor = isDarkMode ? "#121212" : "#ffffff";
const textColor = isDarkMode ? "#ffffff" : "#111111";
const btnBg = isDarkMode ? "#1f1f1f" : "#e6e6e6";
const secondaryBg = isDarkMode ? "#2b2b2b" : "#f2f2f2";
```

---

## How to Run the Application

### 1. Install Dependencies
Navigate to the `counter` directory and run:
```bash
npm install
```

### 2. Start the Metro Bundler
Start the development server:
```bash
npx expo start
```

### 3. Open on a Device or Emulator
From the Expo terminal menu, you can:
- Press **`a`** to open in an Android Emulator.
- Press **`i`** to open in an iOS Simulator.
- Scan the QR code with your phone via the **Expo Go** app (Android) or Camera app (iOS) to run it directly on a physical device.
- Press **`w`** to run in a web browser.
