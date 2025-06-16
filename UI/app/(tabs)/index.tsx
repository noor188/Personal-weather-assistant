import React, { useState } from 'react';
import { View, Text, Button, Picker, StyleSheet, ImageBackground } from 'react-native';
import { useRouter } from 'expo-router';

export default function HomeScreen() {
  const [selectedId, setSelectedId] = useState();
  const router = useRouter();

  const handleGetWeather = () => {
    if (!selectedId) return;
    router.push({ pathname: '/(tabs)/explore', params: { id: selectedId } });
  };

  return (
    <ImageBackground
      source={{ uri: 'https://images.unsplash.com/photo-1506744038136-46273834b3fb' }} // peaceful nature background
      style={styles.background}
      resizeMode="cover"
    >
      <View style={styles.container}>
        <Text style={styles.title}>🌤️ Personal Weather Assistant</Text>
        <Picker
          selectedValue={selectedId}
          onValueChange={(itemValue) => setSelectedId(itemValue)}
          style={styles.picker}
        >
          <Picker.Item label="-- Choose Location --" value={null} />
          <Picker.Item label="El Paso" value="1" />
          <Picker.Item label="Dallas" value="2" />
          <Picker.Item label="Austin" value="3" />
        </Picker>
        <View style={{ marginTop: 20 }}>
          <Button title="Get Weather" onPress={handleGetWeather} color="#2E8B57" />
        </View>
      </View>
    </ImageBackground>
  );
}

const styles = StyleSheet.create({
  background: {
    flex: 1,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
    backgroundColor: 'rgba(255,255,255,0.6)', // light overlay
  },
  title: {
    fontSize: 22,
    fontWeight: 'bold',
    marginBottom: 20,
    color: '#2F4F4F',
  },
  picker: {
    height: 50,
    width: 250,
    backgroundColor: '#f0f0f0',
    borderRadius: 5,
  },
});
