public class Creature
{
	private boolean isZombie;
	private int xValue;
	private int yValue;

	public Creature(boolean isZombie, int xValue, int yValue)
	{
		this.isZombie = isZombie;
		this.xValue = xValue;
		this.yValue = yValue;
	}

	public boolean getZombie()
	{
		return isZombie;
	}

	public int getXValue()
	{
		return xValue;
	}

	public int getYValue()
	{
		return yValue;
	}

	public void setZombie()
	{
		isZombie = true;
	}

	public void setXValue(int newXValue)
	{
		xValue = newXValue;
	}

	public void setYValue(int newYValue)
	{
		yValue = newYValue;
	}

	public String toString()
	{
		return "(" + xValue + "," + yValue + ")";
	}
}