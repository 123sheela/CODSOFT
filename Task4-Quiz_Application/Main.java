import java.util.*;

class Main {
    private static int score = 0;
    private static int currentQuestion = 0;
    private static int totalQuestions = 10;
    private static long[] timeTaken = new long[totalQuestions];
    private static String[] questions = 
    {
            "1. Who invented Java Programming?",
            "2. Which component is used to compile, debug and execute the java programs?",
            "3. What is the extension of java code files?",
            "4. Arrays in Java are",
            "5. Which loop construct in Java is best suited when the number of iterations is known? ",
            "6. Which operator is used for equality comparison in Java?",
            "7. Which operator is used for performing string concatenation in Java? ",
            "8. Which of the following is a primitive data type in Java?",
            "9. What does I/O stand for in Java? ",
            "10. Which data type is used to store a single character in Java?"
    };
    private static String[][] options = {
            {"\nA. Guido van Rossum", "B. James Gosling", "C. Dennis Ritchie", "D. Bjarne Stroustrup"},
            {"\nA. JRE", "B. JIT ", "C. JDK", "D. JVM"},
            {"\nA. .js", "B. .txt", "C. .class", "D. .java"},
            {"\nA. Object references", "B. Objects", "C. Primitive data types", "D. None"},
            {"\nA. for loop", "B. while loop", "C. do-while loop", "D. break statement"},
            {"\nA. +", "B. =", "C. ==", "D. &&"},
            {"\nA. +", "B. -", "C. *", "D. /"},
            {"\nA. String", "B. int", "C. Array", "D. Object"},
            {"\nA. Input/Output", "B. Inheritance/Overriding", "C. Integer/Object", "D. Iteration/Observation"},
            {"\nA. char", "B. String", "C. int", "D. single"},
    };
    private static char[] answers = {'B', 'C', 'D', 'B', 'A', 'C', 'A', 'B', 'A', 'A'};
    private static Timer timer;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**********************************************");
        System.out.println("*        ------->>>QUIZ APP<<<-------        *");
        System.out.println("**********************************************");
        System.out.println("           >>>>>  LET'S BEGIN  <<<<<       ");
        System.out.println("_________________________________________");
        startQuiz();
       
    }

    private static void startQuiz() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                showResult();
                timer.cancel();
            }
        }, 60000); // 60 seconds timer

        displayQuestion();
    }

    private static void displayQuestion() {
        if (currentQuestion < totalQuestions) {
            System.out.println(questions[currentQuestion]);
            for (String option : options[currentQuestion]) {
                System.out.println(option);
            }
            long startTime = System.currentTimeMillis();
            System.out.println("-----------------------------");
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(sc.next().charAt(0));
            long endTime = System.currentTimeMillis();
            timeTaken[currentQuestion] = (endTime - startTime) / 1000; // Time taken in seconds
            checkAnswer(userAnswer);
        } else {
            showResult();
        }
    }

    private static void checkAnswer(char userAnswer) {
        if (userAnswer == answers[currentQuestion]) {
            score++;
            System.out.println("Exactly...Correct!");
        } else {
            System.out.println("Oops...Incorrect!");
        }
        System.out.println("Time Taken: " + timeTaken[currentQuestion] + " seconds");
        System.out.println("_________________________________________");
        currentQuestion++;
        displayQuestion();
    }

    private static void showResult() {
        System.out.println("Quiz Over!");
        System.out.println("Your final score is: " + score + "/" + totalQuestions);
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (totalQuestions - score));
        System.out.println("___________________________________________");
        System.out.println("\n------> I HOPE YOU LEARNT SOMETHING <------");
        System.out.println("___________________________________________");
    }
}
