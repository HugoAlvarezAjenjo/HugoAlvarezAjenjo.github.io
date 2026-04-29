package org.example.newportfolio.models

enum class Experience(
    val company: String,
    val position: String,
    val period: String,
    val description: String = "",
    val link: String = "",
) {
    Amazon(
        company = "Amazon - Kindle reader",
        position = "Jr. Software Development Engineer",
        period = "Jun 2025 - Present",
        description = "Working on the development of Kindle e-readers.",
        link = "https://www.aboutamazon.com/news/devices/new-amazon-kindle-scribe-color"
    ),
    UPMNext(
        company = "UPM - Next Digital",
        position = "On-campus Intern",
        period = "Apr 2026 - May 2026",
        description = "Web Developer in Quality and Sustainability.",
        link = "https://nextdigital.etsisi.upm.es/"
    ),
    // Add more experiences here following the same pattern:
    // ExampleCompany(
    //     company = "Company Name",
    //     position = "Your Role",
    //     period = "Start - End",
    //     description = "Brief description (optional)",
    //     link = "https://example.com (optional)"
    // ),
}
