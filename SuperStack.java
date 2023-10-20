static void superStack(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            if (parts[0].equals("push")) {
                int val = Integer.parseInt(parts[1]);
                stack.push(val);
            } else if (parts[0].equals("pop")) {
                stack.pop();
            } else if (parts[0].equals("inc")) {
                int count = Integer.parseInt(parts[1]);
                int val = Integer.parseInt(parts[2]);
                for (int i = 0; i < count; i++) {
                    stack.set(i, stack.get(i) + val);
                }
            }

            if (stack.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(stack.peek());
            }
        }
    }
