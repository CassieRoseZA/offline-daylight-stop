package lafolie.etc;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.random.Xoroshiro128PlusPlusRandom;
import net.minecraft.world.GameRules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OfflineDaylightStop implements DedicatedServerModInitializer
{
	public static final Logger LOG = LoggerFactory.getLogger("offline-daylight-stop");
	private static final Random RAND = new Xoroshiro128PlusPlusRandom(Util.getEpochTimeMs());
	private static int TICKS = 0;
	private static int NEXT_STOP = 12000;

	@Override
	public void onInitializeServer()
	{
		ServerTickEvents.START_SERVER_TICK.register(OfflineDaylightStop::stopTimeIfNoPlayers);
	}

	private static void stopTimeIfNoPlayers(MinecraftServer server)
	{
		if(server.getCurrentPlayerCount() > 0)
		{
			TICKS = 0;
			if(!server.getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).get())
			{
				server.getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set(true, server);
				LOG.info("Started daylight cycle. Time is {}", server.getOverworld().getTimeOfDay());
			}
		}

		TICKS = Math.min(99999, TICKS + 1);

		if((TICKS > NEXT_STOP) && (TICKS < 99999))
		{
			if(server.getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).get())
			{
				server.getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE).set(false, server);
				LOG.info("No players online for {} ticks. Stopped daylight cycle. Time is {}", NEXT_STOP, server.getOverworld().getTimeOfDay());
				NEXT_STOP = RAND.nextBetween(12000, 24000);
				TICKS = 99999;
			}
		}
	}
}