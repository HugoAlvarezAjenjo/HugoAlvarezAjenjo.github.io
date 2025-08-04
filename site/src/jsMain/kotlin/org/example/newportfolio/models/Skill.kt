package org.example.newportfolio.models

import org.example.newportfolio.utils.Res

enum class Skill(
    val skillName: String,
    val level: String,
    val iconResLight: String,
    val iconResDark: String,
) {
    AndroidStudio(
        skillName = "Android Studio",
        level = "Skilled",
        iconResLight = Res.Images.ANDROID_STUDIO,
        iconResDark = Res.Images.ANDROID_STUDIO,
    ),
    IntellijIdea(
        skillName = "IntelliJ IDEA",
        level = "Skilled",
        iconResLight = Res.Images.INTELLIJ_IDEA,
        iconResDark = Res.Images.INTELLIJ_IDEA,
    ),
    Neovim(
        skillName = "Neovim",
        level = "Skilled",
        iconResLight = Res.Images.NEOVIM,
        iconResDark = Res.Images.NEOVIM,
    ),
    Git(
        skillName = "Git",
        level = "Skilled",
        iconResLight = Res.Images.GIT,
        iconResDark = Res.Images.GIT,
    ),
    GitHub(
        skillName = "GitHub",
        level = "Skilled",
        iconResLight = Res.Images.GITHUB_LIGHT,
        iconResDark = Res.Images.GITHUB_DARK,
    ),
    Java(
        skillName = "Java",
        level = "Skilled",
        iconResLight = Res.Images.JAVA,
        iconResDark = Res.Images.JAVA,
    ),
    Kotlin(
        skillName = "Kotlin",
        level = "Skilled",
        iconResLight = Res.Images.KOTLIN,
        iconResDark = Res.Images.KOTLIN,
    ),
    Cpp(
        skillName = "C++",
        level = "intermediate",
        iconResLight = Res.Images.CPP,
        iconResDark = Res.Images.CPP,

        ),
    Spring(
        skillName = "Spring Framework",
        level = "Skilled",
        iconResLight = Res.Images.SPRING,
        iconResDark = Res.Images.SPRING,
    ),
    Thymeleaf(
        skillName = "Thymeleaf",
        level = "Skilled",
        iconResLight = Res.Images.THYMELEAF,
        iconResDark = Res.Images.THYMELEAF,
    ),
    JetpackCompose(
        skillName = "Compose",
        level = "Novice",
        iconResLight = Res.Images.JETPACK_COMPOSE,
        iconResDark = Res.Images.JETPACK_COMPOSE,
    ),
    Blender(
        skillName = "Blender",
        level = "Skilled",
        iconResLight = Res.Images.BLENDER,
        iconResDark = Res.Images.BLENDER,
    ),
    Figma(
        skillName = "Figma",
        level = "Novice",
        iconResLight = Res.Images.FIGMA,
        iconResDark = Res.Images.FIGMA,
    ),
    LaTex(
        skillName = "LaTex",
        level = "Skilled",
        iconResLight = Res.Images.LATEX,
        iconResDark = Res.Images.LATEX,
    ),
}