# CODING CHALLENGE FOR ACONEX

## Getting Started

### Build

To build the project run 
'mvn clean install' or `mvn clean package`.
The finalized JAR should be generated in the target folder.

## Sample Usage


## Scenario 1 : Read phone numbers from STDIN:


### Default dictionary
```sh
java -jar CodingChallenge-1.0-SNAPSHOT.jar
```

### Provided dictionary
```sh
java -Ddic.file-/path/to/dictionary -jar CodingChallenge-1.0-SNAPSHOT.jar
```

This should prompt for an input of a phone number like so:
Enter the phone number(q for quit): 

You can chose to either enter a phone number, or q to quit the console straight away.

Once you enter the number, the program should spit out the possible combinations for the given number

I have deliberately kept the output clean as that was the requirement. The program can be customized to make the output more fancy and more readable

## Scenario 2: Read numbers from a given file(\n separated)

### Default Dictionary
```sh
java -jar CodingChallenge-1.0-SNAPSHOT.jar /path/to/file1 /path/to/file2 <and so on>
```
I have used the dictionary from the following link: https://github.com/first20hours/google-10000-english/blob/master/google-10000-english-no-swears.txt
and added a couple of more words here and there for testing purposes

### Provided Dictionary
```sh
java -Ddic.file-/path/to/dictionary -jar CodingChallenge-1.0-SNAPSHOT.jar /path/to/file1 /path/to/file2 <and so on>
```

The program should spit out the possible combinations for the given numbers in the files all together

I have deliberately kept the output continuous as that was the requirement. The program can be customized to make the output more fancy and more readable

### Test

Building with `mvn clean package` or `mvn clean package` should successfully runs unit tests.
  
## Approach

**Utils** - To help clean up dirty strings(such as invalid phone numbers, mixed punctuations for dictionary words etc)

**Delegate** - to delegate the phone number to the respective handlers(STDIN/FILE handler), and also to the respective algo implementation

**Algo** - This forms the core of the algorithm running at the backend. Algo as follows
  1. Iterate through each prefix  and search for matching word(s).
  2. If matching word(s) can be found use ,
  3. Make a recursive call to get all combinations of the remaining suffix.
  4. Concatenate the matching combinations of the prefix and the suffix.

