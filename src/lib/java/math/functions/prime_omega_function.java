package lib.java.math.functions;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class prime_omega_function {
    // Uppercase prime omega function
    public int prime_up_omega_function(int n) {
        int answer = prime_factor(n).size();
        return answer;
    }
    // Lowercase prime omega function
    public int prime_low_omega_function(int n) {
        List<Integer> cache = new ArrayList<Integer>(); int answer = 0;
        List<Integer> prime = prime_factor(n);
        for (int i = 0; i < prime.size(); i++) {
            if (!cache.contains(prime.get(i))) {
                answer++; cache.add(prime.get(i));
            }
        }
        return answer;
    }
    // Prime factorization function
    public List<Integer> prime_factor(int n) {
        List<Integer> answer = new ArrayList<Integer>();
        while (n % 2 == 0) {
            answer.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                answer.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            answer.add(n);
        }
        return answer;
    }
}
