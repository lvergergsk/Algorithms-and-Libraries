package leetcode.evaluate_reverse_polish_notation_0150;

import java.util.Stack;
//import java.util.logging.Logger;
import java.util.stream.Stream;

class Solution {
//    private Logger LOGGER = Logger.getLogger(this.getClass().getName());

    enum Operator {
        ADDITION("+"), SUBSTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

        String token;

        Operator(String token) {
            this.token = token;
        }

        Integer calc(Integer operandL, Integer operandR) {
            switch (this) {
                case ADDITION:
                    return operandL + operandR;
                case SUBSTRACTION:
                    return operandL - operandR;
                case MULTIPLICATION:
                    return operandL * operandR;
                case DIVISION:
                    return operandL / operandR;
                default:
                    return null;
            }
        }

        public static Stream<Operator> stream() {
            return Stream.of(Operator.values());
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> fifo = new Stack<>();
        for (String token : tokens) {
            Operator op = Operator.stream().filter(operator -> operator.token.equals(token)).findFirst().orElse(null);

            if (op == null) fifo.push(Integer.valueOf(token));
            else {
                Integer operandR = fifo.pop();
                Integer operandL = fifo.pop();
                fifo.push(op.calc(operandL, operandR));
            }

//            LOGGER.info(String.valueOf(fifo));

        }
        return fifo.pop();
    }
}
