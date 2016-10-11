package algorithm.codility.Problem1;

public class Solution {
    interface State {
        State eat(int input);
        int getNum0();
        int getMax0();
    }

    abstract static class Stateful implements State {
        int num0;
        int max0;
        Stateful(int num0, int max0) {
            this.num0 = num0;
            this.max0 = max0;
        }
        @Override
        public State eat(int input) {
            return this;
        };
        @Override
        public int getNum0() {
            return num0;
        }
        @Override
        public int getMax0() {
            return max0;
        }
    }

    //zero state
    class State0 extends Stateful implements State {
        State0(int num0, int max0) {
            super(num0, max0);
        }
        @Override
        public State eat(int input) {
            super.eat(input);
            if (input == 1) {
                return new State2(0, 0);
            } else {
                return new State0(0, 0);
            }
        }
    }

    //current bit is 0
    class State1 extends Stateful implements State {
        State1(int num0, int max0) {
            super(num0, max0);
        }
        @Override
        public State eat(int input) {
            super.eat(input);
            if (input == 1) {
                max0 = this.num0 > max0 ? this.num0 : max0;
                return new State2(0, max0);
            } else {
                return new State1(this.num0 + 1, max0);
            }
        }
    }

    //current bit is 1
    class State2 extends Stateful implements State {
        State2(int num0, int max0) {
            super(num0, max0);
        }
        @Override
        public State eat(int input) {
            super.eat(input);
            if (input == 1) {
                return new State2(0, max0);
            } else {
                return new State1(1, max0);
            }
        }
    }

    public int solution(int N) {
        State s = new State0(0, 0);
        while (N > 0) {
            int bit = N & 1;
            s = s.eat(bit);
            N >>= 1;
        }
        return s.getMax0();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1610612737));
    }
}
