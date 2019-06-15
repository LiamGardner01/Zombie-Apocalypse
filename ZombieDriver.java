import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ZombieDriver
{
	public static void main(String[] args)
	{
		ZombieDriver zD = new ZombieDriver();
		zD.start();
	}

	public void start()
	{
		ArrayList<Creature> creatures = new ArrayList<Creature>();

		int size = 0;

		try
		{
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);

			if(sc.hasNext())
			{
				size = Integer.parseInt(sc.nextLine());

				creatures.add(addCreature(sc.nextLine(), true));

				String[] add = sc.nextLine().split("\\)");

				for(int i = 0; i < add.length; i++)
				{
					creatures.add(addCreature(add[i], false));
				}

				String moves = sc.nextLine();

				play(creatures, moves, size);
			}
			else
			{
				System.out.println("The input file is empty");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File does not exist");
		}
	}

	public Creature addCreature(String holder, boolean zombie)
	{
		int xValue = holder.charAt(1) - 48;
		int yValue = holder.charAt(3) - 48;

		return new Creature(zombie, xValue, yValue);
		
	}

	public void play(ArrayList<Creature> creatures, String moves, int size)
	{
		int conversions = 0;

		ArrayList<Creature> c = new ArrayList<Creature>();
		c.add(creatures.get(0));

		for(int x = 0; x < creatures.size(); x++)
		{
			if(c.get(x).getZombie())
			{
				for(int j = 0; j < moves.length(); j++)
				{
					if(moves.charAt(j) == 'U')
					{
						c.get(x).setYValue(c.get(x).getYValue() - 1);
					} 
					else if(moves.charAt(j) == 'D')
					{
						c.get(x).setYValue(c.get(x).getYValue() + 1);
					}
					else if(moves.charAt(j) == 'L')
					{
						c.get(x).setXValue(c.get(x).getXValue() - 1);
					} 
					else if(moves.charAt(j) == 'R')
					{
						c.get(x).setXValue(c.get(x).getXValue() + 1);
					}

					if(c.get(x).getYValue() < 0) c.get(x).setYValue(size-1);
					if(c.get(x).getYValue() >= size) c.get(x).setYValue(0);
					if(c.get(x).getXValue() < 0) c.get(x).setXValue(size-1);
					if(c.get(x).getXValue() >= size) c.get(x).setXValue(0);  	

					for(int i = 0; i < creatures.size(); i++)
					{
						if(c.get(x).getXValue() == creatures.get(i).getXValue() && c.get(x).getYValue() == creatures.get(i).getYValue() && !creatures.get(i).getZombie())
						{
							creatures.get(i).setZombie();
							conversions++;

							c.add(creatures.get(i));
						}
					}
				}
			}
			else
			{
				break;
			}
		}

		System.out.println("Zombies Scored: " + conversions + "\nZombie Positions:\n" + c);
	}
}