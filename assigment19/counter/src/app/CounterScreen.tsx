import React, { useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";

const CounterScreen: React.FC = () => {
  const [count, setCount] = useState<number>(0);
  const [isDarkMode, setIsDarkMode] = useState<boolean>(false);

  const handleIncrement = () => setCount((c) => c + 1);
  const handleDecrement = () => setCount((c) => (c > 0 ? c - 1 : c));
  const handleReset = () => setCount(0);
  const toggleTheme = () => setIsDarkMode((d) => !d);

  const backgroundColor = isDarkMode ? "#121212" : "#ffffff";
  const textColor = isDarkMode ? "#ffffff" : "#111111";
  const btnBg = isDarkMode ? "#1f1f1f" : "#e6e6e6";
  const secondaryBg = isDarkMode ? "#2b2b2b" : "#f2f2f2";

  return (
    <View style={[styles.container, { backgroundColor }]}>
      <Text style={[styles.heroSection, { color: textColor }]}>Welcome to&nbsp;Counter</Text>
      <Text style={[styles.counterText, { color: textColor }]}>{count}</Text>

      <View style={styles.row}>
        <TouchableOpacity
          onPress={handleDecrement}
          activeOpacity={0.8}
          style={[styles.button, { backgroundColor: btnBg }]}
        >
          <Text style={[styles.buttonText, { color: textColor }]}>
            Decrement
          </Text>
        </TouchableOpacity>

        <TouchableOpacity
          onPress={handleIncrement}
          activeOpacity={0.8}
          style={[styles.button, { backgroundColor: btnBg }]}
        >
          <Text style={[styles.buttonText, { color: textColor }]}>
            Increment
          </Text>
        </TouchableOpacity>
      </View>

      <View style={styles.row}>
        <TouchableOpacity
          onPress={handleReset}
          activeOpacity={0.8}
          style={[styles.secondaryButton, { backgroundColor: secondaryBg }]}
        >
          <Text style={[styles.buttonText, { color: textColor }]}>Reset</Text>
        </TouchableOpacity>

        <TouchableOpacity
          onPress={toggleTheme}
          activeOpacity={0.8}
          style={[styles.secondaryButton, { backgroundColor: secondaryBg }]}
        >
          <Text style={[styles.buttonText, { color: textColor }]}>
            Toggle Theme
          </Text>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    padding: 24,
  },
  counterText: {
    fontSize: 72,
    fontWeight: "700",
    marginBottom: 32,
  },
  row: {
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    marginVertical: 8,
  },
  button: {
    paddingVertical: 14,
    paddingHorizontal: 20,
    borderRadius: 8,
    marginHorizontal: 8,
    minWidth: 120,
    alignItems: "center",
  },
  secondaryButton: {
    paddingVertical: 12,
    paddingHorizontal: 18,
    borderRadius: 8,
    marginHorizontal: 8,
    minWidth: 120,
    alignItems: "center",
  },
  buttonText: {
    fontSize: 16,
    fontWeight: "600",
  },
  heroSection: {
      alignItems: "center",
      justifyContent: "center",
      fontSize: 25,
      fontWeight: "600",
      color : "#aa3636"
    },
});

export default CounterScreen;
