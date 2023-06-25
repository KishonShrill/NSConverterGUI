/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JPanel;
import javax.swing.JTable;
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

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    public Object[][] getDataArray() {
        return data.clone();
    }
}
