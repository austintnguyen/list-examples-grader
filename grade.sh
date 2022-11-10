# Create your grading script here



rm -rf student-submission

echo "Removed student-submission directory"
git clone $1 student-submission
echo "cloned repository"

cp TestListExamples.java student-submission


echo "Copied Test file into student-submission"

cp -r lib student-submission
echo "Copied lib directory into student-submission"

cd student-submission
echo "Changed directory to student-submission"

FILE=ListExamples.java
if [ ! -f "$FILE" ];
then
    echo "$FILE was not found"
    exit
fi

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java 2>errorOutput.txt
if [ -s errorOutput.txt ];
then 
echo "Compile Error, You failed!"
exit
fi

echo "Sucessfully compiled tests"



java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > goodOutput.txt

echo "Sucessfully ran tests"



if grep -q "2 tests" "goodOutput.txt" ;
then
echo "You passed. Congratulations!"
exit
fi

cat goodOutput.txt
echo "You Failed Buddy. Try again!"





