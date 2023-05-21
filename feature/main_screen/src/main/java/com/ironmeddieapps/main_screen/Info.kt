package com.ironmeddieapps.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ironmeddieapps.models.Currency
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun InfoBanner(data: Currency){

    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("RUSSIAN"))
    val date = formatter.parse(data.Date)
    val date2 = formatter.parse(data.PreviousDate)
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Text(text = "Обновлено в " + date)
        Text(text = "Ранее: " + date2)
    }

}