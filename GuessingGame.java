/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessingGame extends GuessGame {
    public int guessNumber(int n) {
        
        int mid, left = 1, right = n;
        
        while(left <= right){
            
            mid = left + (right - left) / 2;
            
            //The result is stored in res
            int res = guess(mid);
            
            //Correct guess
            if(res == 0)
                return mid;
            
            //If num is lower than guessed number then search left
            else if(res == -1)
                right = mid - 1;
            
            //If num is higher than guessed number then search right
            else
                left = mid + 1;
        }
        
        return -1;
    }
}
