package com.example.analitics

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig

object Analitics {


    fun initAnalitics(app: Application) {
        val config: YandexMetricaConfig =
            YandexMetricaConfig.newConfigBuilder("5923ccec-ded4-4960-be84-a68482c66c71").build();

        YandexMetrica.activate(app.applicationContext, config);

        YandexMetrica.enableActivityAutoTracking(app);
    }

    fun reportListOpen() {
        YandexMetrica.reportEvent("ListScreenOpened")
    }

    fun reportDataLoaded() {
        YandexMetrica.reportEvent("DataLoaded")
    }


}