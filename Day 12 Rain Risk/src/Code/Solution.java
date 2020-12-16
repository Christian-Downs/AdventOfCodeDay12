package Code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static char directionFacing = 'E';
	public static int north =0,
						east = 0;
	public static HashMap<Character,Integer> waypoint = new HashMap<Character,Integer>();
	public static void main(String[] args)
	{
		try {
			
			waypoint.put('E',10);
			waypoint.put('N', 1);
			File myFile = new File("input.txt");
		
			Scanner scn = new Scanner(myFile);

			while(scn.hasNextLine())
			{
				
				String currentLine = scn.nextLine();
				char currentDirection = currentLine.charAt(0);
				int howFar = Integer.parseInt(currentLine.substring(1)) ;
				
				if(Character.compare(currentDirection, 'R')==0||Character.compare(currentDirection, 'L')==0)
				{
					int howManyTurns = howFar/90;
					if(Character.compare(currentDirection, 'R')==0) 
					{
						for(int i =1;i<=howManyTurns;i++)
						{
							TurnRight();
						}
						
						
					}
					else
					{
						for(int i =1;i<=howManyTurns;i++)
						{
							TurnLeft();
						}
					}
					System.out.println("the boat is facing " + directionFacing);
				}
				else {	
				
				switch(currentDirection)
				{
				case 'F':
//					switch(directionFacing)
//					{
//					case 'N':
//						North(howFar);
//						break;
//					case 'E':
//						East(howFar);
//						break;
//					case 'W':
//						West(howFar);
//						break;
//					case 'S':
//						South(howFar);
//						break;
//					}
					
					MoveForward(howFar);
					break;
				case 'N':
					North(howFar);
					break;
				case 'E':
					East(howFar);
					break;
				case 'W':
					West(howFar);
					break;
				case 'S':
					South(howFar);
					break;
				}
				}
				
			}
			
			scn.close();
			
			String output = "";
			
			output+= north>=0? "Goes North " + north:"Goes South " + (north *-1);
			output += east>=0?" times and goes East " + east + " times":" times and goes West " + (east*-1) + " times";
			System.out.println(output);
			
			System.out.println(Math.abs(north) + Math.abs(east));
			
			
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void MoveForward(int howManyTimes)
	{
		for(int i = 0; i<howManyTimes;i++)
		{
			east+= waypoint.get('E');
			north+= waypoint.get('N');
		}
		System.out.println("The North is now " + north+ " the east is now " + east);
		
	}
	
	public static void TurnRight() 
	{
//		switch(directionFacing)
//		{
//		case 'N':
//			directionFacing='E';
//			break;
//		case 'E':
//			directionFacing='S';
//			break;
//		case 'W':
//			directionFacing='N';
//			break;
//		case 'S':
//			directionFacing='W';
//			break;
//		}
		int xOfWaypoint = waypoint.get('E');
		int yOfWaypoint = waypoint.get('N');
		
		waypoint.replace('E', yOfWaypoint);
		waypoint.replace('N', xOfWaypoint *-1);
	}
	
	public static void TurnLeft()
	{
//		switch(directionFacing)
//		{
//		case 'N':
//			directionFacing='W';
//			break;
//		case 'E':
//			directionFacing='N';
//			break;
//		case 'W':
//			directionFacing='S';
//			break;
//		case 'S':
//			directionFacing='E';
//			break;
//		}
		int xOfWaypoint = waypoint.get('E');
		int yOfWaypoint = waypoint.get('N');
		
		waypoint.replace('E', yOfWaypoint *-1);
		waypoint.replace('N', xOfWaypoint);
		
	}
	
	public static void North(int howManyTimes)
	{
		System.out.println("North " + howManyTimes);
		waypoint.replace('N', waypoint.get('N')+ howManyTimes);
	}
	public static void South(int howManyTimes)
	{
		System.out.println("South " + howManyTimes);
		waypoint.replace('N', waypoint.get('N')- howManyTimes);
	}
	public static void East(int howManyTimes)
	{
		System.out.println("East " + howManyTimes);
		waypoint.replace('E', waypoint.get('E')+ howManyTimes);
	}
	public static void West(int howManyTimes)
	{
		System.out.println("West " + howManyTimes);
		waypoint.replace('E', waypoint.get('E')- howManyTimes);
	}
	
	
}
