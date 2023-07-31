# Offline Daylight Stop

### Offline Daylight Stop is a [Fabric mod](https://www.fabricmc.net/) for [Minecraft](https://www.minecraft.net/en-us) 1.20.1

# Features

Offline Daylight Stop pauses Minecraft's Daylight cycle while there are no players on the server.

This mod is extremely lightweight (a single Java file), and does little by itself, but enhances immersion when using other mods such as [Fabric Seaons](https://modrinth.com/mod/fabric-seasons).

### How it works

* When the server has 0 players online, a timer is started. Once the timer expires, the `doDaylightCycle` gamerule is set to `false`.
* When a player connects, the `doDaylightCycle` gamerule is set to `true`.

The timer is set to a random value between 12 and 24 in-game hours (10 and 20 minutes in real time, respectively). This small time window keeps the little surprise of the time of day being different each time you join intact, and allows some time for things like weather to pass.

Obviously, this mod is intended for use on Survival servers that do not toy with the `doDaylightCycle` gamerule.

Offline Daylight Stop is a **Fabric Mod** and is developed exclusively for the Fabric mod loader. The LGPL license means that you are free to port Offline Daylight Stop to another mod loader, such as NeoForge.

Builds can be found on Modrinth, or the github repo.

# Client / Server

Offline Daylight Stop is a server-side mod. It does not need to be installed on clients to work.

# Dependencies

**Minecraft version:** 1.20.1

|                    Name | Version | Modrinth Page     | GitHub Repository | Client/Server |
|------------------------:|:-------:|:-----------------:|:-----------------:|:-------------:|
|              Fabric API | 0.85.0+ | [link][fabric_MR] | [link][fabric_GH] | **Both**      |

# Building

Clone the repo and follow the standard Fabric setup.

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

Once setup, run the `build` gradle task. You will find the compiled jar file in `build/libs/`.

# Authors

Lafolie - developer.

# License

Offline Daylight Stop is licensed under the GNU Lesser General Public License v3.

[fabric_MR]: https://modrinth.com/mod/fabric-api
[fabric_GH]: https://github.com/FabricMC/fabric