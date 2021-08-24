# `cpsc150_p3`

**CPSC150**
**Fall 2017**
**P3: Create Class Schedule**

## Preliminaries

Please refer to [PCSE's git tutorial](https://gitlab.pcs.cnu.edu/cpsc-labs/bash-and-git-wiki/wikis/home) if you need further reference.

You only need to do step 1 a single time for my class.
You need to do step 2 once for each project I give.

1. Create a group on Gitlab called `firstname.lastname.yy-cpsc150` and add me to that group as a **reporter** (follow instructions under **Creating a Gitlab Group** [here](https://gitlab.pcs.cnu.edu/cpsc-labs/bash-and-git-wiki/wikis/tutorials/git-setup)).
Your group name should look like your CNU email address with a `-cpsc150` on the end instead of a `@cnu.edu`.

2. Click the "Fork" button on this page (see image below) and select your newly created group as the place to which you will fork this repository.
![Click the fork button under the repository name](https://gitlab.pcs.cnu.edu/cpsc-labs/bash-and-git-wiki/wikis/tutorials/images/gitlab-fork.png)

## Workflow Proper

This section describes the general workflow for a Git enabled project with a single developer.
For the rest of the tutorial, ensure that Git Bash (Windows) or a terminal (Mac or Linux) is open.

### First time working on current machine

You only need to follow these steps if this is the first time working on a project on the current computer (if you're on the lab machines, you have to do this each time you log on).

1. Inside the directory in which you store your repositories run `pwd`.
This command will tell you where you currently are (in Windows this is much less helpful, however if it outputs `/home/username` or `~` then this corresponds to `C:\users\<username here>`).
Take note of its output as this is where Git will place your assignment.

2. Near the fork button, there is a text box with a URL in it.
Ensure that this box has `HTTPS` next to it and then copy the URL.
**This URL should begin with `https`!!!!**

3. In your terminal/Git Bash, type `git clone` and then paste the URL.
If the command looks as follows, go ahead and press enter.
```
git clone https://gitlab.pcs.cnu.edu/<container name>/<repo name>
```

Proceed to the next section.

### After cloning

Once you've cloned the repository to your current machine, you can just follow these steps.

1. If you just cloned the repository, you can ignore this step.
If you've worked on the project on another machine and wish to update the copy on your current computer, run `git pull`.

2. Do changes. (Differs for each project)

3. Track your changes using `git add .` .
This tells Git to figure out what changed between the repository's previous state and its current state.

4. Double check your changes using `git status`.
Running `git status` will tell you what files you've added, what files you've removed, and what files you've modified so inspect its output carefully.
If you're not happy about its output, go back to step 2 and fix what you don't like.

5. Commit your changes using `git commit -m "Commit message here"`.
This will **permenantly log** the changes you've made in your repository.
Once you've committed your changes, you can view the commit's *hash* and your commit message for it using `git log`.

6. Push your changes back to Gitlab using `git push`.
This uploads your changes to Gitlab so that you have a backup that you can share with your professor and teammates.

7. Check the CI pipeline on Gitlab to see the automated feedback that Gitlab provided (if enabled for your project).

## Goal

The goal of this assignment is that you get practice with arrays.

## Sample Run

In this program, you will ask the user to enter their schedule, then print it out.
Here is a sample run:
```
How many courses are you taking? 3
Enter the name of class number 1 -> CPSC150
Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> ME
E is not a valid day. Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> MWF
What time does CPSC150 start on M? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 900
How many minutes does CPSC150 last on M-> 50
What time does CPSC150 start on W? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 930
How many minutes does CPSC150 last on W-> 50
What time does CPSC150 start on F? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 930
How many minutes does CPSC150 last on F-> 60
Enter the name of class number 2 -> Math140
Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> ftm
What time does Math140 start on F? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 1200
How many minutes does Math140 last on F-> 50
What time does Math140 start on T? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 1200
How many minutes does Math140 last on T-> 60
What time does Math140 start on M? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 1200
How many minutes does Math140 last on M-> 75
Enter the name of class number 3 -> Phys151L
Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> T
What time does Phys151L start on T? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 1800
How many minutes does Phys151L last on T-> 165

****** Your Course Schedule ******
CPSC150: M 09:00-09:50
CPSC150: W 09:30-10:20
CPSC150: F 09:30-10:30
Math140: F 12:00-12:50
Math140: T 12:00-13:00
Math140: M 12:00-13:15
Phys151L: T 18:00-20:45
```

## The Assignment Overview

Your program should be named `P3.java` You should commit it in parts to Gitlab.
Write one method at a time and commit each to Gitlab according to the schedule below.
For the deadlines below, the push should include a `P3.java` with the method (and previous methods so that you build `P3.java` gradually), the javadoc for the method (and previous methods), and `P3Test.java` that includes one junit test testing the method (and previous methods).
Write each method without paying attention to the program as a whole.
Include a screenshot of the method passing (and previous methods).
Even though you only need one junit test per method, make sure you test each method extensively.
You do not need to include junit tests for methods that return a `void` (that is `printSchedule` and `main`).

| Method | Pushed to your Gitlab group by |
| ------ | ------------------------------ |
| `toTime` | Thursday, October 19 |
| `getStart` | Friday, October 20 |
| `calcEnd` | Sunday, October 22 |
| `getEnd` | Tuesday, October 24 |
| `getDays` | Thursday, October 26 |
| `getInfo` | Saturday, October 28 |
| `printSchedule` | Monday, October 30 (no junit test needed) |
| `main` and all screen shots | Tuesday, October 31 (no junit test needed)|

## Description of Methods

* `public static String toTime(int time)`
This method takes an integer, and uses `String` format to return a value in time format.
For example, 920 should return "09:20".
2 would return "00:02".
You should do this by breaking the parameter up into the hundreds digits (`parameter/100`) and 0 filling the value (`String.format("%02d",9) returns "09"`). Then, append a `":"` character then the last 2 digits of the parameter (`parameter % 100`).
  - `toTime(920)` should return `"09:20"`
  - `toTime(1234)` should return `"12:34"`
  - `toTime(1)` should return `"00:01"`
* `public static int getStart(Scanner kbd, String courseName, char day)`
This method reads in (as an integer) the start time for `courseName` on `day`, and returns the result.
A sample run for `getStart(kbd, "Phys151L", 'T')` would produce:

```
What time does Phys151L start on T? Enter time as an integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> 1800
```

and would return the integer 1800.
* `public static int calcEnd(int begin, int length)`
This method takes a beginning time and a duration and returns an ending time.
  - `calcEnd(900, 50)` should return 950
  - `calcEnd(930, 50)` should return 1020
  - `calcEnd(950, 150)` should return 1220
To do this, you will need to split the begin time into hours and minutes, add the number of minutes to length, then convert that into the number of hours to add if the total number of minutes is >60.
Solve this on paper, and write the steps down before writing it in Java.
The solution requires a loop (in the case that you will need to add more than one hour as in `calcEnd(950, 150)`).
* `public static int getEnd(Scanner kbd, int startTime, String courseName, char day)`
This method reads in from `kbd` the number of minutes that `courseName` lasts on day, and returns as an integer the time that the course will end starting at `startTime`.
This method should call `calcEnd`.
  - `getEnd(kbd, 900, "CPSC150", 'M')` returns 950 if 50 is entered.
  - `getEnd(kbd, 930, "CPSC150", 'M')` returns 1020 if 50 is entered.
  - `getEnd(kbd, 1800, "Phys151L", 'M')` returns 2045 if 165 is entered.
* `public static String getDays(Scanner kbd, String className)`
`getDays` reads the days of the week from `kbd` that `className` meets.
The user should enter the days as a `String` (e.g., `"MWF"`); the method method should contain a validation loop to verify that each character in the `String` is a day of the week (`M`, `T`, `W`, `R`, or an `F`).
If one character is not a day of the week, the user should reenter the string.
The method should return the `String` that is entered.
For example, the input and output below, repeated from the sample run, should be in `getDays`:

```
Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> ME
E is not a valid day. Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> MWF
```

* `public static int getInfo(Scanner kbd, int [ ] startTime, int[ ] endTime, String[ ] names, char[ ] dayInSched, int nbrCourses )`
This method reads in all of the information for the program, and populates the arrays with the information.
Before this method, all arrays are empty; after this method, all of the arrays are populated with the information read in by the user.
It should read in `nbrCourses` number of courses.
For each course, it should read the days of the week that the course meets (by calling `getDays`).
For each day that the course meets, the method should call `getStart` and `getEnd`.
`getInfo` should return the number of time slots that the user has in the schedule (e.g., if the user is taking 2 courses that both meet 3 times per week, this method returns 6).
* `public static void printSchedule(int[ ] startTime, int[ ] endTime, String[ ] names, char[ ] days, int length)`
This method prints the schedule with each index as a row from 0 to length. For example if the first class meeting is CPSC150, a 50 minute class at 9AM on Monday, the first line printed by `printSchedule` would display: `CPSC150: M 09:00-09:50`.
* `main`
You should use this `main`.
Do not modify it:

```java
public static void main(String[ ] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.print("How many courses are you taking? ");
        int nbrCourses = kbd.nextInt( );
        // there will be a max of 5 class meetings for each course,
        // so the size of the array is nbrCourses * 5
        int[ ] startTime = new int[nbrCourses*5];
        int[ ] endTime = new int[nbrCourses*5];
        String[ ] names = new String[nbrCourses*5];
        char[ ] days = new char[nbrCourses*5];
        // the actual number of class meetings is nbrTimes
        int nbrTimes = getInfo(kbd, startTime, endTime, names, days, nbrCourses );
        printSchedule(startTime, endTime, names, days, nbrTimes );
    }
```

## Testing
As you write the program, compile and test frequently.
Write the methods first, and write a junit test for each.
For methods that have `Scanner` as a parameter, you can use this [`P2Test.java`](http://www.pcs.cnu.edu/~lambert/Classes/Fall16/P2Test.java) example, `readWgrade`, which reads a W grade into `getGrade`.
Use Gitlab to commit each method, a junit test and a screenshot of your junit tests passing.
Once you have written every method, include a screenshot of the entire program running.

## Documentation
Write javadoc for each method and one javadoc comment for the program as a whole.
The program as a whole should include a comment with your name and your partner's name.
Indicate in the comment how long it took you to work on the program.
If you do not have a partner, include an explanation of why you do not.
If anybody helped you on the program, write a note about how they helped.
If you helped anybody or received help, include a comment about that.
You should also include a one line description of what the program does.

## Submitting the program
You will submit the program using Gitlab.
Make sure that the program is named `P3.java` and that your test program is named `P3Test.java`.
You will submit the program using Gitlab.
Make sure that you add your partner as a developer, and your instructor as a reporter to your fork (one fork per team required).
You should have your first commit before Wednesday, October 11th at midnight.
Remember that you should develop your code is small parts, so your first commit should not be your entire program.
Continue to make incremental commitments (alternate who is the driver by having you do about half the commits, and your partner do about half the commits).
Make sure that the program is named `P3.java`.
You will be graded on both you and your partner making commits.

**BE CAREFUL.**
A green checkmark on your repository means that Gitlab was able to compile and run your code against **your** tests.
Do not assume that a green checkmark means that you'll get an A.
