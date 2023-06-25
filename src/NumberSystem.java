import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * The NumberSystem class provides methods for converting numbers between
 * different base systems.
 */

public class NumberSystem {
  private String userInput = "";
  private int base = 0;
  public int conversion;
  public String bin = "", oct = "", dec = "", hex = "";

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

  int decimal;
  public String convertToBIN(String input) {
    int convertToBase = 2;

    if (!input.isEmpty()) {
      try { //CHECK FOR ERRORS
        decimal = Integer.parseInt(input, conversion);
        if (decimal != 0) {

          if (isHexadecimalSTRICT(userInput) || base == 16) {
            decimal = Integer.parseInt(input, 16);
          } else {
            decimal = Integer.parseInt(input, base);
          }

        } else {bin = "0";}
      } catch (NumberFormatException e) {showErrorPopup("An error occurred in BIN: " + e.getMessage());}
      bin = convertDecimalToOther(decimal, convertToBase);
    } else {bin = "0";}

    return bin;
  }
  public String convertToOCT(String input) {
    int convertToBase = 8;

    if (!input.isEmpty()) {
      try { //CHECK FOR ERRORS
      decimal = Integer.parseInt(input, conversion);
      if (decimal != 0) {

          if (isHexadecimalSTRICT(userInput) || base == 16)
          {
            decimal = Integer.parseInt(input, 16);
          }
          else
          {
            decimal = Integer.parseInt(input, base);
          }

        oct = convertDecimalToOther(decimal, convertToBase);
        } else {oct = "0";}
      } catch (NumberFormatException e) {showErrorPopup("An error occurred in OCT: " + e.getMessage());} //TRY TO PUT THIS MESSAGE IN THE CONVERTER APP
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
    } catch (NumberFormatException e) {showErrorPopup("An error occurred in DEC: " + e.getMessage());}

    /* CONVERTING AREA */
    dec = String.valueOf(decimal);

    return dec;
  }
  public String convertToHEX(String input) {
    int convertToBase = 16;

    if (!input.isEmpty()) {
      int decimal = Integer.parseInt(input, conversion);
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
        catch (NumberFormatException e) {showErrorPopup("An error occurred in HEX: " + e.getMessage());} //TRY TO PUT THIS MESSAGE IN THE CONVERTER APP

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
    String remainderString;
    String answer = "";
    String[] hexArray = {"A","B","C","D","E","F"};
    int result = input;
    int remainder;

    while (result > 0) {
      remainder = result % base;
      result = result / base;

      if (remainder > 10){remainderString = hexArray[remainder - 10];}
      else {remainderString = Integer.toString(remainder);}

      answer = remainderString.concat(answer);
    }

    return answer;
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
   * Sets the conversion type for the number.
   *
   * @param CTWB the conversion type (binary, octal, decimal, hexadecimal)
   */
  public void setConvert(int CTWB) {
    this.conversion = CTWB;
  }
  private static void showErrorPopup(String message) {
    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
  }
}