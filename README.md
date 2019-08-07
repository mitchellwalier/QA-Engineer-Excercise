# QA-Engineer-Exercise
Thank you for giving me this opportunity. It was fun to code! It is always fun to do File -> New -> Project.

# Requirements
* [Java 8](https://java.com/en/download/help/download_options.xml)
* [JUnit 5](https://junit.org/junit5/)
* [Hamcrest](https://search.maven.org/search?q=g:org.hamcrest%20AND%20a:hamcrest-core)

# JUnit test case execution
*Please double check the directory locations* 
  
  
Compile :   
```
        javac -cp <junit-jar-file>;. SentenceMetricsTest.java
```
Run : 
```
        java -cp <junit-jar>;<hamcrest-jar>;. org.junit.runner.JUnitCore  SentenceMetricsTest 
```


# Usage
Returns all the longest words in a sentence and how long the longest word is. 

# Comments
 * Special characters aren't counted
 * Class shouldn't worry about grammar, spelling or sentence structure 
 * Class shouldn't worry about multiple sentences being in the same string 
