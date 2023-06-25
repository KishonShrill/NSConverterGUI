import java.util.ArrayList;

public class TabulateData extends Thread {

    private Object[][] data;
    private ArrayList<String> dataTransfer = new ArrayList<>();
    private String value;
    private int MIN_NUM, MAX_NUM;
    private int base;
    private int loopCount = 1;

    public TabulateData(int base, int min, int max) {
        this.base = base;
        this.MIN_NUM = min;
        this.MAX_NUM = max;
    }

    @Override
    public void run() {
        dataTransfer.clear();

        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            value = convertDecimalToOther(i, base);
            dataTransfer.add(String.format("%d.) %s", loopCount, value));
            loopCount++;
        }

        // Initialize Object data array
        data = new Object[dataTransfer.size()][1];

        // Arrange the data into the object array
        for (int j = 0; j < dataTransfer.size(); j++) {
            data[j][0] = dataTransfer.get(j);
        }
    }

    private String convertDecimalToOther(int input, int base) {
        String remainderString;
        String answer = "";
        String[] hexArray = {"A", "B", "C", "D", "E", "F"};
        int result = input;
        int remainder;

        while (result > 0) {
            remainder = result % base;
            result = result / base;

            if (remainder >= 10) {
                remainderString = hexArray[remainder - 10];
            } else {
                remainderString = Integer.toString(remainder);
            }

            answer = remainderString.concat(answer);
        }
        return answer;
    }

    public Object[][] getDataArray() {
        return data.clone();
    }
}
