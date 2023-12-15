package hu.cubix.logistics.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "logistics")
@Component
public class LogisticsConfig {

	private Delay delay;

	public Delay getDelay()
	{
		return delay;
	}

	public void setDelay(Delay delay)
	{
		this.delay = delay;
	}

	public static class Delay{
		private long firstminlimit;
		private long secondminlimit;
		private long thirdminlimit;

		public long getFirstminlimit()
		{
			return firstminlimit;
		}
		public long getSecondminlimit()
		{
			return secondminlimit;
		}
		public long getThirdminlimit()
		{
			return thirdminlimit;
		}
		public void setFirstminlimit(long firstminlimit)
		{
			this.firstminlimit = firstminlimit;
		}
		public void  setSecondminlimit(long secondminlimit)
		{
			this.secondminlimit = secondminlimit;
		}
		public void setThirdminlimit(long thirdminlimit)
		{
			this.thirdminlimit = thirdminlimit;
		}
	}

	private DecreasePercent decreasePercent;

	public DecreasePercent getDecreasePercent()
	{
		return decreasePercent;
	}

	public void setDecreasePercent(DecreasePercent decreasePercent)
	{
		this.decreasePercent = decreasePercent;
	}

	public static class DecreasePercent{
		private long firstpercentlimit;
		private long secondpercentlimit;
		private long thirdpercentlimit;

		public long getFirstpercentlimit()
		{
			return firstpercentlimit;
		}
		public long getSecondpercentlimit()
		{
			return secondpercentlimit;
		}
		public long getThirdpercentlimit()
		{
			return thirdpercentlimit;
		}
		public void setFirstpercentlimit(long firstpercentlimit)
		{
			this.firstpercentlimit = firstpercentlimit;
		}
		public void  setSecondpercentlimit(long secondpercentlimit)
		{
			this.secondpercentlimit = secondpercentlimit;
		}
		public void setThirdpercentlimit(long thirdpercentlimit)
		{
			this.thirdpercentlimit = thirdpercentlimit;
		}
	}


}
