import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The NumberSystem class provides methods for converting numbers between
 * different base systems.
 */

public class NumberSystem {
  private String userInput = "";
  private int base = 0;
  private int conversion;
  public String bin = "", oct = "", dec = "", hex = "";
  private static final int DECIMAL_NUM = 10;

  /**
   * Sets the user input and the base system for the number.
   *
   * @param numberSystemInput the number input by the user
   * @param givenBase the base system of the number
   */
  public void setUserInput(String numberSystemInput, int givenBase) {
    this.userInput = numberSystemInput;
    this.base = givenBase;
  }

  /**
   * Converts the user input to the specified base system.
   *
   * @param input the input to be converted
   * @return the converted number in the specified base system
   */
  public String convertToBIN(String input) {
    int convertToBase = 2;

    if (input.isEmpty() == false) {
      int decimal = Integer.parseInt(input);
      if (decimal != 0) {
        try { //CHECK FOR ERRORS

          if (isHexadecimalSTRICT(userInput) || base == 16)
          {
            decimal = Integer.parseInt(input, 16);
          }
          else
          {
            decimal = Integer.parseInt(input, base);
          }

        }
        catch (NumberFormatException e) {System.out.println("Entered input is TOO HIGH of a number.");} //TRY TO PUT THIS MESSAGE IN THE CONVERTER APP

        bin = convertDecimalToOther(decimal, convertToBase);
      } else {bin = "0";}
    } else {bin = "0";}

    return bin;
  }

  public String convertToOCT(String input) {
    int convertToBase = 8;

    if (input.isEmpty() == false) {
      int decimal = Integer.parseInt(input);
      if (decimal != 0) {
        try { //CHECK FOR ERRORS

          if (isHexadecimalSTRICT(userInput) || base == 16)
          {
            decimal = Integer.parseInt(input, 16);
          }
          else
          {
            decimal = Integer.parseInt(input, base);
          }

        }
        catch (NumberFormatException e) {System.out.println("Entered input is TOO HIGH of a number.");} //TRY TO PUT THIS MESSAGE IN THE CONVERTER APP

        oct = convertDecimalToOther(decimal, convertToBase);
      } else {oct = "0";}
    } else {oct = "0";}

    return oct;
  }
  public String convertToDEC(String input) {
    int decimal = 0;

    try { //CHECK FOR ERRORS
      if (isHexadecimalSTRICT(userInput) || base == 16) {
        decimal = Integer.parseInt(input, 16);
      } else {
        decimal = Integer.parseInt(input, base);
      }
    } catch (NumberFormatException e) {
      System.out.println("Entered input is TOO HIGH of a number.");
    }

    /* CONVERTING AREA */
    dec = String.valueOf(decimal);

    return dec;
  }
  public String convertToHEX(String input) {
    int convertToBase = 16;

    if (input.isEmpty() == false) {
      int decimal = Integer.parseInt(input);
      if (decimal != 0) {
        try { //CHECK FOR ERRORS

          if (isHexadecimalSTRICT(userInput) || base == 16)
          {
            decimal = Integer.parseInt(input, 16);
          }
          else
          {
            decimal = Integer.parseInt(input, base);
          }

        }
        catch (NumberFormatException e) {System.out.println("Entered input is TOO HIGH of a number.");} //TRY TO PUT THIS MESSAGE IN THE CONVERTER APP

        hex = convertDecimalToOther(decimal, convertToBase);
      } else {hex = "0";}
    } else {hex = "0";}

    return hex;
  }

  /**
   * Converts a number in another base system to decimal.
   *
   * @param input the array representation of the number
   * @param base the base system of the number
   * @return the decimal representation of the number
   */
  private static String convertDecimalToOther(int input, int base) {
    String remainderString = "";
    String answer = "";
    String[] hexArray = {"A","B","C","D","E","F"};
    int result = input;
    int remainder = 0;

    while (result > 0) {
      remainder = result % base;
      result = result / base;

      if (remainder > 10){remainderString = hexArray[remainder - 10];}
      else {remainderString = Integer.toString(remainder);}

      answer = remainderString.concat(answer);
    }

    return answer;
  }

  private static int[] convertToArray(int decimal) {
    String decimalString = String.valueOf(decimal);
    int[] binaryArray = new int[decimalString.length()];
    for (int i = 0; i < decimalString.length(); i++) {
      binaryArray[i] = decimalString.charAt(i) - '0';
    }
    return binaryArray;
  }

  /**
   * Checks if a string represents a certain number system.
   *
   * @param data the string to be checked
   * @return true if the string represents an octal number, false otherwise
   */
  public static boolean isHexadecimalSTRICT(String data) {
    Pattern pattern = Pattern.compile("[A-Fa-f]+");
    Matcher matcher = pattern.matcher(data);
    return matcher.matches();
  }

  // GETTER & SETTER
  /**
   * Returns the user input.
   *
   * @return the user input
   */
//  public String getUserInput() {
//    return this.userInput;
//  }
  /**
   * Sets the conversion type for the number.
   *
   * @param CTWB the conversion type (binary, octal, decimal, hexadecimal)
   */
//  public void setConvert(int CTWB) {
//    this.conversion = CTWB;
//  }
  /**
   * Returns the conversion type for the number.
   *
   * @return the conversion type
   */
//  public int getConvert() {return this.conversion;}
}