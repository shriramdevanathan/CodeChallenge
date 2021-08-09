# CODING CHALLENGE FOR ACONEX

## Getting Started

### Build

To build the project run 
'mvn clean install' or `mvn clean package`.
The finalized JAR along with sample dictionaries and inputs can be found in the `target` directory.

## Sample Usage


Scenario 1 : Read phone numbers from STDIN:


## Default dictionary
java -jar CodingChallenge-1.0-SNAPSHOT.jar

## Provided dictionary
java -Ddic.file-/path/to/dictionary -jar CodingChallenge-1.0-SNAPSHOT.jar


This should prompt for an input of a phone number like so:
Enter the phone number(q for quit): 

You can chose to either enter a phone number, or q to quit the console straight away.

Once you enter the number, the program should spit out the possible combinations for the given number


Scenario 2: Read numbers from a given file(\n separated)

## Default Dictionary
java -jar CodingChallenge-1.0-SNAPSHOT.jar /path/to/file1 /path/to/file2 <and so on>

## Provided Dictionary
java -Ddic.file-/path/to/dictionary -jar CodingChallenge-1.0-SNAPSHOT.jar /path/to/file1 /path/to/file2 <and so on>

### Test

Building with `mvn clean package` or `mvn clean package` should successfully runs unit tests.
