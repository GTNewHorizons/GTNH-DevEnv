
@Suppress("UNCHECKED_CAST")
val workspaceModList = gradle.extensions.get("workspaceModList") as List<String>

val coremodId = "NewHorizonsCoreMod"

tasks.register("prepareWorkspace") {
    group = "DevEnv"
    workspaceModList.forEach {
        val build = gradle.includedBuild(it)
        this.dependsOn(build.task(":setupDecompWorkspace"))
    }
}

val tasksToForward = listOf(
    "assemble",
    "check",
    "build",
    "test",

    "runClient",
    "runClient17",
    "runServer",
    "runServer17",
)

tasksToForward.forEach {
    val taskName = it
    tasks.register(taskName) {
        group = "DevEnv"
        dependsOn(gradle.includedBuild(coremodId).task(":${taskName}"))
    }
}
