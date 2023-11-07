
public static List<String> matchingBraces(List<String> braces) {
    List<String> result = new ArrayList<>();

    for (String s : braces) {
        if (areBracesBalanced(s)) {
            result.add("YES");
        } else {
            result.add("NO");
        }
    }

    return result;
}

private static boolean areBracesBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) {
                return false;
            }
            
            char top = stack.pop();
            
            if ((c == ')' && top != '(') || 
                (c == ']' && top != '[') || 
                (c == '}' && top != '{')) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}
}

