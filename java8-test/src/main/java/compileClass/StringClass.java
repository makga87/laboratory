package compileClass;

public class StringClass {

    public void stringPlusAsMultiRows() {
        String test = "";
        test += "1";
        test += "2";
        test += "3";
        test += "4";
        test += "5";
        test += "6";
    }

    public void stringPlusAsSingleRows() {
        String test = "1" + "2" + "3";
        test = test + "4" + "5" + "6";
    }

    public void stringPlusOtherVariable() {
        String test = "test";
        String test2 = " variable " + "is String";
        String test3 = test + test2;
    }

    public void stringPlusAsLoop() {
        String test = "it test ";
        for (int i = 0; i < 5; i++) {
            test = test + " loop " + i;
        }
    }

    public void stringPlusAppend() {
        String test = "it test ";
        test = test + "test2 append";
        test = test + "test3 append";
    }
}
