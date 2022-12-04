package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Function;

public class Output {
    private static final String FUNCTION_SELECTION = "기능을 선택하세요.";
    private static final String COURSE = "과정";
    private static final String COLON = ": ";
    private static final String SEPARATOR = " | ";
    private static final String SEPARATE_LINE = "#############################################";

    public void printFunctionSelection() {
        System.out.println(FUNCTION_SELECTION);
    }

    public void printFunctionList() {
        for (Function value : Function.values()) {
            System.out.println(value);
        }
    }

    public void printCourse() {
        System.out.println(SEPARATE_LINE);
        System.out.println(COURSE + COLON + makeCourseOutput());
    }

    private String makeCourseOutput() {
        StringBuilder output = new StringBuilder();
        int count = 0;
        for (Course course : Course.values()) {
            if (count != 0) {
                output.append(SEPARATOR);
            }
            output.append(course);
            count++;
        }
        return output.toString();
    }
}
