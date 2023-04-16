rootProject.name = "gtnh-devenv"

val workspaceModList = listOf(
    "GT5-Unofficial",
    "bartworks",
    "GTplusplus",
    "TecTech",
    "NewHorizonsCoreMod",
)
gradle.extensions.add("workspaceModList", workspaceModList)

workspaceModList.forEach {
    includeBuild(it)
}
