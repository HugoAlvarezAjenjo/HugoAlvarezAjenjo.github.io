package org.example.newportfolio.models

import org.example.newportfolio.utils.Res

enum class Work(
    val workName: String,
    val description: String,
    val link: String,
    val imageRes: String,
) {
    SelecTA(
        workName = "SelecTA",
        description = "Web System to search university subjects",
        link = "https://github.com/HugoAlvarezAjenjo/SelecTA",
        imageRes = Res.Images.SELECTA
    ),
    Pulse(
        workName = "Pulse",
        description = "Fast CLI tool to validate development environments",
        link = "https://github.com/HugoAlvarezAjenjo/pulse",
        imageRes = Res.Images.PULSE
    ),
    LinuxExplained(
        workName = "LinuxExplained",
        description = "Web to learn linux components",
        link = "https://github.com/HugoAlvarezAjenjo/LinuxExplained",
        imageRes = Res.Images.LINUX_EXPLAINED
    ),
    NewsSearch(
        workName = "News Search",
        description = "Desktop client for NewsAPI",
        link = "https://github.com/HugoAlvarezAjenjo/News-Search",
        imageRes = Res.Images.NEWS_SEARCH
    ),
    MineSweeper(
        workName = "Mine Sweeper",
        description = "Java Swing Mine Sweeper Game",
        link = "https://github.com/HugoAlvarezAjenjo/Minesweeper",
        imageRes = Res.Images.MINESWEEPER
    ),
    HoroscopeApp(
        workName = "Horoscope",
        description = "Horoscope Mobile App",
        link = "https://github.com/HugoAlvarezAjenjo/HoroscopoApp",
        imageRes = Res.Images.HOROSCOPE
    ),
}