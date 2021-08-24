# Documentation

## `public Course()`

Creates a new `Course` whose name is the empty `String`, the days it meets is a new character array of length 5, the number of times it meets is 0, and the start and end times are blank times.

## `public Course(String courseName, Time start, Time end, String meetDays)`

Creates a new `Course` whose name is as given, its start time is a copy of the given start time, its end time is a copy of the given end time, and it meets on the given days.

 * **Parameters:**
   * `courseName` — The name of the course.
   * `start` — The start time to copy into this `Course`.
   * `end` — The end time to copy into this `Course`.
   * `meetDays` — Contains the characters that should be copied to the days array

## `public String toString()`

Returns a multiline String (use `'\n'` to insert a return character).
Each line should be formatted as `name: dayofweek starttime-endtime`. 
For example if the name is `"CPSC150"`, the days are `MWF`, the start time is 10:00, and the end time is 10:50, this will return:

``` 
CPSC150: M 10:00-10:50
CPSC150: W 10:00-10:50
CPSC150: F 10:00-10:50 
```

 * **Returns:** A multiline String containing the schedule for this course.
