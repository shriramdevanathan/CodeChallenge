# CODING CHALLENGE FOR ACONEX

## Getting Started

### Build

To build the project run 
'mvn clean install' or `mvn clean package`.
The finalized JAR along with sample dictionaries and inputs can be found in the `target` directory.

## Sample Usage


Scenario 1 : Read phone numbers from STDIN:


## Default dictionary
```sh
java -jar CodingChallenge-1.0-SNAPSHOT.jar
```

## Provided dictionary
```sh
java -Ddic.file-/path/to/dictionary -jar CodingChallenge-1.0-SNAPSHOT.jar
```

This should prompt for an input of a phone number like so:
Enter the phone number(q for quit): 

You can chose to either enter a phone number, or q to quit the console straight away.

Once you enter the number, the program should spit out the possible combinations for the given number


Scenario 2: Read numbers from a given file(\n separated)

## Default Dictionary
```sh
java -jar CodingChallenge-1.0-SNAPSHOT.jar /path/to/file1 /path/to/file2 <and so on>
```

## Provided Dictionary
```sh
java -Ddic.file-/path/to/dictionary -jar CodingChallenge-1.0-SNAPSHOT.jar /path/to/file1 /path/to/file2 <and so on>
```

### Test

Building with `mvn clean package` or `mvn clean package` should successfully runs unit tests.
  
## Approach

Utils - To help clean up dirty strings(such as invalid phone numbers, mixed punctuations for dictionary words etc)
Delegate - to delegate the phone number to the respective handlers(STDIN/FILE handler), and also to the respective algo implementation
Algo - This forms the crux of the codebase
1. Iterate through e

