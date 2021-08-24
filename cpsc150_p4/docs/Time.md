# Documentation

## `public class Time`

A class that represent a time of day using hours and minutes.

## `public Time()`

Sets minutes and hours to 0.

## `public Time(int hours, int minutes)`

Sets hours to the first parameter, and minutes to the second.

 * **Parameters:**
   * `hours` — The desired value for hours.
   * `minutes` — The desired value for minutes.

## `public Time addMinutes(int addMinutes)`

Creates a new Time object whose time is the this time plus a user-specified number of minutes.

 * **Parameters:** `addMinutes` — The number of minutes to add to the current time.
 * **Returns:** A new Time object whose time is this time plus addMinutes.

## `public int getHour()`

Gets the hour value for this Time.

 * **Returns:** This Time's hour.

## `public int getMinutes()`

Gets the minute value for this Time.

 * **Returns:** The minute value for this Time.

## `public String toString()`

Returns the time in a String formatted as HH:MM.

 * **Returns:** The time formatted as HH:MM

## `public static Time readTime(java.util.Scanner scnr)`

This method reads in a time from a Scanner (of form HHMM or HH:MM) and returns it as a Time object.

 * **Parameters:** `scnr` — The Scanner from which we read in the time.
 * **Returns:** The Time contained in the Scanner.

## `public static boolean isNumber(String str)`

Is static because it does not use any instance variables isNumber("123") returns true. isNumber("1L") returns false. Note: This method uses exceptions, which we will not learn this

 * **Parameters:** `str` — String to check
 * **Returns:** true if str holds a number, false otherwise
