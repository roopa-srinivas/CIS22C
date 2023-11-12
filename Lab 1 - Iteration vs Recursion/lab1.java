import java.util.Scanner;

/**
 * @author Roopa Srinivas
 * Lab 1 - Iteration vs. Recursion
 * The purpose of the assignment is to explore iteration and recursion through finding all the prime numbers in an given list.
 */
public class lab1 {
    private final int SORT_MAX_SIZE = 8;
    
    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        int i;
        lab1 lab = new lab1();

        System.out.println("Please enter your input data on one line only.");

        int size = scnr.nextInt();
        int[] inputArray = new int[size];
        for (i = 0; i < size; i++) {
            inputArray[i] = scnr.nextInt();
        }
        
        if (lab.isArrayPrimeIter(inputArray, size)) {
            System.out.println("Array was found to be prime using iteration");
        } else {
            System.out.println("Not a Prime Array using iteration");
        }

        if (lab.isArrayPrimeRecur(inputArray, size)) {
            System.out.println("Array was found to be prime using recursion");
        } else {
            System.out.println("Not a Prime Array using recursion");
        }
        scnr.close();
    }
    
    /**
     * Algorithm isArrayPrimeIter (numArray, numArraySize)
     *      allPrime = false
     *      loop (checkNumIndex < numArraySize)
     *          currentNum = 
     *          upperLimit = (square root of currentNum) + 1
     *          if (currentNum is even AND currentNum is not 2)
     *              return false
     *          end if
     * 
     *          for (3 <= divisor < upperLimit, increment divisor by 2)
     *              if (currentNum NOT evenly divisible by divisor)
     *                  continue
     *              else
     *                  return false
     *              end if
     *      end loop
     *      return true
     * end isArrayPrimeIter
     * 
     * 
     * iteratively checks if all integers in numArray are prime
     * 
     * @param numArray list of integers to be checked for prime or not
     * @param numArraySize size of list of integers
     * @return true if all integers are prime, false if any integer is not prime
     */

    public boolean isArrayPrimeIter (int[] numArray, int numArraySize) {  
        System.out.println("Entering isArrayPrimeIter");
        boolean allPrime = true; 
        for (int checkNumIndex = 0; checkNumIndex < numArraySize; checkNumIndex++) { 
            if (allPrime) {
                int currentNum = numArray[checkNumIndex]; 
                int upperLimit  = (int)(Math.sqrt(currentNum)+1); 
                if ((currentNum > 2 && currentNum % 2 == 0) || (currentNum == 1)) { 
                    System.out.println("Leaving isArrayPrimeIter");
                    return false;
                }
                for (int divisor = 3; divisor < upperLimit; divisor+=2) { 
                    if (currentNum % divisor != 0) { 
                        continue;
                    } else {
                        System.out.println("Leaving isArrayPrimeIter");
                        return false; 
                    }
                }
            }
        }
        System.out.println("Leaving isArrayPrimeIter");
        return true;
    }

    /**
     * Algorithm isArrayPrimeRecur(numArray, numArraySize)
     *      allPrime = false
     *      if (numArray is not empty)
     *          if (numArray[numArraySize-1] is prime)
     *              allPrime = isArrayPrimeRecur(numArray, numArraySize-1)
     *          else
     *              allPrime = false
     *          end if
     *      else
     *          allPrime = true
     *      end if
     *      return allPrime
     * end isArrayPrimeRecur
     *
     * 
     * recursively checks if all integers in numArray are prime
     * 
     * @param numArray list of integers to be checked for prime or not
     * @param numArraySize size of list of integers
     * @return true if all integers are prime, false if any integer is not prime
     */
    public boolean isArrayPrimeRecur(int[] numArray, int numArraySize) {
        System.out.println("Entering isArrayPrimeRecur");
        boolean allPrime;
        if (numArraySize > 0) {
            if (isPrimeRecur(numArray[numArraySize-1], 2)) { 
                allPrime = isArrayPrimeRecur(numArray, numArraySize-1);
            } else {
                allPrime = false;
            }
        } else {
            allPrime = true;
        }
        System.out.println("Leaving isArrayPrimeRecur");
        return allPrime;
    }

    /**
     * Algorithm isPrimeRecur(num, divisor)
     *      if (num is 1)
     *          return false
     *      else if (divisor > (square root of num)+1)
     *          return true
     *      else if (num is divisible by divisor)
     *          return false
     *      else if (divisor is 2)
     *          isPrimeRecur(num, divisor+1)
     *      else if (num is not divisible by divisor)
     *          isPrimeRecur(num, divisor+2)
     *      end if
     *      return true
     * end isPrimeRecur
     *      
     * 
     * helper method that recursively checks if one number (num) is prime
     * 
     * @param num integer to be checked for prime or not
     * @param divisor number that num is divided by to see if it is divisible 
     * @return true if num is prime, false if num is not prime
     */

    public boolean isPrimeRecur(int num, int divisor) {
        System.out.println("Entering isPrimeRecur");
        if (num == 1) {
            return false;
        } else if (divisor > (int)(Math.sqrt(num)+1)) {
            return true;
        } else if (num % divisor == 0) {
            return false;
        } else if (divisor == 2) {
            return isPrimeRecur(num, divisor+1);
        } else if (num % divisor != 0) {
            return isPrimeRecur(num, divisor+2);
        }

        System.out.println("Leaving isPrimeRecur");
        return true;
    }

}