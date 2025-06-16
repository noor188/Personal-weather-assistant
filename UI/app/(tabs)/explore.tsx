import React, { useEffect, useState } from 'react';
import { View, Text } from 'react-native';
import { useLocalSearchParams } from 'expo-router';

export default function WeatherScreen() {
  const { id } = useLocalSearchParams();
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!id) return;
    fetch(`http://localhost:8080/location/${id}`)
      .then((res) => {
        if (!res.ok) throw new Error('Request failed');
        return res.json();
      })
      .then((data) => setWeather(data))
      .catch((err) => setError(err.message));
  }, [id]);

  return (
    <View style={{ padding: 40 }}>
      {weather ? (
        <Text>Temperature: {weather.temperature}°C</Text>
      ) : error ? (
        <Text>Error: {error}</Text>
      ) : (
        <Text>Loading...</Text>
      )}
    </View>
  );
}
