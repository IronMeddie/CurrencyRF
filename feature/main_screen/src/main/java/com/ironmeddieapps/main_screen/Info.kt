package com.ironmeddieapps.main_screen


fun convertDate(date: String) : String {
    val day= date.substringBefore("T").substringAfterLast("-")
    val mounth= date.substringAfter("-").substringBefore("-")
    val hour = date.substringAfter("T").substringBefore(":")
    val minute = date.substringAfter(":").substringBefore(":")
    return "$day.$mounth $hour:$minute"
}