import javax.swing.JPanel;
import java.util.ArrayList;

class DataArranger extends JPanel {
    public static ArrayList<String> dataTransfer = new ArrayList<>();
    public static Object[][] data;

    public DataArranger(int toConvert, int givenBase) {
        convertDecimalToOther(toConvert, givenBase);
    }

    private static String convertDecimalToOther(int input, int base) {
        String remainderString;
        String answer = "";
        String[] hexArray = {"A","B","C","D","E","F"};
        int result = input;
        int remainder, currentValue;
        int loopCount = 0;

        while (!dataTransfer.isEmpty()) {
            dataTransfer.remove(0);
        }

        while (result > 0) {
            currentValue = result;
            remainder = result % base;
            result = result / base;

            //Array - Adding values to dataTransfer array
            dataTransfer.add(String.valueOf(currentValue));
            dataTransfer.add(String.valueOf(result));
            dataTransfer.add(String.valueOf(remainder));
            dataTransfer.add(String.valueOf(loopCount));
            loopCount = loopCount + 1;
            //Array - Adding values to dataTransfer array

            if (remainder >=     10){
                remainderString = hexArray[remainder - 10];
            } else {
                remainderString = Integer.toString(remainder);
            }
            answer = remainderString.concat(answer);
        }

        //Initialize Object data array
        data = new Object[(dataTransfer.toArray().length/4)][4];

        //
        int repeat = 0;
        for (int i = 0; i < (dataTransfer.toArray().length/4); i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = dataTransfer.get(repeat);
                repeat = repeat + 1;
            }
        }

        return answer;
    }
    public Object[][] getDataArray() {
        return data.clone();
    }
}
