package cn.lemonnetwork.catpixellobby.MinecraftServer.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class NoWeather implements Listener {
  @EventHandler
  public void onWeatherEvent(WeatherChangeEvent event) {
    event.setCancelled(true);
  }
}
