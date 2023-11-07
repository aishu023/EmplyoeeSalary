
class Adder extends Calculator {
    @Override
    int add(int a, int b) {
        System.out.println("Adding integers: " + a + " " + b);
        return a + b;
    }
}

 

class Multiplier {
    int multiply(int a, int b, Calculator calculator) {
        int result = a; // Initialize result with the value of 'a'
        for (int i = 1; i < b; i++) { // Start the loop from 1, not 0
            result = calculator.add(result, a);
        }
        return result;
    }
}
