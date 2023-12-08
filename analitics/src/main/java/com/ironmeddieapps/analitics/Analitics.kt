package com.ironmeddieapps.analitics

import android.app.Application
import io.appmetrica.analytics.AppMetrica
import io.appmetrica.analytics.AppMetricaConfig

object Analitics {


    fun initAnalitics(app: Application) {
        val config: AppMetricaConfig =
            AppMetricaConfig.newConfigBuilder("5923ccec-ded4-4960-be84-a68482c66c71").build();

        AppMetrica.activate(app.applicationContext, config);

        AppMetrica.enableActivityAutoTracking(app);
    }

    fun reportListOpen() {
        AppMetrica.reportEvent("ListScreenOpened")
    }

    fun reportDataLoaded() {
        AppMetrica.reportEvent("DataLoaded")
    }


}