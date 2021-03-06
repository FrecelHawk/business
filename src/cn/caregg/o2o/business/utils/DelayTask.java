package cn.caregg.o2o.business.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DelayTask {
	public static void startDelayedTask(long delayedTime, Runnable runnable) {
		ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
		pool.schedule(runnable, delayedTime, TimeUnit.MINUTES);
	}

	public static ScheduledFuture<?> startTaskAtFixedRate(long delayedTime, long period, TimeUnit unit,
			Runnable runnable) {
		ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
		return pool.scheduleAtFixedRate(runnable, delayedTime, period, unit);
	}
}
