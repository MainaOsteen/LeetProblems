class Solution {
public:
    bool isPalindrome(int x) {
        // Edge cases
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversed = 0;
        
        // Reverse only half of the number
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        // Check if original equals reversed (for even digits)
        // or original equals reversed/10 (for odd digits)
        return x == reversed || x == reversed / 10;
    }
};