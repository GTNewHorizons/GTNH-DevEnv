# Combined GT5u + GTNH Addons dev workspace

Combines GT5u and many GT addons into one big workspace for easy development of cross-mod changes and large-scale refactoring.

Each individual addon is a git submodule ([read the docs here](https://git-scm.com/book/en/v2/Git-Tools-Submodules)), so you can locally set up separate branches in each of them and push to their respective upstreams for making PRs.

# Setup instructions

```bash
git clone https://github.com/GTNewHorizons/GTNH-DevEnv.git
cd GTNH-DevEnv
git submodule update --init
./gradlew prepareWorkspace
```

Now you can open the folder as an IDEA workspace and work on the mods as you wish. Importing the project for the first time might take a significant amount of time, be prepared.

You can `cd` into the individual mods, add git remotes, push, pull like usual - just make sure to not make PRs to the devenv repository (it will be periodically updated with the latest master versions of mods for convenience).



# Tips and tricks

### Use the SSH protocol instead of HTTPS locally for this folder
Run the following in your console/git bash:
```bash
git config 'url.ssh://git@github.com/.insteadOf' 'https://github.com/'
```

### Verify if [dependency substitution](https://docs.gradle.org/8.1/userguide/composite_builds.html#included_build_declaring_substitutions) is working
```bash
./gradlew NHCM:dependencies --configuration=compileClasspath
```

Output when it works:
```
...
+--- com.github.GTNewHorizons:TecTech:5.1.7 -> project :TecTech
+--- com.github.GTNewHorizons:bartworks:0.6.10 -> project :bartworks
...
```

### Add a new mod to co-develop

```bash
git submodule add https://github.com/GTNewHorizons/NewHorizonsCoreMod.git
```
And then add it to the list in settings.gradle.kts
