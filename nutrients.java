// Alice Tang Lab Assignment 3 - Grams of Nutrition Converter

import java.util.Scanner;

public class nutrients
{
   // food #1 constants
   static final String FOOD_1_NAME = "all-purpose flour";
   static final int FOOD_1_CALORIES_P100G = 364;  // in calories
   static final double FOOD_1_FAT_P100G = 0.98;   // in grams
   static final double FOOD_1_CARBS_P100G = 76.31;   // in grams
   static final double FOOD_1_PROTEIN_P100G = 10.33;   // in grams
   
   // food #2 constants
   static final String FOOD_2_NAME = "egg";
   static final int FOOD_2_CALORIES_P100G = 143;  // in calories
   static final double FOOD_2_FAT_P100G = 9.5;   // in grams
   static final double FOOD_2_CARBS_P100G = 0.7;   // in grams
   static final double FOOD_2_PROTEIN_P100G = 13.;   // in grams
   
   // food #3 constants
   static final String FOOD_3_NAME = "cheddar cheese";
   static final int FOOD_3_CALORIES_P100G = 104;  // in calories
   static final double FOOD_3_FAT_P100G = 33.;   // in grams
   static final double FOOD_3_CARBS_P100G = 3.1;   // in grams
   static final double FOOD_3_PROTEIN_P100G = 23;   // in grams
   
   // food #4 constants
   static final String FOOD_4_NAME = "potato";
   static final int FOOD_4_CALORIES_P100G = 93;  // in calories
   static final double FOOD_4_FAT_P100G = 0.1;   // in grams
   static final double FOOD_4_CARBS_P100G = 21.;   // in grams
   static final double FOOD_4_PROTEIN_P100G = 2.5;   // in grams
   
   // food #5 constants
   static final String FOOD_5_NAME = "tomato paste";
   static final int FOOD_5_CALORIES_P100G = 82;  // in calories
   static final double FOOD_5_FAT_P100G = 0.5;   // in grams
   static final double FOOD_5_CARBS_P100G = 19.;   // in grams
   static final double FOOD_5_PROTEIN_P100G = 4.3;   // in grams
   
   static final String INDENT = "   ";
   static final String SEPARATOR = "\n";
   
   public static void main(String[] args)
   {
      String recipeName, userInputStr;
      int recipeServingsInt, userInputInt;
      double totalCals, totalFat, totalCarbs, totalProtein,
         serCals, serFat, serCarbs, serProtein;
      Scanner inputStream = new Scanner(System.in);
      
      // initialize accumulator variables
      totalCals =  0;
      totalFat  = 0.;
      totalCarbs = 0.;
      totalProtein = 0.;
      
      // initialize result variables
      serCals = 0;
      serFat = 0.;
      serCarbs = 0.;
      serProtein = 0.;
      
      // print menu
      System.out.println("---------- List of Possible Ingredients ---------");
      System.out.println(INDENT + "Food #1: " + FOOD_1_NAME);
      System.out.println(INDENT + "Food #2: " + FOOD_2_NAME);
      System.out.println(INDENT + "Food #2: " + FOOD_3_NAME);
      System.out.println(INDENT + "Food #2: " + FOOD_4_NAME);
      System.out.println(INDENT + "Food #3: " + FOOD_5_NAME + SEPARATOR);      
      
      // name of recipe
      System.out.print("What is the recipe's name? ");
      recipeName  = inputStream.nextLine();
      
      // # of servings
      System.out.print("How many servings? ");
      userInputStr  = inputStream.nextLine();
      recipeServingsInt = Integer.parseInt(userInputStr);
      if ((recipeServingsInt > 15) || (recipeServingsInt < 1)) //servings range
      {
         System.out.println("Error: Enter a value between 1 and 15\n");
         System.exit(-1);
      }
      
      // food #1 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_1_NAME + "? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if ((userInputInt > 1500) || (userInputInt < 0)) //grams range
      {
         System.out.println("Error: Enter a value between 0 and 1500\n");
         System.exit(-1);
      }
      
      // update accumulators
      totalCals += userInputInt * (FOOD_1_CALORIES_P100G / 100.);
      totalFat  += userInputInt * (FOOD_1_FAT_P100G / 100.);
      totalCarbs  += userInputInt * (FOOD_1_CARBS_P100G / 100.);
      totalProtein  += userInputInt * (FOOD_1_PROTEIN_P100G / 100.);
      
      // food #2 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_2_NAME + "? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if ((userInputInt > 1500) || (userInputInt < 0)) //grams range
      {
         System.out.println("Error: Enter a value between 0 and 1500\n");
         System.exit(-1);
      }
      
      // update accumulators
      totalCals += userInputInt * (FOOD_2_CALORIES_P100G / 100.);
      totalFat  += userInputInt * (FOOD_2_FAT_P100G / 100.);
      totalCarbs  += userInputInt * (FOOD_2_CARBS_P100G / 100.);
      totalProtein  += userInputInt * (FOOD_2_PROTEIN_P100G / 100.);
      
      // food #3 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_3_NAME + "? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if ((userInputInt > 1500) || (userInputInt < 0)) //grams range
      {
         System.out.println("Error: Enter a value between 0 and 1500\n");
         System.exit(-1);
      }
      
      // update accumulators
      totalCals += userInputInt * (FOOD_3_CALORIES_P100G / 100.);
      totalFat  += userInputInt * (FOOD_3_FAT_P100G / 100.);
      totalCarbs  += userInputInt * (FOOD_3_CARBS_P100G / 100.);
      totalProtein  += userInputInt * (FOOD_3_PROTEIN_P100G / 100.);
      
      // food #4 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_4_NAME + "? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if ((userInputInt > 1500) || (userInputInt < 0)) //grams range
      {
         System.out.println("Error: Enter a value between 0 and 1500\n");
         System.exit(-1);
      }
      
      // update accumulators
      totalCals += userInputInt * (FOOD_4_CALORIES_P100G / 100.);
      totalFat  += userInputInt * (FOOD_4_FAT_P100G / 100.);
      totalCarbs  += userInputInt * (FOOD_4_CARBS_P100G / 100.);
      totalProtein  += userInputInt * (FOOD_4_PROTEIN_P100G / 100.);
      
      // food #5 ---------------------------------------------------------
      System.out.print("How many grams of " + FOOD_5_NAME + "? ");
      userInputStr = inputStream.nextLine();
      userInputInt = Integer.parseInt(userInputStr);
      if ((userInputInt > 1500) || (userInputInt < 0)) //grams range
      {
         System.out.println("Error: Enter a value between 0 and 1500\n");
         System.exit(-1);
      }
      
      // update accumulators
      totalCals += userInputInt * (FOOD_5_CALORIES_P100G / 100.);
      totalFat  += userInputInt * (FOOD_5_FAT_P100G / 100.);
      totalCarbs  += userInputInt * (FOOD_5_CARBS_P100G / 100.);
      totalProtein  += userInputInt * (FOOD_5_PROTEIN_P100G / 100.);   
      inputStream.close();
      
      // calculate results -----------------------------------------------
      serCals = totalCals / recipeServingsInt;
      serFat = totalFat / recipeServingsInt;
      serCarbs = totalCarbs / recipeServingsInt;
      serProtein = totalProtein / recipeServingsInt;
      
      // report results --------------------------------------------------
      System.out.println("\nNutrition for " + recipeName + " per serving"); 
      System.out.println(INDENT + "Calories: " + serCals + " cals");
      System.out.println(INDENT + "Fat: " + serFat + " grams");     
      System.out.println(INDENT + "Carbs: " + serCarbs + " grams"); 
      System.out.println(INDENT + "Protein: " + serProtein + " grams"); 
   }
}

/* -------------Sample Run #1-------------------------------------------
---------- List of Possible Ingredients ---------
   Food #1: all-purpose flour
   Food #2: egg
   Food #2: cheddar cheese
   Food #2: potato
   Food #3: tomato paste

What is the recipe's name? pasta
How many servings? 22
Error: Enter a value between 1 and 15
-------------------------------------------------------------------- */

/* -------------Sample Run #2--------------------------------------------
---------- List of Possible Ingredients ---------
   Food #1: all-purpose flour
   Food #2: egg
   Food #2: cheddar cheese
   Food #2: potato
   Food #3: tomato paste

What is the recipe's name? Alice's Pasta
How many servings? 7
How many grams of all-purpose flour? 110
How many grams of egg? 50
How many grams of cheddar cheese? 0
How many grams of potato? 0
How many grams of tomato paste? 45

Nutrition for Alice's Pasta per serving
   Calories: 72.68571428571428 cals
   Fat: 0.8647142857142857 grams
   Carbs: 13.263 grams
   Protein: 2.828285714285714 grams
-------------------------------------------------------------------- */

/* -------------Sample Run #3--------------------------------------------
---------- List of Possible Ingredients ---------
   Food #1: all-purpose flour
   Food #2: egg
   Food #2: cheddar cheese
   Food #2: potato
   Food #3: tomato paste

What is the recipe's name? Breakfast Potatoes
How many servings? 3
How many grams of all-purpose flour? 0
How many grams of egg? 25
How many grams of cheddar cheese? 20
How many grams of potato? 35
How many grams of tomato paste? 0

Nutrition for Breakfast Potatoes per serving
   Calories: 29.7 cals
   Fat: 3.003333333333334 grams
   Carbs: 2.715 grams
   Protein: 2.9083333333333337 grams
-------------------------------------------------------------------------- */

/* -------------Sample Run #4----------------------------------------------
---------- List of Possible Ingredients ---------
   Food #1: all-purpose flour
   Food #2: egg
   Food #2: cheddar cheese
   Food #2: potato
   Food #3: tomato paste

What is the recipe's name? Cheesy Baked Potato
How many servings? 4
How many grams of all-purpose flour? 0
How many grams of egg? 0
How many grams of cheddar cheese? 23
How many grams of potato? 44
How many grams of tomato paste? 0

Nutrition for Cheesy Baked Potato per serving
   Calories: 16.21 cals
   Fat: 1.9085 grams
   Carbs: 2.48825 grams
   Protein: 1.5975000000000001 grams
------------------------------------------------------------------------ */

/* -------------Sample Run #5----------------------------------------
---------- List of Possible Ingredients ---------
   Food #1: all-purpose flour
   Food #2: egg
   Food #2: cheddar cheese
   Food #2: potato
   Food #3: tomato paste

What is the recipe's name? Simple Gnocchi
How many servings? 14
How many grams of all-purpose flour? 220
How many grams of egg? 167
How many grams of cheddar cheese? 0
How many grams of potato? 250
How many grams of tomato paste? 0

Nutrition for Simple Gnocchi per serving
   Calories: 90.86500000000001 cals
   Fat: 1.3050714285714287 grams
   Carbs: 15.82507142857143 grams
   Protein: 3.6204285714285716 grams
------------------------------------------------------------------------ */