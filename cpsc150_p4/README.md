# `cpsc150_p4`

**CPSC150**
**Fall 2017**
**P4: Create Class Schedule**

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

The goal of this assignment is that you get practice with objects.

## Description

You will write the same program as last time, but this time, you will create a class named `Course`, a class named `Time`, and a class named `CNUScheduleMaker`.

## Sample Run

Unlike last time, you do no not need to ask the times each day of the week. You can assume that they are the same each day. Here is a sample run:

```
How many courses are you taking? 3
Enter the name of class number 1 -> CPSC150
Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> ME
E is not a valid day. Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> MWF
What time does CPSC150 start -> 900 Note: only asked for once
How many minutes does CPSC150 last -> 50 Note: only asked for once
Enter the name of class number 2 -> Math140
Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> ftm
What time does Math140 start -> 12:00 Note that times with and without :s are accepted
How many minutes does Math140 last? 50
Enter the name of class number 3 -> Phys151L
Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday-> T
What time does Phys151L start? -> 1800
How many minutes does Phys151L last -> 165

 ****** Your Course Schedule ******
 CPSC150: M 09:00-09:50
 CPSC150: W 09:00-09:50
 CPSC150: F 09:00-09:50
 Math140: F 12:00-12:50
 Math140: T 12:00-12:50
 Math140: M 12:00-12:50
Phys151L: T 18:00-20:45
```

## Classes To Write

Create classes named `Course`, `Time`, and `CNUScheduleMaker`.

### `Time`

You should create a new class, `Time`.
This class should have an `int` field called `hour` and an `int` field called `minute`.
Both `startTime` and `endTime` should be of type `Time`. 
[Here](docs/Time.md) is javadoc for `Time`. 
Here are the `readTime` and `isNumber` methods.
You will write the other `Time` methods.
Write `Time` first, and test it before you modify `P3` into being `CNUScheduleMaker`.

```java
public void readTime(java.util.Scanner scnr) {
    String s = scnr.next( );
    if  (isNumber(s)) {
        int nbr = Integer.parseInt(s);
        minutes = nbr %100;
        hours = nbr / 100;
        return;
    }
    int colonIndex = s.indexOf(':');
    if (colonIndex == -1) {
        System.out.println("Invalid time format");
        System.exit(1);
    }
    hours = Integer.parseInt(s.substring(0,colonIndex));
    minutes = Integer.parseInt(s.substring(colonIndex+1));
}

/** returns true if String is a number, false otherwise
 * Is static because it does not use any instance variables
 * isNumber("123") returns true. isNumber("1L") returns false.
 * Note: This method uses exceptions, which we will not learn this
 semester.
 * @param str String to check 
 * @returns true if str holds a number, false otherwise
 */  
public static boolean isNumber(String str)  
{  
    try  
    {  
       int nbr = Integer.parseInt(str);  
    }  
    catch(NumberFormatException e)  
    {  
        return false;
    }  
    return true;
}
```

### `Course`

[Here is the API](docs/Course.md) for the class `Course`. 
You should have the following instance variables: 
a `name` (of type `String`) a `startTime` (of type `Time`), an `endTime` (of type `Time`),
a list of days that the course meets (of type `char[ ]`), and a nbrMeetingsPerWeek (of type `int`). 
You will need a default constructor, and a constructor that has the `name`, `days`, `startTime` and `endTime`. 
Finally, you will need a `toString` method that converts the information in `Course` to a `String`.

### `CNUScheduleMaker`

`CNUScheduleMaker` will be simplified from `P3` because much of the work is done by the `Course` class.
You will need two instance variables, an array of type `Course` named `courses`, and a `Scanner` object named `kbd`. 
Here are the methods that you should have for `CNUScheduleMaker`:

 * `CNUScheduleMaker` constructor.
 The default (and only) constructor initializes the instance variables. 
 Copy as is.
 
 ```java
 public CNUScheduleMaker (Scanner myKbd ) {
     kbd = myKbd;
 }
 ```

 * `public String getDays(String className)` 
 Except that the `Scanner` object is now an instance variable instead of a parameter, this method is unchanged from `P3.java`.
 
 * `public Time getStart(String courseName)`
 Mostly unchanged from P3, but there are a few modifications.
 The method will prompt the user to enter a time, but will be called only once for each course.
 You may assume that classes start and end at the same time each day of the week that they meet.
 Second, the method returns an object of type `Time`, not `int`.
 That means that you will need to create a `Time` object, then call its `readTime` method to read in the information. 
 And last, I have simplified the message because users can enter either `900` or `9:00` -- the `readTime` will read both times correctly 
 (notice the `:` in `12:00` for `Math140` in the sample run).
 
 * `public Time getEnd(Time startTime, String courseName)` 
 Mostly unchanged from P3, but there are a few modifications.
 The method will prompt the user to enter a time, but will be called only once for each course.
 You may assume that classes start and end at the same time each day of the week that they meet.
 Second, the method returns an object of type `Time`, not `int`.
 That means that you will need to create a `Time` object, then call its `readTime` method to read in the information. 
 And last, I have simplified the message because users can enter either `900` or `9:00` -- the `readTime` will read both times correctly 
 (notice the `:` in `12:00` for `Math140` in the sample run).
 
 * `public void getInfo( )` 
 This has a MUCH smaller parameter list than last time, 
 but has the same functionality except that each class meets at the same time and for the same amount each day of the week.
 This method begins asking the user to enter the number of courses he/she is taking and then reads that number.
 It then asks for the name, meeting days, start time, and the length of each meeting of the course.
 After reading all information about a course, create a new `Course` by calling the constructor that accepts all of these parameters. 
 Then assign that new course to the next value in a `Course` array.
 
 * `public void printSchedule( )` 
 Again, this method does almost the same thing that its P3 version did, but with a no parameters
 (because all information is stored in the instance variables).
 Because each `Course` knows how to print itself with the toString method, you can print it as you print any variable (like an `int` or a `String` variable).
 One difference is that you can print Time objects in a System.out.print because you have written a `toString` method.
 
 * `main`
 Here is the code that you should use 
 (note: by convention, main goes at the end of the file and constructors go immediately after the instance variables):
 
 ```java
 public static void main(String[ ] args) {
    Scanner kbd = new Scanner(System.in);
    CNUScheduleMaker mySchedule = new CNUScheduleMaker(kbd);
    mySchedule.getInfo( );
    mySchedule.printSchedule( );
 }
 ```
  
 * No other methods. 
 In particular, you can delete `calcEnd` and `toTime`, but you may use much of that functionality in the Time class methods. 

## Testing
As you write the program, compile and test frequently. 
Write the methods first, and test them by running them, but you do not need to write junit tests. 
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

Your program should be named `CNUScheduleMaker.java`. 
You should commit it in parts to gitlab. 
Write one method at a time. 
Make sure each method works before writing another. 
You will submit the program using gitlab. 
Make sure that the program is named CNUScheduleMaker.java. 
You will submit the program using gitlab.
You can fork this project to your gitlab account. 
Make sure that you add your partner as a developer, and your instructor as a reporter. 
You should have your first commit before Thursday, November 4 at midnight. 
Remember that you should develop your code is small parts, so your first commit should not be your entire program. 
Continue to make incremental commitments 
(alternate who is the driver by having you do about half the commits, and your partner do about half the commits). 
Make sure that the program is named CNUScheduleMaker.java. 
You will be graded on both you and your partner making commits. 